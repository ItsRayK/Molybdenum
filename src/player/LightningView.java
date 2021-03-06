package player;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controllers.LetterClicked;
import controllers.SubmitWord;
import controllers.SubmitWordLightning;
import controllers.UpdateLevelSelectStars;
import entities.Letter;
import entities.Square;
import entities.Lightning;
import entities.Puzzle;
import entities.Score;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The Player class for Lightning Levels.
 * <p>
 * This allows the player to play a Lightning Level.
 * 
 * Creation date: (12/5/2016)
 * 
 * @author Thomas Hagen, Rachel Hahn, Rayyan Khan, Hannah Olshansky, Lauren
 *         Pontbriant (Molybdenum)
 * 
 */

public class LightningView extends JFrame {
	private JPanel contentPane;
	private JButton btnExitLevel, btnReset, btnSubmitWord;
	private JToggleButton boardSquares[][];
	private JScrollPane spWordsFoundList;
	private JList words;
	private DefaultListModel wordsFound;
	private ImageIcon starFilled, starEmpty;
	Square[][] squares = new Square[6][6];
	private JLabel starimg1, starimg2, starimg3, starimg4, starimg5, starimg6;
	JLabel lblTimeLeft, lblTimeIsUp, lblScore, lblTimeUp;
	String name;
	Lightning level;
	int timer;
	Timer count;

	public LightningView(String n, Lightning l) {
		name = n;
		level = l;

	}

	/**
	 * Launch the application.
	 */
	public static void Lightning(Lightning level) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					LightningView frame = new LightningView("default", level);
					frame.initialize();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setLevel(Lightning l) {
		level = l;
	}

	/**
	 * Create the frame.
	 */

	public void initialize() {
		initializeModel();
		loadTimer();
		initializeView();
		initializeController();
		count.start();
	}

	/**
	 * Initialize everything that will be added to the JPanel.
	 */
	private void initializeModel() {

		setTitle("Letter Craze");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1000, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnExitLevel = new JButton("Exit Level");
		btnReset = new JButton("Reset");
		btnSubmitWord = new JButton("Submit Word");

		lblTimeUp = new JLabel("Time's Up!", SwingConstants.CENTER);
		lblTimeUp.setFont(new Font("Gill Sans MT", Font.BOLD, 30));
		lblTimeUp.setBounds(442, 100, 300, 35);
		lblTimeUp.setForeground(Color.WHITE);
		lblTimeUp.setBackground(Color.GRAY);
		lblTimeUp.setVisible(false);
		lblTimeUp.setOpaque(false);
		contentPane.add(lblTimeUp);

		createGrid();

	}

