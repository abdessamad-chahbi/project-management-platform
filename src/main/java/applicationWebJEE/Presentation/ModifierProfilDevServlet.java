package applicationWebJEE.Presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import applicationWebJEE.BusinessLogic.UserManager;

public class ModifierProfilDevServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nomDev");
        String prenom = request.getParameter("prenomDev");
        String login = request.getParameter("loginDev");
        String password = request.getParameter("passwordDev");
        int idDeve = Integer.parseInt(request.getParameter("identDeveloppeur"));

        UserManager userManager = new UserManager();
        userManager.modifierProfilDeveloppeur(nom, prenom, login, password, idDeve);

        // Rediriger vers la page souhaitée après la modification (par exemple, l'interface du développeur)
       // response.sendRedirect("/interface-developpeur");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
        out.println("<link rel='stylesheet' href='https://unpkg.com/sweetalert/dist/sweetalert.css'>");
        out.println("</head><body>");
        out.println("<script>");
        out.println("swal('Profil modifié avec succès !', { icon: 'success' });");
        out.println("window.setTimeout(function(){ location.replace('/interface-developpeur'); }, 2000);"); // Redirection après 2 secondes
        out.println("</script>");
        out.println("</body></html>");
    }

}
