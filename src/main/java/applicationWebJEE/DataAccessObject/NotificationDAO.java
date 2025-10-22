package applicationWebJEE.DataAccessObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import applicationWebJEE.Connexion;
import applicationWebJEE.Models.ProjetModel;

public class NotificationDAO implements NotificationDAOInterface{
	private Connexion connexion;
	
	public NotificationDAO() {
		connexion = new Connexion();
	}
	
	@Override
	public void enregistrerNotification(String msg, int idSour, int idDest) {
	    String req = "INSERT INTO Notification (message, idSour, idDest) VALUES (?, ?, ?)";
	    try {
	    	// PreparedStatement prSt = myCnx.prepareStatement(req);
	        PreparedStatement prSt = connexion.getConnection().prepareStatement(req);
	        prSt.setString(1, msg);
	        prSt.setInt(2, idSour);
	        prSt.setInt(3, idDest);

	         prSt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	

	
	
}
