<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Planifier Réunion</title>
    <!-- Ajoutez ici vos balises meta, liens vers des feuilles de style, etc. -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f8f9fa;
            color: #495057;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh; /* Utilisez la hauteur de la vue pour centrer verticalement */
            margin: 0;
        }

        form {
            display: flex;
            align-items: center;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 800px;
        }

        .icon-container {
            flex: 0 0 auto;
            margin-right: 20px;
        }

        .date-container {
            flex: 1;
            display: flex;
            flex-direction: column;
        }

        label {
            font-size: 18px;
            color: #008080;
            display: block;
            margin-bottom: 8px;
        }

        input {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
            border: 1px solid #ced4da;
            border-radius: 4px;
            font-size: 16px;
            margin-bottom: 10px;
        }

        input[type="date"] {
            /* Ajoutez des styles spécifiques pour le champ de date si nécessaire */
        }

         button {
                    background-color: #008080; /* Changement de couleur */
                    color: #fff;
                    padding: 10px 20px;
                    border: none;
                    border-radius: 5px;
                    cursor: pointer;
                    font-size: 16px;
                    font-weight: bold; /* Texte en gras */
                    align-self: flex-end; /* Aligner à droite */
                }
    </style>
</head>
<body>
    <form action="/traitementReunion" method="post" onsubmit="return validateDate();">
        <div class="icon-container">
            <!-- Ajoutez une icône pour la réunion (utilisation de FontAwesome) -->
            <i class="fas fa-calendar-alt" style="font-size: 48px; color: #008080; margin-bottom:65px;"></i>
        </div>

        <div class="date-container">
            <label for="dateReunion">Veuillez saisir une date de réunion :</label>
            <input type="date" id="dateReunion" name="dateReunion" required>
            <br><br>
            <button type="submit" >Valider la Réunion</button>

            <!-- Afficher le projetId -->
            <p>Projet ID en session : <%= session.getAttribute("projetId") %></p>
        </div>
    </form>
    <script>
            function validateDate() {
                var currentDate = new Date();
                var selectedDate = new Date(document.getElementById("dateReunion").value);

                if (selectedDate < currentDate) {
                    Swal.fire({
                        icon: 'error',
                        title: 'Erreur',
                        text: 'La date de réunion doit être ultérieure à la date actuelle.'
                    });
                    return false;
                }
                return true;
            }
        </script>
</body>
</html>
