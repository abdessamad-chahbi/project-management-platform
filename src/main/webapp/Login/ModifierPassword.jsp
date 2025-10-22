<%--
<%@ page import="your.package.name.Etudiant" %>
<%@ page import="your.package.name.Professeur" %>
<%@ page import="your.package.name.Responsable" %>

 <link rel="stylesheet" type="text/css" href="LoginInterfaceCSS.css">
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Modifier Password</title>
     <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Login/LoginInterfaceCSS.css">
       <!-- Bootstrap -->
     <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous"> -->
          <link href="/Login/bootstrap-5.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="main-login">
        <div class="login-contain container">
            <div class="left-side">
                <h4 style="margin-top:6%; margin-left:14%">Modification de mot de passe</h4>
                <form action="<%= request.getServletPath() + "s" %>" method="post" style="margin-top: 8%;" onsubmit="resetFormFields()" >
                
                    <label class="label-label" for="text"> <h6> Login :</h6> </label>
                    <input type="text" name="login" id="login" class="input-login" placeholder="Entrez votre login..." value="" />
                    
                    <label class="label-label" for="pwd1"> <h6>Password :</h6> </label>
                    <input type="password" name="password" id="password" class="input-login" placeholder="Entrez votre mot de passe..." value="" onchange="setpassval(this.value);" />

                    <label class="label-label" for="pwdConf"> <h6>Confirm Password :</h6> </label>
                    <input type="password" name="passwordConf" id="passwordConf" class="input-login" placeholder="Veuillez confirmer le nouveau mot de passe..." value="" onchange="setpassconf(this.value);" />
                    
            <button type="submit" id="sub-butt" class="btn btn" style="margin-right: -32%; background: #008B8B"> Modifier </button>
            <button onClick="RetourPageUser();" type="button" id="sub-butt" class="btn btn-danger" style="background: #DC143C"> Retour </button>
                </form> <br/>
                                
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
	    function resetFormFields() {
	        // Réinitialise les champs de saisie
	        /* document.getElementById('login').value = '';
	        document.getElementById('password').value = '';
	        document.getElementById('passwordConf').value = ''; */
	    }
    
        function RetourPageUser() {
        	// alert("La fonction RetourPageUser a été appelée.");
            if (window.confirm("Voulez-vous vraiment annuler ?")) {
            	location.replace("/interface-user");
            }
        }
    </script>
    
</body>
</html>
