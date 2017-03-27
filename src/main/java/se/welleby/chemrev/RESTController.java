package se.welleby.chemrev;

import java.util.List;

import org.bson.Document;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.welleby.chemrev.db.DbController;
import se.welleby.chemrev.db.GeneralDao;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RESTController {
	DbController dbController;
	GeneralDao areaDao = new GeneralDao("area");
	GeneralDao equipmentDao = new GeneralDao("equipment");
    
    public RESTController() {
	}
    
    @RequestMapping("/allEquipment")
    public List<Document> getAllEquipment() {
    	List<Document> all = equipmentDao.getAll();
    	System.out.println(all);
        return all;
    }
    @RequestMapping("/allAreas")
    public List<Document> getAllAreas() {
    	List<Document> all = areaDao.getAll();
    	System.out.println(all);
    	return all;
    }
    
    
}
