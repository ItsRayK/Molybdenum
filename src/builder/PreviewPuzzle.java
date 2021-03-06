package builder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controllers.LoadPuzzleLevel;
import entities.*;

/**
 * The Builder class for previewing Puzzle Levels.
 * <p>
 * This allows the user to preview a level of type Puzzle after they created it
 * without exiting the Builder and running the Player.
 * 
 * Creation date: (12/5/2016)
 * 
 * @author Thomas Hagen, Rachel Hahn, Rayyan Khan, Hannah Olshansky, Lauren
 *         Pontbriant (Molybdenum)
 * 
 */

public class PreviewPuzzle extends JFrame {
	private JPanel contentPane;
	private JButton btnExitLevel;
	private JToggleButton boardSquares[][];
	private JButton btnUndo, btnGiveUp, btnSubmitWord;
	private JScrollPane spWordsFoundList;
	Score oneStarScore, twoStarScore, threeStarScore;
	String name;
	Puzzle level;
	LoadPuzzleLevel lpl;

	public PreviewPuzzle(String n, Puzzle p, Score oneStarScore, Score twoStarScore, Score threeStarScore) {
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

					PreviewPuzzle frame = new PreviewPuzzle("default", level, null, null, null);
//					frame.initialize();
//					frame.setVisible(true);
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
	 * Create the Frame.
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
		setTitle("Letter Craze");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// column and row are 0 index
		// level.getBoard().deActivateSquare(3, 5);
		// level.getBoard().deActivateSquare(2, 1);
				
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {

				Letter l = new Letter();
				l.randomLetter();
				if (level.getBoard().squares[i][j].isActive()) {
					boardSquares = new JToggleButton[6][6];
					boardSquares[i][j] = new JToggleButton("<html><b>" + l.getString() + "</b><font size = '3'><sub>"
							+ l.getScore() + "</sub></font></html>");
					boardSquares[i][j].setFont(new Font("Tahoma", Font.PLAIN, 18));
					boardSquares[i][j].setBounds(396 + i * 66, 86 + j * 66, 60, 60);
					contentPane.add(boardSquares[i][j]);

				}
			}
		}

		btnUndo = new JButton("");
		spWordsFoundList = new JScrollPane();
		btnExitLevel = new JButton("Exit Level");
		btnGiveUp = new JButton("Reset");
		btnSubmitWord = new JButton("Submit Word");

	}

	/**
	 * Initialize where everything will be placed in the JPanel.
	 */
	public void initializeView() {

		btnUndo.setIcon(new ImageIcon(PreviewPuzzle.class.getResource("/images/undo-4-xxl.gif")));
		btnUndo.setBounds(913, 127, 40, 40);
		contentPane.add(btnUndo);

		spWordsFoundList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spWordsFoundList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spWordsFoundList.setBounds(141, 116, 226, 284);
		contentPane.add(spWordsFoundList);

		JLabel lblWordsFound = new JLabel("Words Found");
		lblWordsFound.setHorizontalAlignment(SwingConstants.CENTER);
		lblWordsFound.setFont(new Font("Gill Sans MT", Font.BOLD, 19));
		lblWordsFound.setBounds(141, 82, 226, 31);
		contentPane.add(lblWordsFound);

		JLabel lblScore = new JLabel("Score:");
		lblScore.setFont(new Font("Gill Sans MT", Font.BOLD, 19));
		lblScore.setBounds(141, 411, 66, 31);
		contentPane.add(lblScore);

		JLabel lblPuzzle = new JLabel("Puzzle: " + name);
		lblPuzzle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuzzle.setFont(new Font("Gill Sans MT", Font.BOLD, 24));
		lblPuzzle.setBounds(392, 34, 400, 37);
		contentPane.add(lblPuzzle);

		////// STAR IMAGES//////

		JLabel starimg1 = new JLabel("");
		starimg1.setBounds(797, 217, 90, 90);
		starimg1.setIcon(new ImageIcon(PreviewPuzzle.class.getResource("/images/starlevel.png")));
		contentPane.add(starimg1);

		JLabel starimg2 = new JLabel("");
		starimg2.setBounds(797, 302, 90, 90);
		starimg2.setIcon(new ImageIcon(PreviewPuzzle.class.getResource("/images/starlevel.png")));
		contentPane.add(starimg2);

		JLabel starimg3 = new JLabel("");
		starimg3.setBounds(797, 387, 90, 90);
		starimg3.setIcon(new ImageIcon(PreviewPuzzle.class.getResource("/images/starlevel.png")));
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
		gridimg.setIcon(new ImageIcon(PreviewPuzzle.class.getResource("/images/Grid.gif")));
		gridimg.setBounds(392, 82, 400, 400);
		contentPane.add(gridimg);

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(PreviewPuzzle.class.getResource("/images/BackgroundBlank.gif")));
		bg.setBounds(0, 0, 984, 531);
		contentPane.add(bg);

	}

	/**
	 * Initialize what happens when buttons on JPanel are pressed.
	 */
	public void initializeController() {
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		btnExitLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});

		btnGiveUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}

}
