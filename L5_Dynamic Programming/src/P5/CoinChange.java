package P5;
import java.util.Arrays;

/**
 * This class contains a static method that is used to solve the classical
 * coin change problem using a dynamic programming  strategy. Thus the 
 * optimal solution is always achieved (with optimal meaning the smallest 
 * possible amount of coins used to reach the target amount).
 */
public class CoinChange {
	
	/**
	 * This variable represents infinity, which is used internally by the method
	 * coinChange to indicate that a specific problem or subproblem has no solution.
	 * For example, changing 7$ with coin values of 2$ and 4$ is impossible, so the 
	 * algorithm points this out with the infinity variable.
	 */
	static int infinity = 999999;
	
	/**
	 * this number is used to print out the matrix of solutions to all the 
	 * subproblems of a given coinChange problem. Specifically, it indicates the given
	 * space for each cell in the matrix, and will depend on the value that is chosen
	 * to represent infinity.
	 */
	static int width = String.valueOf(infinity).length() + 3;

	/**
	 * Given a specific integer target, and a set of coin values (which can be 
	 * used repeatedly), this method calculates the optimal (smallest amount) 
	 * combination of coins whose added value equal the target (If the combination
	 * exists). The solution provided shows both the total number of coins and the
	 * amount of each different coin used. 
	 * 
	 * @param v Set of coin values. This set must be sorted in increasing order.
	 * @param A Target to reach with the coin values.  
	 * @return An integer array where the first position contains the total amount
	 * of coins used, and the subsequent positions contain the different amounts of 
	 * each coin used. For example, given a set of coins {1,4,6} and  target 8, 
	 * the solution array would be [2,0,2,0], indicating that 2 coins where used in
	 * total, made up of 0 coins of 1, 2 coins of 4, and 0 coins of 6. If the target
	 * is unreachable with the given coins, the first position of this array will 
	 * contain the infinity value (or higher) provided by the infinity static 
	 * variable.
	 */
	public static int[] coinChange(int[] v, int A)
	{
		if(v.length == 0) return new int[] {infinity}; //no coins provided
		
		int[][] C = new int[v.length][A+1]; //matrix of subproblem answers
		for(int i = 0; i < v.length; i++) C[i][0] = 0; //0 coins to change amount 0
		for(int i = 0; i < v.length; i++)
		{
			for(int j = 1; j < A+1; j++)
			{
				if(i == 0) C[0][j] = (v[i] > j) ? infinity : 1 + C[0][j-v[0]]; //first row edge case
				else
				{
					if (v[i] > j) C[i][j] = C[i-1][j];
					else C[i][j] = Math.min(C[i-1][j], 1 + C[i][j-v[i]]);
				}
			}
		}
		int[] coinAmounts = new int[v.length+1];
		coinAmounts[0] = C[v.length-1][A];
		if (C[v.length-1][A] < infinity) //if there is a solution
			backTrack(C, v, A, coinAmounts);
		printMatrix(C, v, A); //used to print matrix of subproblem answers
		return coinAmounts;
	}
	
	/**
	 * Internal method called from the main coinChange method to check what the 
	 * actual combination of coins is. The main algorithm only determines the 
	 * total amount of coins, but not how this total amount is formed. The 
	 * backtrack method goes backwards, checking for each step if a new coin 
	 * was added or a previous solution was used instead. The parameters that it
	 * uses are the same ones as for the main method coinChange, except the 
	 * answer set coinAmounts[].
	 *
	 * @param coinAmounts Answer array that is upgraded in each step, incrementing
	 * the amount of each coin used. 
	 */
	private static void backTrack(int C[][], int[] v, int A, int[] coinAmounts)
	{
		//j and i are used as coordinates to navigate the matrix of subproblem answers.
		int j = A;
		int i = v.length-1;
		while (j > 0) //while there is still money to change
		{
			System.out.println("j = " + j + "; v[i] = " + v[i]);
			if(v[i] <= j && C[i][j] == C[i][j-v[i]]+1) {
				coinAmounts[i+1]++;
				j = j - v[i];
			}
			else i--;
		}
	}
	
	
	/**
	 * Prints out the matrix of subproblem answers. It is mainly used to analyze
	 * the solution to a given problem, or to debug the implementation.
	 * 
	 * @param C matrix of subproblem answers.
	 * @param v Set of coins. 
	 * @param A Target to reach with the coins.
	 */
	public static void printMatrix(int[][] C, int[] v, int A)
	{
		//Problem information
		System.out.printf("%-7s%2s%s\n", "Coins","= ", Arrays.toString(v));
		System.out.printf("%-7s%2s%s\n", "Target", "= ", A);
		
		//Print header of matrix
		System.out.printf("%7s", "");
		for(int i = 0; i < A+1; i++) System.out.printf("%-"+ width + "s", i);
		System.out.printf("\n%7s", "");
		for(int i = 0; i < A+1; i++) {
			for(int a = 0; a < width; a++) System.out.print("-");
		}
		
		//fill out the matrix
		for(int i = 0; i < v.length; i++)
		{
			System.out.printf("\n%-5s%2s", v[i], "|"); //coin value
			for(int j = 0; j < A+1; j++) {
				System.out.printf("%-"+ width + "s", C[i][j]);
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		int v[] = {5,10,25,50,100};
		int A = 96;
		int[] sol = coinChange(v, A);
		System.out.println(Arrays.toString(sol));
	}
	
}
