package cwSkyWars;

import java.util.ArrayList;

//import java.util.ArrayList;

public class Game {
	private GridSky sky;
	private MasterShip masterShip;
	private CreateEnemyShips ces;
	private MoveButton mvbtn;
	private int countESsOnMsSq = 0;
	private int esIdToRemove;
	private int eSsOnSpecificSquare;
	private ArrayList<Integer> listOfEnemies = new ArrayList<Integer>();
	private int stars = 0;
	private int cruises = 0;
	private int newType = 0;
	private boolean gameOver = false;
	private int mSRow;
	private int mSSq;
	private int esNumR1S1; // Row 1 representation variables
	private int esNumR1S2;
	private int esNumR1S3;
	private int esNumR1S4;
	private int esNumR2S1; // Row 2 representation variables
	private int esNumR2S2;
	private int esNumR2S3;
	private int esNumR2S4;
	private int esNumR3S1; // Row 3 representation variables
	private int esNumR3S2;
	private int esNumR3S3;
	private int esNumR3S4;
	private int esNumR4S1; // Row 4 representation variables
	private int esNumR4S2;
	private int esNumR4S3;
	private int esNumR4S4;
	
	public Game() {	
		this.setGridSky(sky);
		this.masterShip = new MasterShip();
		this.masterShip.toString();
		this.masterShip.displayOutput();		
		this.mvbtn = new MoveButton();
		this.ces = new CreateEnemyShips();
	}
	
//	public void game() {}
	
	public void moveAllShips() {		
		this.mvbtn.setCreatedEnemies(ces);
		this.mvbtn.returnEnemyShipsRow();
		this.mvbtn.returnEnemyShipsSq();
		this.mvbtn.getCreatedEnemies();
		this.mvbtn.printOutput();		
		this.mvbtn.returnMasterShipRow(this.masterShip);
		this.mvbtn.returnMasterShipSq(this.masterShip);
		this.masterShip.toString();
		this.masterShip.displayOutput();
//		this.getEsIdToRemove();
//		this.updateEnemyShipsList();
//		this.ces.createEnemyShips();
	}	
		
	public ArrayList<EnemyShip> updateEnemyShipsList(){		
		for(EnemyShip tempEnemyShip : ces.createdEnemies) {
			if(tempEnemyShip.getEnemyShipId() == this.esIdToRemove && tempEnemyShip.isHasMoved() == false) { // EDITED HERE
				ces.createdEnemies.remove(this.esIdToRemove);
			}
		}
		return ces.createdEnemies;
	}
	
	public int getEsIdToRemove() {
		esIdToRemove = ces.getEnemyShipId(masterShip.getMsRow(), masterShip.getMsSq());
		return this.esIdToRemove;
	}
	
	// CONFLICT RESOLUTION
	public boolean isGameOver() {
		if(this.countESsOnMsSq >= 2) {
			gameOver = true;
		}
		if(this.countESsOnMsSq == 1) { // EDITED HERE
			this.getEsIdToRemove();
			this.updateEnemyShipsList();
			gameOver = false;
			ces.getCreatedEnemies();
		}
//		else {
//			ces.getCreatedEnemies();
////			gameOver = false;
//		}
		return this.gameOver;
	}
	
	public int getCountESsOnMsSq() {		
		for(EnemyShip tempEnemyShip : ces.createEnemyShips()) {
			if(tempEnemyShip.getEsRow() == masterShip.getMsRow() && tempEnemyShip.getEsSq() == masterShip.getMsSq()) {
				countESsOnMsSq++;
			}
		}
		return this.countESsOnMsSq;
	}
	
	// Methods to display the Master Ship in the GUI
	public int mSRow() {
		mSRow = masterShip.getMsRow();
		return this.mSRow;
	}
	public int mSSq() {
		mSSq = masterShip.getMsSq();
		return this.mSSq;
	} 
	
