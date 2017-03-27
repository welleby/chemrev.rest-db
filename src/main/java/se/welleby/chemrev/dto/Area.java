package se.welleby.chemrev.dto;

import org.bson.types.ObjectId;

public class Area extends Dto{
	private ObjectId _id;
	private String name;
	public Area() {}
	public Area(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
	public ObjectId get_Id() {
		return _id;
	}
	public void set_Id(ObjectId id) {
		this._id = id;
	}
	
}
