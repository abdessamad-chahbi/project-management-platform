package applicationWebJEE.BusinessLogic;

import applicationWebJEE.DataAccessObject.NotificationDAO;

public class NotificationManager implements NotificationManagerInterface {

	private NotificationDAO notificationDAO;
	
	public NotificationManager() {
		this.notificationDAO = new NotificationDAO();
	}
	
	@Override
	public void enregistrerNotification(String msg, int idSour, int idDest) {
		notificationDAO.enregistrerNotification(msg, idSour, idDest);
	}
	
}
