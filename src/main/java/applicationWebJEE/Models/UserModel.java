package applicationWebJEE.Models;

import java.util.List;

public class UserModel {

	private int id;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	private String role;  // 3 utilisateurs (3 roles) : directeur, chefProjet, developpeur

	private List<TechnologieModel> competences;

	public UserModel(){

	}
	
	public UserModel(int id, String nom, String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	public UserModel(int id, String nom, String prenom, String login, String password, String role) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	public List<TechnologieModel> getCompetences() {
		return competences;
	}

	public void setCompetences(List<TechnologieModel> competences) {
		this.competences = competences;
	}

}