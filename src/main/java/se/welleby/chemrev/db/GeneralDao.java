package se.welleby.chemrev.db;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import static com.mongodb.client.model.Filters.*;

public class GeneralDao {
	private MongoCollection<Document> collection;
	private DbController DB;
	
	public GeneralDao(String collection) {
		DB = DbController.getDbController();
		this.collection = DB.getDatabase().getCollection(collection);
	}
	
	public boolean insert(Document d) {
		try {
			getCollection().insertOne(d);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean insert(List<Document> d) {
		try {
			getCollection().insertMany(d);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public Document get(String id) {
		Document result = getCollection().find(eq("_id",new ObjectId(id))).first();
		//result.put("_id", result.getObjectId("_id").toHexString());
		System.out.println(result);
		return result;
	}
	public List<Document> getAll() { 
		List<Document> result = new ArrayList<Document>();
		MongoCursor<Document> cursor = getCollection().find().iterator();
		try {
			while(cursor.hasNext()) {
				Document val = cursor.next();
				//val.put("_id", val.getObjectId("_id").toHexString());
				result.add(val);
			}
		} finally {
			cursor.close();
		}
		return result;
	}
	public Document update(Document o) { return null;}
	public Document update(String id){ return null;}
	public boolean delete(Document o){ return false;}
	public boolean delete(String id){ return false;}
	
	public MongoCollection<Document> getCollection(){
		return this.collection;
	}
	
}
