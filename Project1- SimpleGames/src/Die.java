/**
 * Project 1: SimpleGames- Die Class
 * A simple die class to model a die object that returns a
 * random number between 1-6
 * @author Jace Rettig
 * @Version 2-11-22
 */
import java.util.Random;

public class Die {
	/**
	 * roll- new random object to generate random number for die
	 */
	private Random roll;
	
	/**
	 * Constructor: Die()
	 * Creates roll object 
	 */
	public Die() {
		this.roll = new Random();
	}

	/**
	 * Method roll:
	 * Generates a random number 1-6, prints the value, and
	 * returns the value to the user
	 * @return int num
	 */
	public int roll() {
		//initialize num to store random value
		int num;
		//roll random value between 0-5
		num = this.roll.nextInt(6);
		//add 1 to the value to make between 1-6
		num += 1;
		//print new num
		System.out.print(num + " ");
		//return random num
		return num;
	}
	/**
	 *  TEST MAIN FUNCTION
	 *  public static void main(String[] args) {
	 *	Die d = new Die();
	 *	d.roll();
	 *	}
	 */

}
