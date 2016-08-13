package org.khmeracademy.akd.services;

import java.util.ArrayList;
import org.khmeracademy.akd.entities.Savelist;
public interface SavelistService {	
	boolean delete(int id);
	
	boolean insert(Savelist list);
	
	boolean update(Savelist list);
	
	ArrayList<Object> findAll();
	
	Savelist findOne(int id);
	
}