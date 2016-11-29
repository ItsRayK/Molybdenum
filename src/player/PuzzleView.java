package player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import entities.*;

public class PuzzleView extends JFrame {
	private JPanel contentPane;
	private JButton btnExitLevel;
	Square[][] squares = new Square[6][6];

	/**
	 * Launch the application.
	 */
	public static void Puzzle() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PuzzleView frame = new PuzzleView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PuzzleView() {
		initialize();
	}

	public void initialize() {
		initEntities();
		initView();
		initControllers();
	}

	public void initEntities() {
		// for (int i = 0; i <= 5; i++) {
		// for (int j = 0; j <= 5; j++) {
		// Letter r = new Letter();
		// r.randomLetter();
		// squares[i][j].fillSquare(r);
		// }
		// }

	}

	public void initView() {
		setTitle("Letter Craze");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setIcon(new ImageIcon(PuzzleView.class.getResource("/images/undo-4-xxl.gif")));
		button.setBounds(913, 127, 40, 40);
		contentPane.add(button);

		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				Letter l = new Letter();
				l.randomLetter();

				JButton boardSquares[][] = new JButton[6][6];
				boardSquares[i][j] = new JButton("<html><b>"+l.getString() +"</b><font size = '3'><sub>" +  l.getScore() +"</sub></font></html>");
				boardSquares[i][j].setFont(new Font("Tahoma", Font.PLAIN, 18));
				boardSquares[i][j].setBounds(396 + i * 66, 86 + j * 66, 60, 60);
				contentPane.add(boardSquares[i][j]);

			}
		}

		JLabel label_3 = new JLabel("");
		label_3.setBounds(797, 217, 90, 90);
		label_3.setIcon(new ImageIcon(PuzzleView.class.getResource("/images/starlevel.png")));
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("");
		label_4.setBounds(797, 302, 90, 90);
		label_4.setIcon(new ImageIcon(PuzzleView.class.getResource("/images/starlevel.png")));
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("");
		label_5.setBounds(797, 387, 90, 90);
		label_5.setIcon(new ImageIcon(PuzzleView.class.getResource("/images/starlevel.png")));
		contentPane.add(label_5);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PuzzleView.class.getResource("/images/Grid.gif")));
		label.setBounds(392, 82, 400, 400);
		contentPane.add(label);

		JLabel lblPuzzle = new JLabel("Puzzle");
		lblPuzzle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuzzle.setFont(new Font("Gill Sans MT", Font.BOLD, 24));
		lblPuzzle.setBounds(392, 34, 400, 37);
		contentPane.add(lblPuzzle);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(141, 116, 226, 284);
		contentPane.add(scrollPane);

		JLabel lblWordsFound = new JLabel("Words Found");
		lblWordsFound.setHorizontalAlignment(SwingConstants.CENTER);
		lblWordsFound.setFont(new Font("Gill Sans MT", Font.BOLD, 19));
		lblWordsFound.setBounds(141, 82, 226, 31);
		contentPane.add(lblWordsFound);

		JLabel lblScore = new JLabel("Score:");
		lblScore.setFont(new Font("Gill Sans MT", Font.BOLD, 19));
		lblScore.setBounds(141, 411, 66, 31);
		contentPane.add(lblScore);

		btnExitLevel = new JButton("Exit Level");

		btnExitLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LevelSelect levelSelect = new LevelSelect();
				levelSelect.setVisible(true);
				dispose();
			}
		});
		btnExitLevel.setBounds(24, 82, 89, 23);
		contentPane.add(btnExitLevel);

		JButton btnGiveUp = new JButton("Reset");
		btnGiveUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PuzzleView temp = new PuzzleView();
				temp.setVisible(true);
				dispose();
			}
		});
		btnGiveUp.setBounds(24, 136, 89, 23);
		contentPane.add(btnGiveUp);

		JButton btnSubmitWord = new JButton("Submit Word");
		btnSubmitWord.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSubmitWord.setBounds(797, 127, 106, 40);
		contentPane.add(btnSubmitWord);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(PuzzleView.class.getResource("/images/BackgroundBlank.gif")));
		label_1.setBounds(0, 0, 984, 531);
		contentPane.add(label_1);

	}

	public void initControllers() {

	}

}
