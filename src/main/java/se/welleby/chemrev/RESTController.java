package se.welleby.chemrev;

import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import se.welleby.chemrev.db.DbController;
import se.welleby.chemrev.db.GeneralDao;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RESTController {
	DbController dbController;
	GeneralDao areaDao = new GeneralDao("area");
	GeneralDao equipmentDao = new GeneralDao("equipment");
	ObjectIdSerializer objIdSerializer = new ObjectIdSerializer();
    
    public RESTController() {
	}
    
    @RequestMapping("/allEquipment")
    @JsonSerialize(using = ObjectIdSerializer.class)
    public List<Document> getAllEquipment() {
    	List<Document> all = equipmentDao.getAll();
    	System.out.println(all);
        return all;
    }
    @RequestMapping("/allAreas")
    @JsonSerialize(using = ObjectIdSerializer.class)
    public List<Document> getAllAreas() {
    	List<Document> all = areaDao.getAll();
    	
    	System.out.println(all);
    	return all;
    }
    
    @Bean
	public Jackson2ObjectMapperBuilder jacksonBuilder() {
		Jackson2ObjectMapperBuilder b = new Jackson2ObjectMapperBuilder();
		b.indentOutput(true).serializerByType(ObjectId.class,objIdSerializer);
		return b;
	}
    
    
}
