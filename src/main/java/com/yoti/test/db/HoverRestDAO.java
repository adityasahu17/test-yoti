package com.yoti.test.db;

import java.util.Map;

import com.yoti.test.db.DB;
import com.yoti.test.model.Coordinates;

/*
 * DAO class for database interaction
 * */

public class HoverRestDAO {
	private Map<Long, Coordinates> coordinatesDb = DB.getPayLoadsFromDb();
	private static Long count = 1L; 

	public void insertData(Coordinates input){
		coordinatesDb.put(count++, input);
	}
	

}
