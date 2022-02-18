/**
 * Project 1: SimpleGames- HighLow Class
 * Allows the user to play High Low with the computer,
 * guessing a number between 1-1000
 * @author Jace Rettig
 * @version 1-11-22
 */
import java.util.Scanner;
import java.util.Random;

public class HighLow {
	/**
	 * randomNumber generates random number
	 */
	private Random randomNumber;
	/**
	 * scan- gets user input
	 */
	private Scanner scan;
	
	/**
	 * Constructor- HighLow()
	 * creates and initializes a randomNumber object and a scanner
	 */
	public HighLow() {
		this.randomNumber = new Random();
		this.scan = new Scanner(System.in);
	}
	
	/**
	 * Method- generateNewNumber()
	 * Helper private method to generate a new random number
	 * @return int num
	 */
	private int generateNewNumber() {
		int num;
		//generate random number from 0-999
		num = this.randomNumber.nextInt(1000);
		//shifts from 0-999 to 1-1000
		num += 1;
		return num;
	}
	/**
	 * Method- play()
	 * allows the user to play a new game of high low,
	 * guessing between 1-1000
	 */
	public void play() {
		int randNum;
		int userNum;
		boolean quit;
		//generate a new random number
		randNum = this.generateNewNumber();
		
		//get user input
		userNum = -1;
		//loop while invalid input
		quit = false;
		while ((userNum < 0) || (userNum > 1000)) {
			System.out.println("Please enter a number between 1-1000, or 0 to quit");
			userNum = scan.nextInt();
			//quit if input is 0
			if (userNum == 0) {
				quit = true;
			}
		}
		//loop till user guesses number or quits
		while (!quit) {
			//if too high
			if (userNum > randNum) {
				System.out.println("Too high, guess again");
				userNum = scan.nextInt();
			} 
			//if too low
			else if (userNum < randNum ) {
				System.out.println("Too low, guess again");
				userNum = scan.nextInt();
			}
			//if correct
			else if (userNum == randNum) {
				System.out.println("Guess is correct! Num was " + randNum + "\nThanks for playing!");
				quit = true;
			}
			//if quit
			else if (userNum == 0) {
				quit = true;
				System.out.println("Thanks for playing!");
			}
			
		}
		
		/*
		Challenge: Instead the computer choosing the number, have the user think of a number 
		between 1 and 1000. Have the computer guess a number, and the user indicate if the 
		computer is too high, too low or correct. Provide a way for the user to quit as well. For 
		simplicity, have the user enter a number for too high, too low, correct, or quit, or figure out 
		how to read a String by looking up the Scanner documentation in the Java API: 
		http://docs.oracle.com/javase/8/docs/api/. The computer’s guesses should use the high/low 
		feedback to choose its next guess!
		 */
		
		//do ~~~ while not usernumberguessed
		//tell user to pick a number 
		//generate random number
		//ask if that's number
		//based on feedback choose another number(binary search)
		
	}
	
	public static void main(String[] args) {
		//create new count doubles object
		HighLow h = new HighLow();
		//call interact method
		h.play();
	}
	
}
