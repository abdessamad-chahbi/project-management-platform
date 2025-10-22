package applicationWebJEE.BusinessLogic;

import java.util.List;

import applicationWebJEE.DataAccessObject.ProjetDAO;
import applicationWebJEE.Models.ProjetModel;

// Couche Logique Métier
public class ProjetManager implements ProjetManagerInterface {
	
// La couche de Logique Métier utilise la classe ProjetModel pour représenter les concepts métier, tandis que la couche DAO utilise cette classe pour interagir avec la base de données. 

	private ProjetDAO projetDAO;
	
	public ProjetManager() {
        this.projetDAO = new ProjetDAO();
    }
	
	@Override
	public int ajouterProjet(ProjetModel projet) {
        // Ajouter ici toute logique métier supplémentaire si nécessaire
        return projetDAO.ajouterProjet(projet);
    }

	@Override
    public List<ProjetModel> getAllDataProjets() {
        // Logique métier, éventuellement en utilisant le DAO
        return projetDAO.getAllDataProjets();
    }
	
	@Override
    public ProjetModel getProjetById(int identProjet) {
        return projetDAO.getProjetById(identProjet);
    }
	
	@Override
	public boolean projetExistsByNom(String nomProjet, int idPrj) {
        return projetDAO.projetExistsByNom(nomProjet, idPrj);
    }
	
	@Override
	public void updateProjetById(ProjetModel projetModifie, int idProject) {
         projetDAO.updateProjetById(projetModifie, idProject);
    }
	
	@Override
	public void deleteProjectById(int projectId) {
        projetDAO.deleteProjectById(projectId);
    }
	
	@Override
	public List<ProjetModel> getPaginationDataProjets(int startIndex, int itemsPerPage) {
        return projetDAO.getPaginationDataProjets(startIndex, itemsPerPage);
    }
	
	@Override
	public List<ProjetModel> rechercheProjetsParNom(String searchTerm) {
        return projetDAO.rechercheProjetsParNom(searchTerm) ;
    }
	
	@Override
	public void affecterChefProjet(int idProjet, int idChefProjet) {
		projetDAO.affecterChefProjet(idProjet, idChefProjet);
	}
	
	@Override
	public List<ProjetModel> getProjetsNonAffectes() {
		return projetDAO.getProjetsNonAffectes();
	}
	
	@Override
	public boolean estProjetAffecte(int idProjet) {
		return projetDAO.estProjetAffecte(idProjet);
	}
	
	@Override
	public List<ProjetModel> getProjetsDeveloppeurs(int idDeveppeur){
		return projetDAO.getProjetsDeveloppeurs(idDeveppeur);
	}
	
	
// ------------- khaoula : ------------------------------------------------------	
    @Override
    public List<ProjetModel> getAllDataProjetsForChef(int idChef){
        return projetDAO.getAllDataProjetsForChef(idChef);
    }

    public void updateMethodologie(int idProjet, String nouvelleMethodologie){
        projetDAO.updateMethodologie(idProjet,nouvelleMethodologie);
    }

    public void updateDateReunion(int idPrj, String dateReunion){
        projetDAO.updateDateReunion(idPrj,dateReunion);
    }

    public List<String> nombreServiceProjet(int idChef){
        return projetDAO.nombreServiceProjet(idChef);
    }

    public List<String> servicesProjet(int idPrj){
        return projetDAO.servicesProjet(idPrj);
    }
    
    public List<String> getEquipeTechnologiesByProjetId(int idProject) {
    	return projetDAO.getEquipeTechnologiesByProjetId(idProject);
    }
	
	
	
    // L'ordre de creation des couches :
       // 1 - Couche DAO
       // 2 - Couche Logique Metier
       // 3 - Couche Presentation
    
/* 1- Couche DAO : (C'est la couche mère)
      ==> Création des classes DAO pour l'accès aux données et les opérations de persistance.
      ==> Contient les modèles associés aux classes DAO.
      
   2- Couche Logique Métier :
      ==> La création de cette couche n'est pas nécessaire, car la couche Présentation peut utiliser la couche DAO directement sans utiliser la couche Métier en intermédiaire.
      ==> Elle utilise la couche d'accès aux données (DAO) pour interagir avec la base de données.
      ==> Les détails des opérations de la BD sont dans la couche DAO, et non dans la couche Métier, car cette couche contient des méthodes générales. 
   
   3- Couche Presentation :
      ==> Création des composants de présentation (servlets, contrôleurs, pages JSP, etc.) qui interagissent avec la couche de logique métier pour répondre aux requêtes utilisateur.
      ==> Elle utilise la couche logique métier pour traiter les demandes métier.
      ==> Il est possible d'utiliser la couche DAO directement sans passer par la couche Métier en intermédiaire.
*/
    
    
}
