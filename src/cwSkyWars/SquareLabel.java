package cwSkyWars;

import javax.swing.JLabel;

public class SquareLabel extends JLabel {
	
	private Square square;
	
	public void setSquare(Square square) {
		this.square = square;
		setText(square == null ? null : square.toString());
	}
	
	public Square getSquare() {
		return square;
	}

}