	// Get list of Enemy Ship Id's on a particular square
	public ArrayList<Integer> listESsOnSpecificSquare(int rowNum, int sqNum) {
		int esId = 0;
		for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
			if(tempEnemyShip.getEsRow() == rowNum && tempEnemyShip.getEsSq() == sqNum) {
				esId = tempEnemyShip.getEnemyShipId();
				listOfEnemies.add(esId);
			}
		}
		return this.listOfEnemies;
	}
	
	//~~~ THIS MEHTOD KIND OF WORKED ~~~ DOES NOT WORK PROPERLY
	public int countESsOnSpecificSquare(int rowNum, int sqNum) {		
		for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
			if(tempEnemyShip.getEsRow() == rowNum && tempEnemyShip.getEsSq() == sqNum) {
				// enter the row when condition: tempEnemyShip row equals mastership row
				//			if(tempEnemyShip.getEsSq() == sqNum) {
				eSsOnSpecificSquare = this.eSsOnSpecificSquare++;
				//			}				
			}
		}
		return this.eSsOnSpecificSquare;
	}
	
	public int countStars() {
		stars = 0;
		for(EnemyShip tempEnemyShip : ces.createdEnemies) {
//			stars = 0;
			if(tempEnemyShip.getName() == "Star Ship") {
				stars++;
			}
		}
		return this.stars;
	}
	
	public int countCruises() {
		cruises = 0;
		for(EnemyShip tempEnemyShip : ces.createdEnemies) {
//			cruises = 0;
			if(tempEnemyShip.getName() == "Cruise Ship") {
				cruises++;
			}
		}
		return this.cruises;
	}
	
	public int countNewTypes() {
		newType = 0;
		for(EnemyShip tempEnemyShip : ces.createdEnemies) {
//			newType = 0;
			if(tempEnemyShip.getType() == "New Enemy Ship") {
				newType++;
			}
		}
		return this.newType;
	}
	
	// --- Methods to correctly display Enemy Ships count on Labels representing squares in GUI ---
	// R1S1
	public int countESsonR1S1() {
		for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
			if(tempEnemyShip.getEsRow() == 1) {
				if(tempEnemyShip.getEsSq() == 1) {
					esNumR1S1++;
				}
			}
		}
		return this.esNumR1S1;
	}
	public int resetR1S1() {
		esNumR1S1 = 0;
		return this.esNumR1S1;
	}
	// R1S2
	public int countESsonR1S2() {
		for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
			if(tempEnemyShip.getEsRow() == 1) {
				if(tempEnemyShip.getEsSq() == 2) {
					esNumR1S2++;
				}
			}
		}
		return this.esNumR1S2;
	}
	public int resetR1S2() {
		esNumR1S2 = 0;
		return this.esNumR1S2;
	}
	// R1S3
	public int countESsonR1S3() {
		for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
			if(tempEnemyShip.getEsRow() == 1) {
				if(tempEnemyShip.getEsSq() == 3) {
					esNumR1S3++;
				}
			}
		}
		return this.esNumR1S3;
	}
	public int resetR1S3() {
		esNumR1S3 = 0;
		return this.esNumR1S3;
	}
	// R1S4
	public int countESsonR1S4() {
		for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
			if(tempEnemyShip.getEsRow() == 1) {
				if(tempEnemyShip.getEsSq() == 4) {
					esNumR1S4++;
				}
			}
		}
		return this.esNumR1S4;
	}
	public int resetR1S4() {
		esNumR1S4 = 0;
		return this.esNumR1S4;
	}
	// R2S1
	public int countESsonR2S1() {
		for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
			if(tempEnemyShip.getEsRow() == 2) {
				if(tempEnemyShip.getEsSq() == 1) {
					esNumR2S1++;
				}
			}
		}
		return this.esNumR2S1;
	}
	public int resetR2S1() {
		esNumR2S1 = 0;
		return this.esNumR2S1;
	}
	// R2S2
	public int countESsonR2S2() {
		for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
			if(tempEnemyShip.getEsRow() == 2) {
				if(tempEnemyShip.getEsSq() == 2) {
					esNumR2S2++;
				}
			}
		}
		return this.esNumR2S2;
	}
	public int resetR2S2() {
		esNumR2S2 = 0;
		return this.esNumR2S2;
	}
	// R2S3
	public int countESsonR2S3() {
		for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
			if(tempEnemyShip.getEsRow() == 2) {
				if(tempEnemyShip.getEsSq() == 3) {
					esNumR2S3++;
				}
			}
		}
		return this.esNumR2S3;
	}
	public int resetR2S3() {
		esNumR2S3 = 0;
		return this.esNumR2S3;
	}
	// R2S4
	public int countESsonR2S4() {
		for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
			if(tempEnemyShip.getEsRow() == 2) {
				if(tempEnemyShip.getEsSq() == 4) {
					esNumR2S4++;
				}
			}
		}
		return this.esNumR2S4;
	}
	public int resetR2S4() {
		esNumR2S4 = 0;
		return this.esNumR2S4;
	}
	// R3S1
	public int countESsonR3S1() {
		for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
			if(tempEnemyShip.getEsRow() == 3) {
				if(tempEnemyShip.getEsSq() == 1) {
					esNumR3S1++;
				}
			}
		}
		return this.esNumR3S1;
	}
	public int resetR3S1() {
		esNumR3S1 = 0;
		return this.esNumR3S1;
	}
	// R3S2
	public int countESsonR3S2() {
		for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
			if(tempEnemyShip.getEsRow() == 3) {
				if(tempEnemyShip.getEsSq() == 2) {
					esNumR3S2++;
				}
			}
		}
		return this.esNumR3S2;
	}
	public int resetR3S2() {
		esNumR3S2 = 0;
		return this.esNumR3S2;
	}
	// R3S3
	public int countESsonR3S3() {
		for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
			if(tempEnemyShip.getEsRow() == 3) {
				if(tempEnemyShip.getEsSq() == 3) {
					esNumR3S3++;
				}
			}
		}
		return this.esNumR3S3;
	}
	public int resetR3S3() {
		esNumR3S3 = 0;
		return this.esNumR3S3;
	}
	// R3S4
	public int countESsonR3S4() {
		for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
			if(tempEnemyShip.getEsRow() == 3) {
				if(tempEnemyShip.getEsSq() == 4) {
					esNumR3S4++;
				}
			}
		}
		return this.esNumR3S4;
	}
	public int resetR3S4() {
		esNumR3S4 = 0;
		return this.esNumR3S4;
	}
	// R4S1
	public int countESsonR4S1() {
		for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
			if(tempEnemyShip.getEsRow() == 4) {
				if(tempEnemyShip.getEsSq() == 1) {
					esNumR4S1++;
				}
			}
		}
		return this.esNumR4S1;
	}
	public int resetR4S1() {
		esNumR4S1 = 0;
		return this.esNumR4S1;
	}
	// R4S2
	public int countESsonR4S2() {
		for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
			if(tempEnemyShip.getEsRow() == 4) {
				if(tempEnemyShip.getEsSq() == 2) {
					esNumR4S2++;
				}
			}
		}
		return this.esNumR4S2;
	}
	public int resetR4S2() {
		esNumR4S2 = 0;
		return this.esNumR4S2;
	}
	// R4S3
	public int countESsonR4S3() {
		for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
			if(tempEnemyShip.getEsRow() == 4) {
				if(tempEnemyShip.getEsSq() == 3) {
					esNumR4S3++;
				}
			}
		}
		return this.esNumR4S3;
	}
	public int resetR4S3() {
		esNumR4S3 = 0;
		return this.esNumR4S3;
	}
	// R4S4
	public int countESsonR4S4() {
		for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
			if(tempEnemyShip.getEsRow() == 4) {
				if(tempEnemyShip.getEsSq() == 4) {
					esNumR4S4++;
				}
			}
		}
		return this.esNumR4S4;
	}
	public int resetR4S4() {
		esNumR4S4 = 0;
		return this.esNumR4S4;
	}
	
	
	public GridSky getGridSky() {
		return this.sky;
	}

	public void setGridSky(GridSky grid) {
		this.sky = new GridSky();
	}
	
	public String toString() {
		String output = "" + this.sky;
		return output;
	}
	
	public void displayOutput() {
		String output = this.toString();
		System.out.println(output);
	}
	
	public String constructGameOver() {
		String output = "\nGame over? ";
		output = output + this.gameOver;
		return output;
	}
	
	public void printGameOver() {
		String output = this.constructGameOver();
		System.out.println(output);
	}
	
