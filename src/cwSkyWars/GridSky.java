package cwSkyWars;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GridSky {
	private ArrayList<Row> theRows = new ArrayList<Row>();
	private final int GRID_MIN_LIMIT = 0;
	private final int GRID_MAX_LIMIT = 5;
	
	private int askAllSquaresIsMSOn = 0;
	
	private ArrayList <EnemyShip> enemiesOnEachSq = new ArrayList <EnemyShip> ();
//	private CreateEnemyShips ces;
	private int eSsOnMSCounter;
	private int sSsOnEachSquare;
//	private ArrayList<Square> surroundingSqs = new ArrayList<Square>();
	
	public GridSky () {		
		for(int loop = this.GRID_MIN_LIMIT + 1; loop < this.GRID_MAX_LIMIT; loop++) {
			this.theRows.add(new Row(loop));			
		}		
	}
	
	public int askAllSquaresIsMSOn(MasterShip masterShip) {
		for(Row tempRow : this.theRows) {
			if(tempRow.getRowNum() == masterShip.getMsRow()) {
				for(int loop = GRID_MIN_LIMIT + 1; loop < GRID_MAX_LIMIT; loop++) {
					Square tempSquare = new Square(loop);
					if(tempSquare.getSqNum() == masterShip.getMsSq()) {
						askAllSquaresIsMSOn++;
					}
				}				
			}
		}		
		return this.askAllSquaresIsMSOn;
	}
	
	
	// PROBABLY BETTER IN GAME CLASS ?? -- NOT USED
	public int countESsOnEachSquare(CreateEnemyShips ces/*, int rowNum, int sqNum*/) {
		// --- ## for testing purposes user input specific row and square to count ESs ## ---
		String rowAsString = JOptionPane.showInputDialog("Please enter the row number");
		int rowNum = Integer.parseInt(rowAsString);//		
		String sqAsString = JOptionPane.showInputDialog("Please enter the square number");
		int sqNum = Integer.parseInt(sqAsString);
		
		for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
			if(tempEnemyShip.getEsRow() == rowNum && tempEnemyShip.getEsSq() == sqNum) {
				// enter the row when condition: tempEnemyShip row equals mastership row
				this.sSsOnEachSquare++;
			}
		}
		
		return this.sSsOnEachSquare;
	}

//	// -- method to count ESs on a particular square--
	public int countESsOnMSSquare(CreateEnemyShips ces, MasterShip masterShip) {
	
		for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
			if(tempEnemyShip.getEsRow() == masterShip.getMsRow() && tempEnemyShip.getEsSq() == masterShip.getMsSq()) {
				// enter the row when condition: tempEnemyShip row equals mastership row
				this.eSsOnMSCounter++;
			}
		}		
		return this.eSsOnMSCounter;
	}
		
	// --- method to count ESs on each square in sky --- NOT USED
	public ArrayList<EnemyShip> countESsOnAllSquares(CreateEnemyShips ces, int row , int sq) {
		for(Row tempRow : this.theRows) {
			for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
				if(tempEnemyShip.getEsRow() == row && tempRow.getRowNum() == row) {
					if(tempEnemyShip.getEsSq() == sq) {
					this.enemiesOnEachSq.add(tempEnemyShip);
				}
					// enter the row when condition, tempEnemyShip row equals tempRow
//					for(int loop = this.GRID_MIN_LIMIT + 1; loop < this.GRID_MAX_LIMIT; loop++) {
//						Square square = new Square (loop);
//						if(square.getSqNum() == tempEnemyShip.getEsSq()) {
//							this.enemiesOnEachSq.add(tempEnemyShip);
//						}
//					}
				}
			}
		}
		return this.enemiesOnEachSq;
	}

	public int getESsCounter() {
		return this.eSsOnMSCounter;
	}

	 // NOT USED
	public void setESsCounter(int eSsCounter) {
		eSsCounter = this.enemiesOnEachSq.size();
		this.eSsOnMSCounter = eSsCounter;
	}

	// method to get to specific row in the grid
	public Row getRowInGrid(int row) {
		for(Row tempRow : this.theRows) {
			if(tempRow.getRowNum() == row) {
				return tempRow;
			}
		}
		return null;
	}
	
	public String constructEnemieOnEachSqOutput() {
		String output = "\nEnemies on this square are: ";
		for(EnemyShip tempEnemyShip : this.enemiesOnEachSq) {
			output = output +"\n" + tempEnemyShip;
		}
		return output;
	}
		
	// construct output
	public String toString() {
		String output="";
		for(Row tempRow : theRows) {
			output = output +tempRow.toString() + "\n";
		}
		return output;
	}
	
	public void displayOutput() {
		String output;
		output = this.toString() + "\n";		
		System.out.println(output);
	}
	
	public void displayListOfEnemiesOnEachSq() {
		String output = "\nThe list of enemies on particular squares are:\n";
		output = output + this.constructEnemieOnEachSqOutput();
		System.out.println(output);
	}
	
	//THIS ONE WORKED!!
	public void displayESsCounter() {
		String output = "\n";
		output = output + "\nThere are " + this.getESsCounter() + " enemy ships on that particular square";
		System.out.println(output);
	}
	

}// end class

// ## --- unused code for eSsCounter method

//if(tempEnemyShip.getEsSq() == sq) {
//this.eSsCounter++;
//}
//for(int loop = this.GRID_MIN_LIMIT + 1; loop < this.GRID_MAX_LIMIT; loop++) {
//Square square = new Square (loop);
////if(tempEnemyShip.getEsSq() == sq) {
////	this.eSsCounter++;
////}
//}

//// ## --- Here or in the Row Class --- ### (??)
//// ### --- ATTEMPT TO GET ALL SURROUNDING SQUARES --- ###
//public ArrayList<Square> makeArrayListofAdjSqs(Square square) {		
//	return this.surroundingSqs;
//}

//public ArrayList<Row> GridSky() {		
//for(int loop = this.GRID_MIN_LIMIT + 1; loop < this.GRID_MAX_LIMIT; loop++) {
//	this.theRows.add(new Row(loop));			
//}
//return this.theRows;
//}


// Access row and square on grid (?)
// --- public method ---
//for(Row tempRow : this.theRows) {
//if(tempRow.getRowNum() == row.getRowNum()) {
//	Square newSquare = tempRow.getSquareInRow(sqNum);
//	for(Square tempSquare : row) {
//	}
//}
//}

//private ArrayList<Square> adjSquares = new ArrayList<Square>();

// test setAdjSquares method
//public String printAdjSquares() {
//	String output = "";
//	for(Square tempSquare : this.adjSquares) {
//		output = output +tempSquare.toString()+" ";
//	}
//	return output;
//}