package builder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controllers.GetStateOfLightningBuilder;
import controllers.GetStateOfPuzzleBuilder;
import entities.Board;
import entities.Letter;
import entities.Lightning;
import player.LightningView;
import player.PuzzleView;

/**
 * The Builder class for Lightning Levels.
 * <p>
 * This allows the user to create a level of type Lightning to
 * be played by the <code>Player.java</code>.
 * 
 * Creation date: (12/5/2016)
 * 
 * @author Thomas Hagen, Rachel Hahn, Rayyan Khan, Hannah Olshansky, Lauren Pontbriant (Molybdenum)
 * 
 */

public class LightningBuilder extends JFrame {
	
	/**
	 * The JPanel to manage the Lightning Level Builder. 
	 */
	private JPanel contentPane;
	
	/**
	 * The JTextField to contain the time allowed in the level.
	 */
	private JTextField txtSetTime;
	
	/**
	 * The JTextField to contain the minimum amount of points to reach 
	 * one star.
	 */
	private JTextField txt1StarThresh;
	
	/**
	 * The JTextField to contain the minimum amount of points to reach
	 * two stars. 
	 */
	private JTextField txt2StarThresh;
	
	/**
	 * The JTextField to contain the minimum amount of points to reach 
	 * three stars. 
	 */
	private JTextField txt3StarThresh;
	
	/**
	 * The JTextField to contain the name of the level.
	 */
	private JTextField txtlevelName;
	
	/**
	 * The JButtons to allow the user to go back, preview the level they
	 * are creating, delete the level they are creating, or save the 
	 * level they are creating. 
	 */
	private JButton btnBack, btnPreview, btnDelete, btnSaveLevel;
	
	/**
	 * The JLabels to tell the user what to enter where.
	 */
	private JLabel lblScoreThresholds, lblLevelTypeLightning;
	
	/**
	 * The JCheckboxes to allow the user to decide how they want the 
	 * level board to look like.
	 */
	private JCheckBox checkBox[][] = new JCheckBox[6][6];
	
	/**
	 * Variables to help loop through the double array of check boxes.
	 */
	int i, j;
	
	/**
	 * Creating a new Lightning Level.
	 */
	Lightning lightning = new Lightning("default", new Board());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LightningBuilder frame = new LightningBuilder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LightningBuilder() {
		initialize();
	}

	/**
	 * Initialize the Lightning Level Builder.
	 */
	private void initialize() {
		initializeModel();
		initializeView();
		initializeController();
	}

	/**
	 * Initialize everything that will be added to the JPanel.
	 */
	private void initializeModel() {
		setResizable(false);
		setTitle("Letter Craze Builder");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1000, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblScoreThresholds = new JLabel("*Score Thresholds:");
		txt1StarThresh = new JTextField();
		txt2StarThresh = new JTextField();
		txt3StarThresh = new JTextField();

		txtlevelName = new JTextField();
		lblLevelTypeLightning = new JLabel("Level Type: Lightning");
		txtSetTime = new JTextField();

		btnSaveLevel = new JButton("Save Level");
		btnBack = new JButton("Main Menu");
		btnPreview = new JButton("Preview");
		btnDelete = new JButton("Delete");

	}

	/**
	 * Initialize where everything will be placed in the JPanel.
	 */
	private void initializeView() {
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {

				checkBox[i][j] = new JCheckBox("", true);
				checkBox[i][j].setBounds(534 + i * 66, 91 + j * 66, 20, 20);
				contentPane.add(checkBox[i][j]);

			}

		}

		lblScoreThresholds.setBounds(172, 154, 120, 14);
		contentPane.add(lblScoreThresholds);

		txt1StarThresh.setText("");
		TextPrompt star1prompt = new TextPrompt("Score required for 1 star", txt1StarThresh);
		txt1StarThresh.setColumns(10);
		txt1StarThresh.setBounds(172, 170, 171, 20);
		contentPane.add(txt1StarThresh);

		txt2StarThresh.setText("");
		TextPrompt star2prompt = new TextPrompt("Score required for 2 star", txt2StarThresh);
		txt2StarThresh.setColumns(10);
		txt2StarThresh.setBounds(172, 195, 171, 20);
		contentPane.add(txt2StarThresh);

		txt3StarThresh.setText("");
		TextPrompt star3prompt = new TextPrompt("Score required for 3 star", txt3StarThresh);
		txt3StarThresh.setColumns(10);
		txt3StarThresh.setBounds(172, 220, 171, 20);
		contentPane.add(txt3StarThresh);

		lblLevelTypeLightning.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelTypeLightning.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLevelTypeLightning.setBounds(10, 86, 510, 32);
		contentPane.add(lblLevelTypeLightning);

