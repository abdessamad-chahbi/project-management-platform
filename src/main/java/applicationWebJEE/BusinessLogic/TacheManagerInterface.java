package applicationWebJEE.BusinessLogic;

import java.util.List;

import applicationWebJEE.Models.TacheModel;

public interface TacheManagerInterface {
	
	public List<TacheModel> getAllTachesByService(int idServ);
	public void updatePourcentage(int tacheId, double nouveauPourcentage);

}
