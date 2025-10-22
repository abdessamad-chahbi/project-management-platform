package applicationWebJEE.Presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import applicationWebJEE.BusinessLogic.TacheManager;


public class ModifierPourcentageAvanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifierPourcentageAvanServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   int tacheId = Integer.parseInt(request.getParameter("identTache"));
    	   double nouveauPourcentage = Double.parseDouble(request.getParameter("newPourcentage"));

    	   // Mettez à jour la base de données avec le nouveau pourcentage
    	   TacheManager tacheManager = new TacheManager();
    	   tacheManager.updatePourcentage(tacheId, nouveauPourcentage);

    	   // Envoyer une réponse au client
    	   response.setContentType("text/plain");
    	   response.setCharacterEncoding("UTF-8");
    	  // response.getWriter().write("Mise à jour réussie");
    	}


}
