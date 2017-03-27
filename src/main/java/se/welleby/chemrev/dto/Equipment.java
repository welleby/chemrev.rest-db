package se.welleby.chemrev.dto;

import org.bson.types.ObjectId;

public class Equipment extends Dto{
	private ObjectId _id;
	private String name;
	private long littra;
	private String area;
	public Equipment() {}
	public Equipment(String name) {
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
	public long getLittra() {
		return littra;
	}
	public void setLittra(long littra) {
		this.littra = littra;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	
}
