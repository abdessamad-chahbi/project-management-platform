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

import applicationWebJEE.BusinessLogic.Equipe_DeveloppementManager;

@WebServlet("/validerEquipeProjet")
public class ValiderEquipeProjetServlet extends HttpServlet {
    
	private Equipe_DeveloppementManager EDM;
    
    public void init() {
        this.EDM=new Equipe_DeveloppementManager();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        Integer prdId=Integer.parseInt(session.getAttribute("projetId").toString());
        String[] technologieDevs = request.getParameterValues("developer");
        session.setAttribute("technologieDevs", technologieDevs);
        if (technologieDevs != null) {
            for (String technologieDev : technologieDevs) {
                String[] ids = technologieDev.split("-");
                String technologieId = ids[0];
                String utilisateurId = ids[1];
                EDM.insererMembreEquipe(Integer.parseInt(utilisateurId),prdId,Integer.parseInt(technologieId));
            }
        }
        response.sendRedirect("/ChefProjet/planifierReunion.jsp");
    }
}


