package applicationWebJEE.Models;

import java.sql.Date;

public class ProjetModel {
	private int idProj;
    private String nomProj;
    private String description;
    private String clientProj;
    private Date dateDem;
    private Date dateLiv;
    private int nbJoursDev;
    private String methodologie;
    private Date dateReu;
    
    private UserModel chefProjet;
    
    private String msgNotification;

	// Constructeur par défaut
    public ProjetModel() {
    }

	public ProjetModel(int idProj, String nomProj, String description, String clientProj, Date dateDem, Date dateLiv,
			int nbJoursDev, String methodologie, Date dateReu) {
		super();
		this.idProj = idProj;
		this.nomProj = nomProj;
		this.description = description;
		this.clientProj = clientProj;
		this.dateDem = dateDem;
		this.dateLiv = dateLiv;
		this.nbJoursDev = nbJoursDev;
		this.methodologie = methodologie;
		this.dateReu = dateReu;
	}

	public int getIdProj() {
		return idProj;
	}

	public void setIdProj(int idProj) {
		this.idProj = idProj;
	}

	public String getNomProj() {
		return nomProj;
	}

	public void setNomProj(String nomProj) {
		this.nomProj = nomProj;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClientProj() {
		return clientProj;
	}

	public void setClientProj(String clientProj) {
		this.clientProj = clientProj;
	}

	public Date getDateDem() {
		return dateDem;
	}

	public void setDateDem(Date dateDem) {
		this.dateDem = dateDem;
	}

	public Date getDateLiv() {
		return dateLiv;
	}

	public void setDateLiv(Date dateLiv) {
		this.dateLiv = dateLiv;
	}

	public int getNbJoursDev() {
		return nbJoursDev;
	}

	public void setNbJoursDev(int nbJoursDev) {
		this.nbJoursDev = nbJoursDev;
	}

	public String getMethodologie() {
		return methodologie;
	}

	public void setMethodologie(String methodologie) {
		this.methodologie = methodologie;
	}

	public Date getDateReu() {
		return dateReu;
	}

	public void setDateReu(Date dateReu) {
		this.dateReu = dateReu;
	}

    
    public UserModel getChefProjet() {
		return chefProjet;
	}

	public void setChefProjet(UserModel chefProjet) {
		this.chefProjet = chefProjet;
	}

	public String getMsgNotification() {
		return msgNotification;
	}

	public void setMsgNotification(String msgNotification) {
		this.msgNotification = msgNotification;
	}
}
