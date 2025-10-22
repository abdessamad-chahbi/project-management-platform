<%@page import="applicationWebJEE.BusinessLogic.ProjetManager"%>
<%@page import="applicationWebJEE.Models.ProjetModel"%>
<%@page import="applicationWebJEE.DataAccessObject.ProjetDAO"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="applicationWebJEE.Connexion" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier Projet</title>
       <!-- Bootstrap -->
     <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous"> -->
          <link href="/Login/bootstrap-5.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
<body >

 <div class="container"> <br />
  <div class="row">
      <div class="card col-md-7 offset-md-2 offset-md-3"> <br />
          <h3 class="text-center">Modifier Projet</h3>
          <div class='card-body'>
          
  <% 
      int identProjet = Integer.parseInt(request.getParameter("identProjet"));
      Connexion connexion = new Connexion();
      ProjetManager projetManager = new ProjetManager();
      ProjetModel projet = projetManager.getProjetById(identProjet);
      
      if (projet != null) {
  %>
          
              <form action="/AjouterModifierProjetServlet?action=modifier" method="post" onsubmit="onSubmitForm()">            
                  <div class="form-group row">
                      <label class="col-sm-3 col-form-label">Nom Projet :</label>
                      <div class="col-sm-9">
                      <input type="hidden" name="identProjectMod" class="form-control" value="<%= projet.getIdProj()%>" />
                          <input name="nomProjet" placeholder="Le nom du projet" class="form-control" value="<%= projet.getNomProj() %>" />  <!-- required -->
                      </div>
                  </div> <br/>
                   <div class="form-group row">
                      <label class="col-sm-3 col-form-label">Description :</label>
                      <div class="col-sm-9">
                          <input name="description" placeholder="La description du projet" class="form-control" value="<%= projet.getDescription() %>" />
                      </div>
                  </div><br/>
                  <div class="form-group row">
                      <label class="col-sm-3 col-form-label">Client :</label>
                      <div class="col-sm-9">
                          <input name="client" placeholder="Le nom du client du projet" class="form-control" value="<%= projet.getClientProj() %>" />
                      </div>
                  </div><br/>
                  <div class="form-group row">
                      <label class="col-sm-3 col-form-label">Date Démarrage :</label>
                      <div class="col-sm-9">
                          <input name="dateDemarrage" type="date" placeholder="La date de démarrage du projet" class="form-control" value="<%= projet.getDateDem() %>" />
                      </div>
                  </div><br/>
                  <div class="form-group row">
                      <label class="col-sm-3 col-form-label">Date Livraison :</label>
                      <div class="col-sm-9">
                          <input name="dateLivraison" type="date" placeholder="La date de livraison du projet" class="form-control" value="<%= projet.getDateLiv() %>" />
                      </div>
                  </div><br/>
                  <div class="form-group row">
                      <label class="col-sm-3 col-form-label">Nombre Jours :</label>
                      <div class="col-sm-9">
                          <input name="nombreJours" type="number" placeholder="Le nombre de jours de développement" class="form-control" value="<%= projet.getNbJoursDev() %>" />
                      </div>
                  </div><br/>

                  <div class="form-group row">
                                  <div class="col-sm-5 offset-sm-8" >
                                      <button type="submit" class="btn btn-success">Enregistrer</button>
                                      
                                      <button type="button" class="btn btn-danger" onClick="Annuler();" style="margin-left:5px">Annuler</button>
                                
                                   </div>
                              </div>
                              
 <%
     }
     connexion.disconnect();
 %>
                              
              </form>
              </div>
              </div>
                </div>
                </div><br/><br/>


    <script>
    // Cette fonction sera appelée lorsque le formulaire est soumis
    function onSubmitForm() {
        window.history.replaceState(null, null, "/AjouterModifierProjetServlet?action=modifier");
    }
        function Annuler() {
            if (window.confirm("Voulez-vous vraiment annuler ?")) {
                location.replace("/consulter-projet");
                // window.history.back();   
            }
        }
    </script>

</body>
</html>