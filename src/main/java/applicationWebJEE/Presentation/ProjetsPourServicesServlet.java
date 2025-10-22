package applicationWebJEE.Presentation;

import applicationWebJEE.BusinessLogic.ProjetManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ProjetPourService")
public class ProjetsPourServicesServlet extends HttpServlet {

    private  ProjetManager PM;
    @Override
    public void init() throws ServletException {
        this.PM=new ProjetManager();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idChef=Integer.parseInt(request.getParameter("idChef"));
        HttpSession session=request.getSession();
        session.setAttribute("idChef",idChef);

        List<String> ProjetsServices=PM.nombreServiceProjet(idChef);
        session.setAttribute("projetsServices", ProjetsServices);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/ChefProjet/ProjetsServices.jsp");
        dispatcher.forward(request, response);
     
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
