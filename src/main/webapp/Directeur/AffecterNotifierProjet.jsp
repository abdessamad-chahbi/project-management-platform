<%@page import="applicationWebJEE.BusinessLogic.UserManager"%>
<%@page import="applicationWebJEE.DataAccessObject.NotificationDAO"%>
<%@page import="applicationWebJEE.Models.UserModel"%>
<%@page import="applicationWebJEE.BusinessLogic.ProjetManager"%>
<%@page import="applicationWebJEE.DataAccessObject.UserDAO"%>
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
<title>Affecter Notifier Projet</title>
       <!-- Bootstrap -->
     <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous"> -->
          <link href="/Login/bootstrap-5.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Add Font Awesome for icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>

<%
	  Connexion connexion = new Connexion();
	  connexion.connect(); // �tablir la connexion � la base de donn�es.
	  UserManager userManager = new UserManager();
	  ProjetManager projetManager = new ProjetManager();
	  
	  List<UserModel> allChefProjets = userManager.recupererTousChefProjets();
	  List<ProjetModel> projetsNonAffectes = projetManager.getProjetsNonAffectes();
%>

<%--   <%	  
      List<UserModel> allChefProjets = (List<UserModel>) session.getAttribute("allChefProjets");
	  List<ProjetModel> projetsNonAffectes = (List<ProjetModel>) session.getAttribute("projetsNonAffectes");
   %> --%>

 <div class="container"> <br /> <br /> <br /> 
  <div class="row">
      <div class="card col-md-7 offset-md-2 offset-md-3"> <br />
          <h3 class="text-center">Affecter Projet</h3>
          <div class='card-body'>
              <form action="/AffecterNotifierProjetServlet" method="post" >
                  <div class="form-group row">
                      <label class="col-sm-4 col-form-label"> Le chef de projet :</label>
                      <div class="col-sm-8">
                          <select name="selectChefProjet" id="selectChefProjet" class="form-control">
					        <% for (UserModel chefPrj : allChefProjets) { %>
					            <option value="<%= chefPrj.getId() %>"><%= chefPrj.getNom() + " " + chefPrj.getPrenom()  %></option>
					        <% } %>
						  </select>
                      </div>
                  </div> <br/> 
                  
                    <div class="form-group row">
                      <label class="col-sm-4 col-form-label"> Sélectionnez le projet :</label>
                      <div class="col-sm-8">
                          <select name="selectProjet" id="selectProjet" class="form-control" required>
					        <% for (ProjetModel projet : projetsNonAffectes) { %>
					            <option value="<%= projet.getIdProj() %>"><%= projet.getNomProj() %></option>
					        <% } %>
						  </select>
                      </div>
                  </div> <br/> 
                  
                  <div class="form-group row">
                      <label class="col-sm-4 col-form-label">Message de notification :</label>
                      <div class="col-sm-8">
                          <input name="notification" placeholder="Le message du directeur qui notifie le chef de projet" class="form-control" required />
                      </div>
                  </div><br/>
                       <div class="col-sm-4 offset-sm-8" >
                           <button type="submit" class="btn btn-success">Affecter et Notifier</button>
                       </div>
               </form>
             </div> 
           </div> 
        </div> 
     </div> 

  <br /> 
  
  
<div class='container'>

              <div class="form-group row">
                  <div class="col-sm-5 offset-sm-8" >
                    <div onClick="Retour();">
                      <button style="width:30%; font-size:110%; background-color:#B0C4DE;" class="btn btn-info">Retour</button>
                    </div>                          
                  </div>
              </div>
    
      </div>
      
<br /> <br /> <br /> 

 <script>
     function Retour() {
        location.replace("/interface-directeur"); 
     }
      

 </script>



</body>
</html>