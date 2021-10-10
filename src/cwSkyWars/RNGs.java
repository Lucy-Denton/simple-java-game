package cwSkyWars;

import java.util.Random;

public class RNGs {
	private Random rn = new Random();
	private final int UPPER_BOUND = 2; // exclusive
	private final int LOWER_BOUND_1in3 = -1;
	private final int LOWER_BOUND_1in2 = 0;
	private final int GRID_MAX_LIMIT = 5;
//	private final int LENGTH_OF_SIDES = 4;
	private int oneInFour;
	private int oneInThree;
	private int oneInTwo;
	private int leftOrRight;
		
	public RNGs () {}
	
	public int random1in4(){	
		oneInFour = rn.nextInt(GRID_MAX_LIMIT - 1) + 1;
		return this.oneInFour;		
	}
	
	public int random1in3(){		
		oneInThree = rn.nextInt(UPPER_BOUND - LOWER_BOUND_1in3) + LOWER_BOUND_1in3;
		return this.oneInThree;		
	}	

	public int random1in2(){	
		this.oneInTwo = rn.nextInt(UPPER_BOUND - LOWER_BOUND_1in2) + LOWER_BOUND_1in2;
		return this.oneInTwo;		
	}
	
	public int randomLeftOrRight(){	
		int oneInTwo = rn.nextInt(UPPER_BOUND - LOWER_BOUND_1in2) + LOWER_BOUND_1in2;
		if( oneInTwo == 1) {
			leftOrRight = 1;
		} if( oneInTwo == 0) {
			leftOrRight = -1;
		}
		return this.leftOrRight;		
	}
	
	public void printOutput() {
		String output = "method random1in3 has generated " + this.oneInThree;
		output = output + "\nand the random1in2 method has generated " + this.oneInTwo;
		System.out.println(output);
	}

}
