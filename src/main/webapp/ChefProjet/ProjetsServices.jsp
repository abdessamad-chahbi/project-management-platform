<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>

<%
    List<String> projetsServices = (List<String>) session.getAttribute("projetsServices");
%>

<html>
<head>
    <title>Résultats des Projets</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .container {
            margin-top: 50px;
            margin-left: 180px;
            text-align: center;
        }



        h1 {
            color: #007bff;
        }

        table {
            width: 80%; /* Réduire la largeur du tableau */
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            text-align: center;
            font-family: system-ui;
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
    </style>
</head>
<body>
    <div class="container">
        <form action="/servicesProjet" method="post">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Nom Projet</th>
                        <th>Total Services</th>
                        <th>Consulter</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (String projetService : projetsServices) { %>
                        <tr>
                            <% String[] elements = projetService.split("-"); %>
                            <td><%= elements[1] %></td>
                            <td>
                                <% int totalServices = Integer.parseInt(elements[2]); %>
                                <% if (totalServices > 0) { %>
                                    <%= totalServices %>
                                <% } else { %>
                                    <i class="fas fa-exclamation-triangle" style="color: orange; font-size:24px;"></i>
                                <% } %>
                            </td>
                            <td>
                                <button type="submit" name="projetId" value="<%= elements[0] %>" class="action-button">
                                    <i class="fas fa-search"></i>
                                </button>
                            </td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </form>
        <% if (projetsServices == null || projetsServices.isEmpty()) { %>
            <p class="no-data"><b>Aucun résultat trouvé.</b></p>
        <% } %>
    </div>
</body>
</html>
