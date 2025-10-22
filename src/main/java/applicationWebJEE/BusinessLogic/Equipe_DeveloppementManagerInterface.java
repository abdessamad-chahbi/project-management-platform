package applicationWebJEE.BusinessLogic;

import java.util.List;

public interface Equipe_DeveloppementManagerInterface {

    public void insererMembreEquipe(int idDev,int idPrj,int idTech);
    public List<String> recupererNomPrenomConcatTechno(int idPrj);
}
