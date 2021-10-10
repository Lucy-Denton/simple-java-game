package cwSkyWars;

import java.util.ArrayList;
import java.util.Random;

public class MoveButton {
	private int newESRow;
	private int newESSq;
	private int newMSRow;
	private int newMSSq;
	private final int GRID_MIN_LIMIT = 0;
	private final int GRID_MAX_LIMIT = 5;
	private ArrayList<EnemyShip> createdEnemies = new ArrayList<EnemyShip>();
	
	public MoveButton () {}

	// Getters and setters to import the createdEnemies ArrayList in the CreateEnemyShips Class
	public ArrayList<EnemyShip> getCreatedEnemies() {
		return this.createdEnemies;
	}	
	public void setCreatedEnemies(CreateEnemyShips ces) {
		this.createdEnemies = ces.getCreatedEnemies();
	}
		
	// Method to move Master Ship row
	public int returnMasterShipRow(MasterShip masterShip) {
		Random randomNumGen = new Random();
		int ranNum;
		Row row = new Row(masterShip.getMsRow());
		ranNum = randomNumGen.nextInt((row.upperBoundNewRow() + 1) - row.lowerBoundNewRow()) + row.lowerBoundNewRow();
		masterShip.setMsRow(ranNum);
		this.newMSRow = masterShip.getMsRow();
		return this.newMSRow;		
	}
	// Method to move Master Ship square
	public int returnMasterShipSq(MasterShip masterShip) {
		RNGs rng = new RNGs();
		Random randomNumGen = new Random();
		int ranNum;
		int msSq = masterShip.getMsSq();
		Square square = new Square (msSq);
		if(masterShip.getMsRow() == this.newMSRow) { // if the masterShip row has not changed
			int ranLorR = rng.randomLeftOrRight(); // returns -1 or 1
			for(int loop = (msSq - 1); loop <= (msSq + 1); loop++) {
				if((msSq - 1) == GRID_MIN_LIMIT) {
					masterShip.setMsSq(msSq + 1); 
					newMSSq = masterShip.getMsSq();
				}
				if((msSq + 1) == GRID_MAX_LIMIT) {
					masterShip.setMsSq(msSq - 1);
					newMSSq = masterShip.getMsSq();
				}
				if(((msSq - 1) != GRID_MIN_LIMIT) && ((msSq + 1) != GRID_MAX_LIMIT)){
					masterShip.setMsSq(msSq + ranLorR);
					newMSSq = masterShip.getMsSq();
				}				
			}
		}
		else {
			ranNum = randomNumGen.nextInt((square.upperBoundNewSq() + 1) - square.lowerBoundNewSq()) + square.lowerBoundNewSq();
			masterShip.setMsSq(ranNum);
			this.newMSSq = masterShip.getMsSq();
		}		
		return this.newMSSq;
	}

	// Method to move an Enemy Ship row
	// (!!!###???) try to use techniques for ArrayLists of adjacent squares to move ships (!!!###???)
	public int returnEnemyShipsRow() {
		Random randomNumGen = new Random();
		int ranNum;
		for(EnemyShip tempEnemyShip : this.createdEnemies) {
			if(tempEnemyShip.isHasMoved() == false) {
				int esRow = tempEnemyShip.getEsRow();
				Row row = new Row(esRow);
				ranNum = randomNumGen.nextInt((row.upperBoundNewRow() + 1) - row.lowerBoundNewRow()) + row.lowerBoundNewRow();
				tempEnemyShip.setEsRow(ranNum);
				newESRow = /*ranNum*/tempEnemyShip.getEsRow();
			}
		}		
		return this.newESRow;
		}		
			
	public int getNewESRow() {
		return this.newESRow;
	}
	// Method to move an Enemy Ship square
	public int returnEnemyShipsSq() {
		RNGs rng = new RNGs();
		Random randomNumGen = new Random();
		int ranNum;
		for(EnemyShip tempEnemyShip : this.createdEnemies) {
			int esSq = tempEnemyShip.getEsSq();
			Square square = new Square (esSq);
			if(tempEnemyShip.getEsRow() == this.newESRow) { // if the enemyShip row has not changed
				int ranLorR = rng.randomLeftOrRight(); // returns -1 or 1
				for(int loop = (esSq - 1); loop <= (esSq + 1); loop++){
					if((esSq - 1) == GRID_MIN_LIMIT) {
						tempEnemyShip.setEsSq(0);
						tempEnemyShip.setEsSq(esSq + 1);
						tempEnemyShip.setHasMoved(true);
						newESSq = tempEnemyShip.getEsSq();
					}
					if((esSq + 1) == GRID_MAX_LIMIT) {
						tempEnemyShip.setEsSq(0);
						tempEnemyShip.setEsSq(esSq - 1);
						tempEnemyShip.setHasMoved(true);
						newESSq = tempEnemyShip.getEsSq();
					}
					if(((esSq - 1) != GRID_MIN_LIMIT) && ((esSq + 1) != GRID_MAX_LIMIT)){
						tempEnemyShip.setEsSq(0);
						tempEnemyShip.setEsSq(esSq + ranLorR);
						tempEnemyShip.setHasMoved(true);
						newESSq = tempEnemyShip.getEsSq();
					}
				}				
			} 
			else {
				ranNum = randomNumGen.nextInt((square.upperBoundNewSq() + 1) - square.lowerBoundNewSq()) + square.lowerBoundNewSq();
				tempEnemyShip.setEsSq(0);
				tempEnemyShip.setEsSq(ranNum);
				tempEnemyShip.setHasMoved(true);
				this.newESSq = tempEnemyShip.getEsSq();
			}
		}
		return this.newESSq;
	}
	
