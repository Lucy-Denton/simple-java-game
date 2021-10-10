package jUnitTests;

import cwSkyWars.CreateEnemyShips;
import cwSkyWars.Game;
import cwSkyWars.MasterShip;
import junit.framework.TestCase;

public class ConflictResolutionTest extends TestCase {
	// create instances of Classes to be Tested
	Game aGame = new Game();	
	MasterShip ms = new MasterShip(3, 4);	
	CreateEnemyShips ces = new CreateEnemyShips();
	
	public void testConflictOneES() {
		// create and place an Enemy Ship on specific square
		ces.manuallyCreateEnemyShips(3, 4);
		aGame.getCountESsOnMsSq();
		// call the isGameOver (conflict check method)
		boolean actualConflictOutcome = aGame.isGameOver();
		boolean expectedConflictOutcome = false; // because only one Enemy Ship has been created
		
		// test
		assertTrue(actualConflictOutcome == expectedConflictOutcome);
	}
	
	public void testConflictTwoES() {
		// Create and place two Enemy Ships on specific square
		// Very perplexing, as I never called the random Enemy Ship generator
		// (which has New Enemy Ship type), but this test still creates such ships??
		ces.manuallyCreateEnemyShips(3, 4);
		ces.manuallyCreateEnemyShips(3, 4);
		aGame.getCountESsOnMsSq();
		// call the isGameOver (conflict check method)
		boolean actualConflictOutcome = aGame.isGameOver();
		boolean expectedConflictOutcome = true; // because only one Enemy Ship has been created
		
		// test
		assertTrue(actualConflictOutcome == expectedConflictOutcome);
	}

}
