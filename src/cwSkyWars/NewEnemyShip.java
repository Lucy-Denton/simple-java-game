package cwSkyWars;

import javax.swing.JOptionPane;

public class NewEnemyShip extends EnemyShip {
	
	public NewEnemyShip() {
		setName(this.name);
		setType("New Enemy Ship");
	}
	
	public void newEnemyShipCreated() {
		String userInputName = JOptionPane.showInputDialog("New type of enemy ship created. What would you like to call it?");
		this.name = userInputName;
	}

}
