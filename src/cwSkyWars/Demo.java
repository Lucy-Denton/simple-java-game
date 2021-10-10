package cwSkyWars;

//import java.awt.Frame;

public class Demo {

	public static void main(String[] args) {
		
//		SkyWarsGUI frame = new SkyWarsGUI();
//		frame.setVisible(true);
		
		Game game = new Game();	
//		game.displayOutput();
//		game.moveAllShips();
//		GridSky sky = new GridSky();
		
		MasterShip ms = new MasterShip();
//		ms.displayOutput();
//		
		MoveButton mvbtn = new MoveButton();			
//		RNGs rng = new RNGs();
			
		
		// ## --- using MoveButton Class to move Master Ship --- ###
//		game.isMsOnThisSquare();
//		sky.askAllSquaresIsMSOn(ms);
//		game.displayOutput();
		mvbtn.returnMasterShipRow(ms);
		mvbtn.returnMasterShipSq(ms);
		
		ms.displayOutput();
//		game.displayOutput();
////		## --- creating Enemy Ships --- ###	
		
		CreateEnemyShips ces = new CreateEnemyShips();
		ces.createEnemyShips();
		
		// --- ## Moving ESs ## ---
		ces.createEnemyShips();
		mvbtn.returnEnemyShipsRow();
		mvbtn.returnEnemyShipsSq();
		mvbtn.printOutput();
		
		mvbtn.returnMasterShipRow(ms);
		mvbtn.returnMasterShipSq(ms);
		
		ms.displayOutput();

//		ces.createEnemyShips();
//		mvbtn.returnEnemyShipsRow();
//		mvbtn.returnEnemyShipsSq();
//		mvbtn.printOutput();
//		
//		ces.createEnemyShips();
//		mvbtn.returnEnemyShipsRow();
//		mvbtn.returnEnemyShipsSq();
//		mvbtn.printOutput();
//		
//		ces.createEnemyShips();
//		mvbtn.returnEnemyShipsRow();
//		mvbtn.returnEnemyShipsSq();
//		mvbtn.printOutput();
		
		// ### try to test list of enemies on each square
//		sky.constructEnemieOnEachSqOutput();
//		sky.displayListOfEnemiesOnEachSq();
//
//		sky.countESsOnEachSquare(ces);
//		
//		sky.countESsOnMSSquare(ces, ms);
//		sky.displayESsCounter();
		
//		game.conflictResolution();
//		game.constructeSsCounterOutput();
//		game.displayESsCounterOutput();		
		
	}

} // end class


//## --- creating Enemy Ships --- ###
//Ship ship = new Ship();
////!!	EnemyShip es = new EnemyShip(); // DEFINITELY DON'T WANT TO USE THIS!!
//CruiseShip cruise = new CruiseShip();
//StarShip star = new StarShip();
//NewEnemyShip newEs = new NewEnemyShip();

//ces.testESRow();
//ces.testEnemyShipName();
//mvbtn.decideEdgeRowNew(rng, ces);
//mvbtn.printOutput(ces);
//mvbtn.decideMiddleRowNew(cruise, star, newEs, rng);S
//mvbtn.decideNewSq(cruise, star, newEs, rng);

//## --- Code to get Adjacent Squares --- ###		
//game.getGridSky().setAdjSquares(4, 4);
//sky.setAdjSquares(4, 4);
//sky.getAdjSquares();
//Row row = new Row (3);
//Square square = new Square(3);
//square.setAdjLeft(square);
//square.setAdjRight(square);
//square.makeArrayListOfLRSqs(square);
//square.makeArrayListOfLMRSqs(square);
//square.displayOutput();
//sky.displayOutput();

//row.makeArrayListOfSqsAbove(square);
//row.makeArrayListOfSameRowSqs(square);
//row.makeArrayListOfSqsBelow(square);
//row.makeArrayListofSurroundSqs(square);
//row.displayOutput();

//mvbtn.setEdgeRowNew(ms, rng);
//mvbtn.setMiddleRowNew(ms, rng);
//mvbtn.setNewSq(ms, rng);
//mvbtn.moveMSRow(ms);				
//mvbtn.moveMSSq(ms);

//ms.testGetMsRowMethod();
//ms.testGetSqNumMethod();

//## --- using MoveButton Class to move Master Ship --- ###	
//mvbtn.setEdgeRowNew(ms, rng);
//mvbtn.setMiddleRowNew(ms, rng);
//mvbtn.setNewSq(ms, rng);
//mvbtn.moveShipRow(ms);				
//mvbtn.moveShipSq(ms);
//mvbtn.printOutput(ms);
