package applicationWebJEE.Models;

import java.util.List;

/**
 * @author pc
 * @version 1.0
 * @created 24-nov.-2023 23:01:19
 */
public class TechnologieModel {

	private int idTech;
	private String nomTech;
	
	private List<UserModel> utilisateurs;

	public TechnologieModel(){

	}
	
	public TechnologieModel(int idTech, String nomTech) {
		this.idTech = idTech;
		this.nomTech = nomTech;
	}

	public TechnologieModel(int idTech, String nomTech, List<UserModel> utilisateurs) {
		this.idTech = idTech;
		this.nomTech = nomTech;
		this.utilisateurs = utilisateurs;
	}

	public int getIdTech() {
		return idTech;
	}

	public void setIdTech(int idTech) {
		this.idTech = idTech;
	}

	public String getNomTech() {
		return nomTech;
	}

	public void setNomTech(String nomTech) {
		this.nomTech = nomTech;
	}
	
	public List<UserModel> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(List<UserModel> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

}