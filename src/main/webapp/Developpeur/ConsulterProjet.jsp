<%@page import="applicationWebJEE.BusinessLogic.UserManager"%>
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
<title>Consulter Projet</title>
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
    <table class='table table-striped table-bordered'>
          <thead >
            <th>Nom Projet</th>
            <th>Description</th>
            <th>Client </th>
            <th>Date Dem </th>
            <th>Date Liv </th>
            <th>Nb Jours </th>
            <th style="width: 8%">Services</th>
          </thead>
         
           <tbody> 
           
<%
	  Connexion connexion = new Connexion();
	  connexion.connect(); // Établir la connexion à la base de données.
	  
	 // int idDeveppeur = 6;
	// Recuperer la valeur du login depuis la session
	  UserManager userManager = new UserManager();
      HttpSession sessionLogin = request.getSession();
      String loginDeveloppeur = (String) sessionLogin.getAttribute("login");
	  int idDeveppeur = userManager.getIdDeveloppeurByLogin(loginDeveloppeur);
	  
	 ProjetManager projetManager = new ProjetManager();
	 List<ProjetModel> projetsDev = projetManager.getProjetsDeveloppeurs(idDeveppeur);
	     
  if (projetsDev.isEmpty()) {  // Verifier si la table est vide ou non 
 %>
	    <tr>
	      <td colspan="7" class="text-center"> <b style="color:#008080;"> Aucun Projet disponible </b> </td>
	    </tr>
 <% }
	  
  for (ProjetModel projet : projetsDev) {
%>          
         <tr>
       	     <td><%= projet.getNomProj() %></td>
             <td><%= projet.getDescription() %></td>
             <td><%= projet.getClientProj() %></td>
             <td><%= projet.getDateDem() %></td>
             <td><%= projet.getDateLiv() %></td>
             <td><%= projet.getNbJoursDev() %></td>
			    <td>
			        <i class="fas fa-search" onclick="openServices(<%= projet.getIdProj() %>)"
			        style="color: #5F9EA0; cursor: pointer; margin-left: 22px; font-size: 22px; border: none; display: inline;" title="Services" ></i>    
			    </td>
         </tr>  
 <%
  } 
    connexion.disconnect(); // Fermer la connexion à la base de données.
%>
            </tbody>
            </table> 
            
              <div class="form-group row">
                  <div class="col-sm-5 offset-sm-10" >
                    <div onClick="Retour();">
                      <button style="width:30%; font-size:110%; background-color:#B0C4DE;" class="btn btn-info">Retour</button>
                    </div>                          
                  </div>
              </div>                           
             
      </div>

 <script>
     function Retour() {
        location.replace("/interface-developpeur"); 
     }
     
     function openServices(idEquipDev) {
         location.replace("/consulter-service-dev?idEquipeDev=" + idEquipDev);
     }
 </script>



</body>
</html>