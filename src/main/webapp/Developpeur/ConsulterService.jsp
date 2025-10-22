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
<title>Consulter Service</title>
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
            <th class="text-center" >Description Service</th>
            <th class="text-center">Duree Service</th>
            <th class="text-center">Tâches</th>
          </thead>
         
           <tbody> 
           
<%
	  Connexion connexion = new Connexion();
	  connexion.connect(); // Établir la connexion à la base de données.
	  
	  int idEquipeDevPrj = Integer.parseInt(request.getParameter("idEquipeDev"));

	    ServiceManager serviceManager = new ServiceManager();
	    List<ServiceModel> servicesDeveloppeur = serviceManager.getServicesForDeveloppeur(idEquipeDevPrj);
	     
  if (servicesDeveloppeur.isEmpty()) {  // Verifier si la table est vide ou non 
 %>
	    <tr>
	      <td colspan="7" class="text-center"> <b style="color:#008080;"> Aucun Service disponible </b> </td>
	    </tr>
 <% }
	  
  for (ServiceModel service : servicesDeveloppeur) {
%>          
         <tr>
       	     <td><%= service.getDescription() %></td>
             <td th class="text-center"><%= service.getDureeSer() %></td>
               <td>
			        <i class="fas fa-search" onclick="openTaches(<%= service.getIdSer() %>)"
			        style="color: #5F9EA0; cursor: pointer; margin-left: 30px; font-size: 22px; border: none; display: inline;" title="Services" ></i>    
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

 <script>
     function Retour() {
        location.replace("/consulter-projet-dev"); 
     }
     
     function openTaches(idServ) {
         location.replace("/consulter-tache-dev?idService=" + idServ);
     }
 </script>



</body>
</html>