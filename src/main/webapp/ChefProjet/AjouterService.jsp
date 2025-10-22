<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String projetId = request.getParameter("projetId");
%>
<html>
<head>
    <title>Formulaire d'ajout de service</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .add-service-form {
            background: linear-gradient(to top, #008080, #ffffff);
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 70px;
        }

        .add-service-form h3 {
            color: #007bff;
            text-align: center;
            font-family: math;
            font-size: 25px;
            color: black;
        }

        .add-service-form label {
            display: block;
            margin: 10px 0;
            font-family: sans-serif;
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
            float: right;
        }

        .add-service-form button:hover {
            background-color: #006666;
        }
    </style>
</head>
<body>
    <div class="add-service-form">
        <h3>Formulaire d'ajout de service</h3>
        <form action="/ajouterService" method="post">
        <input type="hidden" name="projetId" value="<%= projetId %>">
            <div style="overflow: hidden;">
                <div style="float: left; width: 40%;">
                    <label for="description"><b>Description du service:</b></label>
                    <input type="text" id="description" name="description" required>
                </div>
                <div style="float: right; width: 40%;">
                    <label for="duree"><b>Durée du service (en jours):</b></label>
                    <input type="number" id="duree" name="duree" required>
                </div>
            </div>
            <button type="submit">
                <i class="fas fa-check"></i>
            </button>
            <br>
        </form>
    </div>
</body>
</html>
