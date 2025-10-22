<%@ page import="applicationWebJEE.Models.ProjetModel" %>
<%@ page import="java.util.List" %>
<%@ page import="applicationWebJEE.DataAccessObject.ProjetDAO" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <title>Liste des Projets</title>
         <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous"> -->
              <link href="/Login/bootstrap-5.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .container {
            margin-top: 50px;
        }

        h1 {
            color: #007bff;
        }

        table {
            width: 100%;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            text-align: center;
        }

        th {
            background-color: #007bff;
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
    </style>
</head>
<body>
    <div class="container">

        <% List<ProjetModel> projets = (List<ProjetModel>) session.getAttribute("projets"); %>

        <% if (projets == null || projets.isEmpty()) { %>
            <p class="no-data"><b style="color:#007bff;">Aucun Projet disponible</b></p>
        <% } else { %>
            <table class='table table-striped table-bordered'>
                <thead>
                    <th>ID Projet</th>
                    <th>Nom Projet</th>
                    <th>Description</th>
                    <th>Client</th>
                    <th>Date Demande</th>
                    <th>Date Livraison</th>
                    <th>Nb Jours Dev</th>
                    <th>Action</th>
                </thead>
                <tbody>
                    <% for (ProjetModel projet : projets) { %>
                        <tr>
                            <td><%= projet.getIdProj() %></td>
                            <td><%= projet.getNomProj() %></td>
                            <td><%= projet.getDescription() %></td>
                            <td><%= projet.getClientProj() %></td>
                            <td><%= projet.getDateDem() %></td>
                            <td><%= projet.getDateLiv() %></td>
                            <td><%= projet.getNbJoursDev() %></td>
                            <td>
                                <form action="/remplirProjet" method="post">
                                    <button type="submit" class="btn btn-primary" title="Consulter">
                                        <i class="fas fa-search"></i>
                                    </button>
                                    <button type="submit" class="btn btn-primary" name="equipeTechnologies" title="EquipeTech">
                                        <i class="fas fa-search"></i>
                                    </button>
                                    <input type="hidden" name="projetId" value="<%= projet.getIdProj() %>">
                                </form>
                            </td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        <% } %>
    </div>
</body>
</html>
