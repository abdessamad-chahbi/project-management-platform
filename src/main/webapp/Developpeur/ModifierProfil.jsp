<%@page import="applicationWebJEE.Models.UserModel"%>
<%@page import="applicationWebJEE.BusinessLogic.UserManager"%>
<%@page import="applicationWebJEE.BusinessLogic.ProjetManager"%>
<%@page import="applicationWebJEE.Models.ProjetModel"%>
<%@page import="applicationWebJEE.DataAccessObject.ProjetDAO"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="applicationWebJEE.Connexion" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier Profil</title>
       <!-- Bootstrap -->
     <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous"> -->
          <link href="/Login/bootstrap-5.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
<body >

 <div class="container"> <br />
  <div class="row">
      <div class="card col-md-7 offset-md-2 offset-md-3"> <br />
          <h3 class="text-center">Modifier Profil</h3>
          <div class='card-body'>
          
  <% 
      // int identDevelopp = 6;
      Connexion connexion = new Connexion();
      UserManager userManager = new UserManager();
      
  	// Recuperer la valeur du login depuis la session
      HttpSession sessionLogin = request.getSession();
      String loginDeveloppeur = (String) sessionLogin.getAttribute("login");
	  int identDevelopp = userManager.getIdDeveloppeurByLogin(loginDeveloppeur);
	  
      UserModel developpeur = userManager.getDeveloppeurById(identDevelopp);
      
      if (developpeur != null) {
  %>
          
              <form action="/ModifierProfilDevServlet" method="post" onsubmit="return onSubmitForm()">            
                  <div class="form-group row">
                      <label class="col-sm-3 col-form-label">Nom :</label>
                      <div class="col-sm-9">
                      <input type="hidden" name="identDeveloppeur" class="form-control" value="<%= developpeur.getId()%>" />
                          <input name="nomDev" placeholder="Le nom du développeur" class="form-control" value="<%= developpeur.getNom() %>" required />  <!-- required -->
                      </div>
                  </div> <br/>
                   <div class="form-group row">
                      <label class="col-sm-3 col-form-label">Prénom :</label>
                      <div class="col-sm-9">
                          <input name="prenomDev" placeholder="Le prénom du développeur" class="form-control" value="<%= developpeur.getPrenom() %>" required />
                      </div>
                  </div><br/>
                  <div class="form-group row">
                      <label class="col-sm-3 col-form-label">Login :</label>
                      <div class="col-sm-9">
                          <input name="loginDev" placeholder="Le login du développeur" class="form-control" value="<%= developpeur.getLogin() %>" required />
                      </div>
                  </div><br/>
                  <div class="form-group row">
                      <label class="col-sm-3 col-form-label">Password :</label>
                      <div class="col-sm-9">
                          <input name="passwordDev" type="password" placeholder="Le mot de passe du développeur" class="form-control" value="<%= developpeur.getPassword() %>" required />
                      </div>
                  </div><br/>
                  <div class="form-group row">
                      <label class="col-sm-3 col-form-label">Confirm Password:</label>
                      <div class="col-sm-9">
                          <input name="passwordConfDev" type="password" placeholder="Confirmer le mot de passe du développeur" class="form-control" value="<%= developpeur.getPassword() %>" required />
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
    /* function onSubmitForm() {
        window.history.replaceState(null, null, "/ModifierProfilDevServlet");
    } */
    
    function onSubmitForm() {
        var password = document.getElementsByName("passwordDev")[0].value;
        var confirmPassword = document.getElementsByName("passwordConfDev")[0].value;

        if (password !== confirmPassword) {
            alert("Le mot de passe et sa confirmation ne correspondent pas.");
            return false; // Empêche la soumission du formulaire si les mots de passe ne correspondent pas
        }

        // Si les mots de passe correspondent, soumettez le formulaire normalement
        window.history.replaceState(null, null, "/ModifierProfilDevServlet");
        return true;
    }
    
    function Annuler() {
        if (window.confirm("Voulez-vous vraiment annuler ?")) {
            location.replace("/interface-developpeur");  
        }
    }
    </script>

</body>
</html>