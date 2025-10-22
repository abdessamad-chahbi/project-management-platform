<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Page de connexion</title>
     <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Login/LoginInterfaceCSS.css">
       <!-- Bootstrap -->
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <!--   <link href="/Login/bootstrap-5.3.2-dist/css/bootstrap.min.css" rel="stylesheet"> -->
</head>
<body>

<input type="hidden" id="status" value="<%= request.getAttribute("status") %>" />

    <div class="main-login">
        <div class="login-contain container">
            <div class="left-side">
                <h4>Bienvenue sur notre plateforme en ligne !</h4>
                <form action="<%= request.getServletPath() + "s" %>" method="post" style="margin-top: 15%;">
                
                    <label class="label-label" for="text"> <h6> Login :</h6> </label>
                    <input type="text" name="login" id="login" class="input-login" placeholder="Entrez votre login..." value="" />
                    
                    <label class="label-label" for="pwd1"> <h6>Password :</h6> </label>
                    <input type="password" name="password" id="pwd1" class="input-login" placeholder="Entrez votre mot de passe..." value="" onchange="setpassval(this.value);" />
                    
            <button type="submit" id="sub-butt" class="btn btn" style="margin-right: -32%; background: #008B8B"> Vérifier </button>
            <button onClick="RetourPageUser();" type="button" id="sub-butt" class="btn btn-danger" style="background: #DC143C"> Retour </button>
                </form> <br/>
                                
<div class="text-center mt-3">
    <h6 style="cursor:pointer;"> <div onClick="ModifierPassword();"> Mot de passe oublié ? </div> </h6>
</div>
</div>  <!-- La fin de class="left-side"  -->

<div class="right-side">
    <div class="welcomeimg img-class">
        <img src="<%= request.getContextPath() %>/Login/images/logo1.png" id="img-id" alt="" class="w-100" />
    </div>
</div>   <!-- La fin de class="right-side"  -->

        </div> <!-- La fin de class="login-contain container"  -->
    </div>  <!-- La fin de class="main-login"  -->

<!-- Bootstrap -->    
    <!-- Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

    <script>
        function RetourPageUser() {
        	// alert("La fonction RetourPageUser a été appelée.");
            if (window.confirm("Voulez-vous vraiment annuler ?")) {
                // location.href = "/interface-user";
                location.replace("/interface-user");
            }
        }
        
        function ModifierPassword() {
            if (window.confirm("Voulez-vous vraiment modifier le mot de passe ?")) {
            	var currentPath = location.pathname;
            	
                if (currentPath === '/loginDirecteur') {
                	location.replace('/modifier-password-directeur');
                    
                } else if (currentPath === '/loginChefProjet') {
                	location.replace('/modifier-password-chefProjet');
                    
                } else if (currentPath === '/loginDeveloppeur') {
                	location.replace('/modifier-password-developpeur');
                }
            }
        }
    </script>
  
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">  
  
  <script type="text/javascript">
      var status = document.getElementById("status").value
          // var status = "<%= request.getAttribute("status") %>"; 
      if (status === "success") {
          swal("Congrats", "Les données sont correctes", "success");
      } else if (status === "vide") {
          swal("Erreur", "Veuillez remplir tous les champs", "error");
      } else if (status === "failed") {
          swal("Erreur", "Identifiants incorrects. Veuillez réessayer.", "error");
      }
  </script>

  
</body>
</html>
