package cwSkyWars;

import java.util.ArrayList;

public class Row {
	private ArrayList<Square> theSquares = new ArrayList<Square>();
	private int rowNum;
	private int upperBoundRow;
	private int lowerBoundRow;
	private final int GRID_MIN_LIMIT = 0;
	private final int GRID_MAX_LIMIT = 5;
	private ArrayList<Integer> aboveSqs = new ArrayList<Integer>();
	private ArrayList<Integer> adjSqs = new ArrayList<Integer>();
	private ArrayList<Integer> belowSqs = new ArrayList<Integer>();
	
	public Row(int num) {		
		for(int loop = GRID_MIN_LIMIT + 1; loop < GRID_MAX_LIMIT; loop++) {
			this.theSquares.add(new Square(loop));			
		}
		setRowNum(num);
	}
	
	public int upperBoundNewRow() {
		if(this.rowNum + 1 == GRID_MAX_LIMIT) {
			upperBoundRow = rowNum;
		}
		else {
			upperBoundRow = rowNum + 1;
		}
		return this.upperBoundRow;
	}
	
	public int lowerBoundNewRow() {
		if(this.rowNum - 1 == GRID_MIN_LIMIT) {
			lowerBoundRow = rowNum;
		}
		else {
			lowerBoundRow = rowNum - 1;
		}
		return this.lowerBoundRow;
	}
		
	public ArrayList<Integer> makeArrayListOfSqsAbove(Square square){
		if(this.rowNum != GRID_MIN_LIMIT + 1) {	
			for(int loop = square.getAdjLeft(); loop <= square.getAdjRight(); loop++) {
				if(loop == GRID_MIN_LIMIT) {
					continue;
				}
				if(loop == GRID_MAX_LIMIT) {
					continue;
				}
				this.aboveSqs.add(loop);
			}				
		}		
		return this.aboveSqs;
	}

	public ArrayList<Integer> makeArrayListOfSameRowSqs(Square square){
		if((this.rowNum != GRID_MIN_LIMIT + 1) || (this.rowNum != GRID_MAX_LIMIT - 1)) {
//			Square square;
			for(int loop = square.getAdjLeft(); loop <= square.getAdjRight(); loop++) {
				if(loop == GRID_MIN_LIMIT) {
					continue;
				}
				if(loop == GRID_MAX_LIMIT) {
					continue;
				}
				if(loop == square.getSqNum()) {
					continue;
				}
//				Square tempSquare = new Square (loop);
				this.adjSqs.add(loop);
			}				
		}			
		return this.adjSqs;
	}

	public ArrayList<Integer> makeArrayListOfSqsBelow(Square square) {
		if(this.rowNum != GRID_MAX_LIMIT - 1) {	
//			Square square;
			for(int loop = square.getAdjLeft(); loop <= square.getAdjRight(); loop++) {
				if(loop == GRID_MIN_LIMIT) {
					continue;
				}
				if(loop == GRID_MAX_LIMIT) {
					continue;
				}
//				Square tempSquare = new Square (loop);
				this.belowSqs.add(loop);
			}				
		}	
		return this.belowSqs;
	}
	
	
	public Square getSquareInRow(int sq) {
		for(Square tempSquare : theSquares) {
			if(tempSquare.getSqNum() == sq) {
				return tempSquare;			
			}			
		}
		return null;
	}
	
	
	public ArrayList<Square> getTheSquares() {
		return this.theSquares;
	}

