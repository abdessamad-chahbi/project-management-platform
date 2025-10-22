package applicationWebJEE.Presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import applicationWebJEE.BusinessLogic.ProjetManager;
import applicationWebJEE.Models.ProjetModel;
@WebServlet("/chefProjet/consulter")
public class ConsulterProjetChefProjetServlet extends HttpServlet {
    private ProjetManager projetManager;

    public void init() {
        this.projetManager = new ProjetManager();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String idChefParam = request.getParameter("idChef");

            if (idChefParam != null) {
                int idChef = Integer.parseInt(idChefParam);

                // Nettoie la session existante et crée une nouvelle session
                HttpSession session = request.getSession();
                session.invalidate();
                session = request.getSession(true);

                session.setAttribute("idChef", idChef);

                Integer idChef1 = (Integer) session.getAttribute("idChef");
                List<ProjetModel> projets = projetManager.getAllDataProjetsForChef(idChef1);

                session.setAttribute("projets", projets);

                request.setAttribute("projets", projets);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/ChefProjet/ConsulterProjet.jsp");
                dispatcher.forward(request, response);
            } else {
                response.getWriter().println("<p>Aucun ID de chef spécifié.</p>");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.getWriter().println("<p>Format d'ID de chef incorrect.</p>");
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Vous pouvez également récupérer les variables de session dans la méthode doPost si nécessaire
        doGet(request, response);
    }
}

