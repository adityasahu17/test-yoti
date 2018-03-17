package com.yoti.test.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.yoti.test.db.HoverRestDAO;
import com.yoti.test.exception.CoordinateNotFoundException;
import com.yoti.test.model.Coordinates;


/*
 * Service implementation class for all business logic
 * */
public class HoverServiceImpl implements HoverService{	
	
	private final static int xAxis = 0;
	private final static int yAxis = 1;
	private final static int xCorner = 0;
	private final static int yCorner = 0;
	private int patchesCount = 0;

	HoverRestDAO hoverDAO = new HoverRestDAO();

	/*
	 * Consuming payload and processing Instructions
	 *  */
	public Map<String,Object> takeInstruction(Coordinates input) throws CoordinateNotFoundException{

		Integer[] roomSize = input.getRoomSize();
		Integer[] coords = input.getCoords();
		ArrayList<Integer[]> patches = input.getPatches();
		String instructions = input.getInstructions();		
		Map<String,Object> finalPosition = new HashMap<String, Object>();
		List<Integer[]> patchList = new ArrayList<Integer[]>(patches);
		Integer[] newPosition={0,0} ;
		int dirtCleanedCount = 0;
		char[] driving = instructions.toCharArray();
		int x= coords[0];
		int y = coords[1];
		
		dirtCleanedCount = cleanPatches(x,y,patchList); //Check for the initial position, whether we have to clean dirt patch of this coordinates or not

		for(char instruction : driving){
			if(instruction == 'N' && y != roomSize[yAxis]){
				y++;
			}else if(instruction == 'E' && x!=roomSize[xAxis]){
				x++;
			}else if(instruction == 'S' && y != yCorner){
				y--;
			}else if(instruction == 'W' && x!= xCorner){
				x--;
			}else{
				System.out.println("Not a valid instrucion or hover skid the wall");
				continue;
			}
			dirtCleanedCount = cleanPatches(x,y,patchList);
		}
		newPosition[xAxis]=x;
		newPosition[yAxis]=y;
		finalPosition.put("coords", newPosition);
		finalPosition.put("patches", dirtCleanedCount);
		return finalPosition;
	}
	
	/*
	 * Cleaning dirt 
	 * @Param [x,y] are the coordinates of dirt patch for cleaning
	 * @Param patches is the list of given patches
	 * Removing the patch from the list once dirt is cleaned 
	 *
	 * */
	public int cleanPatches(int x, int y, List<Integer[]> patches){
		for (Iterator<Integer[]> iterator = patches.iterator(); iterator.hasNext();) {
		    Integer[] dimension = iterator.next();
		    if (x == dimension[xAxis] && y == dimension[yAxis]) {
		    	patchesCount++;
		    	iterator.remove();
		    }
		}
		return patchesCount;
	}

	public void insertPayload(Coordinates input) {
		hoverDAO.insertData(input);
	}

}
