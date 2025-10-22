/*package applicationWebJEE.Models;

public class Equipe_DeveloppementModel {

	private int idDevPrj;
	private UserModel developpeur;
	private ProjetModel projet;

	public Equipe_DeveloppementModel(){

	}
} */


package applicationWebJEE.Models;

public class Equipe_DeveloppementModel {
	private int idDevPrj;
	private int idDev;
	private int idPrj;
	private int idTech;
	public Equipe_DeveloppementModel(){
	}

	public Equipe_DeveloppementModel(int idDev, int idPrj, int idTech) {
		this.idDev = idDev;
		this.idPrj = idPrj;
		this.idTech = idTech;
	}

	public int getIdDev() {
		return idDev;
	}

	public void setIdDev(int idDev) {
		this.idDev = idDev;
	}

	public int getIdPrj() {
		return idPrj;
	}

	public void setIdPrj(int idPrj) {
		this.idPrj = idPrj;
	}

	public int getIdTech() {
		return idTech;
	}

	public void setIdTech(int idTech) {
		this.idTech = idTech;
	}
}