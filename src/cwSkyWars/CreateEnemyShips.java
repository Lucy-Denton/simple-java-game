package cwSkyWars;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CreateEnemyShips {
	private RNGs rng = new RNGs();
	private int esRow;
	private int esSq;
	int enemyShipId = 1;	
	int esIdToRemove = 0;
//	private int stars = 0;
//	private int cruises = 0;
//	private int newType = 0;
	
	private boolean enemyShipCreated = false;
	ArrayList<EnemyShip> createdEnemies = new ArrayList<EnemyShip>();
	
	public CreateEnemyShips() {}
		
	public void manuallyCreateEnemyShips(int row, int sq) {
		StarShip star = new StarShip(row, sq);
		this.createdEnemies.add(star);
	}
	public boolean isEnemyShipCreated() {
		return this.enemyShipCreated;
	}

	public int getEnemyShipId(int row, int sq) {
		for(EnemyShip tempEnemyShip : this.createdEnemies) {
			if(tempEnemyShip.getEsRow() == row && tempEnemyShip.getEsSq() == sq) {
				esIdToRemove = tempEnemyShip.getEnemyShipId();
			}
		}
		return this.esIdToRemove;
	}

	public int getEnemyShipId() {
		return this.enemyShipId;
	}
//	public void setEnemyShipId(int enemyShipId) {
//		this.enemyShipId = enemyShipId;
//	}

	public int getEsIdToRemove() {
		return this.esIdToRemove;
	}
	public ArrayList<EnemyShip> updateEnemyShipsList(/*int esId,*/){		
		for(EnemyShip tempEnemyShip : this.createdEnemies) {
			if(tempEnemyShip.getEnemyShipId() == this.esIdToRemove) {
				this.createdEnemies.remove(this.esIdToRemove);
			}
		}
		return this.createdEnemies;
	}
	
	
	public ArrayList<EnemyShip> createEnemyShips() {
//		int enemyShipId = 1; // this needs to be accessed from all methods in class
		int oneInThree = rng.random1in3();
		if (oneInThree == 0) {
			EnemyShip enemyShip;
			this.enemyShipCreated = true;
			int innerOneInThree = rng.random1in3(); // randomly decide the Enemy Ship name	
			switch (innerOneInThree) {
			case -1:
				StarShip star = new StarShip();
				enemyShip = star;
				star.setName("Star Ship");
				star.setEnemyShipId(this.enemyShipId++);
				star.setEsRow(1);
				star.setEsSq(1);
				createdEnemies.add(star);
				break;
			case 0: 
				CruiseShip cruise = new CruiseShip();
				enemyShip = cruise;
				cruise.setEnemyShipId(this.enemyShipId++);
				cruise.setEsRow(1);
				cruise.setEsSq(1);
				createdEnemies.add(cruise);
				break;
			case 1:
				NewEnemyShip newEs = new NewEnemyShip();
				enemyShip = newEs;
				newEs.newEnemyShipCreated();
				newEs.setEnemyShipId(this.enemyShipId++);
				newEs.setEsRow(1);
				newEs.setEsSq(1);
				this.createdEnemies.add(newEs);
			}					
		}					
		if(this.enemyShipCreated == true) {
			this.displayEsCreationOutput();
			this.enemyShipCreated = false;
		}
		return this.createdEnemies;
	}
	
	public ArrayList<EnemyShip> getCreatedEnemies() {
		return this.createdEnemies;
	}

	public void setCreatedEnemies(ArrayList<EnemyShip> createdEnemies) {
		this.createdEnemies = createdEnemies;
	}
	
	public int getEnemyShipRowById(int esId) {
		int esRow = 0;
		for(EnemyShip tempEnemyShip : this.createdEnemies) {
			if(tempEnemyShip.getEnemyShipId() == esId) {
				esRow = tempEnemyShip.getEsRow();
			}
		}
		return esRow;
	}
	
	public int getEnemyShipSqById(int esId) {
		int esSq = 0;
		for(EnemyShip tempEnemyShip : this.createdEnemies) {
			if(tempEnemyShip.getEnemyShipId() == esId) {
				esSq = tempEnemyShip.getEsSq();
			}
		}
		return esSq;
	}
	
	public int getEsRow() {
//		int esRow = 0;
		for(EnemyShip tempEnemyShip : this.createdEnemies) {
			esRow = tempEnemyShip.getEsRow();
		}
		return this.esRow;
	}

	public int getEsSq() {
//		int esSq = 0;
		for(EnemyShip tempEnemyShip : this.createdEnemies) {
			esSq = tempEnemyShip.getEsRow();
		}
		return this.esSq;
	}

	public String testEsRowSqToString() {
		String output = "";
		for(EnemyShip tempEnemyShip : this.createdEnemies) {
			output = "\nEnemy ship id: " + tempEnemyShip.getEnemyShipId() + " is a... " + tempEnemyShip.getName();
			output = output + "\nIt is on row: " + this.getEsRow() + ", square: " + this.getEsSq();
		}
		return output;
	}
	
	public String toString(){
		String createdEnemiesOutput = "";
		for(EnemyShip tempEnemyShip : this.createdEnemies) {
			createdEnemiesOutput = createdEnemiesOutput + tempEnemyShip.getName() + "\n";
		}
		return createdEnemiesOutput;
	}
	
	public void displayCreatedEnemiesArrayList() {
		String output = "\n" +this.toString();
		System.out.println(output);
		JOptionPane.showMessageDialog(null, output);
	}
	
	
	public void displayEsCreationOutput() {
		String output = this.testEsRowSqToString();
		System.out.println(output);
	}
	

} // end class



