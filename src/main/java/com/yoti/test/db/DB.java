package com.yoti.test.db;

import java.util.HashMap;
import java.util.Map;

import com.yoti.test.model.Coordinates;

public class DB {

	private static Map<Long,Coordinates> payloads = new HashMap<Long,Coordinates>();
	
	public static Map<Long,Coordinates> getPayLoadsFromDb(){
		return payloads;
	}
}
