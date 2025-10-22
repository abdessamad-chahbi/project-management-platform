
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter Projet</title>
       <!-- Bootstrap -->
     <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous"> -->
          <link href="/Login/bootstrap-5.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body >

 <div class="container"> <br />
  <div class="row">
      <div class="card col-md-7 offset-md-2 offset-md-3"> <br />
          <h3 class="text-center">Ajouter Projet</h3>
          <div class='card-body'>
              <form action="/AjouterModifierProjetServlet?action=ajouter" method="post" onsubmit="onSubmitForm();" >
                  <div class="form-group row">
                      <label class="col-sm-3 col-form-label">Nom Projet :</label>
                      <div class="col-sm-9">
                          <input name="nomProjet" placeholder="Le nom du projet" class="form-control"  />  <!-- required -->
                      </div>
                  </div> <br/>
                   <div class="form-group row">
                      <label class="col-sm-3 col-form-label">Description :</label>
                      <div class="col-sm-9">
                          <input name="description" placeholder="La description du projet" class="form-control"  />
                      </div>
                  </div><br/>
                  <div class="form-group row">
                      <label class="col-sm-3 col-form-label">Client :</label>
                      <div class="col-sm-9">
                          <input name="client" placeholder="Le nom du client du projet" class="form-control"  />
                      </div>
                  </div><br/>
                  <div class="form-group row">
                      <label class="col-sm-3 col-form-label">Date Démarrage :</label>
                      <div class="col-sm-9">
                          <input name="dateDemarrage" type="date" placeholder="La date de démarrage du projet" class="form-control"  />
                      </div>
                  </div><br/>
                  <div class="form-group row">
                      <label class="col-sm-3 col-form-label">Date Livraison :</label>
                      <div class="col-sm-9">
                          <input name="dateLivraison" type="date" placeholder="La date de livraison du projet" class="form-control"  />
                      </div>
                  </div><br/>
                  <div class="form-group row">
                      <label class="col-sm-3 col-form-label">Nombre Jours :</label>
                      <div class="col-sm-9">
                          <input name="nombreJours" type="number" placeholder="Le nombre de jours de développement" class="form-control"  />
                      </div>
                  </div><br/>

                           <div class="form-group row">
                                  <div class="col-sm-5 offset-sm-8" >
                                      <button type="submit" class="btn btn-success">Enregistrer</button>
                                      <button type="button" class="btn btn-danger" onClick="Annuler();" style="margin-left:5px">Annuler</button>
                                   </div>
                              </div>
              </form>
              </div>
              </div>
                </div>
                </div><br/><br/>


    <script>
	    // Cette fonction sera appelée lorsque le formulaire est soumis
	    function onSubmitForm() {
	             history.replaceState(null, null, "/AjouterModifierProjetServlet?action=ajouter");
/* 	            setTimeout(function() {
	                location.replace("http://localhost:9090/Directeur/InterfacePrincipaleDirecteur.jsp");
	            }, 2000); */
	    }

        function Annuler() {
            if (window.confirm("Voulez-vous vraiment annuler ?")) {
                location.replace("/interface-directeur");
                // window.history.back();   
            }
        }
    </script>

</body>
</html>