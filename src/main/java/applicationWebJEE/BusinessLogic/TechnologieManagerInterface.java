package applicationWebJEE.BusinessLogic;

import java.util.List;

import applicationWebJEE.Models.TechnologieModel;

public interface TechnologieManagerInterface {

	public List<TechnologieModel> getAllTechnologiesByDeveloppeur(int identDev);
	public List<TechnologieModel> getAllUnmasteredTechnologiesByDeveloppeur(int identDev);
	public void ajouterTechnologie(int identDev, int identTech);
	
	
// ------------- khaoula : ------------------------------------------------------
    public List<TechnologieModel> getAllTechnologies();
    public List<TechnologieModel> getUsersByTechnologies(String[] technologies);
	
}
