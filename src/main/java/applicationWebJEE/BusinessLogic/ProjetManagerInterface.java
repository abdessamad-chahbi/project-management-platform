package applicationWebJEE.BusinessLogic;

import java.util.List;

import applicationWebJEE.Models.ProjetModel;

public interface ProjetManagerInterface {
	
	public int ajouterProjet(ProjetModel projet);
	public List<ProjetModel> getAllDataProjets();
	public ProjetModel getProjetById(int identProjet);
	public boolean projetExistsByNom(String nomProjet, int idPrj);
	public void updateProjetById(ProjetModel projetModifie, int idProject);
	public void deleteProjectById(int projectId);
	public List<ProjetModel> getPaginationDataProjets(int startIndex, int itemsPerPage);
	public List<ProjetModel> rechercheProjetsParNom(String searchTerm);
	public void affecterChefProjet(int idProjet, int idChefProjet);
	public List<ProjetModel> getProjetsNonAffectes();
	public boolean estProjetAffecte(int idProjet);
	public List<ProjetModel> getProjetsDeveloppeurs(int idDeveppeur);
	
// ------------- khaoula : ------------------------------------------------------
	public List<ProjetModel> getAllDataProjetsForChef(int idChef);
	public void updateMethodologie(int idProjet, String nouvelleMethodologie);
	public void updateDateReunion(int idPrj, String dateReunion);
	public List<String> nombreServiceProjet(int idChef);
	public List<String> servicesProjet(int idPrj);
	public List<String> getEquipeTechnologiesByProjetId(int idProject);
	
	
}


