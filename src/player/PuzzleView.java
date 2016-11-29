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
	public static void PuzzleView() {
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
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 6; j++) {
				Letter r = new Letter();
				r.randomLetter();
				squares[i][j].fillSquare(r);
			}
		}

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

		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 6; j++) {
				JButton boardSquares[][] = new JButton[6][6];
				boardSquares[i][j] = new JButton(squares[i][j].getContentsString());
				boardSquares[i][j].setFont(new Font("Tahoma", Font.PLAIN, 18));
				boardSquares[i][j].setBounds(330 + i * 66, 20 + j * 66, 60, 60);
				contentPane.add(boardSquares[i][j]);

			}
		}

		//
		// JButton btnL = new JButton("R");
		// btnL.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// btnL.setBounds(396, 86, 60, 60);
		// contentPane.add(btnL);
		//
		// JButton button_1 = new JButton("S");
		// button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_1.setBounds(462, 86, 60, 60);
		// contentPane.add(button_1);
		//
		// JButton button_2 = new JButton("T");
		// button_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_2.setBounds(594, 86, 60, 60);
		// contentPane.add(button_2);
		//
		// JButton button_3 = new JButton("L");
		// button_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_3.setBounds(528, 86, 60, 60);
		// contentPane.add(button_3);
		//
		// JButton button_4 = new JButton("N");
		// button_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_4.setBounds(661, 86, 60, 60);
		// contentPane.add(button_4);
		//
		// JButton button_5 = new JButton("E");
		// button_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_5.setBounds(727, 86, 60, 60);
		// contentPane.add(button_5);
		//
		// JButton button_6 = new JButton("O");
		// button_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_6.setBounds(396, 152, 60, 60);
		// contentPane.add(button_6);
		//
		// JButton button_7 = new JButton("P");
		// button_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_7.setBounds(462, 152, 60, 60);
		// contentPane.add(button_7);
		//
		// JButton button_8 = new JButton("R");
		// button_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_8.setBounds(528, 152, 60, 60);
		// contentPane.add(button_8);
		//
		// JButton button_9 = new JButton("P");
		// button_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_9.setBounds(594, 152, 60, 60);
		// contentPane.add(button_9);
		//
		// JButton button_10 = new JButton("E");
		// button_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_10.setBounds(661, 152, 60, 60);
		// contentPane.add(button_10);
		//
		// JButton button_11 = new JButton("F");
		// button_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_11.setBounds(727, 152, 60, 60);
		// contentPane.add(button_11);
		//
		// JButton button_12 = new JButton("G");
		// button_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_12.setBounds(396, 219, 60, 60);
		// contentPane.add(button_12);
		//
		// JButton button_13 = new JButton("Qu");
		// button_13.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_13.setBounds(462, 219, 60, 60);
		// contentPane.add(button_13);
		//
		// JButton button_16 = new JButton("L");
		// button_16.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_16.setBounds(661, 219, 60, 60);
		// contentPane.add(button_16);
		//
		// JButton button_17 = new JButton("K");
		// button_17.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_17.setBounds(727, 219, 60, 60);
		// contentPane.add(button_17);
		//
		// JButton button_18 = new JButton("E");
		// button_18.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_18.setBounds(396, 284, 60, 60);
		// contentPane.add(button_18);
		//
		// JButton button_19 = new JButton("U");
		// button_19.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_19.setBounds(462, 284, 60, 60);
		// contentPane.add(button_19);
		//
		// JButton button_22 = new JButton("E");
		// button_22.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_22.setBounds(661, 284, 60, 60);
		// contentPane.add(button_22);
		//
		// JButton button_23 = new JButton("N");
		// button_23.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_23.setBounds(727, 284, 60, 60);
		// contentPane.add(button_23);
		//
		// JButton button_24 = new JButton("E");
		// button_24.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_24.setBounds(396, 350, 60, 60);
		// contentPane.add(button_24);
		//
		// JButton button_25 = new JButton("M");
		// button_25.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_25.setBounds(462, 350, 60, 60);
		// contentPane.add(button_25);
		//
		// JButton button_26 = new JButton("L");
		// button_26.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_26.setBounds(528, 350, 60, 60);
		// contentPane.add(button_26);
		//
		// JButton button_27 = new JButton("D");
		// button_27.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_27.setBounds(594, 350, 60, 60);
		// contentPane.add(button_27);
		//
		// JButton button_28 = new JButton("X");
		// button_28.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_28.setBounds(661, 350, 60, 60);
		// contentPane.add(button_28);
		//
		// JButton button_29 = new JButton("Z");
		// button_29.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_29.setBounds(727, 350, 60, 60);
		// contentPane.add(button_29);
		//
		// JButton button_30 = new JButton("N");
		// button_30.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_30.setBounds(396, 417, 60, 60);
		// contentPane.add(button_30);
		//
		// JButton button_31 = new JButton("B");
		// button_31.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_31.setBounds(462, 417, 60, 60);
		// contentPane.add(button_31);
		//
		// JButton button_32 = new JButton("A");
		// button_32.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_32.setBounds(528, 417, 60, 60);
		// contentPane.add(button_32);
		//
		// JButton button_33 = new JButton("A");
		// button_33.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_33.setBounds(594, 417, 60, 60);
		// contentPane.add(button_33);
		//
		// JButton button_34 = new JButton("E");
		// button_34.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_34.setBounds(661, 417, 60, 60);
		// contentPane.add(button_34);
		//
		// JButton button_35 = new JButton("T");
		// button_35.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// button_35.setBounds(727, 417, 60, 60);
		// contentPane.add(button_35);

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