	public void printOutput() {
		for(EnemyShip tempEnemyShip : this.createdEnemies) {
			String output = "\n";
			output = "\nThe Enemy Ship with id: " + tempEnemyShip.getEnemyShipId();
			output = output + "\nwill have newRow: " + tempEnemyShip.getEsRow();		
			output = output + "\nand newSq: " + tempEnemyShip.getEsSq() + "\n";
			System.out.println(output);
		}		
	}
	
	public void printOutput(MasterShip ms) {
		String output = "The Master Ship row number is: " + ms.getMsRow() + " and the square number is: " + ms.getMsSq();
		output = output + "\nIts newRow is " + this.newMSRow;
		output = output + "\nand its newSq is " + this.newMSSq + "\n";
		System.out.println(output);
	}
		
} // end class


//MasterShip masterShip = new MasterShip();
//private int ESRow;
//private int ESSq;

//public int getESRow() {
//	return this.ESRow;
//}
//
//public void setESRow(CreateEnemyShips ces) {
//	this.ESRow = ces.testESRow();
//}
//
//public int getESSq() {
//	return this.ESSq;
//}
//
//public void setESSq(int eSSq) {
//	this.ESSq = eSSq;
//}

//public void moveEnemyShipsRow() {
//for(EnemyShip tempEnemyShip : this.createdEnemies) {
//	tempEnemyShip.setEsRow(newESRow);
//}
//}

//public void setNewESRow(int newESRow) {
//	this.newESRow = newESRow;
//}

//public void moveMSRow(MasterShip ms) {
//ms.setMsRow(this.newRow);
//}
//
//public void moveMSSq(MasterShip ms) {
//ms.setMsSq(this.newSq);
//}


//private int msRow;
//private int msSq;
//private Ship ship;
//private EnemyShip es;

//// Moving ESs same way as moving MS
//public int decideEdgeRowNew(RNGs rng, CreateEnemyShips ces) {
//	for(EnemyShip tempEnemyShip : ces.getCreatedEnemies()) {
//		int esRow = tempEnemyShip.getEsRow();
//		if(esRow == GRID_MIN_LIMIT + 1) {
//			newRow = esRow + rng.random1in2();			
//		}		
//		if(esRow == GRID_MAX_LIMIT - 1) {
//			newRow = esRow - rng.random1in2();
//		}
//	}
//	return this.newRow;
//}
//	
//public void moveESRow(EnemyShip enemyShip) {
//	enemyShip.setEsRow(newRow);
//}
//
//public void moveESSq(EnemyShip enemyShip) {
//	enemyShip.setEsSq(newSq);
//}
//
//// Below are methods to move the Master Ship -- written in early development phase
//public int setEdgeRowNew(MasterShip ms, RNGs rng) {	
//	int msRow = ms.getMsRow();
//	if(msRow == GRID_MIN_LIMIT + 1) {
//		newRow = msRow + rng.random1in2();			
//	}		
//	if(msRow == GRID_MAX_LIMIT - 1) {
//		newRow = msRow - rng.random1in2();
//	}
//	return this.newRow;
//}
//
//public int setMiddleRowNew(MasterShip ms, RNGs rng)	{
//	int msRow = ms.getMsRow();
//	if(ms.isEdgeRow(msRow) == false) {
//		newRow = msRow + rng.random1in3(); 			
//	} 		
//	return this.newRow;
//}
//
//public int setNewSq(MasterShip ms, RNGs rng) {
//	int msRow = ms.getMsRow();
//	int msSq = ms.getMsSq();
//	// ---- dealing with corner squares ----
//	// left corner square that didn't move row, must move right
//	if((msRow == newRow) && (ms.isEdgeRow(msRow) == true && ms.isEdgeSq(msSq) == true && msSq == GRID_MIN_LIMIT + 1)) {
//		newSq = msSq + 1;
//	}
//	// right corner square that didn't move row, must move left
//	if((msRow == newRow) && (ms.isEdgeRow(msRow) == true && ms.isEdgeSq(msSq) == true && msSq == GRID_MAX_LIMIT - 1)) {
//		newSq = msSq - 1;
//	}
//	// middle squares that didn't move row, must move left or right
//	if((msRow == newRow) && (ms.isEdgeRow(msRow) == false && ms.isEdgeSq(msSq) == false)) {
//		newSq = msSq + rng.randomLeftOrRight();
//	}
//	// middle squares that didn't move row, must move left or right
//	if((msSq != GRID_MIN_LIMIT + 1 || msSq != GRID_MAX_LIMIT - 1) && msRow == newRow) {
//		newSq = msSq + rng.randomLeftOrRight();
//	}
//	// controlling for edge squares that didn't move row
//	if(msSq == GRID_MIN_LIMIT + 1 && msRow == newRow) {
//		newSq = msSq + 1;
//	}
//	if(msSq == GRID_MAX_LIMIT - 1 && msRow == newRow) {
//		newSq = msSq - 1;
//	}
//	// middle squares that did move row, can move left/stay/right
//	if((ms.isEdgeRow(msRow) == false && ms.isEdgeSq(msSq) == false) && (msRow != newRow)) {
//		newSq = msSq + rng.random1in3();
//	} 
//	else {
//		newSq = msSq;
//	}
//	return this.newSq;
//}
//
//
//
//public int getNewRow() {
//	return this.newRow;
//}

