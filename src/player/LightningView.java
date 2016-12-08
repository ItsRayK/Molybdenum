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
import entities.Lightning;
import entities.Puzzle;
import entities.Score;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LightningView extends JFrame {
	private JPanel contentPane;
	private JButton btnExitLevel, btnReset, btnSubmitWord;
	private JToggleButton boardSquares[][];
	Square[][] squares = new Square[6][6];
	JLabel starimg1, starimg2, starimg3;
	String name;
	Lightning level;
	int timer;
	Timer count;

	public LightningView(String n, Lightning l) {
		name = n;
		level = l;

		initialize();

	}

	/**
	 * Launch the application.
	 */
	public static void Lightning(Lightning level) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LightningView frame = new LightningView("default", level);
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
		initializeView();
		initializeController();
	}

	private void initializeModel() {
		setTitle("Letter Craze");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnExitLevel = new JButton("Exit Level");
		btnReset = new JButton("Reset");
		btnSubmitWord = new JButton("Submit Word");

		starimg1 = new JLabel("");
		starimg2 = new JLabel("");
		starimg3 = new JLabel("");

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
		int originalTimer = timer;
		count = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timer--;
				if (timer == 0) {
					timer = originalTimer;
					count.restart();
				}
			}

		});

	}

	private void initializeView() {

		btnExitLevel.setBounds(24, 82, 89, 23);
		contentPane.add(btnExitLevel);

		btnReset.setBounds(24, 136, 89, 23);
		contentPane.add(btnReset);

		btnSubmitWord.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSubmitWord.setBounds(797, 127, 106, 40);
		contentPane.add(btnSubmitWord);

		starimg1.setBounds(797, 387, 90, 90);
		starimg1.setIcon(new ImageIcon(LightningView.class.getResource("/images/starlevel.png")));
		contentPane.add(starimg1);

		starimg2.setBounds(797, 302, 90, 90);
		starimg2.setIcon(new ImageIcon(LightningView.class.getResource("/images/starlevel.png")));
		contentPane.add(starimg2);

		starimg3.setBounds(797, 217, 90, 90);
		starimg3.setIcon(new ImageIcon(LightningView.class.getResource("/images/starlevel.png")));
		contentPane.add(starimg3);

		JTextArea txtTimeResetNote = new JTextArea();
		txtTimeResetNote.setBounds(24, 159, 89, 68);
		txtTimeResetNote.setBackground(Color.LIGHT_GRAY);
		txtTimeResetNote.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		txtTimeResetNote.setText("Note: The time\r\nwill continue to\r\ncountdown on\r\nreset.");
		contentPane.add(txtTimeResetNote);

		JLabel lblTimeLeft = new JLabel("Time Left: " + timer);
		lblTimeLeft.setBounds(141, 453, 200, 31);
		lblTimeLeft.setFont(new Font("Gill Sans MT", Font.BOLD, 19));
		contentPane.add(lblTimeLeft);

		JLabel gridImg = new JLabel("");
		gridImg.setBounds(392, 82, 400, 400);
		gridImg.setIcon(new ImageIcon(LightningView.class.getResource("/images/Grid.gif")));
		contentPane.add(gridImg);

		JLabel lblLightning = new JLabel("Lightning");
		lblLightning.setBounds(392, 34, 400, 37);
		lblLightning.setHorizontalAlignment(SwingConstants.CENTER);
		lblLightning.setFont(new Font("Gill Sans MT", Font.BOLD, 24));
		contentPane.add(lblLightning);

		JScrollPane spWordsFound = new JScrollPane();
		spWordsFound.setBounds(141, 116, 226, 284);
		spWordsFound.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spWordsFound.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(spWordsFound);

		JLabel lblWordsFound = new JLabel("Words Found");
		lblWordsFound.setBounds(141, 82, 226, 31);
		lblWordsFound.setHorizontalAlignment(SwingConstants.CENTER);
		lblWordsFound.setFont(new Font("Gill Sans MT", Font.BOLD, 19));
		contentPane.add(lblWordsFound);

		JLabel lblScore = new JLabel("Score:");
		lblScore.setBounds(141, 411, 66, 31);
		lblScore.setFont(new Font("Gill Sans MT", Font.BOLD, 19));
		contentPane.add(lblScore);

		JLabel bg = new JLabel("");
		bg.setBounds(0, 0, 984, 531);
		bg.setIcon(new ImageIcon(LightningView.class.getResource("/images/BackgroundBlank.gif")));
		contentPane.add(bg);

	}

	private void initializeController() {
		btnExitLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LevelSelect levelSelect = new LevelSelect();
				levelSelect.setVisible(true);
				dispose();
			}
		});

		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

}
