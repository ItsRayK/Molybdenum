package player;

import java.awt.*;
import java.awt.event.*;

import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controllers.LetterClicked;
import controllers.LoadPuzzleLevel;
import controllers.SubmitWord;
import controllers.UndoManager;
import controllers.UpdateLevelSelectStars;
import entities.*;

/**
 * The Player class for Puzzle Levels.
 * <p>
 * This allows the player to play a Puzzle Level.
 * 
 * Creation date: (12/5/2016)
 * 
 * @author Thomas Hagen, Rachel Hahn, Rayyan Khan, Hannah Olshansky, Lauren
 *         Pontbriant (Molybdenum)
 * 
 */

public class PuzzleView extends JFrame {
	private ImageIcon starFilled, starEmpty;
	private JLabel lblScore, lblWordsLeft, lblNoMoreMoves;
	private JPanel contentPane;
	private JButton btnExitLevel;
	private JToggleButton[][] boardSquares;
	private JButton btnUndo, btnReset, btnSubmitWord;
	private JScrollPane spWordsFoundList;
	private JList words;
	private DefaultListModel wordsFound;
	private JLabel starimg1, starimg2, starimg3, starimg4, starimg5, starimg6;
	Score oneStarScore, twoStarScore, threeStarScore;
	String name;
	Puzzle level;
	LoadPuzzleLevel lpl;
	int i, j;

	public PuzzleView(String n, Puzzle p) {
		this.name = n;
		this.level = p;
	}

	/**
	 * Launch the application.
	 */
	public static void Puzzle(Puzzle level) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					PuzzleView frame = new PuzzleView("default", level);
					frame.initialize();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setLevel(Puzzle p) {
		level = p;
	}

	/**
	 * Create the frame.
	 */
	public void initialize() {
		initializeModel();
		initializeView();
		initializeController();
	}

	/**
	 * Initialize everything that will be added to the JPanel.
	 */
	public void initializeModel() {
		Puzzle p = this.level;
		PuzzleView pV = this;
		setTitle("Letter Craze");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1000, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNoMoreMoves = new JLabel("No Moves Left!", SwingConstants.CENTER);
		lblNoMoreMoves.setFont(new Font("Gill Sans MT", Font.BOLD, 30));
		lblNoMoreMoves.setBounds(442, 100, 300, 35);
		lblNoMoreMoves.setForeground(Color.WHITE);
		lblNoMoreMoves.setBackground(Color.GRAY);
		lblNoMoreMoves.setVisible(false);
		lblNoMoreMoves.setOpaque(false);
		contentPane.add(lblNoMoreMoves);
		
		boardSquares = new JToggleButton[6][6];

		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {

				Letter l = new Letter();
				l.randomLetter();
				if (level.getBoard().squares[i][j].isActive()) {
					level.getBoard().squares[i][j].fillSquare(l);

					boardSquares[i][j] = new JToggleButton("<html><b>" + l.getString() + "</b><font size = '3'><sub>"
							+ l.getScore() + "</sub></font></html>");

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
			}
		}

		btnUndo = new JButton("");
		spWordsFoundList = new JScrollPane();
		btnExitLevel = new JButton("Exit Level");
		btnReset = new JButton("Reset");
		btnSubmitWord = new JButton("Submit Word");
		lblScore = new JLabel("Score: " + p.getCurrentWord().getPoints());
		

	}

