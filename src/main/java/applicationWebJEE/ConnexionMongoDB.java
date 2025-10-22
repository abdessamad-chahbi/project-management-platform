/*
package applicationWebJEE;

import java.sql.Connection;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class ConnexionMongoDB {
    private MongoClient mongoClient;
    private MongoDatabase database;  // static Connection myCnx;

    public ConnexionMongoDB() {
        mongoClient = new MongoClient("localhost", 27017); // Adresse et port de votre instance MongoDB
        database = mongoClient.getDatabase("myMongoDB_gestion_projets"); // Nom de votre base de données MongoDB
    }

    public void connect() {
        // Ici, la connexion MongoDB est établie lors de la création de l'objet ConnexionMongoDB.
        // Vous n'avez pas besoin de gérer la connexion/déconnexion de la même manière qu'avec JDBC.
    }

    public void disconnect() {
        mongoClient.close(); // Vous pouvez fermer la connexion MongoDB lorsque vous avez terminé.
    }
    
// Utilisez "database" pour effectuer des opérations MongoDB
    public MongoDatabase getDatabase() {
        return database;
    }
    
// La fonction d'authentification pour les trois Users (Directeur, ChefProjet, Developpeur)
    public Document authenticationUser(String login, String password, String userType) {
        MongoDatabase database = getDatabase();     // database <===> myCnx
        MongoCollection<Document> userCollection = database.getCollection(userType); 

        Document user = new Document("login", login).append("password", password); // 
        FindIterable<Document> result = userCollection.find(user);

        MongoCursor<Document> cursor = result.iterator();

        if (cursor.hasNext()) {
            return cursor.next();
        } else {
            return null;
        }
    }


}

*/
