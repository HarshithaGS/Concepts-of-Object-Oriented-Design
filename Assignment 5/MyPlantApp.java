/*
* NUID: 001444756
* @author Harshitha Sangameshwarappa Gaddadhar
*/
package edu.neu.csye6200.bg;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *  @author HarshithaGS
 *  This is the main Application or the start of the application is present in this  class. 
 *  This class includes the definition of JButtons (used for Start , Stop , Pause Resume) , JtextFields(to read user input for number of generations) , Combo box ( select rule)
 * @param <DesignGridLayout>
 *  
 */
public class MyPlantApp extends BGApp {

	private static Logger log = Logger.getLogger(MyPlantApp.class.getName());

	protected JPanel mainPanel = null;
	protected JPanel westPanel = null;// Panel that consists of the Button and TextField and Labels

	protected JButton startBtn = null;// Start button
	protected JButton stopBtn = null;// Stop Button
	protected JButton pauseBtn = null;// Pause Button
	protected JButton resumeBtn = null;// Resume Button

	static JLabel l_no_generations;// Label that is placed beside the textfield which takes the number of
									// generations to print from the user
	static JLabel l_select_rule;// label beside the combo box where user selects the rule
	
	static JLabel l_note;

	String s;// variable to hold the text written in the TextField
	int n;// variable to hold the Parsed Integer value of the String number entered in the
			// TextField
	String rule;// variable that holds the rule input being selected in the combobox

	BGGenerationSet BGGS;// instance of BGGenerationSet
	Thread threadA; // instance of a thread required to create the data and send to the observer


	// Creating a canvas
	private BGCanvas bgPanel = null;

	/**
	 * Main Plant app constructor
	 */
	public MyPlantApp() {
		frame.setSize(500, 400); // initial Frame size
		frame.setTitle("MY PLANT APP");
		menuMgr.createDefaultActions(); // Set up default menu items
		showUI(); // Cause the Swing Dispatch thread to display the JFrame
	}

	/**
	 * Create a main panel that will hold the bulk of our application display
	 */
	@Override
	public JPanel getMainPanel() {

		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());


		bgPanel = BGCanvas.instance();// Singleton instance of the BGCanvas so that new canvas isn't created to print
										// the tree
		mainPanel.add(BorderLayout.CENTER, bgPanel);
		mainPanel.add(BorderLayout.WEST, getWestPanel());

		return mainPanel;
	}

	/**
	 * Create a west panel that will hold control buttons
	 * This panel holds the start , stop , pause , resume , JTextfield ,JLabel  , ComboBox
	 * @return
	 */
	public JPanel getWestPanel() {
		westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(300, 100));
		westPanel.setBackground(Color.darkGray);
		westPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
		westPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		westPanel.setLayout(new GridLayout(20, 5));

		// Label for TextField to type number of generations
		l_no_generations = new JLabel();
		l_no_generations.setText("Please enter the number of generations ");
		l_no_generations.setForeground(Color.WHITE);
		l_no_generations.setPreferredSize(new Dimension(20, 10));
		westPanel.add(l_no_generations, BorderLayout.CENTER);
	

		// Field to enter the number of generations
		final JTextField number_gen = new JTextField();
		number_gen.setPreferredSize(new Dimension(100, 10));
		number_gen.setEnabled(true);
		westPanel.add(number_gen, BorderLayout.CENTER);

		// Label for TextField to select the rule
		l_select_rule = new JLabel();
		l_select_rule.setText("Please enter the number of generations");
		l_select_rule.setForeground(Color.WHITE);
		westPanel.add(l_select_rule, BorderLayout.CENTER);

		// COMBO-BOX CONFIG - The two rules sets have two rules within with the parameters being different
		String[] Rules = new String[] { "1", "2" };// define items in a String array
		JComboBox<String> RuleListCombo = new JComboBox<String>(Rules); // create a combo box with the fixed array:
		RuleListCombo.setForeground(Color.WHITE);
		RuleListCombo.setBackground(Color.BLACK);
		westPanel.add(RuleListCombo, BorderLayout.CENTER);

		// START BUTTON CONFIG
		startBtn = new JButton("Start");
		startBtn.setPreferredSize(new Dimension (10,10));
		startBtn.setForeground(Color.WHITE);
		startBtn.setBackground(Color.BLACK);
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// if( (number_gen != null )){
				s = number_gen.getText();
				try {
					n = Integer.parseInt((String) (s));
				} catch (NumberFormatException e) {
					System.out.println("not a number");
				}
				rule = (String) RuleListCombo.getSelectedItem();

				BGGS = new BGGenerationSet(n, rule);
				threadA = new Thread(BGGS);
				threadA.start();
			}
		}

		); // Allow the app to hear about button pushes
		westPanel.add(new JLabel(""));
		westPanel.add(startBtn,BorderLayout.CENTER);

		// PAUSE BUTTON CONFIG
		pauseBtn = new JButton("Pause");
		pauseBtn.setForeground(Color.WHITE);
		pauseBtn.setBackground(Color.BLACK);
		pauseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("pause pressed");
				threadA.suspend();
			}
		}); // Allow the app to hear about button pushes
		westPanel.add(new JLabel(""));
		westPanel.add(pauseBtn,BorderLayout.CENTER);

		// RESUME BUTTON CONFIG
		resumeBtn = new JButton("Resume");
		resumeBtn.setForeground(Color.WHITE);
		resumeBtn.setBackground(Color.BLACK);
		resumeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("restart pressed");
				threadA.resume();
			}
		}); // Allow the app to hear about button pushes
		westPanel.add(new JLabel(""));
		westPanel.add(resumeBtn,BorderLayout.CENTER);

		// STOP BUTTON CONFIG
		stopBtn = new JButton("Stop");
		stopBtn.setLocation(8, 8);
		// stopBtn.setLocation();
		stopBtn.setForeground(Color.WHITE);
		stopBtn.setBackground(Color.BLACK);
		stopBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Stop pressed");
				threadA.stop();
			}
		}); // Allow the app to hear about button pushes
		westPanel.add(new JLabel(""));
		westPanel.add(stopBtn,BorderLayout.CENTER);

		return westPanel;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		log.info("Window opened");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		log.info("Window closing");
	}

	@Override
	public void windowClosed(WindowEvent e) {
		log.info("Window closed");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		log.info("Window iconified");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		log.info("Window deiconified");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		log.info("Window activated");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		log.info("Window deactivated");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Main method to initiate the growth of the plant
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new MyPlantApp();
		log.info("MyPlantApp started");
	}

}
