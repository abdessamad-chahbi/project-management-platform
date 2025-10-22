<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="applicationWebJEE.Models.TechnologieModel" %>
<%@ page import="applicationWebJEE.Models.UserModel" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/Login/bootstrap-5.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    <title>Résultats</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f8f9fa;
            color: #495057;
            margin: 20px;
        }

        h2, h3, h4 {
            color: #008080;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            margin-bottom: 10px;
        }

        label {
            font-size: 16px;
            color: #008080;
            display: block;
            margin-bottom: 8px;
        }

        .custom-checkbox {
            appearance: none;
            width: 20px;
            height: 20px;
            border: 2px solid #008080; /* Couleur de la bordure de la checkbox */
            border-radius: 4px;
            cursor: pointer;
            margin-right: 10px; /* Espacement entre la checkbox et le texte */
            outline: none;
            display: inline-block;
            vertical-align: middle;
        }

        .custom-checkbox:checked {
            background-color: #008080; /* Couleur de fond lorsque la checkbox est cochée */
            border-color: #008080;
        }

        .custom-checkbox:checked::before {
            content: '\2713';
            color: white;
            font-size: 14px;
            display: block;
            text-align: center;
            line-height: 18px; /* Ajustez la hauteur de la coche */
        }

        .developer-item {
                border: 1px solid #131313;
                padding: 10px; /* Espacement interne */
                margin-bottom: 10px; /* Marge en bas */
                border-radius: 5px; /* Coins arrondis */
        }

        .developer-item:nth-child(even) {
                background-color: #f9f9f9; /* Couleur de fond pour les développeurs pairs */
        }

        .developer-item:nth-child(odd) {
                background-color: #e2ebe6; /* Couleur de fond pour les développeurs impairs */
        }

        .select-dev-label {
            font-size: 24px;
            color: #008080;
            margin-bottom: 20px;
        }

        .tech-title {
            background-color: #f2f2f2; /* Arrière-plan gris léger */
            padding: 10px; /* Ajout d'un espace autour du texte */
            border: 1px solid #ddd; /* Ajout d'une bordure */
            border-radius: 5px; /* Coins arrondis */
            margin-bottom: 10px; /* Marge en bas pour l'espace */
            color: #008080; /* Couleur du texte teal, vous pouvez ajuster cela selon vos préférences */
        }

        h3 {
            margin-top: 20px;
        }

        ul {
            padding-left: 20px;
        }

        button[type="submit"] {
            background-color: #28a745;
            color: #000;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            float: right;
        }

        button[type="submit"]:hover {
            color: #fff;
        }
        .selected-count{
            float:right;
        }
    </style>

</head>
<body>
    <form action="/validerEquipeProjet" method="post" id="monFormulaire">
        <p class="select-dev-label">Sélectionnez les développeurs souhaités</p>
        <%
                    List<TechnologieModel> technologies = (List<TechnologieModel>) session.getAttribute("technoList");
                    if (technologies != null && !technologies.isEmpty()) {
                        for (TechnologieModel technologie : technologies) {
                            if (technologie.getNomTech() != null) {
                %>
                                <h3 class="tech-title">
                                    Nom de la technologie : <%= technologie.getNomTech() %>
                                    <span id="count<%= technologie.getIdTech() %>" class="selected-count">0</span>
                                </h3>
                                <ul>
                                    <%
                                        List<UserModel> utilisateurs = technologie.getUtilisateurs();
                                        if (utilisateurs != null && !utilisateurs.isEmpty()) {
                                            for (UserModel utilisateur : utilisateurs) {
                                    %>
                                                <li class="developer-item">
                                                    <input type="checkbox" id="<%= technologie.getIdTech() + "-" + utilisateur.getId() %>" name="developer" value="<%= technologie.getIdTech() + "-" + utilisateur.getId() %>" class="custom-checkbox technologie-checkbox">
                                                    <%= utilisateur.getNom() %> <%= utilisateur.getPrenom() %></label>
                                                </li>
                                    <%
                                            }
                                        } else {
                                    %>
                                            <li class="no-developer">Aucun développeur lié à cette technologie.</li>
                                    <%
                                        }
                                    %>
                                </ul>
                <%
                            }
                        }
                    } else {
                %>
                    <p>Aucune technologie disponible.</p>
                <%
                    }
                %>
<button type="submit" >
    <b>Valider les développeurs</b>
</button>
    </form>

     <script>
            document.addEventListener('DOMContentLoaded', function() {
                const form = document.querySelector('monFormulaire');
                const checkboxes = document.querySelectorAll('.technologie-checkbox');

                checkboxes.forEach(function(checkbox) {
                    checkbox.addEventListener('change', function() {
                        updateSelectedCount(checkbox);
                    });
                });

                function updateSelectedCount(checkbox) {
                    const technologieId = checkbox.id.split('-')[0];
                    const countElement = document.getElementById('count' + technologieId);
                    const selectedCount = document.querySelectorAll('.technologie-checkbox:checked[id^="' + technologieId + '"]').length;
                    countElement.textContent = selectedCount;
                }
            });
        </script>

</body>
</html>
