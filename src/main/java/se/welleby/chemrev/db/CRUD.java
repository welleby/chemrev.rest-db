package se.welleby.chemrev.db;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import static com.mongodb.client.model.Filters.*;
import se.welleby.chemrev.dto.DocHelper;

public abstract class CRUD<T> {
	private final Class<T> classType;
	protected CRUD(Class<T> classType) {
		this.classType = classType;
	}
	
	public boolean insert(T o) {
		try {
			getCollection().insertOne(DocHelper.toDoc(o));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean insert(List<T> o) {
		try {
			getCollection().insertMany(DocHelper.toDocs(o));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public T get(String id) {
		Document result = getCollection().find(eq("_id",new ObjectId(id))).first();
		T tmp = DocHelper.toDto(result, classType);
		System.out.println(tmp);
		return tmp;
	}
	public List<T> getAll() { 
		List<T> result = new ArrayList<T>();
		MongoCursor<Document> cursor = getCollection().find().iterator();
		try {
			while(cursor.hasNext()) {
				result.add(DocHelper.toDto(cursor.next(),classType));
			}
		} finally {
			cursor.close();
		}
		return result;
	}
	public T update(T o) { return null;}
	public T update(String id){ return null;}
	public boolean delete(T o){ return false;}
	public boolean delete(String id){ return false;}
	
	protected abstract MongoCollection<Document> getCollection();
}
