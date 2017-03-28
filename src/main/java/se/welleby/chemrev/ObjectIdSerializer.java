package se.welleby.chemrev;

import java.io.IOException;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class ObjectIdSerializer extends StdSerializer<ObjectId>{
	private static final long serialVersionUID = 3014163630056279377L;

	public ObjectIdSerializer() {
		this(null);
	}
	protected ObjectIdSerializer(Class<ObjectId> t) {
		super(t);
	}

	@Override
	public void serialize(ObjectId objId, JsonGenerator gen,
			SerializerProvider arg2) throws IOException {
		 gen.writeString(objId.toHexString());
		 
	}

}
