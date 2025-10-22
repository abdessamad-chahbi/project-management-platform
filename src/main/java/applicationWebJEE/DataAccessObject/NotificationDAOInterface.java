package applicationWebJEE.DataAccessObject;

public interface NotificationDAOInterface {

	public void enregistrerNotification(String msg, int idSour, int idDest);
}
