/**
 * Project 1: SimpleGames- CountDoubles Class
 * Counts the number of doubles a player has rolled
 * @author Jace Rettig
 * @version 1-11-22
 */
import java.util.Scanner;

public class CountDoubles {
	/**
	 * die1- die object 1
	 */
	private Die die1;
	/**
	 * die2- die object 2
	 */
	private Die die2;
	/**
	 * scan- gets user input
	 */
	private Scanner scan;
	
	/**
	 * Constructor- CountDoubles()
	 * creates and initializes the 2 die objects and the scanner
	 */
	public CountDoubles() {
		this.die1 = new Die();
		this.die2 = new Die();
		this.scan = new Scanner(System.in);
	}
	
	
	/**
	 * Method- play
	 * Allows the user to play the game count doubles and guess how many doubles; 
	 * rolls die user specified number of times then tells user the results of the game
	 * @param int numOfRolls- how many times the user wants to roll the dice
	 */
	public void play(int numOfRolls) {
		int guessDoubles;
		int doublesRolled;
		int roll1;
		int roll2;
		int[] numList = {0,0,0,0,0,0,0,0,0,0,0};
		int numSum;
		
		//tell user how many times dice will be rolled
		System.out.println("Dice will be rolled " + numOfRolls + " times");
		//ask user to guess how many doubles there will be 
		System.out.println("How many doubles do you think there will be?");
		guessDoubles = this.scan.nextInt();
		//loop for numOfRolls times and print values + count num of doubles
		doublesRolled = 0;
		roll1 = -1;
		roll2 = -1;
		for (int i= 0; i < numOfRolls; i++) {
			//roll die1 and die2
			//print roll result
			System.out.print("Roll " + (i + 1) + ": ");
			roll1 = this.die1.roll();
			roll2 = this.die2.roll();
			System.out.println();
			//CHALLENGE CODE
			//calc sum of numbers
			numSum = roll1 + roll2;
			//loop through values 0-10
			for (int v = 0; v < numList.length; v++) {
				//if sum of numbers is equal to number in array, increase that number
				if (numSum == (v + 2)) {
					numList[v] += 1;
				}
			}
			//if doubles increment counter
			if (roll1 == roll2) {
				doublesRolled += 1;
			}
		}
		//print number of times each value rolled 
		for (int v = 0; v < numList.length; v++) {
			System.out.println("Number of " + (v + 2) + "'s: " + numList[v]);	
		}
		//print # of doubles
		System.out.println("Number of Doubles Rolled: " + doublesRolled + "\nYou guessed: "
				+ guessDoubles);
		//if user guessed correctly tell them
		if (doublesRolled == guessDoubles) {
			System.out.println("Congratulations! You guessed correctly :)");
		}
		
		
		//CHALLENGE: Track/Print how many times each number (2-12) was rolled//
			//array of numbers
			//separate loop that prints values throughout array
			//int[] numList = {0,0,0,0,0,0,0,0,0,0,0};
			//int numSum = roll1 + roll2;
			//int v = 0;
			//inside nested for loop from i = 0-10
			//if (numSum == (v + 2)) {
				//numList[v] += 1;
			//}
	}
		
	
	/**
	 * Method- interact
	 * Informs the user that they are playing the count doubles game, and asks for
	 * the number of rolls they want to make
	 */
	public void interact() {
		int numOfRolls;
		//Print informative game message
		System.out.println("Welcome to Count Doubles, how many rolls would you like " +
				"to make?");
		//get user input
		numOfRolls = this.scan.nextInt();
		//call play method
		this.play(numOfRolls);
	}
	public static void main(String[] args) {
		//create new count doubles object
		CountDoubles c = new CountDoubles();
		//call interact method
		c.interact();
	}
}