//	public String constructeSsCounterOutput() {
//		String output = "\nThere are " + this.eSsCounter + " on the same square as the Master Ship";
//		return output;
//	}
	
//	public void displayESsCounterOutput() {
//		String output = this.constructeSsCounterOutput();
//		System.out.println(output);
//	}


	// -- NOT USED --
	public void setCountESsOnMsSq(int countESsOnMsSq) {
		this.countESsOnMsSq = countESsOnMsSq;
	}
	// -- NOT USED --
	public void setEsId(int esId) {
	this.esIdToRemove = esId;
	}
	
} // end class



//private ArrayList<EnemyShip> enemiesOnEachSq = new ArrayList<EnemyShip>();


//private int sSsOnEachSquareUpdated = 0;
//private final int GRID_MIN_LIMIT = 0;
//private final int GRID_MAX_LIMIT = 5;
//private boolean msOnThisSquare = false;

// -- ## !! This method does not work because not accessing the REAL row and squares !! ## --
// -- ## which are in ArrayLists theRows (GridSky) and theSquares (Row) ## --
//public boolean isMsOnThisSquare() {
//	for(int loop = GRID_MIN_LIMIT + 1; loop < GRID_MAX_LIMIT; loop++) {
//		Row tempRow = new Row (loop);
//		if(tempRow.getRowNum() == masterShip.getMsRow()) {
//			for(Square tempSquare : tempRow.getTheSquares()) {
//				if(tempSquare.getSqNum() == masterShip.getMsSq()) {
//					msOnThisSquare = true;
//				}
//			}
//		}
//	}
//	return this.msOnThisSquare;
//}

