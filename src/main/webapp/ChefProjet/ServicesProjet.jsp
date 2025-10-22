<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>

<%
    List<String> servicesList = (List<String>) request.getAttribute("servicesList");
    String projectId = (String) request.getAttribute("projetId");
%>

<html>
<head>
    <title>Résultats des Services du projet</title>
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
            <h2>Les services du projet: <%= projectId %></h2>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Description</th>
                        <th>Duree</th>
                        <th>Devps</th>
                    </tr>
                </thead>
                <tbody>
                    <% if (servicesList != null && !servicesList.isEmpty()) { %>
                        <% for (String service : servicesList) { %>
                            <tr>
                                <% String[] elements = service.split("-"); %>
                                <td><%= elements[1] %></td>
                                <td><%= elements[2] %></td>
                                <td>
                                    <% String[] developers = elements[3].split(","); %>
                                    <% for (String developer : developers) { %>
                                        <%= developer %><br>
                                    <% } %>
                                </td>

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
    <form action="/ChefProjet/AjouterService.jsp" method="post">
    <input type="hidden" name="projetId" value="<%= projectId %>">
    <button class="add-service-button">
                     Ajouter un nouveau service
                     <i class="fas fa-plus" style="margin-left: 5px;"></i>
    </button>
    </form>

    <div class="add-service-form" id="addServiceForm" style="display: none;">
                     <h3 style="font-family: math; font-size: 25px; color: black; text-align:center;">Formulaire d'ajout de service</h3>
                     <form action="/ajouterService" method="post">
                         <input type="hidden" name="projectId" value="<%= projectId %>">
                         <input type="hidden" id="servicesList" name="servicesList" value="<%= String.join("|", servicesList) %>" />
                         <div style="overflow: hidden;">
                                     <div style="float: left; width: 40%;">
                                         <label for="description" style="font-family:sans-serif;"><b>Description du service:</b></label>
                                         <input type="text" id="description" name="description" required>
                                     </div>
                                     <div style="float: right; width: 40%;">
                                         <label for="duree" style="font-family:sans-serif;"><b>Durée du service (en jours):</b></label>
                                         <input type="number" id="duree" name="duree" required>
                                     </div>
                         </div>
                         <button type="submit" style="float: right;">
                                     <i class="fas fa-check"></i>
                         </button>
                         <br>
                     </form>
    </div>

</body>
</html>
