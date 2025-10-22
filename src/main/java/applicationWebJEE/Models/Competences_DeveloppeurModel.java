package applicationWebJEE.Models;

import java.util.List;

/**
 * @author pc
 * @version 1.0
 * @created 24-nov.-2023 23:01:06
 */
public class Competences_DeveloppeurModel {

	private int idComDev;
	private List<UserModel> listeDeveloppeurs;  // Liste des utilisateurs qui maîtrisent cette technologie
	private List<TechnologieModel> listeTechnologies;  // Liste des compétences de l'utilisateur

	public Competences_DeveloppeurModel(){

	}

}