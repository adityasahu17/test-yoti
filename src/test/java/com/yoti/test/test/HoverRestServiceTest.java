package com.yoti.test.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import com.yoti.test.api.HoverRestService;
import com.yoti.test.model.Coordinates;

import javax.ws.rs.client.Entity;

/*
 * Test Class implementing Jesrsey Test*/

public class HoverRestServiceTest  extends JerseyTest{
	
	public Application configure(){
		return new ResourceConfig(HoverRestService.class);
	}
	

	
	@Test
	public void updateUserPost() throws Exception{
		Integer[] patch1={1,0};
		Integer[] patch2={2,2};
		Integer[] patch3={2,3};
		ArrayList<Integer[]>patches = new ArrayList<Integer[]>();
		patches.add(patch1);
		patches.add(patch2);
		patches.add(patch3);
		Integer[] roomSize = {5,5};
		Integer[] coords = {1,2};
		Coordinates input = new Coordinates(roomSize,coords,patches,"NNESEESWNWW");
		Response output = target("/hover").request().post(Entity.entity(input, MediaType.APPLICATION_JSON));
		assertEquals(200, output.getStatus());

	}
	
	/*
	 * locations of patches of dirt, also defined by X and Y 
	 * coordinates identifying the bottom left
	 *  corner of those grid positions.
	 *  
	 *  Taking [0,0] as initial position and patch also at [0,0]
	 *  Taken care of the condition in which coordinates exceed the
	 *  wall coordinates.
	 *  
	 *  */
	
	@Test
	public void updateUserPost1() throws Exception{
		Integer[] roomSize = {3,3};
		Integer[] coords = {0,0};
		Integer[] patch1={0,0};
		Integer[] patch2={0,2};
		Integer[] patch3={2,0};
		Integer[] patch4={2,2};
		ArrayList<Integer[]>patches = new ArrayList<Integer[]>();
		patches.add(patch1);
		patches.add(patch2);
		patches.add(patch3);
		patches.add(patch4);
		Coordinates input = new Coordinates(roomSize,coords,patches,"NNNNSSEENNS");
		Response output = target("/hover").request().post(Entity.entity(input, MediaType.APPLICATION_JSON));
		assertEquals(200, output.getStatus());

	}
	

}
