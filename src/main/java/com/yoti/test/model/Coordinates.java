package com.yoti.test.model;

import java.util.ArrayList;

public class Coordinates {
	Integer[] roomSize;
	Integer[] coords;
	ArrayList<Integer[]> patches;
	String instructions;
	
	public Coordinates() {
	}

	public Coordinates(Integer[] roomSize, Integer[] coords, ArrayList<Integer[]> patches, String instructions) {
		this.roomSize = roomSize;
		this.coords = coords;
		this.patches = patches;
		this.instructions = instructions;
	}
	
	public Integer[] getRoomSize() {
		return roomSize;
	}
	public void setRoomSize(Integer[] roomSize) {
		this.roomSize = roomSize;
	}
	public Integer[] getCoords() {
		return coords;
	}
	public void setCoords(Integer[] coords) {
		this.coords = coords;
	}
	public ArrayList<Integer[]> getPatches() {
		return patches;
	}
	public void setPatches(ArrayList<Integer[]> patches) {
		this.patches = patches;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	
	
	
}
