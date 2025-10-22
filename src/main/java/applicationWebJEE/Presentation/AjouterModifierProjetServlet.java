package applicationWebJEE.Presentation;
import applicationWebJEE.Connexion;
import applicationWebJEE.BusinessLogic.ProjetManager;
import applicationWebJEE.DataAccessObject.ProjetDAO;
import applicationWebJEE.Models.ProjetModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

// Couche Présentation (exemple avec une servlet)
// La Couche Présentation 
public class AjouterModifierProjetServlet extends HttpServlet {
	private ProjetManager projetManager;
	
	public void init() {
        this.projetManager = new ProjetManager();
    }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// Récupérer les données du formulaire
        String nomProjet = request.getParameter("nomProjet");
        String description = request.getParameter("description");
        String client = request.getParameter("client");
        String dateDemarrageStr = request.getParameter("dateDemarrage");
        String dateLivraisonStr = request.getParameter("dateLivraison");
        String nombreJoursStr = request.getParameter("nombreJours");
        int nombreJours = 0; // Default value or any appropriate default value
       // String methodologie = request.getParameter("methodologie");
       // Date dateReu = Date.valueOf(request.getParameter("dateReu"));

        Date dateDemarrage = null;
        Date dateLivraison = null;

        if (!dateDemarrageStr.isEmpty()) {
            dateDemarrage = Date.valueOf(dateDemarrageStr);
        }

        if (!dateLivraisonStr.isEmpty()) {
            dateLivraison = Date.valueOf(dateLivraisonStr);
        }
        
        if (!nombreJoursStr.isEmpty()) {
            try {
                nombreJours = Integer.parseInt(nombreJoursStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
         
     // Créez un objet ProjetModel et initialisez-le avec les données du formulaire
        ProjetModel projet = new ProjetModel();
        projet.setNomProj(nomProjet);
        projet.setDescription(description);
        projet.setClientProj(client);
        projet.setDateDem(dateDemarrage);
        projet.setDateLiv(dateLivraison);
        projet.setNbJoursDev(nombreJours);
       // projet.setMethodologie(methodologie);
       // projet.setDateReu(dateReu);
        
        String action = request.getParameter("action");
        
        Connexion connexion = new Connexion();
        
try {
	 connexion.connect();
	if (nomProjet.isEmpty() || description.isEmpty() || client.isEmpty() || dateDemarrage == null || dateLivraison == null || nombreJours <= 0) {
		if ("ajouter".equals(action)) {
		     messageErreur(response, "ajouter", null);
		} else if ("modifier".equals(action)) {
			 messageErreur(response, "modifier", request);
		}
	} else {
		boolean projetExiste = projetManager.projetExistsByNom(nomProjet,-500);
	   	
		if ("ajouter".equals(action)) {
			if(projetExiste) {
				messageErreurProjetExiste(response, "ajouter", null);
			} else {
				//int rowsInserted = connexion.ajouterProjet(nomProjet, description, client, dateDemarrage, dateLivraison, nombreJours);
				// Appelez la méthode ajouterProjet de la classe ProjetDAO avec l'objet ProjetModel
				int rowsInserted = projetManager.ajouterProjet(projet);
				    if(rowsInserted > 0) {
				    	  messageSuccess(response, "ajouter");
				    } }
		    
		 } else if ("modifier".equals(action)) {
			 int identProjectMod = Integer.parseInt(request.getParameter("identProjectMod"));
			 // Modifier le projet en cours avec l'identifiant "identProjectMod", même s'il existe déjà dans la BD. Et Afficher un message d'erreur uniquement pour les autres projets qui existent dans la base de données et qui sont différents du projet actuellement.    
			    // ResultSet res = connexion.getProjetById(identProjectMod);
			 boolean projetExistes = projetManager.projetExistsByNom(nomProjet, identProjectMod);
			 if(projetExistes) {
				messageErreurProjetExiste(response, "modifier", request);;
			} else {
				projetManager.updateProjetById(projet, identProjectMod);
				        messageSuccess(response, "modifier");
	     } }
	}
} catch (SQLException e) {
		e.printStackTrace();
} finally {
	connexion.disconnect();
}  
    }
    
// -----------------------------------------------------------------------------------------------    
    private void messageErreur(HttpServletResponse response, String action, HttpServletRequest request) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
        out.println("<link rel='stylesheet' href='https://unpkg.com/sweetalert/dist/sweetalert.css'>");
        out.println("</head><body>");
        out.println("<script>");
        out.println("swal('Veuillez remplir tous les champs.', { icon: 'error' });");
        if ("ajouter".equals(action)) {
            out.println("window.setTimeout(function(){ location.replace('/ajouter-projet'); }, 3000);"); // Redirection après 3 secondes
        } else if ("modifier".equals(action)) {
            int identProjectModi = Integer.parseInt(request.getParameter("identProjectMod"));
        	out.println("setTimeout(function(){ location.replace('/modifier-projet?identProjet=" + identProjectModi + "'); }, 3000);"); // Revenir à la page précédente // Revenir à la page précédente
        }
        out.println("</script>");
        out.println("</body></html>");
    }
    
    private void messageErreurProjetExiste(HttpServletResponse response, String action, HttpServletRequest request) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
        out.println("<link rel='stylesheet' href='https://unpkg.com/sweetalert/dist/sweetalert.css'>");
        out.println("</head><body>");
        out.println("<script>");
        out.println("swal('Ce Projet existe déjà dans la base de données.', { icon: 'error' });");
        if ("ajouter".equals(action)) {
            out.println("window.setTimeout(function(){ location.replace('/ajouter-projet'); }, 3000);"); // Redirection après 3 secondes
        } else if ("modifier".equals(action)) {
            int identProjectModi = Integer.parseInt(request.getParameter("identProjectMod"));
        	out.println("setTimeout(function(){ location.replace('/modifier-projet?identProjet=" + identProjectModi + "'); }, 3000);"); // Revenir à la page précédente // Revenir à la page précédente
        }
        out.println("</script>");
        out.println("</body></html>");
    }
    
    private void messageSuccess(HttpServletResponse response, String action) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
        out.println("<link rel='stylesheet' href='https://unpkg.com/sweetalert/dist/sweetalert.css'>");
        out.println("</head><body>");
        out.println("<script>");
        
        if ("ajouter".equals(action)) {
            out.println("swal('Projet ajouté avec succès.', { icon: 'success' });");
            out.println("window.setTimeout(function(){ location.replace('http://localhost:8083/interface-directeur'); }, 3000);");
        } else if ("modifier".equals(action)) {
            out.println("swal('Projet modifié avec succès.', { icon: 'success' });");
            out.println("setTimeout(function(){ location.replace('http://localhost:8083/consulter-projet'); }, 3000);");
        }
        // out.println("window.setTimeout(function(){ location.replace('http://localhost:8083/Directeur/InterfacePrincipaleDirecteur.jsp'); }, 3000);"); // Redirection après 3 secondes
        out.println("</script>");
        out.println("</body></html>");
    }
}
