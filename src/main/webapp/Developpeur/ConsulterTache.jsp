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
<title>Consulter Tache</title>
       <!-- Bootstrap -->
     <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous"> -->
          <link href="/Login/bootstrap-5.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Add Font Awesome for icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
  <br />  <br />
<div class='container'>

<br />
    <table class='table table-striped table-bordered mx-auto' style="width: 90%;">
          <thead >
            <th class="text-center" >Description Tâche</th>
            <th class="text-center">Pourcentage d'avancement (%)</th>
          </thead>
         
           <tbody> 
           
<%
	  Connexion connexion = new Connexion();
	  connexion.connect(); // Établir la connexion à la base de données.
	  
	  int idService = Integer.parseInt(request.getParameter("idService"));

	    TacheManager tacheManager = new TacheManager();
	    List<TacheModel> taches = tacheManager.getAllTachesByService(idService);
	     
  if (taches.isEmpty()) {  // Verifier si la table est vide ou non 
 %>
	    <tr>
	      <td colspan="7" class="text-center"> <b style="color:#008080;"> Aucun Tâche disponible </b> </td>
	    </tr>
 <% }
	  
  for (TacheModel tache : taches) {
%>          
         <tr>
       	     <td><%= tache.getDescription() %></td>
             <td class="text-center">     
	            <%  // Vérifier si le pourcentage actuel est inférieur à 100%
	               if (tache.getPourAvan() < 100) {  %>
	                  <input style="background-color: transparent; border: none; outline: none;"
	                          type="number" value="<%= tache.getPourAvan() %>" min="0" max="100" 
	                          onchange="updatePourcentage(this)" 
	                          id="<%= tache.getIdTache() %>"  />
	            <% } else { %>
	                  <%= tache.getPourAvan() %>
	            <%
	               }
	            %>
         </td>
         
       </tr>  
 <%
  } 
    connexion.disconnect(); // Fermer la connexion à la base de données.
%>
            </tbody>
            </table> 
            
              <div class="form-group row">
                  <div class="col-sm-5 offset-sm-9" >
                    <div onClick="Retour();">
                      <button style="width:30%; font-size:110%; background-color:#B0C4DE;" class="btn btn-info">Retour</button>
                    </div>                          
                  </div>
              </div>                           
             
      </div>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
 <script>
     function Retour() {
        location.replace("/consulter-projet-dev"); 
     }
     
     function updatePourcentage(inputElement) {
         var tacheId = inputElement.id;
         var nouveauPourcentage = inputElement.value;

         $.ajax({
            type: "POST",
            url: "/ModifierPourcentageAvanServlet",
            data: {
               identTache: tacheId,
               newPourcentage: nouveauPourcentage
            },
            success: function(response) {
               // alert("Pourcentage mis à jour avec succès !");
            },
            error: function(error) {
               // alert("Erreur lors de la mise à jour du pourcentage : " + error.responseText);
            }
         });
      }
     
 </script>



</body>
</html>