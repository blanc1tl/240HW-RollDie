package RollDie;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GameFrame extends JFrame {
	// sets up JButton
	private JButton[] buttons;

	// set up JLabel
	JLabel[] labelImage;

	// set up choice
	Choice choice = new Choice();

	// set up JTextField
	JTextField dieRollField = new JTextField(15);

	// set the max number of dice
	final int diceMax = 4;

	// set up the labels for the buttons
	private String[] buttonLabels =
		{ "Show Freq", "Roll"};

	// set up the methods for the buttons
	private String[] methods = 
		{"results", "diceRoll"};

	// set up the number of buttons
	final int numButtons = buttonLabels.length;

	// set up the HasMap
	Map<String,String> labelMethods = new HashMap<String,String>(2);

	/**
	 * Initiate the view of the GameFrame
	 * @param title The title of the java frame
	 */
	public GameFrame(String title) {
		// set title of the frame
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set size of the frame
		setSize(800, 325);
		// make layout be a borderLayOut
		setLayout(new BorderLayout());

		// set up choice box
		String[] choiceString = {"1 die", "2 dice", "3 dice", "4 dice"};
		for (String c : choiceString) {
			choice.add(c);
		}
		// set up the font size, make it plain, and style
		choice.setFont(new Font("TimesRoman", Font.PLAIN, 24));

		// make JPanel for buttons and choice
		JPanel p = new JPanel();
		p.setLayout( new FlowLayout() );
		buttons = new JButton[numButtons];
		for (int i = 0; i < buttons.length; i++) {  
			//set up button label
			buttons[i] = new JButton(buttonLabels[i]);
			// set up the font size, make it bold, and style
			buttons[i].setFont(new Font("TimesRoman", Font.BOLD, 24));
			// make the color of the words be blue
			buttons[i].setForeground(Color.BLUE);
			// add button
			p.add(buttons[i]);
			// add the buttons to the HasMap
			labelMethods.put(buttonLabels[i], methods[i]);
		}
		
		// add the choice to the JPanel
		p.add(choice);
		
		// set locations of the buttons and choices at 
		// the 'south' part of the JFrame
		add(p, BorderLayout.SOUTH);

		// A text field is added at the top of the frame
		// for display of total sum you rolled on the dice(s)
		dieRollField.setFont(new Font("TimesRoman", Font.BOLD, 48));
		// make text color be magenta
		dieRollField.setForeground(Color.MAGENTA);
		// display text in the center of textField
		dieRollField.setHorizontalAlignment(JTextField.CENTER);
		// make text field be blank
		dieRollField.setText("");
		// make text field be at the north of JFrame
		add(dieRollField, BorderLayout.NORTH);

		// create JPanel for the labels
		JPanel a = new JPanel();
		a.setLayout( new FlowLayout() );
		// arrayList for the labels
		labelImage = new JLabel[diceMax];
		// create four labels that will be made images
		for (int i = 0; i < diceMax; i++) {
			labelImage[i] = new JLabel();
			// add label
			a.add(labelImage[i]);
		}
		// place the labels in the center of JTextField
		add(a, BorderLayout.CENTER);
	}

	/**
	 * Get the buttons
	 */
	public JButton[] getButtons() {
		return buttons;
	}

	/**
	 * Get choices
	 */
	public Choice getChoice() {
		return choice;
	}

	/**
	 * Get methods of the buttons
	 */
	public Map<String, String> getButtonMethods() {
		return labelMethods;
	}
}
