package cwSkyWars;

import java.util.ArrayList;

public class Square {
	private int sqNum;
	private int upperBoundNewSq;
	private int lowerBoundNewSq;
	private final int GRID_MIN_LIMIT = 0;
	private final int GRID_MAX_LIMIT = 5;
	// --  The variables below are to determine the adhacent squares -- 
	private int adjLeft;
	private int adjRight;
	private ArrayList <Integer> leftRightSquares = new ArrayList <Integer>();
	private ArrayList<Integer> leftMiddleRightSqs = new ArrayList<Integer>();

		
	public Square(int num) {
		this.setSqNum(num);
		
	}
	
	public int upperBoundNewSq() {
		if(this.sqNum == GRID_MAX_LIMIT - 1) {
			upperBoundNewSq = sqNum;
		}
		else {
			upperBoundNewSq = sqNum + 1;
		}
		return upperBoundNewSq;
	}
	
	public int lowerBoundNewSq() {
		if(this.sqNum == GRID_MIN_LIMIT + 1) {
			lowerBoundNewSq = sqNum;
		}
		else {
			lowerBoundNewSq = sqNum - 1;
		}
		return lowerBoundNewSq;
	}
	
	public ArrayList<Integer> makeArrayListOfLMRSqs(){
		for(int loop = this.getAdjLeft(); loop <= this.getAdjRight(); loop++) {
			if(loop == GRID_MIN_LIMIT) {
				continue;
			}
			if(loop == GRID_MAX_LIMIT) {
				continue;
			}
//			Square tempSquare = new Square(loop);
			this.leftMiddleRightSqs.add(loop);
		}
		return this.leftMiddleRightSqs;
	}

	public ArrayList<Integer> makeArrayListOfLRSqs(){
		for(int loop = this.getAdjLeft(); loop <= this.getAdjRight(); loop++) {
			if(loop == GRID_MIN_LIMIT) {
				continue;
			}
			if(loop == GRID_MAX_LIMIT) {
				continue;
			}
			if(loop == this.sqNum) {
				continue;
			}
//			Square tempSquare = new Square(loop);
			this.leftRightSquares.add(loop);
		}	
		return this.leftRightSquares;
	}
	
	public int getAdjLeft() {
		this.setAdjLeft();
		return this.adjLeft;
	}

	public void setAdjLeft() {
		this.adjLeft = this.sqNum - 1;
	}

	public int getAdjRight() {
		this.setAdjRight();
		return this.adjRight;
	}

	public void setAdjRight() {
		this.adjRight = this.sqNum + 1;
	}

	public int getSqNum() {
		return this.sqNum;
	}

	public void setSqNum(int num) {
		this.sqNum = num;
	}
		
	
	public String toString() {
		String output="";	
		output = this.sqNum + "";
		return output;
	}
	
	public void displayOutput() {
		String output = "";
		output = this.toString();
		// the below output cannot be used yet
//		output = output + this.constructEnemieOnThisSqOutput();
		System.out.println(output);
	}
	
	
} // end class


//private boolean msOnThisSquare = false;
//private Game game = new Game();
//-- the below is the list of Enemy Ships on each square --
//private ArrayList <EnemyShip> enemiesOnThisSq = new ArrayList <EnemyShip> ();

// transferred this method to Game Class
//public boolean isMsOnThisSquare(MasterShip masterShip, GridSky sky) {
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

// is this needed??? -- modified Setter
//public void setMsOnThisSquare(Game game) {
//	this.msOnThisSquare = game.isMsOnThisSquare();
//}

// Getter for the boolean variable msOnThisSquare -- MAKE SURE TO USE THIS
//public boolean isMsOnThisSquare() {
//	return this.msOnThisSquare;
//}

//public void setMsOnThisSquare(boolean msOnThisSquare) {
//	this.msOnThisSquare = msOnThisSquare;
//}

//public ArrayList <EnemyShip> getEnemiesOnThisSq (CreateEnemyShips ces){
//
//for(EnemyShip enemyShip : ces.getCreatedEnemies()) {
//	Row row = new Row(enemyShip.getEsRow());
//	int rowNum = row.getRowNum();
//	for(int loop = GRID_MIN_LIMIT + 1; loop <= GRID_MAX_LIMIT - 1; loop++) {
//		if(loop == rowNum) {
//			int esSq = enemyShip.getEsSq();
//			if(esSq == this.sqNum) {
//				enemiesOnThisSq.add(enemyShip);
//			}
//		}
//	}
//}		
//return this.enemiesOnThisSq;
//}
//
//// the below output cannot be used yet
//public String constructEnemieOnThisSqOutput() {
//String output = "\nEnemies on this square are: ";
//for(EnemyShip tempEnemyShip : this.enemiesOnThisSq) {
//	output = output +"\n" + tempEnemyShip;
//}
//return output;
//}


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

//// ## --- method NOT USED YET --- ##
//public ArrayList<EnemyShip> makeArrayListofESsOnThisSq (){
////	for()
//	for(int loop = 0; loop < ces.getCreatedEnemies().size(); loop++) {
//		for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
//			this.theEnemiesOnThisSq.add(tempEnemyShip);
//		}
//	}
//	
//	return this.theEnemiesOnThisSq;
//}	
//
//


//public String printAdjNums() {
//String output = this.getAdjLeft() + " " +this.getAdjRight() + "\n";
//return output;
//}


//output = this.printAdjNums();
//output = output + this.printArrayList_LRSquares();
//output = output + this.printArrayList_LMRSquares();
//output = output + this.printMinMaxBoolean();

//// the below is a counter for number of enemy ships on each square
////private int eSsCounter;
//private CreateEnemyShips ces = new CreateEnemyShips();


//public int getESsNum() {
//return this.eSsCounter;
//}
//
//public void setESsNum(int esNum) {		
//this.eSsCounter = eSsCounter + 1;
//}

//private boolean minSq = false;
//private boolean maxSq = false;

// --- ## CHECK this method ## --- determine if the minSq property is true 
//public boolean isMinSq (int num) {		
//	for(int loop = GRID_MIN_LIMIT; loop < GRID_MAX_LIMIT; loop++) {
//		if(num == GRID_MIN_LIMIT + 1) {
//			minSq = true;
//		}
//	}	
//	return minSq;
//}

// --- ## CHECK this method ## --- determine if the maxSq property is true
//public boolean isMaxSq (int num) {
//	for(int loop = GRID_MIN_LIMIT; loop < GRID_MAX_LIMIT; loop++) {
//		if(num == GRID_MAX_LIMIT - 1) {
//			maxSq = true;
//		}
//	}		
//	return maxSq;
//}

//public String printMinMaxBoolean() {
//	String output = "\nThe square " +this.sqNum+ " is a Min square: " +this.isMinSq(sqNum)+ "\n";
//	output = output +"it is a Max square: " +this.isMaxSq(sqNum);
//	return output;
//}

//private IntergalacticHole igh = new IntergalacticHole(); // probably not necessary
//
//
//