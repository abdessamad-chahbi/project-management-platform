package applicationWebJEE.DataAccessObject;

import applicationWebJEE.Connexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Equipe_DeveloppementDAO {
    private Connexion connexion;

    public Equipe_DeveloppementDAO(){
        connexion=new Connexion();
    }
    public void insererMembreEquipe(int idDev,int idPrj,int idTech){
        String query = "INSERT INTO equipe_developpement (idDev, idPrj, idTech) VALUES (?, ?, ?)";
        try{
            PreparedStatement prst=connexion.getConnection().prepareStatement(query);
            prst.setInt(1, idDev);
            prst.setInt(2, idPrj);
            prst.setInt(3, idTech);
            prst.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> recupererNomPrenomConcatTechno(int idPrj) {
        List<String> resultats = new ArrayList<>();

        String requete = "SELECT users.id, users.nom, users.prenom, GROUP_CONCAT(technologie.nomTech SEPARATOR '-') AS technologies " +
                "FROM users " +
                "JOIN equipe_developpement ON users.id = equipe_developpement.idDev " +
                "JOIN technologie ON equipe_developpement.idTech = technologie.idTech " +
                "WHERE equipe_developpement.idPrj = ? " +
                "GROUP BY users.id, users.nom, users.prenom;";

        try {
            PreparedStatement prst = connexion.getConnection().prepareStatement(requete);
            prst.setInt(1, idPrj);
            ResultSet resultSet = prst.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String technologies = resultSet.getString("technologies");

                String resultat = id + "," + nom + "," + prenom + "," + technologies;
                resultats.add(resultat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultats;
    }
}