		JLabel gridImg = new JLabel("");
		gridImg.setIcon(new ImageIcon(PuzzleBuilder.class.getResource("/images/Grid.gif")));
		gridImg.setBounds(530, 86, 400, 400);
		contentPane.add(gridImg);

		JLabel lblTime = new JLabel("*Timer:");
		lblTime.setBounds(172, 129, 50, 14);
		contentPane.add(lblTime);
		
		JLabel lblRequiredNote = new JLabel("*Required Fields");
		lblRequiredNote.setBounds(182, 248, 110, 14);
		contentPane.add(lblRequiredNote);

		txtSetTime.setText("");
		TextPrompt timePrompt = new TextPrompt("Set Max Time", txtSetTime);
		txtSetTime.setBounds(217, 126, 86, 20);
		contentPane.add(txtSetTime);
		txtSetTime.setColumns(10);

		btnSaveLevel.setBounds(10, 95, 95, 23);
		contentPane.add(btnSaveLevel);

		btnBack = new JButton("Main Menu");
		btnBack.setBounds(10, 171, 95, 23);
		contentPane.add(btnBack);

		btnPreview = new JButton("Preview");
		btnPreview.setBounds(10, 200, 95, 23);
		contentPane.add(btnPreview);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(10, 230, 95, 23);
		contentPane.add(btnDelete);
		
		txtlevelName.setBounds(10, 146, 95, 20);
		TextPrompt levelNameprompt = new TextPrompt("<html><text color = black></text>Level Name</html>", txtlevelName);
		contentPane.add(txtlevelName);
		txtlevelName.setColumns(10);
		
		JLabel lblLevelName = new JLabel("*Level Name");
		lblLevelName.setBounds(10, 126, 95, 20);
		contentPane.add(lblLevelName);

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(LightningBuilder.class.getResource("/images/BackgroundBlank.gif")));
		bg.setBounds(0, 0, 994, 541);
		contentPane.add(bg);
	}
	
	/**
	 * Initialize what happens when buttons on the JPanel are pressed.
	 */
	private void initializeController() {
		LightningBuilder lightningBuilder = this;
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Builder mainMenu = new Builder();
				mainMenu.setVisible(true);
				dispose();
			}
		});

		btnPreview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				GetStateOfLightningBuilder state = new GetStateOfLightningBuilder(lightningBuilder, lightning);
				state.makePreview();
			}
		});
		
		btnSaveLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetStateOfLightningBuilder getState = new GetStateOfLightningBuilder(lightningBuilder, lightning);
				getState.saveLevel();
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetStateOfLightningBuilder getState = new GetStateOfLightningBuilder(lightningBuilder, lightning);
				getState.deletePuzzle();
			}
		});
	}

	/**
	 * Getter for the name of the level.
	 * @return String name of the level.
	 */
	public String getNameText() {
		return txtlevelName.getText();
	}

	/**
	 * Getter for the timer.
	 * @return String time that the user has to complete the level.
	 */
	public String getTimerText() {
		return txtSetTime.getText();
	}

	/**
	 * Getter for the check boxes.
	 * @return JCheckBox[][] check boxes representing which squares on the board
	 * are active versus inactive.
	 */
	public JCheckBox[][] getCheckBox() {
		return checkBox;
	}

	/**
	 * Setter for the check boxes.
	 * @param checkBox A double array of JCheckBox representing which squares on 
	 * the board are active versus inactive.
	 */
	public void setCheckBox(JCheckBox checkBox[][]) {
		this.checkBox = checkBox;
	}

	/**
	 * Getter for the threshold for one star.
	 * @return JTextField the amount of points the user must get to reach one star.
	 */
	public JTextField getTxt1StarThresh() {
		return txt1StarThresh;
	}

	/**
	 * Setter for the threshold for one star.
	 * @param txt1StarThresh A JTextField representing how many points the user 
	 * must get to reach one star.
	 */
	public void setTxt1StarThresh(JTextField txt1StarThresh) {
		this.txt1StarThresh = txt1StarThresh;
	}

	/**
	 * Getter for the threshold for two stars.
	 * @return JTextField the amount of points the user must get to reach two stars.
	 */
	public JTextField getTxt2StarThresh() {
		return txt2StarThresh;
	}

	/**
	 * Getter for the threshold for three stars.
	 * @return JTextField the amount of points the user must get to reach three stars.
	 */
	public JTextField getTxt3StarThresh() {
		return txt3StarThresh;
	}
	
	public void setTimeLimit(String s) {
		txtSetTime.setText(s);
	}
	
	public void set1StarScoreText(String s) {
		txt1StarThresh.setText(s);
	}
	
	public void set2StarScoreText(String s) {
		txt2StarThresh.setText(s);
	}
	
	public void set3StarScoreText(String s) {
		txt3StarThresh.setText(s);
	}
	
	public void setNameText(String s) {
		txtlevelName.setText(s);
	}
}