	public int getRowNum() {
		return this.rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	
	public String toString() {
		String output ="" +this.rowNum + "| ";
		for(Square tempSquare : theSquares) {
			output = output +tempSquare.toString()+" ";
		}
		return output;
	}
	
	public void displayOutput () {
		String output;
		output = this.toString();
		System.out.println(output);
	}

} // end class

//public String printArrayList_LMRSquares() {
//String output = "\nThe left, middle and right adjacent squares are: ";			
////for(Square tempSquare : this.leftMiddleRightSqs) {
////	output = output + tempSquare.toString() + ",  ";
////}
//return output;
//}
//
//
//public String printArrayList_LRSquares() {
//String output = "\nThe left and right adjacent squares are: ";			
////for(Square tempSquare : this.leftRightSquares) {
////	output = output + tempSquare.toString() + ",  ";
////}
//return output;
//}


//// method to get possible new row num
//public ArrayList<Integer> possibleNewRow() {
//	for(int loop = this.rowNum - 1; loop <= this.rowNum + 1; loop++) {
//		if(loop == GRID_MIN_LIMIT) {
//			continue;
//		}
//		if(loop == GRID_MAX_LIMIT) {
//			continue;
//		}		
//		this.possibleNewRows.add(loop);
//	}
//	return this.possibleNewRows;
//}


// ADD the Above/Same/Below row adjacent squares


//// print makeArrayListofSurroundSqs method
//public String printMakeArrayListofSurroundSqs() {
//	String output = "The surrounging squares are: \n";
//	for(Square tempSquare : this.surroundingSqs) {
//		output = output + tempSquare.toString() + ", ";
//	}
//	return output;
//}
//
//
//// print makeArrayListOfADJSqs method
//public String printMakeArrayListOfADJSqsAbove() {
//	String output = "The adjacent squares ABOVE are ";
//	for(Square tempSquare : this.aboveSqs) {
//		output = output + tempSquare.toString() + ", ";
//	}
//	return output;
//}
//
//
//// print makeArrayListOfADJSqs method
//public String printmakeArrayListOfSameRowSqs() {
//	String output = "The adjacent squares are ";
//	for(Square tempSquare : this.adjSqs) {
//		output = output + tempSquare.toString() + ", ";
//	}
//	return output;
//}
//
//// print makeArrayListOfADJSqs method
//public String printMakeArrayListOfADJSqsBelow() {
//	String output = "The adjacent squares BELOW are ";
//	for(Square tempSquare : this.belowSqs) {
//		output = output + tempSquare.toString() + ", ";
//	}
//	return output;
//}


////output = output + "\n" + this.printMakeArrayListofSurroundSqs();
//output = output + "\n" + this.printMakeArrayListOfADJSqsAbove();
//output = output + "\n" + this.printmakeArrayListOfSameRowSqs();
//output = output + "\n" + this.printMakeArrayListOfADJSqsBelow();

// ## --- Here or in the SkyGrid Class --- ### (??)
// ### --- ATTEMPT TO GET ALL SURROUNDING SQUARES --- ###
//public ArrayList<Square> makeArrayListofSurroundSqs(Square square) {
//	for(int loop = this.rowNum - 1; loop <= this.rowNum + 1; loop++) {
//		if(loop == GRID_MIN_LIMIT) {
//			continue;
//		}
//		if(loop == GRID_MAX_LIMIT) {
//			continue;
//		}
//		for(int counter = square.getAdjLeft(); loop <= square.getAdjRight(); loop++) {
//			if(counter == GRID_MIN_LIMIT) {
//				continue;
//			}
//			if(counter == GRID_MAX_LIMIT) {
//				continue;
//			}
//			if(loop == this.rowNum && counter == square.getSqNum()) {
//				continue;
//			}
//			Square tempSquare = new Square (counter);
//			this.surroundingSqs.add(tempSquare);
//		}
//	}
//	return this.surroundingSqs;
//}
//




//private boolean minRow = false;
//private boolean maxRow = false;

//if(num == GRID_MIN_LIMIT + 1) {
//minRow = true;				
//}
//if(num == GRID_MAX_LIMIT - 1) {
//maxRow = true;
//}

//public boolean isMinRow(int num) {
//if(this.rowNum == GRID_MIN_LIMIT + 1) {
//	minRow = true;
//}
//return minRow;
//}


//// ## --- method NOT USED YET --- ##
//public ArrayList<EnemyShip> makeArrayListofESsOnR1S1 (CreateEnemyShips ces){
////	for()
//	for(int loop = 0; loop < ces.getCreatedEnemies().size(); loop++) {
//		for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
//			this.theEnemiesOnR1S1.add(tempEnemyShip);
//		}
//	}
//	
//	return this.theEnemiesOnR1S1;
//}	