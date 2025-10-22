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

<!--  ----------- La barre de rechereche : ---------------------------------------------------------   -->
  <div class="form-group" style="display: flex; align-items: center; margin-left: 70px;">
    <label for="search" style="font-weight: bold; color: #008080; margin-right: 20px;">Nom Projet : </label>
    <input type="text" class="form-control col-sm-4" id="search" name="search" placeholder="Rechercher par le nom du projet" style="flex: 1; margin-right: 20px;">
 <a href="" onclick="updateRechercheParNom()">
    <button type="submit" class="btn btn-primary" style="margin-right: 30px;">Rechercher</button>
</a>
    <button type="reset" class="btn btn-primary" style="margin-right: 80px; margin-left: -10px;" onclick="reinitialiserPage()">Réinitialiser</button>
   </div>
<!--  ---------------------------------------------------------------------------------------------     -->
<br />
    <table class='table table-striped table-bordered'>
          <thead >
            <th>Nom Projet</th>
            <th>Description</th>
            <th>Client </th>
            <th>Date Dem </th>
            <th>Date Liv </th>
            <th>Nb Jours </th>
            <th style="width:13%">Actions</th>
          </thead>
         
           <tbody> 
           
<%
	  Connexion connexion = new Connexion();
	  connexion.connect(); // Établir la connexion à la base de données.
	/*
	   ResultSet projets = connexion.getAllDataProjets(); // Récupérer les données de la table "Projet".
	 */
	 ProjetDAO projetDAO = new ProjetDAO();
	 List<ProjetModel> projets = projetDAO.getAllDataProjets();
	   
// ----------------------- Pagination : -------------------------------------------------------------
  int currentPage = 1;
	  String currentPageParam = request.getParameter("currentPage");
	  if (currentPageParam != null) {
	      currentPage = Integer.parseInt(currentPageParam);
	  }
  // int itemsPerPage = 1; // Le nombre de lignes affichees pour chaque page
  int itemsPerPage = 10; // Le nombre de lignes affichees pour chaque page
  int startIndex = (currentPage - 1) * itemsPerPage;
  int endIndex = currentPage * itemsPerPage;
  
   int totalRows = 0;
/*  while (projets.next()) {
      totalRows++; }
   projets.beforeFirst(); // Revenir au début du ResultSet */
  
  totalRows = projets.size();
  int totalPages = (int) Math.ceil((double) totalRows / itemsPerPage);
   
   // La Recherche par le nom du projet 
   String searchTerm = request.getParameter("search");
   List<ProjetModel> displayedProjets;
   if (searchTerm != null && !searchTerm.isEmpty()) {
         displayedProjets = projetDAO.rechercheProjetsParNom(searchTerm);
   } else {
        displayedProjets = projetDAO.getPaginationDataProjets(startIndex, itemsPerPage);
   }
//---------------------------------------------------------------------------------------------------
	  
  if (displayedProjets.isEmpty()) {  // Verifier si la table est vide ou non 
 %>
	    <tr>
	      <td colspan="7" class="text-center"> <b style="color:#008080;"> Aucun Projet disponible </b> </td>
	    </tr>
 <% }
	  
  for (ProjetModel projet : displayedProjets) {
%>          
         <tr>
       	     <td><%= projet.getNomProj() %></td>
             <td><%= projet.getDescription() %></td>
             <td><%= projet.getClientProj() %></td>
             <td><%= projet.getDateDem() %></td>
             <td><%= projet.getDateLiv() %></td>
             <td><%= projet.getNbJoursDev() %></td>
                <td> 
                  <a href="/modifier-projet?identProjet=<%= projet.getIdProj() %>" style="color: green; cursor: pointer; margin-left: 25px; font-size: 22px;"
                      onclick="return confirm('Voulez-vous vraiment modifier ce projet ?')"
                      title="Edit"> <i class="fas fa-edit"></i> 
                   </a>
		          <form action='/DeleteProjectServlet?idProjet=<%= projet.getIdProj() %>' id="<%= projet.getIdProj() %>" method="post"  style="display: inline;">
		            <button type="button" onclick="confirmDelete('<%= projet.getIdProj() %>')" style="color: red; cursor: pointer; margin-left: 22px; font-size: 22px; border: none; display: inline;" title="Delete">
		                <i class="fas fa-trash-alt"></i>
		            </button>
		          </form>
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
                  
<div class="pagination" style="margin-top: -3.3%; margin-left: 3%;">
    <ul class="pagination">
        <li class="page-item">
            <div class="page-link" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </div>
        </li>
        <% for (int pageNumber = 1; pageNumber <= totalPages; pageNumber++) { %>
            <li class="page-item <%= pageNumber == currentPage ? "active" : "" %>">
               <a class="page-link" href="?currentPage=<%= pageNumber %>" onclick="updatePagination(<%= pageNumber %>)"><%= pageNumber %></a>    
             <%--  <a class="page-link" href="javascript:void(0);" onclick="loadPage(<%= pageNumber %>)"><%= pageNumber %></a>   --%> 
            </li>
        <% } %>
        <li class="page-item">
            <div class="page-link" aria-label="Next" >
                <span aria-hidden="true">&raquo;</span>
            </div>
        </li>
    </ul>
</div>
  
                             
             
      </div>

 <script>
     function Retour() {
        location.replace("/interface-directeur"); 
     }
     
     function confirmDelete(idProjet) {
         if (confirm("Voulez-vous vraiment supprimer ce projet ?")) {
             // Si l'utilisateur confirme la suppression, soumettez le formulaire.
             document.getElementById(idProjet).submit();
         }
      }
   // l'URL précédente sera remplacée par la nouvelle URL. Supprimer l'URL précédente 
     function updatePagination(pageNumber) {
	         // window.location.pathname : Obtient le chemin de l'URL de la page web actuelle.
    	    const newUrl = window.location.pathname + "?currentPage=" + pageNumber;
    	    history.replaceState({}, "", newUrl);
    	}
   
     function updateRechercheParNom() {
    	const searchNomPrj = document.getElementById('search').value;
    	if (searchNomPrj.trim() !== '') {
		    const newUrl = window.location.pathname + "?search=" + searchNomPrj;
		    history.replaceState({}, "", newUrl);
        } else {
            alert("Veuillez saisir un nom de projet avant de rechercher.");
        }
	}
     
     function reinitialiserPage() {
         // Redirige l'utilisateur vers la nouvelle page.
         window.location.replace("http://localhost:8083/consulter-projet");
     }
 </script>



</body>
</html>