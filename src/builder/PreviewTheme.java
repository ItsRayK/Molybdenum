package builder;

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

/**
 * The Builder class for previewing Theme Levels.
 * <p>
 * This allows the user to preview a level of type Theme after they created it
 * without exiting the Builder and running the Player.
 * 
 * Creation date: (12/5/2016)
 * 
 * @author Thomas Hagen, Rachel Hahn, Rayyan Khan, Hannah Olshansky, Lauren
 *         Pontbriant (Molybdenum)
 * 
 */

public class PreviewTheme extends JFrame {

	private JPanel contentPane;
	private JToggleButton[][] boardSquares;
	private ImageIcon starFilled, starEmpty;
	private JLabel starimg1, starimg2, starimg3, starimg4, starimg5, starimg6;
	Score oneStarScore, twoStarScore, threeStarScore;
	private DefaultListModel wordsFound;
	private JScrollPane spWordsFoundList;
	private JList words;
	private JButton btnExitLevel, btnSubmitWord, btnGiveUp, btnUndo;
	private JLabel lblTheme, lblWordsLeft;
	String name;
	Theme level;
	ThemeBuilder lb;

	/**
	 * Launch the application.
	 */
	public static void Theme(Theme level) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					PreviewTheme frame = new PreviewTheme("default", level, lb);
//					frame.initialize();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PreviewTheme(String n, Theme t, ThemeBuilder tb) {
		this.name = n;
		this.level = t;
		this.lb = tb;
		initialize();

	}

	public void initialize() {
		initializeModel();
		initializeView();
		initializeController();
	}

	/**
	 * Initialize everything that will be added to the JPanel.
	 */
	private void initializeModel() {
		Theme p = this.level;
		PreviewTheme pV = this;

		setTitle("Letter Craze");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		boardSquares = new JToggleButton[6][6];
		String path = "savedLevels/" + level.getLevelName() + ".txt";
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				if (level.getBoard().squares[i][j].isActive()) {
					if(!lb.getLetterField()[i][j].getText().equals("")){
					boardSquares[i][j] = new JToggleButton("<html><b>" + lb.getLetterField()[i][j].getText().toUpperCase() + "</b></font></html>");
					}
					else{
						Letter l = new Letter();
						l.randomLetterNoPoints();
						boardSquares[i][j] = new JToggleButton("<html><b>" + l.getLetterString() + "</b></font></html>");
					}
					boardSquares[i][j].setFont(new Font("Tahoma", Font.PLAIN, 18));
					boardSquares[i][j].setBounds(396 + i * 66, 86 + j * 66, 60, 60);
					boardSquares[i][j].setFocusPainted(false);
					contentPane.add(boardSquares[i][j]);
				}
			}
		}
		
		btnUndo = new JButton("");
		btnExitLevel = new JButton("Exit Level");
		btnGiveUp = new JButton("Reset");
		btnSubmitWord = new JButton("Submit Word");

		lblTheme = new JLabel("Theme: " + level.getThemeName());
		lblWordsLeft = new JLabel("Words Left: " + level.getWordLimit());

	}

	/**
	 * Initialize where everything will be placed in the JPanel.
	 */
	private void initializeView() {
		Theme p = this.level;
		PreviewTheme pV = this;

		btnUndo.setIcon(new ImageIcon(PreviewTheme.class.getResource("/images/undo-4-xxl.gif")));
		btnUndo.setBounds(913, 127, 40, 40);
		contentPane.add(btnUndo);

		////// STAR IMAGES//////
		starFilled = new ImageIcon(PreviewTheme.class.getResource("/images/starlevelFilled.png"));
		starEmpty = new ImageIcon(PreviewTheme.class.getResource("/images/starlevel.png"));

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
		label.setIcon(new ImageIcon(PreviewTheme.class.getResource("/images/Grid.gif")));
		label.setBounds(392, 82, 400, 400);
		contentPane.add(label);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(PreviewTheme.class.getResource("/images/BackgroundBlank.gif")));
		label_1.setBounds(0, 0, 984, 531);
		contentPane.add(label_1);

	}

	/**
	 * Initialize what happens when buttons on JPanel are pressed.
	 */
	private void initializeController() {
		Theme p = this.level;
		PreviewTheme pV = this;
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		btnGiveUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}

		});

		btnExitLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		btnSubmitWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}

		});

	}

	public JToggleButton[][] getBoardSquares() {
		return boardSquares;
	}

	public void setLevel(Theme p) {
		level = p;
	}

	/**
	 * Add given string to array of words found.
	 * @param s Given string to add to array
	 */
	public void addToWordsFound(String s) {
		wordsFound.addElement(s);
	}

	/**
	 * Remove given last word from array of words found
	 */
	public void removeFromWordsFound() {
		wordsFound.remove(wordsFound.size() - 1);
	}

	/**'
	 * Update number of stars based on the current score.
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
	 * Unselect all button squares that were selected.
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

}
