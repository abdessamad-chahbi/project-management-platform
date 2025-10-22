<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Interface Principale Developpeur</title>
       <!-- Bootstrap -->
     <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous"> -->
          <link href="/Login/bootstrap-5.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body style="background-color:gray; color:gray">
      <!-- <h4> <b> L'interface Principale pour le Developpeur ....... </b></h4> -->

 <br/> <br/>  <br/> <br/> <br/> <br/> <br/> 
    <div  class="container"> <!-- {/* Ajoutez la classe "offset-2 offset-md-0" pour décaler le bouton de 2 colonnes vers la gauche */} -->
       <div class="row">    <!-- {/*"col-4" : chaque bouton occupe 4 colonnes sur les 12 disponibles */} -->

<!-- ------------------------------- Bouton :  "Modifier Profil"-------------------------  -->
    <div class="col-3 offset-1"> <!-- {/* Ajoutez la classe "offset-2" pour décaler le bouton de 2 colonnes à droite */} -->  
      <div onClick="ModifierProfil()"
         class="text-center rounded-circle border-danger p-3"
         style="width: 180px; height: 170px; border: 2px solid" >
        <img src="<%= request.getContextPath() %>/Login/images/modifier_profil.png" alt="" style="border-radius:50%; max-width: 100%; max-height: 100% " />
          <br/>
        <label style="margin-top:15%; font-size:110%; font-weight:bold; white-space:nowrap; color:black"> Modifier Profil </label>
      </div>   
    </div>

<!-- ------------------------------- Bouton :  "Competences"-------------------------  -->
    <div class="col-3 offset-1">
      <div onClick="ConsulterCompetence()"
         class="text-center rounded-circle border-danger p-3"
         style="width: 180px; height: 170px; border: 2px solid" >
        <img src="<%= request.getContextPath() %>/Login/images/competence_dev.png" alt="" style="border-radius:50%; max-width: 100%; max-height: 100% " />
          <br/>
        <label style="margin-top:15%; font-size:110%; font-weight:bold; white-space:nowrap; color:black"> Compétences </label>
      </div>   
    </div>
    
<!-- ------------------------------- Bouton :  "Consulter Projet"-------------------------  -->
    <div class="col-3 offset-1">  
      <div onClick="ConsulterProjet()"
         class="text-center rounded-circle border-danger p-3"
         style="width: 180px; height: 170px; border: 2px solid" >
        <img src="<%= request.getContextPath() %>/Login/images/consulter_projet1.png" alt="" style="border-radius:50%; max-width: 100%; max-height: 100% " />
          <br/>
        <label style="margin-top:15%; font-size:110%; font-weight:bold; white-space:nowrap; color:black"> Consulter Projet </label>
      </div>   
    </div>
    
  </div>   
</div>      <br/> <br/>  <br/> <br/> <br/> <br/>


    <script> ConsulterCompetence
        
	    function ModifierProfil() {
	        location.replace("/modifier-profil-dev");
	    }
    
	    function ConsulterCompetence() {
	        location.replace("/ajouter-competence-dev");
	    }
    
        function ConsulterProjet() {
            location.replace("/consulter-projet-dev");
        }
        
    </script>

</body>
</html>