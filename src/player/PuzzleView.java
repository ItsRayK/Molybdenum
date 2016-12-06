package player;

import java.awt.*;
import java.awt.event.*;

import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controllers.LetterClicked;
import controllers.LoadPuzzleLevel;
import controllers.SubmitWord;
import entities.*;

public class PuzzleView extends JFrame {
	private JLabel lblScore;
	private JPanel contentPane;
	private JButton btnExitLevel;
	private JToggleButton[][] boardSquares;
	private JButton btnUndo, btnGiveUp, btnSubmitWord;
	private JScrollPane spWordsFoundList;
	private TextArea wordsFound;
	Score oneStarScore, twoStarScore, threeStarScore;
	String name;
	Puzzle level;
	LoadPuzzleLevel lpl;
	int i, j;

	public PuzzleView(String n, Puzzle p, Score oneStarScore, Score twoStarScore, Score threeStarScore) {
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

					PuzzleView frame = new PuzzleView("default", level, null, null, null);
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

	public void initialize() {
		initializeModel();
		initializeView();
		initializeController();
	}

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
									letterClicked.constructWord();
								} else if (square.isAlreadyInList(level.getCurrentWord().getSquares()))
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
		btnGiveUp = new JButton("Reset");
		btnSubmitWord = new JButton("Submit Word");
		lblScore = new JLabel("Score: " + this.level.getCurrentWord().getPoints());


	}

	public void initializeView() {

		btnUndo.setIcon(new ImageIcon(PuzzleView.class.getResource("/images/undo-4-xxl.gif")));
		btnUndo.setBounds(913, 127, 40, 40);
		contentPane.add(btnUndo);

		wordsFound = new TextArea();
		wordsFound.setEditable(false);
		spWordsFoundList = new JScrollPane(wordsFound, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
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
		lblScore.setBounds(141, 411, 200, 41);
		contentPane.add(lblScore);

		JLabel lblPuzzle = new JLabel("Puzzle: " + name);
		lblPuzzle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuzzle.setFont(new Font("Gill Sans MT", Font.BOLD, 24));
		lblPuzzle.setBounds(392, 34, 400, 37);
		contentPane.add(lblPuzzle);

		////// STAR IMAGES//////

		JLabel starimg1 = new JLabel("");
		starimg1.setBounds(797, 217, 90, 90);
		starimg1.setIcon(new ImageIcon(PuzzleView.class.getResource("/images/starlevel.png")));
		contentPane.add(starimg1);

		JLabel starimg2 = new JLabel("");
		starimg2.setBounds(797, 302, 90, 90);
		starimg2.setIcon(new ImageIcon(PuzzleView.class.getResource("/images/starlevel.png")));
		contentPane.add(starimg2);

		JLabel starimg3 = new JLabel("");
		starimg3.setBounds(797, 387, 90, 90);
		starimg3.setIcon(new ImageIcon(PuzzleView.class.getResource("/images/starlevel.png")));
		contentPane.add(starimg3);

		///////////////////////////

		btnExitLevel.setBounds(24, 82, 89, 23);
		contentPane.add(btnExitLevel);

		btnGiveUp.setBounds(24, 136, 89, 23);
		contentPane.add(btnGiveUp);

		btnSubmitWord.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSubmitWord.setBounds(797, 127, 106, 40);
		contentPane.add(btnSubmitWord);

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
	
	public void replaceBoardLetters(){
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				JToggleButton buttonSquares = boardSquares[i][j];
				if (level.getBoard().squares[i][j].isActive()) {
					buttonSquares.setSelected(false);

				}
			}
		}
	}

	public TextArea addToWordsFound(String s) {
		wordsFound.setText(wordsFound.getText() + s + "\n");
		return wordsFound;
	}

	public void initializeController() {
		Puzzle p = this.level;
		PuzzleView pV = this;

		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		btnExitLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LevelSelect levelSelect = new LevelSelect();
				levelSelect.setVisible(true);
				dispose();

			}
		});

		btnGiveUp.addActionListener(new ActionListener() {
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
					submitWord.submit();
					System.out.println("Actual Score: " + p.getCurrentWord().getPoints());
					lblScore.setText("Score: " + p.getCurrentWord().getPoints());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

	}
}
