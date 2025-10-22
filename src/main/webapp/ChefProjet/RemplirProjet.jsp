<%@ page import="java.util.List" %>
<%@ page import="applicationWebJEE.Models.TechnologieModel" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Affichage des Technologies</title>
    <link href="/Login/bootstrap-5.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f8f9fa;
            color: #495057;
        }

        .container {
            margin-top: 50px;
        }

        h2, h3 {
            color: #008080;
        }

        .instructions {
            margin-bottom: 20px;
        }

        .no-tech {
            text-align: center;
            margin-top: 20px;
            color: #007bff;
        }

        .textarea-container {
            margin-bottom: 20px;
        }

        label {
            font-size: 18px;
            color: #008080;
            display: block;
            margin-bottom: 8px;
        }

        textarea {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
            border: 1px solid #ced4da;
            border-radius: 4px;
            font-size: 16px;
        }

        textarea::placeholder {
            color: #6c757d;
        }


        .checkbox-container {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            margin-top: 20px;
        }

        .checkbox-item {
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 10px;
            border: 1px solid #dee2e6;
            border-radius: 5px;
            min-width: 200px;
            box-sizing: border-box;
        }

        .checkbox-item:nth-child(even) {
            background-color: #f2f2f2;
        }

        .custom-checkbox {
            appearance: none;
            width: 20px;
            height: 20px;
            border: 2px solid #008080;
            border-radius: 4px;
            cursor: pointer;
            margin-bottom: 10px;
            outline: none;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .custom-checkbox:checked {
            background-color: #007bff;
            border-color: #007bff;
        }

        .custom-checkbox:checked::before {
            content: '\2713';
            color: white;
            font-size: 14px;
        }

        .tech-label {
            font-size: 16px;
        }
        .input-text {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
            border: 1px solid #ced4da;
            border-radius: 4px;
            font-size: 16px;
            margin-bottom: 10px;
        }

        .input-text::placeholder {
            color: #6c757d;
        }

        .input-text:focus {
            border-color: #008080;
        }

    </style>
</head>
<body>
   <form action="/validerDetailsProjet" method="post" id="monFormulaire">
       <div class="container">
           <% List<TechnologieModel> technologies = (List<TechnologieModel>) session.getAttribute("technologies"); %>

           <div class="textarea-container">
               <label for="methodologie"><h3>Methodologie du Projet :</h3></label>
               <input class="input-text" type="text" id="methodologie" name="methodologie" placeholder="Saisissez la methodologie du projet ici...">
           </div>

           <h3>Veuillez selectionner les technologies pour ce projet :</h3>
           <p class="instructions">Cochez les technologies necessaires pour ce projet.</p>

           <div class="checkbox-container">
               <% if (technologies != null && !technologies.isEmpty()) { %>
                   <% for (TechnologieModel technologie : technologies) { %>
                       <div class="checkbox-item">
                           <input type="checkbox" id="<%= technologie.getIdTech() %>" name="technologie" value="<%= technologie.getIdTech() %>" class="custom-checkbox">
                           <label for="<%= technologie.getNomTech() %>" class="tech-label"><%= technologie.getNomTech() %></label>
                       </div>
                   <% } %>
               <% } else { %>
                   <p class="no-tech">Aucune technologie disponible</p>
               <% } %>
           </div>
           <br>
           <div style="overflow: hidden;">
            <button type="submit" class="btn btn-primary" style="float: right; background-color: #008080;">Valider</button>
        </div>
       <br>
       </div>
   </form>

   <script>
           document.addEventListener('DOMContentLoaded', function () {
               var form = document.getElementById('monFormulaire');
               form.addEventListener('submit', function (event) {
                   var methodologieValue = document.getElementById('methodologie').value;
                      if (methodologieValue.trim() === '') {
                       event.preventDefault();

                       Swal.fire({
                           icon: 'error',
                           title: 'Erreur',
                           text: 'Veuillez saisir une methodologie.',
                           timer: 2000,
                           showConfirmButton: false
                       });

                       return;
                   }
                   var checkboxes = document.querySelectorAll('.custom-checkbox:checked');
                   if (checkboxes.length === 0) {
                       event.preventDefault();

                       Swal.fire({
                           icon: 'error',
                           title: 'Erreur',
                           text: 'Veuillez selectionner au moins une technologie.',
                           timer: 2000,
                           showConfirmButton: false
                       });
                   }
               });
           });
       </script>
</body>
</html>
