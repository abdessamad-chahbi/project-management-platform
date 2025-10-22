<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Interface Principale Directeur</title>
       <!-- Bootstrap -->
     <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous"> -->
          <link href="/Login/bootstrap-5.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color:gray; color:gray">

    <!--    <h4> <b> L'interface Principale pour le Directeur ....... </b></h4>  -->

    <br/> <br/>  <br/> <br/>  <br/> <br/>
    <div  class="container"> <!-- {/* Ajoutez la classe "offset-2 offset-md-0" pour décaler le bouton de 2 colonnes vers la gauche */} -->
       <div class="row">    <!-- {/*"col-4" : chaque bouton occupe 4 colonnes sur les 12 disponibles */} -->

<!-- ------------------------------- Bouton :  "Créer Projet"-------------------------  -->
    <div class="col-4 offset-1"> <!-- {/* Ajoutez la classe "offset-2" pour décaler le bouton de 2 colonnes à droite */} -->  
      <div onClick="CreerProjet()"
         class="text-center rounded-circle border-danger p-3"
         style="width: 180px; height: 170px; border: 2px solid" >
        <img src="<%= request.getContextPath() %>/Login/images/add_project2.png" alt="" style="border-radius:50%; max-width: 100%; max-height: 100% " />
          <br/>
        <label style="margin-top:15%; font-size:110%; font-weight:bold; white-space:nowrap; color:black"> Créer Projet </label>
      </div>   
    </div>
    
<!-- ------------------------------- Bouton :  "Affecter Projet"-------------------------  -->
    <div class="col-4">  
      <div onClick="AffecterProjet()"
         class="text-center rounded-circle border-danger p-3"
         style="width: 180px; height: 170px; border: 2px solid" >
        <img src="<%= request.getContextPath() %>/Login/images/affecter_projet1.png" alt="" style="border-radius:50%; max-width: 100%; max-height: 100% " />
          <br/>
        <label style="margin-top:15%; font-size:110%; font-weight:bold; white-space:nowrap; color:black"> Affecter Projet </label>
      </div>   
    </div>
        
<!-- ------------------------------- Bouton :  "Consulter Projet"-------------------------  -->
    <div class="col-3"> <!-- {/* Ajoutez la classe "offset-2" pour décaler le bouton de 2 colonnes à droite */} -->  
      <div onClick="ConsulterProjet()"
         class="text-center rounded-circle border-danger p-3"
         style="width: 180px; height: 170px; border: 2px solid" >
        <img src="<%= request.getContextPath() %>/Login/images/consulter_projet.png" alt="" style="border-radius:50%; max-width: 100%; max-height: 100% " />
          <br/>
        <label style="margin-top:15%; font-size:110%; font-weight:bold; white-space:nowrap; color:black"> Consulter Projet </label>
      </div>   
    </div>    
        
  </div>
</div>
    <br/> <br/>

    <script>
        function CreerProjet() {
            location.replace("/ajouter-projet");
        }
        function AffecterProjet() {
            location.replace("/affecter-projet");
        }
        function ConsulterProjet() {
            location.replace("/consulter-projet");
        }
    </script>
   
</body>
</html>