//String output= "1- 1/3 chance create an Enemy Ship\n2- Move Enemy Ships\n3- Exit\n";
//String userInputAsString;
//int userInput;
//int enemyShipId = 1;
//do {
//	userInputAsString= JOptionPane.showInputDialog(output +"Please enter your choice");
//	userInput= Integer.parseInt(userInputAsString);
//	if(userInput == 1) {
//		int oneInThree = rng.random1in3();
//		if (oneInThree == 0) {
//			EnemyShip enemyShip;
//			this.enemyShipCreated = true;
//			int innerOneInThree = rng.random1in3(); // randomly decide its name	
//			switch (innerOneInThree) {
//			case -1:
//				enemyShip = star;
//				this.star.setEnemyShipId(enemyShipId++);
//				this.star.setEsRow(1);
//				this.star.setEsSq(1);
//				this.createdEnemies.add(this.star);
//				break;
//			case 0: 
//				enemyShip = cruise;
//				this.cruise.setEnemyShipId(enemyShipId++);
//				this.cruise.setEsRow(1);
//				this.cruise.setEsSq(1);
//				this.createdEnemies.add(this.cruise);
//				break;
//			case 1:
//				enemyShip = newEs;
//				this.newEs.newEnemyShipCreated();
//				this.newEs.setEnemyShipId(enemyShipId++);
//				this.newEs.setEsRow(1);
//				this.newEs.setEsSq(1);
//				this.createdEnemies.add(this.newEs);
//			}					
//		}					
//		if(this.enemyShipCreated == true) {
//			this.displayEsCreationOutput();
//			this.enemyShipCreated = false;
//		}
//	}
////	if(userInput == 2) {
////		mvbtn.moveEnemyShipsRow();
////		mvbtn.moveEnemyShipsSq();
////		mvbtn.printOutput();
////		this.displayEsCreationOutput();
////	}
//}		
//while (userInput != 3);


//public int getEsId() {
//int enemyShipId = 0;
//for(EnemyShip enemyShip : this.createdEnemies) {
//	enemyShipId = enemyShip.getEnemyShipId();
//}
//return enemyShipId;
//}


//public void addEnemyShipTypes() {
//	enemyShipTypes.add(cruise);
//	enemyShipTypes.add(star);
//	enemyShipTypes.add(newEs);
//}

//public void testEnemyShipName() {	
//String output = "";
//output = "It's a " + this.name;
//System.out.println(output);
//}

// ---- Are the row and square numbers needed here? --- NO Because they are in the EnemyShip Class
//private int EsRow;
//private int EsSq;

//private boolean enemyShipCreated = false;