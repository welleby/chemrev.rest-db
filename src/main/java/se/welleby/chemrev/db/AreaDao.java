package se.welleby.chemrev.db;


import org.bson.Document;

import com.mongodb.client.MongoCollection;

import se.welleby.chemrev.dto.Area;

public class AreaDao extends CRUD<Area>{
	private DbController DB;
	private MongoCollection<Document> areaCollection;
	
	
	public AreaDao() {
		super(Area.class);
		DB = DbController.getDbController();
		areaCollection = DB.getDatabase().getCollection("area");
	}

	@Override
	protected MongoCollection<Document> getCollection() {
		return areaCollection;
	}

}
