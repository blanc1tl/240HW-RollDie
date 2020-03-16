package RollDie;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Handler implements ActionListener, ItemListener {
	// set up random
	Random rn = new Random();

	Die[] dieArr = new Die[6];
	// set up hashMap
	Map<String,String> buttonTask;
	// set up GameFrame variable
	GameFrame frame;
	// set up StatFrame variable
	StatFrame resultFrame;
	// set up local variables
	int totalOne, totalTwo, totalThree;
	int totalFour, totalFive, totalSix;
	int totalSumRolled, numberRolled;
	int numberOfDice = 1;

	/**
	 * Constructor -- set reference to the the views
	 * 				  GameFrame and StatFrame
	 * @param frame The view of the GameFrame
	 * @param resultFrame The model of the StatFrame
	 */
	public Handler(GameFrame frame, StatFrame resultFrame) {
		this.frame = frame;
		this.resultFrame = resultFrame;

		for (int i = 0; i < 6; i++) {
			dieArr[i] = new Die();
			dieArr[i].faceValue = i + 1;
			dieArr[i].icon = new ImageIcon("dice_" + (i+1) +".png");

		}

		// set up choice box
		frame.getChoice().addItemListener(this);

		// register this controller (event handler) with
		// each button (event source) in the view
		JButton[] buttons = frame.getButtons();
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		buttonTask = frame.getButtonMethods();
		// if the user clicks a button
		if (source instanceof JButton) {
			JButton b = (JButton)source;
			// sets the label of button to a variable
			String buttonLabel = b.getActionCommand();
			// sets the task to a variable
			String task = buttonTask.get(buttonLabel);
			doTask(buttonLabel, task);
		}

	}

	/**
	 * Process the button click by displaying either the
	 * total number rolled on the dice and displaying a image
	 * for the rolled number or opening the StatFrame to show
	 * how many times you rolled a certain number on a dice
	 * 
	 * @param buttonLabel The label on the button
	 * @param task The nature of the button (results, diceRoll)
	 */
	private void doTask(String buttonLabel, String task) {

		// if the user hits the "show Freq" button
		if (task.equals("results")) {
			// display the amount of times each number was rolled on a die
			// in the textArea in the StatFrame
			resultFrame.dieFrequencies.setText("Die 1 occured " + totalOne + " times.  \n"
					+ "Die 2 occured " + totalTwo + " times.  \n" + "Die 3 occured " + totalThree + " times.  \n"
					+ "Die 4 occured " + totalFour + " times.  \n" + "Die 5 occured " + totalFive + " times.  \n"
					+ "Die 6 occured " + totalSix + " times.  \n");

			// make the statFrame visible
			resultFrame.setVisible(true);
		}
		// if the user hits the "Roll" button
		if (task.equals("diceRoll")) {
			// resets the totalSumRolled to zero
			totalSumRolled = 0;

			// rolls for the number of dice there is
			for (int i = 0; i < numberOfDice; i++) {
				// roll a number from 1 to 6
				numberRolled = rn.nextInt(6) + 1;

				// if it rolls a one add to the totalOne variable
				if (numberRolled == 1) {
					totalOne++;
				}

				// if it rolls a two add to the totalTwo variable
				if (numberRolled == 2) {
					totalTwo++;
				}

				// if it rolls a three add to the totalThree variable
				if (numberRolled == 3) {
					totalThree++;
				}

				// if it rolls a four add to the totalFour variable
				if (numberRolled == 4) {
					totalFour++;
				}

				// if it rolls a five add to the totalFive variable
				if (numberRolled == 5) {
					totalFive++;
				}

				// if it rolls a six add to the totalSix variable
				if (numberRolled == 6) {
					totalSix++;
				}

				// set icon of the label depending on the number of dice
				frame.labelImage[i].setIcon(dieArr[numberRolled - 1].icon);

				// add the rolled number to the totalSumRolled variable
				totalSumRolled = totalSumRolled + numberRolled;
			}
			// display the total amount rolled in the JTextField
			frame.dieRollField.setText("You got " + totalSumRolled);
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getSource();
		if (source instanceof Choice) {
			// make JTextField blank
			frame.dieRollField.setText("");

			// make the dice images blank
			for(int i=0; i < 4; i++) {
				frame.labelImage[i].setIcon(null);
			}

			Choice c = (Choice)source;
			// set the number of dice there is
			numberOfDice = c.getSelectedIndex() +  1;

		}

	}

}
