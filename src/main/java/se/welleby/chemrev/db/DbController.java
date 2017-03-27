package se.welleby.chemrev.db;

import java.io.Closeable;
import java.io.IOException;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class DbController implements Closeable{
	private static DbController DB_CONTROLLER;
	MongoClient mongoClient = new MongoClient("192.168.56.101",27017);
	private MongoDatabase database;
	
	public static DbController getDbController() {
		if(DB_CONTROLLER==null)
			DB_CONTROLLER = new DbController();
		return DB_CONTROLLER;
	}
	
	private DbController() {
		setDatabase(mongoClient.getDatabase("chemrev"));
	}

	public void close() throws IOException {
		mongoClient.close();
	}

	public MongoDatabase getDatabase() {
		return database;
	}

	private void setDatabase(MongoDatabase database) {
		this.database = database;
	}
	
}
