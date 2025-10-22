<%@page import="applicationWebJEE.BusinessLogic.UserManager"%>
<%@page import="applicationWebJEE.Models.TechnologieModel"%>
<%@page import="applicationWebJEE.BusinessLogic.TechnologieManager"%>
<%@page import="applicationWebJEE.Models.TacheModel"%>
<%@page import="applicationWebJEE.BusinessLogic.TacheManager"%>
<%@page import="applicationWebJEE.BusinessLogic.ServiceManager"%>
<%@page import="applicationWebJEE.Models.ServiceModel"%>
<%@page import="applicationWebJEE.BusinessLogic.ProjetManager"%>
<%@page import="applicationWebJEE.Models.ProjetModel"%>
<%@page import="java.util.List"%>
<%@page import="applicationWebJEE.DataAccessObject.ProjetDAO"%>
<%@page import="org.apache.catalina.Globals"%>
<%@page import="org.apache.catalina.valves.rewrite.Substitution.StaticElement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ page import="java.sql.ResultSet" %>
<%@ page import="applicationWebJEE.Connexion" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulter Competence</title>
       <!-- Bootstrap -->
     <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous"> -->
          <link href="/Login/bootstrap-5.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Add Font Awesome for icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f8f9fa;
            color: #495057;
        }

        label {
            font-size: 18px;
            color: #008080;
            display: block;
            margin-bottom: 8px;
        }

        .checkbox-container {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            margin-top: 30px;
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

    </style>

</head>
<body>

<%
	  Connexion connexion = new Connexion();
	  connexion.connect(); // Établir la connexion à la base de données.
	 	  
	// Recuperer la valeur du login depuis la session
	  UserManager userManager = new UserManager();
      HttpSession sessionLogin = request.getSession();
      String loginDeveloppeur = (String) sessionLogin.getAttribute("login");
	  int identDevel = userManager.getIdDeveloppeurByLogin(loginDeveloppeur);

	    TechnologieManager technologieManager = new TechnologieManager();
	    List<TechnologieModel> technologies = technologieManager.getAllTechnologiesByDeveloppeur(identDevel);
	    
	    List<TechnologieModel> unmasteredTechnologies = technologieManager.getAllUnmasteredTechnologiesByDeveloppeur(identDevel);
%>

<div class="container"> <br /> <br /> 
  <div class="row">
      <div class="card col-md-7 offset-md-3" style="background-color: #f8f9fa;"> <br />
          <h3 class="text-center" style="color: #008080;">Ajouter Technologie</h3>
          <div class='card-body'>
              <form id="technologieForm" method="post" >
                  <div class="form-group row">
                      <label class="col-sm-5 col-form-label"> <b> Sélectionnez la Technologie : </b></label>
                      <div class="col-sm-7" >
                         <select name="selectTechnologie" class="form-control" style="background-color: #f8f9fa;" required >
					        <% for (TechnologieModel technologie : unmasteredTechnologies) { %>
						        <option value="<%= technologie.getIdTech() %>"><%= technologie.getNomTech() %></option>
						    <% } %>
						 </select>
                      </div>
                  </div> <br/> 
                      <div class="form-group row">
                          <div class="col-sm-5 offset-sm-8" >
                              <button type="button" class="btn btn-success" onclick="enregistrerTechnologie()">Enregistrer</button>
                              <button type="button" class="btn btn-danger" onClick="Retour();" style="margin-left:5px">Retour</button>
                           </div>
                      </div>
               </form>
             </div> 
           </div> 
        </div> 
     </div> 

  <br />  <br /> 
<div class='container'>           

         <h4 style="color: #008080;">La liste des technologies maîtrisées par le développeur :</h4>
			  <div class="checkbox-container">
		        <% if (technologies != null && !technologies.isEmpty()) { %>
		            <% for (TechnologieModel technologie : technologies) { %>
		                <div class="checkbox-item">
		                    <input type="checkbox" class="custom-checkbox" disabled>
		                    <label for="<%= technologie.getNomTech() %>" class="tech-label"><%= technologie.getNomTech() %></label>
		                </div>
		            <% } %>	 
		        <% } else { %>
		        
		        <% } %>     	    
	     
	                <!-- <div class="checkbox-item" onClick="Retour();">
	                    <input type="checkbox" class="custom-checkbox" disabled>
	                    <label class="tech-label"> Retour </label>
	                </div> -->
		         </div>
<% 
    connexion.disconnect(); // Fermer la connexion à la base de données.
%>
                                    
             
      </div>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
 <script>
     function Retour() {
        location.replace("/interface-developpeur"); 
     }
     
     function enregistrerTechnologie() {
    	// Récupérer la valeur sélectionnée dans la liste déroulante
         var idTechno = $("select[name='selectTechnologie']").val();
    	
    // Demander confirmation à l'utilisateur
       if (confirm("Voulez-vous vraiment ajouter cette technologie ?")) {
        	 
         // Soumettre le formulaire de manière asynchrone
         $.ajax({
             type: "POST",
             url: "/AjouterTechnologieDevServlet",
             data: {
                 idDeveloppeur: <%= identDevel %>, 
                 idTechnologie: idTechno
             },
             success: function(response) {
                 // Traitement réussi, mettre à jour la page si nécessaire
                // alert("Technologie ajoutée avec succès!");
                 location.reload(); // recharger la page
             },
             error: function(error) {
                 // Gérer les erreurs en cas d'échec du traitement
                // alert("Erreur lors de l'ajout de la technologie.");
             }
         });
       }
     }
     
 </script>

  <br /> <br /> <br /> <br /> <br /> 
</body>
</html>