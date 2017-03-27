package se.welleby.chemrev.dto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DocHelper {
	private static ObjectMapper mapper;
	public static Document toDoc(Object o) {
		String json;
		try {
			json = getMapper().writeValueAsString(o);
			return Document.parse(json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static List<Document> toDocs(List<?> o) {
		List<Document> result = new ArrayList<Document>();
		for(Object obj : o) {
			String json;
			try {
				json = getMapper().writeValueAsString(obj);
				result.add(Document.parse(json));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		return result;
	}
	public static <T> T toDto(Document doc, Class<T> classType) {
		String json = doc.toJson();
		try {
			return getMapper().readValue(json, classType);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	private static ObjectMapper getMapper() {
		if(mapper==null) {
			mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		}
		return mapper;
	}
}
