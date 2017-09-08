
public class Main {
	
	//main
	public static void main(String args[]) {
		char[][] tank = new char [8][32];
		fillTank(tank, "~".charAt(0));
		renderTank(tank);
		int[][] positions = generateRandomPositions(3,2,5);
		for (int i=0;i<positions.length;i++) {
			System.out.println("{" + positions[i][0] + " , " + positions[i][1] + "}");
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
				System.out.print(tank[i][j] + " ");
			}
			System.out.print("\n");
		}	 
	}
	
	public static int[][] generateRandomPositions(int number, int width, int height)
	{
		width = Math.min(width, 32);
		height = Math.max(height, 8);
		
		int [][] randomPositions = new int[number][2];
		for (int i=0;i<number;i++) {
			randomPositions[i][1] = Utility.randomInt(width+1);
			randomPositions[i][0] = Utility.randomInt(height+1);
		}
		return randomPositions;
	}
}
