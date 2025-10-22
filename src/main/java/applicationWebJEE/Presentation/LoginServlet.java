package applicationWebJEE.Presentation;

import applicationWebJEE.Connexion;
//import applicationWebJEE.ConnexionMongoDB;
import applicationWebJEE.BusinessLogic.ProjetManager;
import applicationWebJEE.BusinessLogic.UserManager;
import applicationWebJEE.DataAccessObject.UserDAO;
import applicationWebJEE.Models.ProjetModel;
import applicationWebJEE.Models.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//import org.bson.Document;
 

@WebServlet({"/loginDirecteurs", "/loginChefProjets", "/loginDeveloppeurs"})
public class LoginServlet extends HttpServlet {
	
	private UserManager userManager;
	private ProjetManager projetManager;
	
	public void init() {
		this.userManager = new UserManager();
		this.projetManager = new ProjetManager();
	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        
     // Stocker la valeur du login dans la session
        HttpSession session = request.getSession();
        session.setAttribute("login", login);
        
        Connexion connexion = new Connexion();
       // ConnexionMongoDB connexion = new ConnexionMongoDB();
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
try {
	connexion.connect();
//----------------------------------------------------------------------------------
	// Stocker les données dans la session
    List<UserModel> allChefProjets = userManager.recupererTousChefProjets();
    List<ProjetModel> projetsNonAffectes = projetManager.getProjetsNonAffectes();
   // HttpSession session = request.getSession();
    session.setAttribute("allChefProjets", allChefProjets);
    session.setAttribute("projetsNonAffectes", projetsNonAffectes);
//------------------------------------------------------------------------------------
    
//--------------------  I - // Authentification du Directeur ------------------------------------------  
  if (request.getServletPath().equals("/loginDirecteurs")) {        
    if (login == null || login.isEmpty() || password == null || password.isEmpty()) {
    	  messageErreur(response);
      // response.sendRedirect("/loginDirecteur");
    } else {
              ResultSet resultSet = userManager.authenticationUser(login, password, "directeur");
             // Document user = connexion.authenticationUser(login, password, "Directeur");          
             // if(user != null) {
             if (resultSet.next()) {   // Les informations d'identification sont correcte         
                // request.setAttribute("status", "success");
             	  response.sendRedirect("/interface-directeur");
             	    // out.println("<script>");
             	    // out.println("window.location.replace('/Directeur/InterfacePrincipaleDirecteur.jsp');");
             	    // out.println("</script>");
             } else {    // Les informations d'identification sont incorrectes            
                // request.setAttribute("status", "failed");
            	// RequestDispatcher disp=request.getRequestDispatcher("/loginDirecteur");
                // disp.forward(request, response);
                // response.sendRedirect("/loginDirecteur");
            	   messageErreur(response);
             }
            }
 }
  
//--------------------  II - // Authentification du Chef de Projet ------------------------------------------
  else if (request.getServletPath().equals("/loginChefProjets")) {
	    if (login == null || login.isEmpty() || password == null || password.isEmpty()) {
	    	// response.sendRedirect("/loginChefProjet");
	    	messageErreur(response);
	    } else {
	    	 ResultSet resultSet = userManager.authenticationUser(login, password, "chefProjet");
	    	// Document user = connexion.authenticationUser(login, password, "ChefProjet");
	            if (resultSet.next()) {   
	    	    // if(user != null) {
	             	  response.sendRedirect("/interface-chefProjet");
	             } else {           
	                 // response.sendRedirect("/loginChefProjet");
	            	     messageErreur(response);
	             }
	            }
 }  

//--------------------  III - // Authentification du Développeur ------------------------------------------
  else if (request.getServletPath().equals("/loginDeveloppeurs")) {
	    if (login == null || login.isEmpty() || password == null || password.isEmpty()) {
	    	// response.sendRedirect("/loginDeveloppeur");
	    	messageErreur(response);
	    } else {
	    	 ResultSet resultSet = userManager.authenticationUser(login, password, "developpeur");
	    	 // Document user = connexion.authenticationUser(login, password, "Developpeur");
	            if (resultSet.next()) {   
	    	    // if(user != null) {
	             	  response.sendRedirect("/interface-developpeur");
	             } else {           
	                 // response.sendRedirect("/loginDeveloppeur");
	            	 messageErreur(response);
	             }
	            }
 }
  
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
	   // connexion.disconnect();
	}
}
  
    private void messageErreur(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
        out.println("<link rel='stylesheet' href='https://unpkg.com/sweetalert/dist/sweetalert.css'>");
        out.println("</head><body>");
        out.println("<script>");
        out.println("swal('Le login ou le mot de passe que vous avez saisi est incorrect. Veuillez réessayer.', { icon: 'error' });");
        out.println("window.setTimeout(function(){ history.back(); }, 3000);"); // Redirection après 3 secondes
     // out.println("window.history.back();"); // Revenir en arrière dans l'historique du navigateur
        out.println("</script>");
        out.println("</body></html>");
    }

    
}



//@WebServlet(name = "LoginServlet", urlPatterns = {"/loginDirecteur", "/loginChefProjet", "/loginDeveloppeur"})
//ResultSet resultSet = preparedStatement.executeQuery();
//dispatcher=request.getRequestDispatcher("/Login/LoginInterface.jsp");
//dispatcher.forward(request, response);
//PrintWriter out = response.getWriter();
//out.print(request.getServletPath());