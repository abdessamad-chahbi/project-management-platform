<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Interface Principale Chef Projet</title>
       <!-- Bootstrap -->
     <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous"> -->
          <link href="/Login/bootstrap-5.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
</head>
      
<body style="background-color:gray; color:gray">
      <!-- <h4> <b> L'interface Principale pour le Chef du Projet ....... </b></h4> -->

    <br/> <br/>
    <div  class="container"> <!-- {/* Ajoutez la classe "offset-2 offset-md-0" pour d�caler le bouton de 2 colonnes vers la gauche */} -->
       <div class="row">    <!-- {/*"col-4" : chaque bouton occupe 4 colonnes sur les 12 disponibles */} -->

<!-- ------------------------------- Bouton :  "Recevoir Notifications"-------------------------  -->
    <div class="col-4 offset-2"> <!-- {/* Ajoutez la classe "offset-2" pour d�caler le bouton de 2 colonnes � droite */} -->  
      <div class="text-center rounded-circle border-danger p-3"
         style="width: 180px; height: 170px; border: 2px solid" >
        <img src="<%= request.getContextPath() %>/Login/images/notification.png" alt="" style="border-radius:50%; max-width: 100%; max-height: 100% " />
          <br/>
        <label style="margin-top:15%; font-size:110%; font-weight:bold; white-space:nowrap; color:black"> Notifications </label>
      </div>   
    </div>
    
<!-- ------------------------------- Bouton :  "Consulter Projet"-------------------------  -->
    <div class="col-4 offset-1">  
      <div onClick="ConsulterProjet()"
         class="text-center rounded-circle border-danger p-3"
         style="width: 180px; height: 170px; border: 2px solid" >
        <img src="/Login/images/affecter_projet.png" alt="" style="border-radius:50%; max-width: 100%; max-height: 100% " />
          <br/>
            <label style="margin-top:15%; font-size:110%; font-weight:bold; white-space:nowrap; color:black; cursor: pointer;"> 
                Consulter Projet 
            </label>
      </div>   
    </div>
    
  </div>   
</div>      <br/> <br/>  <br/> <br/>
 
     <div  class="container"> <!-- {/* Ajoutez la classe "offset-2 offset-md-0" pour d�caler le bouton de 2 colonnes vers la gauche */} -->
       <div class="row">        
<!-- ------------------------------- Bouton :  "Planifier Réunion"-------------------------  -->
    <div class="col-4 offset-2">
      <div class="text-center rounded-circle border-danger p-3"
         style="width: 180px; height: 170px; border: 2px solid" >
        <img src="<%= request.getContextPath() %>/Login/images/planifier_reunion.png" alt="" style="border-radius:50%; max-width: 100%; max-height: 100% " />
          <br/>
        <label style="margin-top:15%; font-size:110%; font-weight:bold; white-space:nowrap; color:black"> Planifier Reunion </label>
      </div>   
    </div>    

<!-- ------------------------------- Bouton :  "Affecter Service"-------------------------  -->
    <div class="col-3 offset-1"> <!-- {/* Ajoutez la classe "offset-2" pour d�caler le bouton de 2 colonnes � droite */} -->  
      <div class="text-center rounded-circle border-danger p-3"
         style="width: 180px; height: 170px; border: 2px solid" >
        <a href="<%= request.getContextPath() %>/ProjetPourService?idChef=4">
        <img src="<%= request.getContextPath() %>/Login/images/consulter_projet.png" alt="" style="border-radius:50%; max-width: 100%; max-height: 100% " />
        </a>
          <br/>
        <label style="margin-top:15%; font-size:110%; font-weight:bold; white-space:nowrap; color:black"> Affecter Service </label>
      </div>   
    </div>  
        
  </div>
</div>
    <br/> <br/>


    <script>
        function RecevoirNotifications() {
            
        }
        
        function ConsulterProjet() {
            location.replace("/chefProjet/consulter?idChef=4");
        }
    </script>

</body>
</html>