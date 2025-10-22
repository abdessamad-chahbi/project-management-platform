<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Les Users</title>
       <!-- Bootstrap -->
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous"> 
         <!--  <link href="/Login/bootstrap-5.3.2-dist/css/bootstrap.min.css" rel="stylesheet"> -->
</head>
<body style="background-color: #DCDCDC;">
<div  class="container">  <!-- La debut de class="container" -->
 <br/> <br/>  
     
   <div class="row">  <!-- La debut de class="row" -->
<!-- ------------------------------- Bouton :  "Gestion Directeurs"------------------------- -->
         <div class="col-6 offset-1"> 
           <div onClick="lienInterfaceDirecteur();">
		      <div 
		         class="text-center" 
		         style="width: 280px; height:230px">
		         <img src="<%= request.getContextPath() %>/Login/images/interface_direct.png" alt="" style="border-radius:50%; max-width:100%; max-height: 100%" />
		      </div> 
           </div>
         </div>
<!-- ------------------------------- Bouton :  "Gestion Chef Projets" ------------------------ -->
         <div class="col"> 
         <div onClick="lienInterfaceChefProjet();">
		      <div 
		         class="text-center" 
		         style="width: 280px; height:230px">
		         <img src="<%= request.getContextPath() %>/Login/images/interface_chef.png" alt="" style="border-radius:50%; max-width:100%; max-height: 100%" />
		      </div> 
          </div>
         </div>
     </div> <!-- La fin de class="row" -->
<!-- ------------------------------- ------- Partie II : ------------------------------------- -->
 <br/> <br/>
 
 
    <div class="row"> 
 <!-- ------------------------------- Bouton :  "Gestion Devloppeur" ------------------------- --> 
       <div class="col-6 offset-4"> 
        <div onClick="lienInterfaceDeveloppeur();">
		      <div 
		         class="text-center" 
		         style="width: 280px; height:230px">
		         <img src="<%= request.getContextPath() %>/Login/images/interface_dev.png" alt="" style="border-radius:50%; max-width:100%; max-height: 100%" />
		      </div> 
         </div>
         </div>
       </div>  
 </div> <!-- La fin de class="container" -->
   
    <!-- Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  <script>
       function lienInterfaceDirecteur() {
    	       location.replace("/loginDirecteur");
              // location.href = "/loginDirecteur";
              // location.href = "/Login/LoginInterface.jsp";
       }  
       function lienInterfaceChefProjet() {
    	     location.replace("/loginChefProjet");
	   }  
       function lienInterfaceDeveloppeur() {
    	     location.replace("/loginDeveloppeur");
	   }  
  </script>       
</body>
</html>
