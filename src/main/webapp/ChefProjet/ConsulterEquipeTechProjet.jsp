<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>

<%
    List<String> equipeTechnologiesList = (List<String>) session.getAttribute("equipeTechnologiesProjet");
    String projectId = (String) session.getAttribute("projetId");    
     // System.out.println(equipeTechnologiesList);
%>

<html>
<head>
    <title>L'equipe / Technologies du projet</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .container {
            margin-top: 50px;
            margin-left: 0px;
            text-align: center;
            margin-bottom: 20px;
        }
        h1 {
            color: #007bff;
        }
        h2 {
                    text-align: left; /* Aligner le texte à gauche */
                    margin-bottom: 20px; /* Ajouter une marge en bas */
                    font-family: math;
                }

        table {
            width: 100%; /* Réduire la largeur du tableau */
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            text-align: center;
                font-family: math;
        }

        th {
            font-weight: bold;
            font-size: 24px;
        }

        td {
            font-weight: bold;
            font-size: 18px;
        }


        th {
            background-color: #008080;
            color: white;
        }

        tbody tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tbody tr:hover {
            background-color: #e0e0e0;
        }

        .no-data {
            text-align: center;
            margin-top: 20px;
            color: #007bff;
        }

        /* Ajouter un style pour les boutons d'action */
        .action-button {
            background-color: #8cb2dc00;
            color: #008080;
            border: none;
            padding: 8px 12px;
            cursor: pointer;
            font-size:26px;
        }
        .add-service-button {
                    float:right;
                    background-color: #008080;
                    color: white;
                    border: none;
                    padding: 10px 20px;
                    cursor: pointer;
                    font-size: 18px;
                    border-radius: 5px;
                    box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1);
        }
        .add-service-form {
            display: none;
            background: linear-gradient(to top, #008080, #ffffff);
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 70px;
        }

        .add-service-form h3 {
            color: #007bff;
        }

        .add-service-form label {
            display: block;
            margin: 10px 0;
        }

        .add-service-form input {
            width: 100%;
            padding: 8px;
            margin: 8px 0;
            box-sizing: border-box;
        }

        .add-service-form button {
            background-color: #008080;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .add-service-form button:hover {
            background-color: #006666;
        }

    </style>
</head>
<body>
    <div class="container">
            <h2>Le projet : <%= projectId %></h2>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>L'equipe du projet</th>
                        <th>Les Technologies du projet</th>
                    </tr>
                </thead>
                <tbody>
                    <% if (equipeTechnologiesList != null && !equipeTechnologiesList.isEmpty()) { %>
                        <% for (String equipeTechnologie : equipeTechnologiesList) { %>
                            <tr>
                                <% String[] elements = equipeTechnologie.split("-"); %>
                                <td><%= elements[0] %> <%= elements[1] %></td>
                                <td><%= elements[2] %></td>
                            </tr>
                        <% } %>
                    <% } else { %>
                        <tr>
                            <td colspan="5" class="no-data"><b>Aucun résultat trouvé.</b></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
    </div>


</body>
</html>
