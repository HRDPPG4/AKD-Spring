package org.khmeracademy.akd.services;
import org.khmeracademy.akd.entities.Category;
import org.khmeracademy.akd.entities.Document;
public interface UploadToDBService {			
	boolean uploadFile(Document doc);
	boolean uploadFolder(Category cat);		
	boolean uploadUserProfile(String filePath,int userID);	
}
