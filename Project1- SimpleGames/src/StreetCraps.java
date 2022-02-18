/**
 * Project 1: SimpleGames- StreetCraps Class
 * Allows the user to play StreetCraps, where they guess a number and 
 * roll dice until their guess or a 7 is rolled
 * @author Jace Rettig
 * @version 1-11-22
 */
import java.util.Scanner;

public class StreetCraps {
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
	 * Constructor- StreetCraps()
	 * creates and initializes the 2 die objects and a scanner
	 */
	public StreetCraps() {
		this.die1 = new Die();
		this.die2 = new Die();
		this.scan = new Scanner(System.in);
	}
	/**
	 * Method- play()
	 * Allows the user to play StreetCraps; prompts user to guess a number 
	 * between 2-12 but not 7, then rolls 2 dice until the sum is the user's 
	 * guess or 7
	 */
	public void play() {
		int userGuess = -1;
		int roll1 = -1;
		int roll2 = -1;
		int count = -1;
		boolean quit = false;
		//get user guess between 2-12
		while ((userGuess < 2) || (userGuess > 13) || (userGuess == 7)) {
			//Ask the user to pick a number
			System.out.println("Please pick a number between 2 and 12, but not 7");
			userGuess = this.scan.nextInt();
		}
		//counter for # of rolls
		count = 1;
		//roll until user rolls a 7 and loses or wins
		while (!quit) {
			//print roll result
			System.out.print("Roll " + count + ": ");
			roll1 = this.die1.roll();
			roll2 = this.die2.roll();
			System.out.println("\nTotal: " + (roll1 + roll2) + "\n------------");
			
			//check if roll is userGuess
			if (roll1 + roll2 == userGuess) {
				System.out.println("Rolled a " + userGuess + ", you win!");
				quit = true;
			}
			else if (roll1 + roll2 == 7) {
				//7 rolled, user loses
				System.out.println("Rolled a 7, you lose!");
				quit = true;
			}
			//increase roll counter by 1
			count += 1;
		}
		
		
		
	}

	public static void main(String[] args) {
		//create new count doubles object
		StreetCraps s = new StreetCraps();
		//call interact method
		s.play();
	}
}

 