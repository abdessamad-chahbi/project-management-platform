package applicationWebJEE.BusinessLogic;

import java.util.List;

import applicationWebJEE.DataAccessObject.TechnologieDAO;
import applicationWebJEE.Models.TechnologieModel;

public class TechnologieManager implements TechnologieManagerInterface {
	
	private TechnologieDAO technologieDAO;
	
	public TechnologieManager() {
		technologieDAO = new TechnologieDAO();
	}
	
	@Override
	public List<TechnologieModel> getAllTechnologiesByDeveloppeur(int identDev) {
		return technologieDAO.getAllTechnologiesByDeveloppeur(identDev);
	}
	
	@Override
	public List<TechnologieModel> getAllUnmasteredTechnologiesByDeveloppeur(int identDev) {
		return technologieDAO.getAllUnmasteredTechnologiesByDeveloppeur(identDev);
	}
	
	@Override
	public void ajouterTechnologie(int identDev, int identTech) {
		technologieDAO.ajouterTechnologie(identDev, identTech);
	}

	
// ------------- khaoula : ------------------------------------------------------
    public List<TechnologieModel> getAllTechnologies(){
        return technologieDAO.getAllTechnologies();
    }

    public List<TechnologieModel> getUsersByTechnologies(String[] technologies){
        return  technologieDAO.getUsersByTechnologies(technologies);
    }
	
}
