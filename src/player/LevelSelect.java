package player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import controllers.*;
import entities.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.io.*;
import java.nio.file.*;

/**
 * The Player class for Selecting Levels.
 * <p>
 * This allows the player to select a level they would like to play.
 * 
 * Creation date: (12/5/2016)
 * 
 * @author Thomas Hagen, Rachel Hahn, Rayyan Khan, Hannah Olshansky, Lauren
 *         Pontbriant (Molybdenum)
 * 
 */

public class LevelSelect extends JFrame {

	private JPanel contentPane;
	private JLabel lvlStars[], lblScore[];
	private JButton btnMainMenu, btnClearStars, btnCustom;
	private JButton[] btnLevel;
	private JLabel cheater;


	/**
	 * Launch the application.
	 */
	public static void Levels() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelSelect frame = new LevelSelect();
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
	public LevelSelect() {
		setTitle("Letter Craze");
		initialize();
	}

	private void initialize() {
		initializeModel();
		initializeView();
		initializeController();
	}

	/**
	 * Initialize everything that will be added to the JPanel.
	 */
	private void initializeModel() {

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1000, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnLevel = new JButton[15];
		int j = 0;
		for (int i = 0; i < 15; i++) {

			btnLevel[i] = new JButton("Level " + (i + 1));
			if (j > 4) {
				j = 0;
			}
			if (i < 5) {
				btnLevel[i].setBounds(260 + (j * 100), 155, 80, 80);
			}
			if (i >= 5 && i < 10) {
				btnLevel[i].setBounds(260 + (j * 100), 275, 80, 80);
			}
			if (i >= 10 && i < 15) {
				btnLevel[i].setBounds(260 + (j * 100), 395, 80, 80);
			}
			btnLevel[i].setFont(new Font("Tahoma", Font.PLAIN, 10));
			btnLevel[i].setFocusPainted(false);
			final int k = (i + 1);
			btnLevel[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String path = "savedLevels/Level " + k + ".txt";
					try {
						String readCheck = Files.readAllLines(Paths.get(path)).get(41);
						if (readCheck.equals("Puzzle")) {
							LoadPuzzleLevel puzz = new LoadPuzzleLevel("Level " + k,
									new Puzzle("Level " + k, new Board()));
							puzz.loadPuzzle();
							System.out.println("Puzzle Loaded");
						} else if (readCheck.equals("Lightning")) {
							LoadLightningLevel temp = new LoadLightningLevel("Level " + k,
									new Lightning("Level " + k, new Board()));
							temp.loadLightning();
							System.out.println("Lightning Loaded");
						} else if (readCheck.equals("Theme")) {
							LoadThemeLevel temp = new LoadThemeLevel("Level " + k,
									new Theme("Level " + k, new Board()));
							temp.loadTheme();
							System.out.println("Theme Loaded");
						} else {
							System.out.println(readCheck);
						}
						dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});
			contentPane.add(btnLevel[i]);
			j++;
		}
		btnMainMenu = new JButton("Main Menu");
		btnClearStars = new JButton("Clear All Data");
		btnCustom = new JButton("Custom Levels");
		cheater = new JLabel("");
	}

	/**
	 * Initialize where everything will be placed in the JPanel.
	 */
	private void initializeView() {
		btnMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMainMenu.setBounds(110, 155, 110, 30);
		btnMainMenu.setFocusPainted(false);
		contentPane.add(btnMainMenu);

		btnClearStars.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnClearStars.setBounds(110, 405, 110, 30);
		btnClearStars.setFocusPainted(false);
		contentPane.add(btnClearStars);
		
		btnCustom.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCustom.setBounds(110, 190, 110, 30);
		btnCustom.setFocusPainted(false);
		contentPane.add(btnCustom);
		
		cheater.setBounds(110, 250, 100, 100);
		cheater.setIcon(new ImageIcon(player.LevelSelect.class.getResource("/images/cheater.png")));
		cheater.setVisible(false);
		contentPane.add(cheater);
		
		

		try {
			initializeStars();
		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(player.LevelSelect.class.getResource("/images/BackgroundTitle.gif")));
		bg.setBounds(0, 0, 994, 531);
		contentPane.add(bg);

	}

	/**
	 * Initialize the stars that will be placed in the JPanel.
	 */
	private void initializeStars() throws IOException {
		
		lvlStars = new JLabel[15];
		lblScore = new JLabel[15];
		String path = "src/SavedStars.txt";
		String pathScore = "src/SavedScores.txt";
		int j = 0;
		for (int i = 0; i < 15; i++) {

			String icon = "/images/StarsBlank.gif";
			int readCheck = Integer.parseInt(Files.readAllLines(Paths.get(path)).get(i));
			int scoreCheck = Integer.parseInt(Files.readAllLines(Paths.get(pathScore)).get(i));
			
			if (readCheck == 0) {
				icon = "/images/StarsBlank.gif";
			} else if (readCheck == 1) {
				icon = "/images/oneStars.gif";
			} else if (readCheck == 2) {
				icon = "/images/twoStars.gif";
			} else if (readCheck == 3) {
				icon = "/images/Stars.gif";
			}
			if (i != 0) {
				int prevCheck = Integer.parseInt(Files.readAllLines(Paths.get(path)).get(i - 1));
				if (prevCheck == 0) {
					btnLevel[i].setEnabled(false);
					icon = "/images/locked.gif";
				}
			}
			lblScore[i] = new JLabel("High: " + scoreCheck, SwingConstants.CENTER);
			lvlStars[i] = new JLabel("");
			lvlStars[i].setIcon(new ImageIcon(LevelSelect.class.getResource(icon)));
			if (j > 4) {
				j = 0;
			}
			if (i < 5) {
				lblScore[i].setBounds(260 + (j * 100), 235, 80, 16);
				lvlStars[i].setBounds(277 + (j * 100), 254, 50, 16);
			}
			if (i >= 5 && i < 10) {
				lblScore[i].setBounds(260 + (j * 100), 355, 80, 16);
				lvlStars[i].setBounds(277 + (j * 100), 374, 50, 16);
			}
			if (i >= 10 && i < 15) {
				lblScore[i].setBounds(260 + (j * 100), 475, 80, 16);
				lvlStars[i].setBounds(277 + (j * 100), 494, 50, 16);
			}
			lblScore[i].setForeground(Color.WHITE);
			lblScore[i].setBackground(Color.BLACK);
			lblScore[i].setOpaque(true);
			contentPane.add(lblScore[i]);
			contentPane.add(lvlStars[i]);
			j++;
		}
		if((Integer.parseInt(Files.readAllLines(Paths.get(path)).get(15)) == 3)){
			cheater.setVisible(true);
		}
	}

	/**
	 * Initialize what happens when buttons on the JPanel are pressed.
	 */
	private void initializeController() {
		LevelSelect ls = this;
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Player temp = new Player();
				temp.setVisible(true);
				dispose();
			}
		});

		btnClearStars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClearAllProgress clr = new ClearAllProgress();
				clr.clearAllData();
				LevelSelect temp = new LevelSelect();
				temp.setVisible(true);
				dispose();
			}
		});
		
		btnCustom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlayCustomView temp = new PlayCustomView(ls);
				temp.setVisible(true);
				
			}
		});
	}

}
