package applicationWebJEE;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion {
	static Connection myCnx;
    private String pilote;
    private String URL = "jdbc:mysql://localhost:3306/myDataBase_gestion_projets";
    private String USER = "root";
    private String PASSWORD = "";

	public Connexion() {
		try {
			pilote = new String("com.mysql.cj.jdbc.Driver");
			Class c = Class.forName(pilote);
			myCnx = DriverManager.getConnection(URL,USER,PASSWORD);
			} 
		catch(ClassNotFoundException e) {
				System.err.println("Erreur lors du chargement du pilote : " + e); 
			}
		 catch (SQLException e) {
			System.err.println("Erreur de syntaxe SQL :" + e);
		} 
	}

// On n'a pas besion de cette fonction connect() car deja declaree dans la fonction Connexion() 
	public void connect() throws SQLException {
		try {
			myCnx = DriverManager.getConnection(URL,USER,PASSWORD);		
		} catch (SQLException e) {
			System.err.println("Erreur de syntaxe SQL :" + e);
		} 		
	}
	
	public void disconnect() {
		try {
			myCnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
        return myCnx;
    }
	
}
