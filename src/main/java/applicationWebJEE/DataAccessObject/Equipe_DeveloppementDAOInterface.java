package applicationWebJEE.DataAccessObject;

import java.util.List;

public interface Equipe_DeveloppementDAOInterface {

    public void insererMembreEquipe(int idDev,int idPrj,int idTech);
    public List<String> recupererNomPrenomConcatTechno(int idPrj);
}
