package applicationWebJEE.Presentation;

import java.io.IOException;
import java.io.PrintWriter;

import applicationWebJEE.Connexion;
import applicationWebJEE.DataAccessObject.ProjetDAO;
import jakarta.servlet.http.*;

public class DeleteProjectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int projectId = Integer.parseInt(request.getParameter("idProjet"));
        
        Connexion connexion;
        ProjetDAO projetDAO;
        try {
        	connexion = new Connexion();
        	projetDAO = new ProjetDAO(); 
        	connexion.connect();
            projetDAO.deleteProjectById(projectId);
            connexion.disconnect();
            // response.sendRedirect("/Directeur/ConsulterProjet.jsp");

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><head>");
            out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
            out.println("<link rel='stylesheet' href='https://unpkg.com/sweetalert/dist/sweetalert.css'>");
            out.println("</head><body>");
            out.println("<script>");
            out.println("swal('Projet supprimé avec succès !', { icon: 'success' });");
            out.println("window.setTimeout(function(){ location.replace('/consulter-projet'); }, 2000);"); // Redirection après 2 secondes
            out.println("</script>");
            out.println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
