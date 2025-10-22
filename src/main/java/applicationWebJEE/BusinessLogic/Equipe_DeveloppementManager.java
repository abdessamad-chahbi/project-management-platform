package applicationWebJEE.BusinessLogic;
import applicationWebJEE.DataAccessObject.Equipe_DeveloppementDAO;

import java.util.List;

public class Equipe_DeveloppementManager {

    private Equipe_DeveloppementDAO EDD;

    public Equipe_DeveloppementManager(){
        this.EDD=new Equipe_DeveloppementDAO();
    }
    public void insererMembreEquipe(int idDev,int idPrj,int idTech){
        EDD.insererMembreEquipe(idDev, idPrj, idTech);
    }

    public List<String> recupererNomPrenomConcatTechno(int idPrj){
        return EDD.recupererNomPrenomConcatTechno(idPrj);
    }
}
