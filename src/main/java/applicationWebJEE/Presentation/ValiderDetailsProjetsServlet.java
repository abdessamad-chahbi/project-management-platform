package applicationWebJEE.Presentation;

import applicationWebJEE.BusinessLogic.ProjetManager;
import applicationWebJEE.BusinessLogic.TechnologieManager;
import applicationWebJEE.Models.TechnologieModel;
import applicationWebJEE.Models.UserModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/validerDetailsProjet")

public class ValiderDetailsProjetsServlet extends HttpServlet {

    private TechnologieManager technologieManager;
    private  ProjetManager projetManager;

    public void init() {
        this.technologieManager = new TechnologieManager();
        this.projetManager=new ProjetManager();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String methodologie = request.getParameter("methodologie");
            String[] technologiesSelected = request.getParameterValues("technologie");
            List<TechnologieModel> technoList = technologieManager.getUsersByTechnologies(technologiesSelected);

            HttpSession session=request.getSession() ;
            Integer idPrj=Integer.parseInt(session.getAttribute("projetId").toString());
            projetManager.updateMethodologie(idPrj,methodologie);

            System.out.println(technoList.size());
            session.setAttribute("methodologie",methodologie);
            session.setAttribute("technoList", technoList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/ChefProjet/RemplirDevps.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
