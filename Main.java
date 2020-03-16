package RollDie;
/*
 * Author:		Tyler Blanchard
 * Date:		11/24/2018
 * 
 * Description:		This program rolls dice and displays the total
 * 					amount gotten on the dice. Displays the image of the 
 * 					dice and has a choice box to determine the number
 * 					of dice rolled. Has a button that shows how many times
 * 					you rolled each number on a separate frame.
 */
public class Main {

	public static void main(String[] args) {
		// set title of the GameFrame
		GameFrame frame = new GameFrame("Roll Dice");
		
		// set title of the StatFrame
		StatFrame ResultFrame = new StatFrame("Dice Frequencies");
		
		// set up handler
		new Handler(frame, ResultFrame);
		
		// make the GameFrame visible at the start
		frame.setVisible(true);

	}

}