	/**
	 * Initialize where everything will be placed in the JPanel.
	 */
	public void initializeView() {
		
		
		btnUndo.setIcon(new ImageIcon(PuzzleView.class.getResource("/images/undo-4-xxl.gif")));
		btnUndo.setBounds(913, 127, 40, 40);
		btnUndo.setFocusPainted(false);
		contentPane.add(btnUndo);

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

		JLabel lblWordsFound = new JLabel("Words Found");
		lblWordsFound.setHorizontalAlignment(SwingConstants.CENTER);
		lblWordsFound.setFont(new Font("Gill Sans MT", Font.BOLD, 19));
		lblWordsFound.setBounds(141, 82, 226, 31);
		contentPane.add(lblWordsFound);

		lblScore.setFont(new Font("Gill Sans MT", Font.BOLD, 20));
		lblScore.setBounds(141, 411, 150, 31);
		contentPane.add(lblScore);

		JLabel lblPuzzle = new JLabel("Puzzle: " + name);
		lblPuzzle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuzzle.setFont(new Font("Gill Sans MT", Font.BOLD, 24));
		lblPuzzle.setBounds(392, 34, 400, 37);
		contentPane.add(lblPuzzle);

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

		btnExitLevel.setBounds(24, 82, 89, 23);
		btnExitLevel.setFocusPainted(false);
		contentPane.add(btnExitLevel);

		btnReset.setBounds(24, 136, 89, 23);
		btnReset.setFocusPainted(false);
		contentPane.add(btnReset);

		btnSubmitWord.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSubmitWord.setBounds(797, 127, 106, 40);
		btnSubmitWord.setFocusPainted(false);
		contentPane.add(btnSubmitWord);

		lblWordsLeft = new JLabel("Moves Left: " + level.getWordLimit());
		lblWordsLeft.setBounds(141, 453, 200, 31);
		lblWordsLeft.setFont(new Font("Gill Sans MT", Font.BOLD, 19));
		contentPane.add(lblWordsLeft);

		JLabel gridimg = new JLabel("");
		gridimg.setIcon(new ImageIcon(PuzzleView.class.getResource("/images/Grid.gif")));
		gridimg.setBounds(392, 82, 400, 400);
		contentPane.add(gridimg);

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(PuzzleView.class.getResource("/images/BackgroundBlank.gif")));
		bg.setBounds(0, 0, 984, 531);
		contentPane.add(bg);

	}

	public JToggleButton[][] getBoardSquares() {
		return boardSquares;
	}

	public Puzzle getLevel() {
		return level;
	}

	public JButton getBtnSubmitWord() {
		return btnSubmitWord;
	}

	public JButton getBtnUndo() {
		return btnUndo;
	}

	public JButton getBtnExitLevel() {
		return btnExitLevel;
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	/**
	 * Sets all buttons to unselected.
	 */
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

	/**
	 * Add given string to array of words found.
	 * @param s String to add to array
	 */
	public void addToWordsFound(String s) {
		wordsFound.addElement(s);
	}

	/**
	 * Remove last word in the array.
	 */
	public void removeFromWordsFound() {
		wordsFound.remove(wordsFound.size() - 1);
	}

	/**
	 * Sets stars as visiable depending on the player's score
	 */
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

	/**
	 * Initialize what happens when buttons on the JPanel are pressed.
	 */
	public void initializeController() {
		Puzzle p = this.level;
		PuzzleView pV = this;

		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNoMoreMoves.setVisible(false);
				lblNoMoreMoves.setOpaque(false);
				UndoManager undo = new UndoManager(pV, p);
				undo.undoLevel();
				lblWordsLeft.setText("Moves Left: " + level.getWordLimit());
				System.out.println("Actual Score: " + p.getCurrScore().getScore());
				lblScore.setText("Score: " + p.getCurrScore().getScore());
				if (p.getWordLimit() > 0) {
					for (int i = 0; i < 6; i++) {
						for (int j = 0; j < 6; j++) {
							if (p.getBoard().squares[i][j].isActive()) {
								pV.boardSquares[i][j].setEnabled(true);
								btnSubmitWord.setEnabled(true);
							}
						}
					}
				}
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

		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LoadPuzzleLevel temp = new LoadPuzzleLevel(name, new Puzzle(name, new Board()));
					temp.loadPuzzle();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});

		btnSubmitWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SubmitWord submitWord = new SubmitWord(pV, p, p.getCurrentWord());

				try {
					boolean sw = submitWord.submit();
					if (sw == false) {
						p.setCurrScore(new Score(p.getCurrentWord().getPoints()
								- (p.getCurrentWord().getPoints() - p.getCurrScore().getScore())));
						System.out.println("submit() returned false");
					}

					p.getCurrentWord().setPoints(-p.getCurrentWord().getPoints());
					p.setCurrScore(p.getCurrScore());

					lblWordsLeft.setText("Moves Left: " + level.getWordLimit());
					System.out.println("Actual Score: " + p.getCurrScore().getScore());
					lblScore.setText("Score: " + p.getCurrScore().getScore());

					System.out.println(p.getCurrScore().getScore());
					if (p.getWordLimit() == 0) {
						lblNoMoreMoves.setVisible(true);
						lblNoMoreMoves.setOpaque(true);
						btnSubmitWord.setEnabled(false);
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
}