//public int decideMiddleRowNew(CruiseShip cruise, StarShip star, NewEnemyShip newEs, RNGs rng)	{
//int esRow = this.es.getEsRow();
//if(es.isEdgeRow(esRow) == false) {
//	newRow = esRow + rng.random1in3(); 			
//} 		
//return this.newRow;
//}	
//
//public int decideNewSq(CruiseShip cruise, StarShip star, NewEnemyShip newEs,RNGs rng) {
//int esRow = this.es.getEsRow();
//int esSq = this.es.getEsSq();
//// left corner square that didn't move row, must move right
//if((esRow == newRow) && (es.isEdgeRow(esRow) == true && es.isEdgeSq(esSq) == true && esSq == GRID_MIN_LIMIT + 1)) {
//	newSq = esSq + 1;			
//}
//// right corner square that didn't move row, must move left
//if((esRow == newRow) && (es.isEdgeRow(esRow) == true && es.isEdgeSq(esSq) == true && esSq == GRID_MAX_LIMIT - 1)) {
//	newSq = esSq -1;
//}
//// middle squares that didn't move row, must move left or right
//if((esRow == newRow) && (es.isEdgeRow(esRow) == false && es.isEdgeSq(esSq) == false)) {
//	newSq = esSq + rng.randomLeftOrRight();
//}
//// controlling for edge squares that didn't move row
//if(esSq == GRID_MIN_LIMIT + 1 && esRow == newRow) {
//	newSq = esSq + 1;
//}
//if(esSq == GRID_MAX_LIMIT - 1 && esRow == newRow) {
//	newSq = esSq - 1;
//}
//// middle squares that did move row, can move left/stay/right
//if((es.isEdgeRow(esRow) == false && es.isEdgeSq(esSq) == false) && (esRow != newRow)) {
//	newSq = esSq + rng.random1in3();
//}
//else {
//	newSq = esSq;
//}
//return this.newSq;
//}


//ranNum = randomNumGen.nextInt(row.possibleNewRow().get(row.possibleNewRow().size())- (row.getRowNum()-1));	

//for(int loop = row.getRowNum() - 1; loop < row.getRowNum() + 1; loop++) {
//	if(row.getRowNum() - 1 == GRID_MIN_LIMIT) {
//		break;
//	}
//	if(row.getRowNum() + 1 == GRID_MAX_LIMIT) {
//		break;
//	}
//	if(ranNum == row.possibleNewRow().size()) {
//		tempEnemyShip.setEsRow(loop);
//	}
//}
//for(int loop = esRow - 1; loop <= esRow +1; loop++) {
//	
//}


//ranNum = randomNumGen.nextInt(row.possibleNewRow().get(row.possibleNewRow().size())- (row.getRowNum()-1));	

//for(int loop = row.getRowNum() - 1; loop < row.getRowNum() + 1; loop++) {
//	if(row.getRowNum() - 1 == GRID_MIN_LIMIT) {
//		break;
//	}
//	if(row.getRowNum() + 1 == GRID_MAX_LIMIT) {
//		break;
//	}
//	if(ranNum == row.possibleNewRow().size()) {
//		tempEnemyShip.setEsRow(loop);
//	}
//}
//for(int loop = esRow - 1; loop <= esRow +1; loop++) {
//	
//}