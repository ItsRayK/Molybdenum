package player;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controllers.LetterClicked;
import entities.*;
import player.LevelSelect;

public class ThemeView extends JFrame {

	private JPanel contentPane;
	private JToggleButton[][] boardSquares;
	private ImageIcon starFilled, starEmpty;
	private JLabel starimg1, starimg2, starimg3, starimg4, starimg5, starimg6;
	Score oneStarScore, twoStarScore, threeStarScore;
	private JButton btnExitLevel;
	private JLabel lblTheme;
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

	}

	private void initializeView() {
		Theme p = this.level;
		ThemeView pV = this;
		setTitle("Letter Craze");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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
						if(readCheck.equals("null")){
							l.randomLetter();
							
						}
						else{
						
						}
						level.getBoard().squares[i][j].fillSquare(l);

						boardSquares[i][j] = new JToggleButton("<html><b>" + l.getString()
								+ "</b></font></html>");

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
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				k++;

			}
		}

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setIcon(new ImageIcon(ThemeView.class.getResource("/images/undo-4-xxl.gif")));
		button.setBounds(913, 127, 40, 40);
		contentPane.add(button);

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

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ThemeView.class.getResource("/images/Grid.gif")));
		label.setBounds(392, 82, 400, 400);
		contentPane.add(label);

		lblTheme = new JLabel("Theme: " + level.getThemeName());
		lblTheme.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheme.setFont(new Font("Gill Sans MT", Font.BOLD, 24));
		lblTheme.setBounds(392, 34, 400, 37);
		contentPane.add(lblTheme);

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
		label_1.setIcon(new ImageIcon(ThemeView.class.getResource("/images/BackgroundBlank.gif")));
		label_1.setBounds(0, 0, 984, 531);
		contentPane.add(label_1);

	}

	private void initializeController() {
		btnExitLevel.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				LevelSelect levelSelect = new LevelSelect();
				levelSelect.setVisible(true);
				dispose();
			}
		});

	}

	public void setLevel(Theme p) {
		level = p;
	}

}
