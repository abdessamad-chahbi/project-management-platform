package applicationWebJEE.Presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import applicationWebJEE.BusinessLogic.TechnologieManager;

/**
 * Servlet implementation class AjouterTechnologieDevServlet
 */
public class AjouterTechnologieDevServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupérer les paramètres de la requête
        int identDev = Integer.parseInt(request.getParameter("idDeveloppeur"));
        int identTech = Integer.parseInt(request.getParameter("idTechnologie"));

	    // Ajouter la nouvelle technologie à la base de données (Table : Competence_Developpeur)
	    TechnologieManager technologieManager = new TechnologieManager();
	    technologieManager.ajouterTechnologie(identDev, identTech);

	    // Répondre avec un statut HTTP 200 (OK)
	   // response.setStatus(HttpServletResponse.SC_OK);
	}


}
