package jUnitTests;

import java.util.ArrayList;

import cwSkyWars.CreateEnemyShips;
import cwSkyWars.Game;
import cwSkyWars.Row;
import cwSkyWars.Square;
import junit.framework.TestCase;

public class EnemyShipsTest extends TestCase{
	int esId = 0;
	int esrow = 0;
	int esSq = 0;
	
	public void testEnemyShipMoved() {
		// create instances of Classes to be tested
		Game aGame = new Game();
		CreateEnemyShips ces = new CreateEnemyShips();
		
		// prepare the test conditions
		int aHighNumber = 20; // to be sure that at least one Enemy Ship is created
		ArrayList<Integer> esIds = new ArrayList<Integer>();
		
		ces.createEnemyShips();
		for(int loop = 0; loop < aHighNumber; loop++) {
			if(ces.isEnemyShipCreated() == true) {
				// once an Enemy Ship is created
				// get its id and exit loop
				esId = ces.getEnemyShipId();
				break;
			}
			// set the Test Enemy Ship row and square variables
			esrow = ces.getEnemyShipRowById(esId);
			esSq = ces.getEnemyShipSqById(esId);
		}
		
		// move the Enemy Ship
		aGame.moveAllShips();
		
		// check the list of Enemy Ships on particular square
		esIds = aGame.listESsOnSpecificSquare(esrow, esSq);

		// Prepare test variables
		// Search the list of Enemy Ship id's to check that 
		// the Test Enemy Ship is not in it.
		boolean actualIsESOnList = esIds.contains(esId);
		boolean expectedIsESOnList = false;
		
		// test	
		assertTrue(actualIsESOnList == expectedIsESOnList);
		
		
	}// end method
	
	// Method to test that the Test Enemy Ship has
	// moved to one of the neighbouring squares -- incomplete
	public void testEnemyShipNewSquare() {
		ArrayList<Integer> squaresAbove = new ArrayList<Integer>();
		ArrayList<Integer> squaresAdj = new ArrayList<Integer>();
		ArrayList<Integer> squaresBelow = new ArrayList<Integer>();
		final int GRID_MIN_LIMIT = 0;
		final int GRID_MAX_LIMIT = 5;
		
		// use Row and Square Classes to find neighbouring squares
		for(int loop = GRID_MIN_LIMIT + 1; loop < GRID_MAX_LIMIT; loop++) {
			Row tempRow = new Row (loop);
			if(tempRow.getRowNum() == esrow) {
				// when we get to the Test Enemy Ship row, make temp Squares
				for(int counter = GRID_MIN_LIMIT + 1; counter < GRID_MAX_LIMIT; counter++) {
					Square tempSquare = new Square (counter);
					if(tempSquare.getSqNum() == esSq) {
						// when we get to the Test Enemy Ship square (inside the correct row)
						// make list of neighbouring squares in above/same/below rows
						squaresAbove = tempRow.makeArrayListOfSqsAbove(tempSquare);
						squaresAdj = tempRow.makeArrayListOfSameRowSqs(tempSquare);
						squaresBelow = tempRow.makeArrayListOfSqsBelow(tempSquare);
					}
				}
			}
		} // end for loop
		
		
		// ~~~ TO DO ~~~
		// check that the Enemy Ship with test esId is on one of squares in
		// Row esRow -1, ArrayList<Integer> squaresAbove
		// Row esRow, ArrayList<Integer> squaresAdj
		// Row esRow + 1, ArrayList<Integer> squaresBelow
	}

	
} // end class
