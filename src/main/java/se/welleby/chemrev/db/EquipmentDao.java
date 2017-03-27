package se.welleby.chemrev.db;


import org.bson.Document;

import com.mongodb.client.MongoCollection;

import se.welleby.chemrev.dto.Equipment;

public class EquipmentDao extends CRUD<Equipment>{
	private DbController DB;
	private MongoCollection<Document> collection;
	
	
	public EquipmentDao() {
		super(Equipment.class);
		DB = DbController.getDbController();
		collection = DB.getDatabase().getCollection("equipment");
	}

	@Override
	protected MongoCollection<Document> getCollection() {
		return collection;
	}

}
