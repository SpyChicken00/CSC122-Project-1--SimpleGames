/**
 * Project 1: SimpleGames- SlotMachine Class 
 * Simulates a super mario bros slot machine
 * and calculates how many coins earned based on slot results
 * @author Jace Rettig
 * @version 1-11-22
 */
import java.util.Scanner;
import java.util.Random;

public class SlotMachine {
	/**
	 * coins- tracks number of coins user has
	 */
	private int coins;
	/**
	 * wheel1- slot machine wheel 1
	 */
	private int wheel1;
	/**
	 * wheel2- slot machine wheel 2
	 */
	private int wheel2;
	/**
	 * wheel3- slot machine wheel 3
	 */
	private int wheel3;
	/**
	 * wheel4- slot machine wheel 4
	 */
	private int wheel4;
	/**
	 * scan- gets user input
	 */
	private Scanner scan;
	
	
	/**
	 * Constructor- SlotMachine()
	 * creates and initializes coins, wheels 1-4, and the scanner
	 */
	public SlotMachine() {
		this.coins = 0;
		this.wheel1 = -1;
		this.wheel2 = -2;
		this.wheel3 = -3;
		this.wheel4 = -4;
		this.scan = new Scanner(System.in);
	}
	
	/**
	 * Helper Method- generateNewNumber()
	 * generates and returns a new random number
	 * @return int randomNumber- the generated random number
	 */
	private int generateNewNumber() {
		Random randomNumber = new Random();
		return randomNumber.nextInt(5);
	}
	
	/**
	 * Helper Method- numberToString()
	 * Translates wheel numbers to string options
	 * @param wheel- the wheel who's value will be converted to a string
	 * @return wheelString- the string value equivalent to the wheel
	 */
	private String numberToString(int wheel) {
		String wheelString = "ERROR";
		final int MUSHROOM = 0;
		final int ACORN = 1;
		final int FIREFLOWER = 2;
		final int ICEFLOWER = 3;
	    final int LEAF = 4;
		//check which option wheel is
		
		//MUSHROOM
		if (wheel == MUSHROOM) {
			wheelString = "Mushroom";
		}
		//ACORN
		else if (wheel == ACORN) {
			wheelString = "Acorn";
		}
		//FIRE FLOWER
		else if (wheel == FIREFLOWER) {
			wheelString = "Fire Flower";
		}
		//ICE FLOWER
		else if (wheel == ICEFLOWER) {
			wheelString = "Ice Flower";
		}
		//LEAF
		else if (wheel == LEAF) {
			wheelString = "Leaf";
		}
		//ERROR
		else {
			System.out.println("ERROR: Wheel number not between 0-4");
		}
		
		return wheelString;
	}
	
	
	/**
	 * Helper Method- calculateCoins()
	 * calculates the number of coins earned based on the outcome of the slot
	 * machine's four wheels
	 * @return roundCoins- number of coins earned this round
	 */
	private int calculateCoins() {
		int roundCoins;
		
		//check 4 same
		if ((this.wheel1 == this.wheel2) && (this.wheel2 == this.wheel3) && (this.wheel3 == this.wheel4)) {
			roundCoins = 600;
		}
		//check 3 same
		else if (((this.wheel1 == this.wheel2) && (this.wheel2 == this.wheel3)) || 
				((this.wheel2 == this.wheel3) && (this.wheel3 == this.wheel4))
				|| ((this.wheel3 == this.wheel4) && (this.wheel4 == this.wheel1))
				|| ((this.wheel4 == this.wheel1) && (this.wheel1 == this.wheel2))) {
			roundCoins = 300;
		}
		//check 2 same
		else if ((this.wheel1 == this.wheel2) || (this.wheel1 == this.wheel3) || (this.wheel1 == this.wheel4) 
				|| (this.wheel2 == this.wheel3) || (this.wheel2 == this.wheel4) || (this.wheel3 == this.wheel4)) {
			roundCoins = 100;
		}
		//no similar
		else {
			roundCoins = 0;
		}
		
		
		//OLD
		/*
		//check for 2 similar
		if ((this.wheel1 == this.wheel2) || (this.wheel1 == this.wheel3) || (this.wheel1 == this.wheel4) 
				|| (this.wheel2 == this.wheel3) || (this.wheel2 == this.wheel4) || (this.wheel3 == this.wheel4)) {
			//check for 3 similar
			if (((this.wheel1 == this.wheel2) && (this.wheel2 == this.wheel3)) || 
					((this.wheel2 == this.wheel3) && (this.wheel3 == this.wheel4))
					|| ((this.wheel3 == this.wheel4) && (this.wheel4 == this.wheel1))
					|| ((this.wheel4 == this.wheel1) && (this.wheel1 == this.wheel2))) {
				//4 similar
				if ((this.wheel1 == this.wheel2) && (this.wheel2 == this.wheel3) && (this.wheel3 == this.wheel4)) {
					roundCoins = 600;
				}
				//3 similar
				else {
					roundCoins = 300;
				}
			}
			//2 similar
			else {
				roundCoins = 100;
			}	
		}
		
		//no similar, 0 coins
		else {
			roundCoins = 0;
		}
		*/
		
		return roundCoins;
		//CHALLENGE: If the slot machine has 2 pairs the same, the player wins 200 coins.
	}
	
