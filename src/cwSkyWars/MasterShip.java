package cwSkyWars;

public class MasterShip {
	
	private int msRow;	
	private int msSq;
	// Might not need property, alive
	private boolean alive = false;
	
	public MasterShip() {
		this.initalMsRow(msRow);
		this.initialMsSq(msSq);
		this.alive = true;
	}
	
	public MasterShip(int row, int sq) {
		this.setMsRow(row);
		this.setMsSq(sq);
		this.alive = true;
	}

	// Might not need this
	public boolean isAlive() {
		return this.alive;
	}
	public void setAlive(boolean gameOver) {
		this.alive = gameOver;
	}

	public void initalMsRow (int row) {
		RNGs rng = new RNGs();
		this.msRow = rng.random1in4();
	}
	
	public void initialMsSq(int sq) {
		RNGs rng = new RNGs();
		this.msSq = rng.random1in4();
	}
	
	public void setMsSq(int sq) {
		this.msSq = sq;
	}
	
	public int getMsSq() {
		return this.msSq;
	}
	
	public void setMsRow(int row) {
		this.msRow = row;
	}

	public int getMsRow() {
		return this.msRow;
	}
		
	public String toString() {
		String output = "\nThe Master Ship is on row " + this.msRow + ", square " + this.msSq;
		return output;
	}
	
	public void displayOutput() {
		String output = this.toString();
		System.out.println(output);
	}

} // end class

//public void testGetMsRowMethod() {
//String output = "" + this.msRow;
//System.out.println(output);
//}
//
//public void testGetSqNumMethod() {
//String output = "" + this.msSq;
//System.out.println(output);
//}
 

//private boolean edgeRow = false;
//private boolean edgeSq = false;
//private final int GRID_MAX_LIMIT = 5;
//private final int GRID_MIN_LIMIT = 0;
//RNGs rng = new RNGs();


//public boolean isEdgeRow (int row) {
//	row = this.getMsRow();
//	if(row == 1 || row == 4) {
//		edgeRow = true;
//	}
//	return edgeRow;
//}
//
//public boolean isEdgeSq (int sq) {
//	sq = this.getMsSq();
//	if(sq == 1 || sq == 4) {
//		edgeSq = true;
//	}
//	return edgeSq;
//}

//public int randomSetMasterShip(){	
//	Random rn = new Random();
////	RNGs rng = new RNGs();
//	int randomMSNumber = rn.nextInt((GRID_MAX_LIMIT - 1) - GRID_MIN_LIMIT) + (GRID_MIN_LIMIT + 1);
//	return randomMSNumber;		
//}
