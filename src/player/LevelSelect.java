package player;

import java.awt.BorderLayout;
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

public class LevelSelect extends JFrame {

	private JPanel contentPane;
	private JLabel lvlStars[];
	private JButton btnMainMenu, btnClearStars;
	private JButton[] btnLevel;

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
				btnLevel[i].setBounds(260 + (j * 100), 255, 80, 80);
			}
			if (i >= 10 && i < 15) {
				btnLevel[i].setBounds(260 + (j * 100), 355, 80, 80);
			}
			btnLevel[i].setFont(new Font("Tahoma", Font.PLAIN, 10));
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
							System.out.println("Lightning Loaded");
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
		btnClearStars = new JButton("Clear Stars");

	}

	private void initializeView() {
		btnMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMainMenu.setBounds(110, 155, 110, 30);
		contentPane.add(btnMainMenu);

		btnClearStars.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnClearStars.setBounds(110, 190, 110, 30);
		contentPane.add(btnClearStars);

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

	private void initializeStars() throws IOException {
		lvlStars = new JLabel[15];
		String path = "src/SavedStars.txt";
		int j = 0;
		for (int i = 0; i < 15; i++) {

			String icon = "/images/StarsBlank.gif";
			int readCheck = Integer.parseInt(Files.readAllLines(Paths.get(path)).get(i));

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

			lvlStars[i] = new JLabel("");
			lvlStars[i].setIcon(new ImageIcon(LevelSelect.class.getResource(icon)));
			if (j > 4) {
				j = 0;
			}
			if (i < 5) {
				lvlStars[i].setBounds(277 + (j * 100), 234, 50, 16);
			}
			if (i >= 5 && i < 10) {
				lvlStars[i].setBounds(277 + (j * 100), 334, 50, 16);
			}
			if (i >= 10 && i < 15) {
				lvlStars[i].setBounds(277 + (j * 100), 434, 50, 16);
			}
			contentPane.add(lvlStars[i]);
			j++;
		}
	}

	private void initializeController() {
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
				clr.clearAllStars();
				LevelSelect temp = new LevelSelect();
				temp.setVisible(true);
				dispose();
			}
		});
	}

}