	/**
	 *  Method- play()
	 *  Allows the user to play 'attempt' # of rounds of the slot machine
	 * @param attempt- the number of times to run the slot machine
	 * @return coins- the total number of coins the user has earned
	 */
	public void play(int attempt) {
		int roundCoins = 0;
		//loop for 'attempt' number of times
		for (int i = 0; i < attempt; i++) {
			//prompt which round this is
			System.out.println("ROUND " + (i + 1) + "-");
			//generate new number and assign to each wheel
			this.wheel1 = this.generateNewNumber();
			this.wheel2 = this.generateNewNumber();
			this.wheel3 = this.generateNewNumber();
			this.wheel4 = this.generateNewNumber();
			//translate each wheel to a string and output to user
			System.out.println("Wheel 1: " + numberToString(this.wheel1));
			System.out.println("Wheel 2: " + numberToString(this.wheel2));
			System.out.println("Wheel 3: " + numberToString(this.wheel3));
			System.out.println("Wheel 4: " + numberToString(this.wheel4));
			//calculate how many coins user earned this round and add to total
			roundCoins = this.calculateCoins();
			this.coins += roundCoins;
			//output result to user
			System.out.println("Coins won this round: " + roundCoins 
					+ "\nTotal Coins: " + this.coins + "\n-------------------");
		}
		
	}
	
	/**
	 * Method- Interact()
	 * Allows the user to specify how many times they want to play the game
	 */
	public void interact() {
		int attempt;
		//welcome user
		this.welcome();
		//prompt user for how many times to play, loop while less than 1 attempt
		attempt = -1;
		while (attempt < 1) {
			System.out.println("How many times would you like to play?");
			attempt = this.scan.nextInt();
		}
		//play 'attempt' # of times
		this.play(attempt);
	}
	
	/**
	 * Helper Method- welcome()
	 * welcomes the user to the slot machine game
	 */
	private void welcome() {
		System.out.println("Welcome to Mario Bros. Slot Machine!\n"
				+ "------------------------------------");
	}
	
	/**
	 * Method- playAgain()
	 * Welcomes the user, runs the slot machine once,
	 * then asks if the user wants to play again, running 
	 * until they say yes or no to quit
	 */
	public void playAgain() {
		String playAgain;
		boolean quit;
		
		//welcome user and play 1 round of slot machine
		this.welcome();
		this.play(1);
		
		//loop while quit is false
		quit = false;
		while (!quit) {
			//ask the user if they want to play again
			System.out.println("Do you want to play again?");
			playAgain = scan.nextLine();
			
			//yes
			if (playAgain.equals("Yes") || playAgain.equals("yes")) {
				this.play(1);
			}
			//no
			else if (playAgain.equals("No") || playAgain.equals("no")) {
				quit = true;
			}
			//other
			else {
				System.out.println("ERROR: please try again");
			}	
			
		}
	}

	
	//CREATE A SLOT MACHINE CLASS THEN CALL THE CLASS IN GAME1 AND GAME2 FUNCTIONS
} 
