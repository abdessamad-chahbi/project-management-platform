package applicationWebJEE.Models;


/**
 * @author pc
 * @version 1.0
 * @created 24-nov.-2023 23:01:18
 */
public class TacheModel {

	private int idTache;
	private String description;
	private double pourAvan;
	private ServiceModel service;

	public TacheModel(){

	}

	public int getIdTache() {
		return idTache;
	}

	public void setIdTache(int idTache) {
		this.idTache = idTache;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPourAvan() {
		return pourAvan;
	}

	public void setPourAvan(double pourAvan) {
		this.pourAvan = pourAvan;
	}

	public ServiceModel getService() {
		return service;
	}

	public void setService(ServiceModel service) {
		this.service = service;
	}
	
	

}