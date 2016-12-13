package player;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controllers.LetterClicked;
import controllers.LoadPuzzleLevel;
import controllers.LoadThemeLevel;
import controllers.SubmitWord;
import controllers.SubmitWordTheme;
import controllers.UndoManager;
import controllers.UpdateLevelSelectStars;
import entities.*;
import player.LevelSelect;

public class ThemeView extends JFrame {

	private JPanel contentPane;
	private JToggleButton[][] boardSquares;
	private ImageIcon starFilled, starEmpty;
	private JLabel starimg1, starimg2, starimg3, starimg4, starimg5, starimg6;
	Score oneStarScore, twoStarScore, threeStarScore;
	private DefaultListModel wordsFound;
	private JScrollPane spWordsFoundList;
	private JList words;
	private JButton btnExitLevel, btnSubmitWord, btnGiveUp, btnUndo;
	private JLabel lblTheme, lblWordsLeft, lblCongrats;
	String name;
	Theme level;

	/**
	 * Launch the application.
	 */
	public static void Theme(Theme level) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemeView frame = new ThemeView("default", level);
					frame.initialize();
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
	public ThemeView(String n, Theme t) {
		this.name = n;
		this.level = t;
		initialize();

	}

	public void initialize() {
		initializeModel();
		initializeView();
		initializeController();
	}

	private void initializeModel() {
		Theme p = this.level;
		ThemeView pV = this;

		setTitle("Letter Craze");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1000, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblCongrats = new JLabel("Level Complete!", SwingConstants.CENTER);
		lblCongrats.setFont(new Font("Gill Sans MT", Font.BOLD, 30));
		lblCongrats.setBounds(442, 100, 300, 35);
		lblCongrats.setForeground(Color.WHITE);
		lblCongrats.setBackground(Color.GRAY);
		lblCongrats.setVisible(false);
		lblCongrats.setOpaque(false);
		contentPane.add(lblCongrats);
		
		
		boardSquares = new JToggleButton[6][6];
		String path = "savedLevels/" + level.getLevelName() + ".txt";
		int k = 42;
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {

				Letter l = new Letter();
				try {
					String readCheck = Files.readAllLines(Paths.get(path)).get(k);
					l.setLetter(readCheck, 0);
					if (level.getBoard().squares[i][j].isActive()) {
						if (readCheck.equals("null")) {
							l.randomLetterNoPoints();
						}
						level.getBoard().squares[i][j].fillSquare(l);

						boardSquares[i][j] = new JToggleButton("<html><b>" + l.getString() + "</b></font></html>");

						boardSquares[i][j].setFont(new Font("Tahoma", Font.PLAIN, 18));
						boardSquares[i][j].setBounds(396 + i * 66, 86 + j * 66, 60, 60);
						boardSquares[i][j].setFocusPainted(false);

						final Square square = p.getBoard().squares[i][j];
						JToggleButton buttonSquares = boardSquares[i][j];
						boardSquares[i][j].addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {
								LetterClicked letterClicked = new LetterClicked(p, square);
								boolean selected = buttonSquares.isSelected();
								if (!selected && level.getCurrentWord().getLastSquare().isSameSquare(square)) {
									letterClicked.deConstructWord();
								} else {
									if (level.getCurrentWord().getSquares().size() == 0) {
										letterClicked.constructWord();
									} else if ((level.getCurrentWord().getLastSquare().isAdjacentTo(square))
											&& !square.isAlreadyInList(level.getCurrentWord().getSquares())) {
										if (letterClicked.constructWord()) {
											letterClicked.constructWord();
										} else
											buttonSquares.setSelected(true);
									} else if (level.getCurrentWord().getSquares().contains(square))
										buttonSquares.setSelected(true);
									else
										buttonSquares.setSelected(false);
								}

								System.out.println(p.getCurrentWord().getWordString());
								System.out.println("Running score: " + p.getCurrentWord().getPoints());
							}

						});

						contentPane.add(boardSquares[i][j]);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				k++;

			}
		}

