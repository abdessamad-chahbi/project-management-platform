package applicationWebJEE.Presentation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;
import applicationWebJEE.Models.TechnologieModel;

import applicationWebJEE.BusinessLogic.ProjetManager;
import applicationWebJEE.BusinessLogic.TechnologieManager;

@WebServlet("/remplirProjet")
public class RemplirProjetChefProjetServlet extends HttpServlet {
    private ProjetManager projetManager;
    private TechnologieManager technologieManager;

    public void init() {
        this.projetManager = new ProjetManager();
        this.technologieManager=new TechnologieManager();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String projetId = request.getParameter("projetId");
        
        HttpSession session = request.getSession();
        session.setAttribute("projetId", projetId);
        
     // --------------------------------------------------------------------------------
        String action = request.getParameter("equipeTechnologies");
        if (action != null) {
            List<String> equipeTechnologiesProjet = projetManager.getEquipeTechnologiesByProjetId(Integer.parseInt(projetId));
            session.setAttribute("equipeTechnologiesProjet", equipeTechnologiesProjet);
            
            RequestDispatcher dispat = request.getRequestDispatcher("/ChefProjet/ConsulterEquipeTechProjet.jsp");
            dispat.forward(request, response);
            return; // Ajoutez cette ligne pour sortir de la méthode après la redirection.
        }
               
        List<TechnologieModel> technologies = technologieManager.getAllTechnologies();
        session.setAttribute("technologies",technologies);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/ChefProjet/RemplirProjet.jsp");
        dispatcher.forward(request, response);
                
      }
   

}

