package applicationWebJEE.Presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import applicationWebJEE.Connexion;
import applicationWebJEE.BusinessLogic.NotificationManager;
import applicationWebJEE.BusinessLogic.ProjetManager;
import applicationWebJEE.BusinessLogic.UserManager;
import applicationWebJEE.DataAccessObject.UserDAO;
import applicationWebJEE.Models.ProjetModel;

public class AffecterNotifierProjetServlet extends HttpServlet {

	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        
        try {
            Connexion connexion = new Connexion();
            connexion.connect(); // Établir la connexion à la base de données.
            
    	  UserDAO userDAO = new UserDAO();
    	  ProjetManager projetManager = new ProjetManager();
    	  

            NotificationManager notificationManager = new NotificationManager();
            
         // Récupérer la valeur du login depuis la session
             HttpSession session = request.getSession();
            String loginDirecteur = (String) session.getAttribute("login");
            int idDirecteur = userDAO.getIdDirecteurByLogin(loginDirecteur);
            
            // Récupérer les données du formulaire
            int idChefProjet = Integer.parseInt(request.getParameter("selectChefProjet"));
            int idProjet = Integer.parseInt(request.getParameter("selectProjet"));
            String msgNot = request.getParameter("notification");

            // Mettre à jour l'ID du chef de projet dans le projet sélectionné
            projetManager.affecterChefProjet(idProjet, idChefProjet);

            // Enregistrer la notification dans la table Notification
            notificationManager.enregistrerNotification(msgNot, idDirecteur, idChefProjet);

            // Redirection vers une page de confirmation ou autre
            response.sendRedirect("http://localhost:8083/affecter-projet");
            
        } catch (SQLException e) {
            e.printStackTrace(); 

        }
	  }
}
