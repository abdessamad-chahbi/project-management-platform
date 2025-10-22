package applicationWebJEE.Presentation;

import applicationWebJEE.BusinessLogic.ProjetManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/servicesProjet")
public class ServicesProjetsServlet extends HttpServlet {
    private ProjetManager PM;

    public void init(){
        this.PM=new ProjetManager();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {

            String projetId = request.getParameter("projetId");
            request.setAttribute("projetId",projetId);
            if (projetId != null && !projetId.isEmpty()) {
                int idProjet = Integer.parseInt(projetId);
                List<String> services = PM.servicesProjet(idProjet);
                request.setAttribute("servicesList", services);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/ChefProjet/ServicesProjet.jsp");
                dispatcher.forward(request, response);

            } else {
                response.getWriter().println("ID du projet non fourni.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Une erreur s'est produite : " + e.getMessage());
        }
    }

}
