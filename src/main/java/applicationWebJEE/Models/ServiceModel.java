package applicationWebJEE.Models;


/**
 * @author pc
 * @version 1.0
 * @created 24-nov.-2023 23:01:16
 */
public class ServiceModel {

	private int idSer;
	private String description;
	private int dureeSer;
	private Equipe_DeveloppementModel equipe_Developpement;

	public ServiceModel(){

	}

	public int getIdSer() {
		return idSer;
	}

	public void setIdSer(int idSer) {
		this.idSer = idSer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDureeSer() {
		return dureeSer;
	}

	public void setDureeSer(int dureeSer) {
		this.dureeSer = dureeSer;
	}

	public Equipe_DeveloppementModel getEquipe_Developpement() {
		return equipe_Developpement;
	}

	public void setEquipe_Developpement(Equipe_DeveloppementModel equipe_Developpement) {
		this.equipe_Developpement = equipe_Developpement;
	}
	
	


}