// this method needs to row and square input
//public boolean isMSOnSquare(int row, int sq) {
//	if(this.sky.getRowInGrid(row).getSquareInRow(sq).isMsOnThisSquare(masterShip, sky) == true) {
//		msOnSquare = true;
//		return this.msOnSquare;
//	}
//	else {
//		msOnSquare = false;
//		return this.msOnSquare;
//	}
//}

// representing the grid in the GUI
//public void gridInGUI() {
//}


//
//// method to RESET ESNum on label display -- NOT USED
//public int resetDisplay(int rowNum, int sqNum) {
//	for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
//		if(tempEnemyShip.getEsRow() == rowNum) {
//			if(tempEnemyShip.getEsSq() == sqNum) {
//				this.eSsOnEachSquare = 0;
//			}
//		}
//	}
//	return this.eSsOnEachSquare;
//}


//public int geteSsCounter() {
//return this.eSsCounter;
//}
//
//public void seteSsCounter(int eSsCounter) {
//this.eSsCounter = sky.getESsCounter();
//}


//public int countESsOnEachSquare() {
//eSsOnEachSquare = this.enemiesOnEachSq.size();
//return this.eSsOnEachSquare;
//}

//// !!! This method added too many ESs to GUI labels !!!
//// --- method to count ESs on each square in sky ---
//public int countESsOnAllSquares(int row , int sq) {
//for(int counter = this.GRID_MIN_LIMIT + 1; counter < this.GRID_MAX_LIMIT; counter++) {
//	for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
//		if(tempEnemyShip.getEsRow() == row) {
//			if(tempEnemyShip.getEsSq() == sq) {
//				enemiesOnEachSq.add(tempEnemyShip);
//				eSsOnEachSquare = enemiesOnEachSq.size();
//			}
////			for(int loop = this.GRID_MIN_LIMIT + 1; loop < this.GRID_MAX_LIMIT; loop++) {
////			}
////				Square square = new Square (loop);
////				if(tempEnemyShip.getEsSq() == sq) {
////					enemiesOnEachSq.add(tempEnemyShip);
////					eSsOnEachSquare = enemiesOnEachSq.size();
////				}				
//		}
//	}
//}
//return this.eSsOnEachSquare;
//}
//			// enter the row when condition, tempEnemyShip row equals tempRow
//			for(int loop = this.GRID_MIN_LIMIT + 1; loop < this.GRID_MAX_LIMIT; loop++) {
//				Square square = new Square (loop);
//				if(square.getSqNum() == tempEnemyShip.getEsSq()) {
//					this.enemiesOnEachSq.add(tempEnemyShip);
//				}
//			}