		btnUndo = new JButton("");
		btnExitLevel = new JButton("Exit Level");
		btnGiveUp = new JButton("Reset");
		btnSubmitWord = new JButton("Submit Word");

		lblTheme = new JLabel("Theme: " + level.getThemeName());
		lblWordsLeft = new JLabel("Words Left: " + level.getWordLimit());

	}

	private void initializeView() {
		Theme p = this.level;
		ThemeView pV = this;

		btnUndo.setIcon(new ImageIcon(ThemeView.class.getResource("/images/undo-4-xxl.gif")));
		btnUndo.setBounds(913, 127, 40, 40);
		contentPane.add(btnUndo);

		////// STAR IMAGES//////
		starFilled = new ImageIcon(PuzzleView.class.getResource("/images/starlevelFilled.png"));
		starEmpty = new ImageIcon(PuzzleView.class.getResource("/images/starlevel.png"));

		starimg1 = new JLabel("");
		starimg1.setBounds(797, 387, 90, 90);
		starimg1.setIcon(starEmpty);
		contentPane.add(starimg1);

		starimg4 = new JLabel("");
		starimg4.setBounds(797, 387, 90, 90);
		starimg4.setIcon(starFilled);
		contentPane.add(starimg4);

		starimg2 = new JLabel("");
		starimg2.setBounds(797, 302, 90, 90);
		starimg2.setIcon(starEmpty);
		contentPane.add(starimg2);

		starimg5 = new JLabel("");
		starimg5.setBounds(797, 302, 90, 90);
		starimg5.setIcon(starFilled);
		contentPane.add(starimg5);

		starimg3 = new JLabel("");
		starimg3.setBounds(797, 217, 90, 90);
		starimg3.setIcon(starEmpty);
		contentPane.add(starimg3);

		starimg6 = new JLabel("");
		starimg6.setBounds(797, 217, 90, 90);
		starimg6.setIcon(starFilled);
		contentPane.add(starimg6);
		///////////////////////////

		spWordsFoundList = new JScrollPane();
		spWordsFoundList.setBounds(141, 116, 226, 284);
		spWordsFoundList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spWordsFoundList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		// contentPane.add(spWordsFoundList);
		wordsFound = new DefaultListModel();
		words = new JList(wordsFound);
		// wordsFound.setEditable(false);
		spWordsFoundList = new JScrollPane(words, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		// spWordsFoundList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// spWordsFoundList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spWordsFoundList.setBounds(141, 116, 226, 284);
		contentPane.add(spWordsFoundList);

		lblTheme.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheme.setFont(new Font("Gill Sans MT", Font.BOLD, 24));
		lblTheme.setBounds(392, 34, 400, 37);
		contentPane.add(lblTheme);

		JLabel lblWordsFound = new JLabel("Words Found");
		lblWordsFound.setHorizontalAlignment(SwingConstants.CENTER);
		lblWordsFound.setFont(new Font("Gill Sans MT", Font.BOLD, 19));
		lblWordsFound.setBounds(141, 82, 226, 31);
		contentPane.add(lblWordsFound);

		lblWordsLeft.setFont(new Font("Gill Sans MT", Font.BOLD, 19));
		lblWordsLeft.setBounds(141, 411, 150, 31);
		contentPane.add(lblWordsLeft);

		btnExitLevel.setBounds(24, 82, 89, 23);
		btnExitLevel.setFocusPainted(false);
		contentPane.add(btnExitLevel);

		btnGiveUp.setBounds(24, 136, 89, 23);
		btnGiveUp.setFocusPainted(false);
		contentPane.add(btnGiveUp);

		btnSubmitWord.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSubmitWord.setBounds(797, 127, 106, 40);
		btnSubmitWord.setFocusPainted(false);
		contentPane.add(btnSubmitWord);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ThemeView.class.getResource("/images/Grid.gif")));
		label.setBounds(392, 82, 400, 400);
		contentPane.add(label);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ThemeView.class.getResource("/images/BackgroundBlank.gif")));
		label_1.setBounds(0, 0, 984, 531);
		contentPane.add(label_1);

	}

	private void initializeController() {
		Theme p = this.level;
		ThemeView pV = this;
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UndoManager undo = new UndoManager(pV, p);
				undo.undoLevelTheme();
				lblWordsLeft.setText("Words Left: " + level.getWordLimit());
				System.out.println("Actual Score: " + p.getCurrScore().getScore());
				if (p.getWordLimit() > 0) {
					for (int i = 0; i < 6; i++) {
						for (int j = 0; j < 6; j++) {
							if (p.getBoard().squares[i][j].isActive()) {
								pV.boardSquares[i][j].setEnabled(true);
							}
						}
					}
				}
			}
		});

		btnGiveUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LoadThemeLevel temp = new LoadThemeLevel(name, new Theme(name, new Board()));
					temp.loadTheme();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}

		});

		btnExitLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateLevelSelectStars updateStars = new UpdateLevelSelectStars(p);
				try {
					updateStars.updateSavedStars();
					updateStars.updateSavedScore();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				LevelSelect levelSelect = new LevelSelect();
				levelSelect.setVisible(true);
				dispose();
			}
		});

		btnSubmitWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SubmitWordTheme submitWord = new SubmitWordTheme(pV, p, p.getCurrentWord());

				try {
					boolean sw = submitWord.submit();
					if (sw == false) {
						p.setCurrScore(new Score(p.getCurrentWord().getPoints()
								- (p.getCurrentWord().getPoints() - p.getCurrScore().getScore())));
						System.out.println("submit() returned false");
					}

					p.getCurrentWord().setPoints(-p.getCurrentWord().getPoints());
					p.setCurrScore(p.getCurrScore());

					lblWordsLeft.setText("Words Left: " + level.getWordLimit());
					System.out.println("Actual Score: " + p.getCurrScore().getScore());

					System.out.println(p.getCurrScore().getScore());
					if (p.getWordLimit() == 0) {
						lblCongrats.setVisible(true);
						lblCongrats.setOpaque(true);
						for (int i = 0; i < 6; i++) {
							for (int j = 0; j < 6; j++) {
								if (p.getBoard().squares[i][j].isActive()) {
									pV.boardSquares[i][j].setEnabled(false);
								}
							}
						}
					} else {

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

	}

	public JToggleButton[][] getBoardSquares() {
		return boardSquares;
	}

	public void setLevel(Theme p) {
		level = p;
	}

	public void addToWordsFound(String s) {
		wordsFound.addElement(s);
	}

	public void removeFromWordsFound() {
		wordsFound.remove(wordsFound.size() - 1);
	}

	public void updateStars() {

		level.compareToGoalScores();

		if (level.getCurrScore().isStar1Filled()) {
			starimg1.setVisible(false);
			System.out.println("Star1");
		} else {
			starimg1.setVisible(true);
		}
		if (level.getCurrScore().isStar2Filled()) {
			starimg2.setVisible(false);
			System.out.println("Star2");
		} else {
			starimg2.setVisible(true);
		}
		if (level.getCurrScore().isStar3Filled()) {
			starimg3.setVisible(false);
			System.out.println("Star3");
		} else {
			starimg3.setVisible(true);
		}

	}

	public void unselectBoardSquares() {
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				JToggleButton buttonSquares = boardSquares[i][j];
				if (level.getBoard().squares[i][j].isActive()) {
					buttonSquares.setSelected(false);

				}
			}
		}
	}

	public JButton getBtnExitLevel() {
		return btnExitLevel;
	}

	public JButton getBtnGiveUp() {
		return btnGiveUp;
	}

	public JButton getBtnSubmitWord() {
		return btnSubmitWord;
	}

	public JButton getBtnUndo() {
		return btnUndo;
	}

}
