package applicationWebJEE.Presentation;

import applicationWebJEE.BusinessLogic.ServiceManager;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ajouterService")
public class AjouterServiceServlet extends HttpServlet {
    private ServiceManager serviceManager;

    public void init() {
        this.serviceManager = new ServiceManager();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Récupérer les paramètres du formulaire
        String description = request.getParameter("description");
        int duree = Integer.parseInt(request.getParameter("duree"));
        String projetId = request.getParameter("projetId");

        // Configurer le type de contenu de la réponse
        response.setContentType("text/html;charset=UTF-8");

        // Créer un objet PrintWriter
        PrintWriter out = response.getWriter();

        // Imprimer les valeurs dans le corps de la réponse
        out.println("<html>");
        out.println("<head><title>Résultat du formulaire</title></head>");
        out.println("<body>");
        out.println("<h1>Résultat du formulaire</h1>");
        out.println("<p>Description du service : " + description + "</p>");
        out.println("<p>Durée du service : " + duree + " jours</p>");
        out.println("<p>Projet ID : " + projetId + "</p>");
        out.println("</body>");
        out.println("</html>");

        // Fermer le PrintWriter
        out.close();
    }


}
