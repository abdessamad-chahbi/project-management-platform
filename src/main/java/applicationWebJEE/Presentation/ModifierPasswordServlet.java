package applicationWebJEE.Presentation;
import applicationWebJEE.Connexion;
import applicationWebJEE.BusinessLogic.UserManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet({"/modifier-password-directeurs", "/modifier-password-chefProjets", "/modifier-password-developpeurs"})
public class ModifierPasswordServlet extends HttpServlet {
	
	private UserManager userManager;
	
	public void init() {
		this.userManager = new UserManager();
	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String passwordConf = request.getParameter("passwordConf");
        
        Connexion connexion = new Connexion();
        
try {
	connexion.connect();
	
//--------------------  I - // Authentification du Directeur ------------------------------------------  
  if (request.getServletPath().equals("/modifier-password-directeurs")) {        
    if (login == null || login.isEmpty() || password == null || password.isEmpty() || !password.equals(passwordConf)) {
    	  messageErreur(response);
    } else {
             ResultSet resultSet = userManager.UserExiste(login, "directeur");
             if (resultSet.next()) {    // UserModel existe dans la BD  
            	 userManager.modifierPasswordUser(login, password, "directeur");
             	      messageSuccess(response);
             } else {
            	   messageErreur(response);
             }
            }
 }
  
//--------------------  II - // Authentification du Chef de Projet ------------------------------------------
  else if (request.getServletPath().equals("/modifier-password-chefProjets")) {
	    if (login == null || login.isEmpty() || password == null || password.isEmpty() || !password.equals(passwordConf)) {
	    	messageErreur(response);
	    } else {
	    	  ResultSet resultSet = userManager.UserExiste(login, "chefProjet");
	             if (resultSet.next()) {    // UserModel existe dans la BD    
	            	 userManager.modifierPasswordUser(login, password, "chefProjet");
             	      messageSuccess(response);
	             } else {           
	            	     messageErreur(response);
	             }
	            }
 }  

//--------------------  III - // Authentification du Développeur ------------------------------------------
  else if (request.getServletPath().equals("/modifier-password-developpeurs")) {
	    if (login == null || login.isEmpty() || password == null || password.isEmpty() || !password.equals(passwordConf)) {
	    	messageErreur(response);
	    } else {
	    	  ResultSet resultSet = userManager.UserExiste(login, "developpeur");
	             if (resultSet.next()) {    // UserModel existe dans la BD    
	            	 userManager.modifierPasswordUser(login, password, "developpeur");
             	      messageSuccess(response);
	             } else {           
	            	 messageErreur(response);
	             }
	            }
 }
  
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
	    connexion.disconnect();
	}
}

  
    private void messageErreur(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
       // out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
       // out.println("<link rel='stylesheet' href='https://unpkg.com/sweetalert/dist/sweetalert.css'>");
        out.println("<script src='/Gestion_Projets_DevlpInfo/src/main/webapp/Login/Swal_JS/sweetalert.min.js'></script>");
        out.println("<link rel='stylesheet' href='/Gestion_Projets_DevlpInfo/src/main/webapp/Login/Swal_JS/sweetalert.css'>");
        out.println("</head><body>");
        out.println("<script>");
        out.println("swal('Le login ou le mot de passe que vous avez saisi est incorrect. Veuillez réessayer.', { icon: 'error' });");
       // out.println("window.setTimeout(function(){ location.replace('http://localhost:9090/interface-user'); }, 3000);");
        out.println("window.setTimeout(function(){ history.back(); }, 3000);"); // Redirection après 3 secondes
        // out.println("window.history.back();"); // Revenir en arrière dans l'historique du navigateur
        out.println("</script>");
        out.println("</body></html>");
    }

    private void messageSuccess(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
       // out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
       // out.println("<link rel='stylesheet' href='https://unpkg.com/sweetalert/dist/sweetalert.css'>");
        out.println("</head><body>");
        out.println("<script>");
        out.println("swal('Le mot de passe a été modifié avec succès.', { icon: 'success' });");
        out.println("window.setTimeout(function(){ location.replace('http://localhost:8083/interface-user'); }, 3000);"); // Redirection après 3 secondes
        out.println("</script>");
        out.println("</body></html>");
    }   
}