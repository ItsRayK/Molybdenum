package player;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.LoadLightningLevel;
import controllers.LoadPuzzleLevel;
import entities.Board;
import entities.Puzzle;
import entities.Lightning;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LevelSelect extends JFrame {

	private JPanel contentPane;
	private JButton btnLevel1, btnLevel2, btnLevel3, btnLevel4, btnLevel5, btnLevel6, btnLevel7, btnLevel8, btnLevel9,
			btnLevel10, btnLevel11, btnLevel12, btnLevel13, btnLevel14, btnLevel15;
	private JLabel lvlStars[];
	private JButton btnMainMenu, btnCustom;

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

		btnMainMenu = new JButton("Main Menu");
		btnCustom = new JButton("Custom Level");
		btnLevel1 = new JButton("Level 1");
		btnLevel2 = new JButton("Level 2");
		btnLevel3 = new JButton("Level 3");
		btnLevel4 = new JButton("Level 4");
		btnLevel5 = new JButton("Level 5");
		btnLevel6 = new JButton("Level 6");
		btnLevel7 = new JButton("Level 7");
		btnLevel8 = new JButton("Level 8");
		btnLevel9 = new JButton("Level 9");
		btnLevel10 = new JButton("Level 10");
		btnLevel11 = new JButton("Level 11");
		btnLevel12 = new JButton("Level 12");
		btnLevel13 = new JButton("Level 13");
		btnLevel14 = new JButton("Level 14");
		btnLevel15 = new JButton("Level 15");

	}

	private void initializeView() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1000, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnLevel1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel1.setBounds(260, 155, 80, 80);
		contentPane.add(btnLevel1);

		btnMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMainMenu.setBounds(110, 155, 110, 30);
		contentPane.add(btnMainMenu);

		btnCustom.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCustom.setBounds(110, 190, 110, 30);
		contentPane.add(btnCustom);

		// ONLY BUTTONS 1 - 3 DO SOMETHING >> See initializeController

		btnLevel2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel2.setBounds(360, 155, 80, 80);
		contentPane.add(btnLevel2);

		btnLevel3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel3.setBounds(460, 155, 80, 80);
		contentPane.add(btnLevel3);

		btnLevel4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel4.setBounds(560, 155, 80, 80);
		contentPane.add(btnLevel4);

		btnLevel5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel5.setBounds(660, 155, 80, 80);
		contentPane.add(btnLevel5);

		btnLevel6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel6.setBounds(260, 255, 80, 80);
		contentPane.add(btnLevel6);

		btnLevel7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel7.setBounds(360, 255, 80, 80);
		contentPane.add(btnLevel7);

		btnLevel8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel8.setBounds(460, 255, 80, 80);
		contentPane.add(btnLevel8);

		btnLevel9.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel9.setBounds(560, 255, 80, 80);
		contentPane.add(btnLevel9);

		btnLevel10.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel10.setBounds(660, 255, 80, 80);
		contentPane.add(btnLevel10);

		btnLevel11.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel11.setBounds(260, 355, 80, 80);
		contentPane.add(btnLevel11);

		btnLevel12.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel12.setBounds(360, 355, 80, 80);
		contentPane.add(btnLevel12);

		btnLevel13.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel13.setBounds(460, 355, 80, 80);
		contentPane.add(btnLevel13);

		btnLevel14.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel14.setBounds(560, 355, 80, 80);
		contentPane.add(btnLevel14);

		btnLevel15.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel15.setBounds(660, 355, 80, 80);
		contentPane.add(btnLevel15);
		
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
		File file = new File(path);
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

			lvlStars[i] = new JLabel("");
			lvlStars[i].setIcon(new ImageIcon(LevelSelect.class.getResource(icon)));
			if(j > 4){
				j = 0;
			}
			if (i < 5) {
				lvlStars[i].setBounds(277 + (j*100), 234, 46, 14);
			}
			if (i >= 5 && i < 10) {
				lvlStars[i].setBounds(277  + (j*100), 334, 46, 14);
			}
			if (i >= 10 && i < 15) {
				lvlStars[i].setBounds(277  + (j*100), 434, 46, 14);
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

		btnLevel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LoadPuzzleLevel temp = new LoadPuzzleLevel("Level 1", new Puzzle("Level 1", new Board()));
					temp.loadPuzzle();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});

		btnLevel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoadLightningLevel temp;
				try {
					temp = new LoadLightningLevel("Level 2", new Lightning("Level 2", new Board()));
					temp.loadLightning();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				dispose();
			}
		});
		btnLevel3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ThemeView temp = new ThemeView();
				temp.setVisible(true);
				dispose();
			}
		});

		btnLevel4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LoadPuzzleLevel temp = new LoadPuzzleLevel("Level 4", new Puzzle("Level 4", new Board()));
					temp.loadPuzzle();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});

		btnLevel5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoadLightningLevel temp;
				try {
					temp = new LoadLightningLevel("Level 5", new Lightning("Level 5", new Board()));
					temp.loadLightning();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				dispose();
			}
		});
		btnLevel6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ThemeView temp = new ThemeView();
				temp.setVisible(true);
				dispose();
			}
		});

		btnLevel7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LoadPuzzleLevel temp = new LoadPuzzleLevel("Level 7", new Puzzle("Level 7", new Board()));
					temp.loadPuzzle();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});

		btnLevel8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoadLightningLevel temp;
				try {
					temp = new LoadLightningLevel("Level 8", new Lightning("Level 8", new Board()));
					temp.loadLightning();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				dispose();
			}
		});
		btnLevel9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ThemeView temp = new ThemeView();
				temp.setVisible(true);
				dispose();
			}
		});

		btnLevel10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LoadPuzzleLevel temp = new LoadPuzzleLevel("Level 10", new Puzzle("Level 10", new Board()));
					temp.loadPuzzle();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});

		btnLevel11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoadLightningLevel temp;
				try {
					temp = new LoadLightningLevel("Level 11", new Lightning("Level 11", new Board()));
					temp.loadLightning();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				dispose();
			}
		});
		btnLevel12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ThemeView temp = new ThemeView();
				temp.setVisible(true);
				dispose();
			}
		});

		btnLevel13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LoadPuzzleLevel temp = new LoadPuzzleLevel("Level 13", new Puzzle("Level 13", new Board()));
					temp.loadPuzzle();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});

		btnLevel14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoadLightningLevel temp;
				try {
					temp = new LoadLightningLevel("Level 14", new Lightning("Level 14", new Board()));
					temp.loadLightning();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				dispose();
			}
		});

		btnLevel15.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				ThemeView temp = new ThemeView();
				temp.setVisible(true);
				dispose();
			}
		});
	}

}
