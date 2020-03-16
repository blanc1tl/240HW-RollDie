package RollDie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class StatFrame extends JFrame {
	// set up JTextArea
	JTextArea dieFrequencies = new JTextArea();
	
	/**
	 * Initiate the view of the StatFrame
	 * @param title The title of the java frame
	 */
	public StatFrame(String resultTital) {
		// set the title
		super(resultTital);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set size of frame
		setSize(375, 350);
		// make layout be a borderLayOut
		setLayout(new BorderLayout());

		// sets the font size, style, and make it bold for the text area
		dieFrequencies.setFont(new Font("TimesRoman", Font.BOLD, 38));
		// make the text black
		dieFrequencies.setForeground(Color.BLACK);
		// make the text area be blank at the start
		dieFrequencies.setText("");
		// A text filed is added at the 'west' of the frame
		// to displaying the choices for the question.
		add(dieFrequencies, BorderLayout.WEST);
	}
}

