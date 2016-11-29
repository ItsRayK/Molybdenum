package player;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import entities.Letter;
import entities.Square;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LightningView extends JFrame {
	private JPanel contentPane;
	private JButton btnExitLevel;
	Square[][] squares = new Square[6][6];

	/**
	 * Launch the application.
	 */
	public static void Lightning() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LightningView frame = new LightningView();
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
	public LightningView() {
		// initializeEntities();
		initComponents();

		createEvents();

	}

	private void createEvents() {
		btnExitLevel.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				LevelSelect levelSelect = new LevelSelect();
				levelSelect.setVisible(true);
				dispose();
			}
		});

	}

	public void initializeEntities() {
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				if (j % 2 == 0 && i % 2 == 0) {
					squares[i][j].setActivity(false);
				} else {
					squares[i][j].setActivity(true);
				}
			}
			
		}

	}

	private void initComponents() {
		setTitle("Letter Craze");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label_3 = new JLabel("");
		label_3.setBounds(797, 217, 90, 90);
		label_3.setIcon(new ImageIcon(LightningView.class.getResource("/images/starlevel.png")));
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("");
		label_4.setBounds(797, 302, 90, 90);
		label_4.setIcon(new ImageIcon(LightningView.class.getResource("/images/starlevel.png")));
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("");
		label_5.setBounds(797, 387, 90, 90);
		label_5.setIcon(new ImageIcon(LightningView.class.getResource("/images/starlevel.png")));
		contentPane.add(label_5);

		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				Letter l = new Letter();
				l.randomLetter();

				JButton boardSquares[][] = new JButton[6][6];
				boardSquares[i][j] = new JButton("<html><b>" + l.getString() + "</b><font size = '3'><sub>"
						+ l.getScore() + "</sub></font></html>");
				boardSquares[i][j].setFont(new Font("Tahoma", Font.PLAIN, 18));
				boardSquares[i][j].setBounds(396 + i * 66, 86 + j * 66, 60, 60);
				contentPane.add(boardSquares[i][j]);

			}
		}

		JTextArea txtrNoteTheTime = new JTextArea();
		txtrNoteTheTime.setBounds(24, 159, 89, 68);
		txtrNoteTheTime.setBackground(Color.LIGHT_GRAY);
		txtrNoteTheTime.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		txtrNoteTheTime.setText("Note: The time\r\nwill continue to\r\ncountdown on\r\nreset.");
		contentPane.add(txtrNoteTheTime);

		JLabel label_2 = new JLabel("Time Left:");
		label_2.setBounds(141, 453, 100, 31);
		label_2.setFont(new Font("Gill Sans MT", Font.BOLD, 19));
		contentPane.add(label_2);

		JLabel label = new JLabel("");
		label.setBounds(392, 82, 400, 400);
		label.setIcon(new ImageIcon(LightningView.class.getResource("/images/Grid.gif")));
		contentPane.add(label);

		JLabel lblPuzzle = new JLabel("Lightning");
		lblPuzzle.setBounds(392, 34, 400, 37);
		lblPuzzle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuzzle.setFont(new Font("Gill Sans MT", Font.BOLD, 24));
		contentPane.add(lblPuzzle);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(141, 116, 226, 284);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane);

		JLabel lblWordsFound = new JLabel("Words Found");
		lblWordsFound.setBounds(141, 82, 226, 31);
		lblWordsFound.setHorizontalAlignment(SwingConstants.CENTER);
		lblWordsFound.setFont(new Font("Gill Sans MT", Font.BOLD, 19));
		contentPane.add(lblWordsFound);

		JLabel lblScore = new JLabel("Score:");
		lblScore.setBounds(141, 411, 66, 31);
		lblScore.setFont(new Font("Gill Sans MT", Font.BOLD, 19));
		contentPane.add(lblScore);

		btnExitLevel = new JButton("Exit Level");
		btnExitLevel.setBounds(24, 82, 89, 23);

		btnExitLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnExitLevel);

		JButton btnGiveUp = new JButton("Reset");
		btnGiveUp.setBounds(24, 136, 89, 23);
		btnGiveUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnGiveUp);

		JButton btnSubmitWord = new JButton("Submit Word");
		btnSubmitWord.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSubmitWord.setBounds(797, 127, 106, 40);
		contentPane.add(btnSubmitWord);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 0, 984, 531);
		label_1.setIcon(new ImageIcon(LightningView.class.getResource("/images/BackgroundBlank.gif")));
		contentPane.add(label_1);

	}
}