	/**
	 * Initialize where everything will be placed in the JPanel.
	 */
	private void initializeView() {
		Lightning l = this.level;

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

		JTextArea txtTimeResetNote = new JTextArea();
		txtTimeResetNote.setBounds(24, 159, 89, 68);
		txtTimeResetNote.setBackground(Color.LIGHT_GRAY);
		txtTimeResetNote.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		txtTimeResetNote.setText("Note: The time\r\nwill continue to\r\ncountdown on\r\nreset.");
		txtTimeResetNote.setEditable(false);
		contentPane.add(txtTimeResetNote);

		lblTimeLeft = new JLabel("Time Left: " + timer);
		lblTimeLeft.setBounds(141, 453, 200, 31);
		lblTimeLeft.setFont(new Font("Gill Sans MT", Font.BOLD, 19));
		contentPane.add(lblTimeLeft);

		JLabel gridImg = new JLabel("");
		gridImg.setBounds(392, 82, 400, 400);
		gridImg.setIcon(new ImageIcon(LightningView.class.getResource("/images/Grid.gif")));
		contentPane.add(gridImg);

		JLabel lblLightning = new JLabel("Lightning: " + level.getLevelName());
		lblLightning.setBounds(392, 34, 400, 37);
		lblLightning.setHorizontalAlignment(SwingConstants.CENTER);
		lblLightning.setFont(new Font("Gill Sans MT", Font.BOLD, 24));
		contentPane.add(lblLightning);

		spWordsFoundList = new JScrollPane();
		spWordsFoundList.setBounds(141, 116, 226, 284);
		spWordsFoundList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spWordsFoundList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		// contentPane.add(spWordsFoundList);
		wordsFound = new DefaultListModel();
		words = new JList(wordsFound);
		spWordsFoundList = new JScrollPane(words, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		// spWordsFoundList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// spWordsFoundList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spWordsFoundList.setBounds(141, 116, 226, 284);
		contentPane.add(spWordsFoundList);

		JLabel lblWordsFound = new JLabel("Words Found");
		lblWordsFound.setBounds(141, 82, 226, 31);
		lblWordsFound.setHorizontalAlignment(SwingConstants.CENTER);
		lblWordsFound.setFont(new Font("Gill Sans MT", Font.BOLD, 19));
		contentPane.add(lblWordsFound);

		lblScore = new JLabel("Score: " + l.getCurrScore().getScore());
		lblScore.setBounds(141, 411, 150, 31);
		lblScore.setFont(new Font("Gill Sans MT", Font.BOLD, 19));
		contentPane.add(lblScore);

		JLabel bg = new JLabel("");
		bg.setBounds(0, 0, 984, 531);
		bg.setIcon(new ImageIcon(LightningView.class.getResource("/images/BackgroundBlank.gif")));
		contentPane.add(bg);

	}

	/**
	 * Initialize what happens when buttons on the JPanel are pressed.
	 */
	private void initializeController() {
		Lightning l = this.level;
		LightningView lV = this;

		btnExitLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateLevelSelectStars updateStars = new UpdateLevelSelectStars(l);
				try {
					count.stop();
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
			public void actionPerformed(ActionEvent e) {
				level.clearBoardLetters();
				level.fillEmptyWithRandomLetters();
				for (int i = 0; i <= 5; i++) {
					for (int j = 0; j <= 5; j++) {
						if (level.getBoard().squares[i][j].isActive()) {
							boardSquares[i][j].setText("<html><b>" + level.getBoard().squares[i][j].getContentsString()
									+ "</b><font size = '3'><sub>" + level.getBoard().squares[i][j].getContentsPoints()
									+ "</sub></font></html>");
						}
					}
				}
				clearWordsFound();
				l.setCurrScore(new Score(0));
				System.out.println(l.getCurrScore().getScore());
				unselectBoardSquares();
				lblScore.setText("Score: " + l.getCurrScore().getScore());
				updateStars();
			}
		});

		btnSubmitWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SubmitWordLightning submitWord = new SubmitWordLightning(lV, l, l.getCurrentWord());

				try {
					if (submitWord.submit() == false) {
						l.setCurrScore(new Score(l.getCurrentWord().getPoints()
								- (l.getCurrentWord().getPoints() - l.getCurrScore().getScore())));
						System.out.println("submit() returned false");
					}

					l.getCurrentWord().setPoints(-l.getCurrentWord().getPoints());
					l.setCurrScore(l.getCurrScore());
					System.out.println("Actual Score: " + l.getCurrScore().getScore());
					lblScore.setText("Score: " + l.getCurrScore().getScore());

					System.out.println(l.getCurrScore().getScore());

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
	}

	/**
	 * Set the timer based on created level and count down
	 */
	private void loadTimer() {
		timer = level.getTimer();
		Lightning l = this.level;
		LightningView lV = this;
		count = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timer--;
				if (timer <= 10) {
					lblTimeLeft.setForeground(Color.red);
				}
				lblTimeLeft.setText("Time Left: " + timer);
				if (timer == 0) {
					count.stop();

					lblTimeUp.setVisible(true);
					lblTimeUp.setOpaque(true);
					btnSubmitWord.setEnabled(false);
					for (int i = 0; i < 6; i++) {
						for (int j = 0; j < 6; j++) {
							if (l.getBoard().squares[i][j].isActive()) {
								lV.boardSquares[i][j].setEnabled(false);
							}
						}
					}

				}
			}
		});
	}

	public JToggleButton[][] getBoardSquares() {
		return boardSquares;
	}

	/**
	 * Add given string to array of words found.
	 * 
	 * @param s
	 *            String to add to array
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
	 * Remove all words from the array
	 */
	public void clearWordsFound() {
		wordsFound.clear();
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
	 * Creates the board of squares for the player to create words with.
	 */
	private void createGrid() {
		Lightning li = this.level;
		LightningView lV = this;
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

					final Square square = li.getBoard().squares[i][j];
					JToggleButton buttonSquares = boardSquares[i][j];
					boardSquares[i][j].addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent arg0) {
							LetterClicked letterClicked = new LetterClicked(li, square);
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

							System.out.println(li.getCurrentWord().getWordString());
							System.out.println("Running score: " + li.getCurrentWord().getPoints());
						}

					});

					contentPane.add(boardSquares[i][j]);

				}
			}
		}
	}

	public JButton getBtnExitLevel() {
		return btnExitLevel;
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	public JButton getBtnSubmitWord() {
		return btnSubmitWord;
	}

	public Lightning getLevel() {
		return level;
	}
}
