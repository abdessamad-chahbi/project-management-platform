package applicationWebJEE.BusinessLogic;

import java.sql.ResultSet;
import java.util.List;

import applicationWebJEE.Models.UserModel;

public interface UserManagerInterface {
	
	public ResultSet authenticationUser(String login, String password, String role);
	public ResultSet UserExiste(String login, String role);
	public void modifierPasswordUser(String login, String password, String role);
	public List<UserModel> recupererTousChefProjets();
	public UserModel getDeveloppeurById(int identDev);
	public void modifierProfilDeveloppeur(String nom, String prenom, String login, String password, int idDeve);
	public int getIdDeveloppeurByLogin(String login);
	
}
