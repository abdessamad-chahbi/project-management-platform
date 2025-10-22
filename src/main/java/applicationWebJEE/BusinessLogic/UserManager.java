package applicationWebJEE.BusinessLogic;

import java.sql.ResultSet;
import java.util.List;

import applicationWebJEE.DataAccessObject.UserDAO;
import applicationWebJEE.Models.UserModel;

public class UserManager implements UserManagerInterface {
	
	private UserDAO userDAO;
	
	public UserManager() {
		this.userDAO = new UserDAO();
	}
	
	@Override
	public ResultSet authenticationUser(String login, String password, String role) {
		return userDAO.authenticationUser(login, password, role);
	}
	
	@Override
	public ResultSet UserExiste(String login, String role) {
		return userDAO.UserExiste(login, role);
	}
	
	@Override
	public void modifierPasswordUser(String login, String password, String role) {
		userDAO.modifierPasswordUser(login, password, role);
	}
	
	@Override
	public List<UserModel> recupererTousChefProjets() {
		  return userDAO.recupererTousChefProjets();
	}
	
	@Override
	public UserModel getDeveloppeurById(int identDev) {
		return userDAO.getDeveloppeurById(identDev);
	}
	
	@Override
	public void modifierProfilDeveloppeur(String nom, String prenom, String login, String password, int idDeve) {
		userDAO.modifierProfilDeveloppeur(nom, prenom, login, password, idDeve);
	}
	
	@Override
	public int getIdDeveloppeurByLogin(String login) {
		return userDAO.getIdDeveloppeurByLogin(login);
	}
}
