package jUnitTests;

import cwSkyWars.GridSky;
import cwSkyWars.MasterShip;
import junit.framework.TestCase;

public class MasterShipTest  extends TestCase {
	// create new instances of Classes to be tested
	MasterShip ms = new MasterShip(3, 4);
	GridSky grid = new GridSky();
	
	public void testMasterShip() {				
		// prepare test variables
		int actualRow = ms.getMsRow();
		int expectedRow = 3;		
		
		// test 
		assertTrue(actualRow == expectedRow);
	}
	
	public void testMasterShipSq() {
		// prepare the variables
		int actualSq = ms.getMsSq();
		int expectedSq = 4;
		
		// test
		assertTrue(actualSq == expectedSq);		
	}
	
	public void testUniqueMasterShip() {
		// prepare the variables
		// Access the method in GridSky Class that iterates through the grid
		// checking whether an instance of Master Ship is on each square and
		// adds the instance to the counter variable - askAllSquaresIsMSOn -
		int actualMS = grid.askAllSquaresIsMSOn(ms);
		int expectedMS = 1; // only 1 instance of Master Ship	
		
		// test
		assertTrue(actualMS == expectedMS);
		
	}
}
