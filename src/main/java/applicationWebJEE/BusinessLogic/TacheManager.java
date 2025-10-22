package applicationWebJEE.BusinessLogic;

import java.util.List;

import applicationWebJEE.DataAccessObject.TacheDAO;
import applicationWebJEE.Models.TacheModel;

public class TacheManager implements TacheManagerInterface {
	private TacheDAO tacheDAO;
	
	public TacheManager() {
		tacheDAO = new TacheDAO();
	}
	
	@Override
	public List<TacheModel> getAllTachesByService(int idServ){
		return tacheDAO.getAllTachesByService(idServ);
	}
	
	@Override
	public void updatePourcentage(int tacheId, double nouveauPourcentage) {
		tacheDAO.updatePourcentage(tacheId, nouveauPourcentage);
	}

}
