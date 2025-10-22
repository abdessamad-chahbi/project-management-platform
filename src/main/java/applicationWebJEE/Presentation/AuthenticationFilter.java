package applicationWebJEE.Presentation;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
/*
@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        // Liste des URLs autorisées sans authentification
        List<String> allowedURLs = Arrays.asList("/interface-user", "/loginDirecteur", "/loginChefProjet", "/loginDeveloppeur",
        		                                 "/loginDirecteurs", "/loginChefProjets", "/loginDeveloppeurs",
        		                                 "/modifier-password-directeur", "/modifier-password-chefProjet", "/modifier-password-developpeur"
        		                                 );

        // Vérifier si l'utilisateur est authentifié
        boolean isAuthenticated = (session != null && session.getAttribute("login") != null);

        // Vérifier si l'URL demandée nécessite une authentification
        String requestedURL = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

        if (isAuthenticated || allowedURLs.contains(requestedURL)) {
            // L'utilisateur est authentifié ou l'URL est autorisée, permettre la poursuite de la requête.
            chain.doFilter(request, response);
        } else {
            // L'utilisateur n'est pas authentifié et l'URL n'est pas autorisée, rediriger vers la page de connexion.
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/interface-user");
        }
    }

} */

