
public class Main {
	
	//main
	public static void main(String args[]) {
		// create the tank
		char[][] tank = new char [8][32];
		fillTank(tank, "~".charAt(0));
		// generate fish positions
		int[][] fishPositions = new int[4][2];
		fishPositions = generateRandomPositions(4, tank[0].length, tank.length);
		// repeat forever:
		while (true){
		    // update the simulation by:
		    // moving all fish one position to the right
		    moveAllFish(fishPositions, tank[0].length, tank.length);
		    // render (draw) the simulation by:
		    // clear the tank by filling it with water (~)
		    fillTank(tank, "~".charAt(0));
		    // place each fish into the tank
		    for (int i=0; i<fishPositions.length;i++){
		    	placeFishInTank(tank, fishPositions[i][0], fishPositions[i][1]);
		    }
		    // draw the contents of this tank to the screen
		 	renderTank(tank);
		    // pause briefly to slow down the simulation a bit
		    Utility.pause(200);
		    System.out.println("\n\n\n");
		}
	}
	
	/**
	 * Copies the water character into every position in the tank array. The two-dimensional tank
	 * array can have dimensions of any size(s).
	 * 
	 * @param tank will contain all water characters after this method is called.
	 * @param water is the character copied into the tank.
	 */
	public static void fillTank(char[][] tank, char water)
	{
		for(int i=0;i<tank.length;i++) {
			for (int j=0;j<tank[0].length;j++) {
				tank[i][j] = water;
			}
		}
	}
	 
	/**
	 * Prints the contents of the tank into the console in row major order, so that the 
	 * smallest row indexes are on top and the smallest column indexes are on the left. For 
	 * example:
	 * tank[0][0] tank[0][1] tank[0][2] ...
	 * tank[1][0] tank[1][1] tank[1][2] ...
	 * ...
	 * Each row is on its own line, and this method should work for two-dimensional tanks with 
	 * dimensions of any size.
	 * 
	 * @param tank contains the characters that will be printed to the console.
	 */
	public static void renderTank(char[][] tank)
	{
		for(int i=0;i<tank.length;i++) {
			for (int j=0;j<tank[0].length;j++) {
				System.out.print(tank[i][j]);
			}
			System.out.print("\n");
		}	 
	}
	/**
	 * 
	 * @param number: the number of random positions to generate
	 * @param width: the range of the width(column) (should be smaller than 32)
	 * @param height: the range of the height(row) (should be smaller than 8)
	 * @return the random position in an array{{row, col} ...}
	 */
	public static int[][] generateRandomPositions(int number, int width, int height)
	{
		/* No longer needed
		// Check the boundary of input
		if (width>32 || width<0)
			System.out.println("Width out of boundary");
		if (height>8 || height<0)
			System.out.println("Height out of boundary");
		
		width = Math.min(width, 32);
		width = Math.max(width, 0);
		height = Math.min(height, 8);
		height = Math.max(height, 0);
		*/
		int [][] randomPositions = new int[number][2];
		for (int i=0;i<number;i++) {
			randomPositions[i][1] = Utility.randomInt(width+1);
			randomPositions[i][0] = Utility.randomInt(height+1);
		}
		return randomPositions;
	}
	
	public static void placeFishInTank(char[][] tank, int row, int col) {
		if (row<0 || row>=tank.length) {
			while(row<0) {
				row = row + tank.length;
			}
			row = row%tank.length;			
		}

		String fish = "><((‘>";
		for (int i=col-5; i<=col;i++) {
			int temp = i;
			if (temp<0 || temp>=tank[0].length) {
				while(temp<0) {
					temp = temp + tank[0].length;
				}
				temp = temp%tank[0].length;
			}
//			System.out.println("row is "+ row);
//			System.out.println("temp is "+ temp);
//			System.out.println("i is "+ i);
//			System.out.println("i - (col-5) is " + (i-(col-5)));
			tank[row][temp] = fish.charAt(i-(col-5));
		}
	}

	public static void moveAllFish(int[][] fishPositions, int width, int height){
		for (int i=0; i<fishPositions.length;i++){
			fishPositions[i][1] = ((fishPositions[i][1] + 1)>=width)?
									((fishPositions[i][1]+1)%width):
									(fishPositions[i][1]+1);
		}
	}

}
