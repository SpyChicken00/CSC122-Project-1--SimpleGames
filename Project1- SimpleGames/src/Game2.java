/**
 * Project 1: SimpleGames- Game2
 * Runs game2 version of slot machine, where user plays
 * once, then asks to play again until quitting and
 * coins are tracked between games
 * @author Jace Rettig
 * @version 2-11-22
 */
public class Game2 {
	//Main function to call slot machine 
		public static void main(String[] args) {
			//create new slot machine object
			SlotMachine s = new SlotMachine();
			//call interact method
			s.playAgain();
		} 
}
