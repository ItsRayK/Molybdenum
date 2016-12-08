package builder;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import entities.Lightning;
import entities.Score;
import entities.Theme;
import player.LevelSelect;

public class PreviewTheme extends JFrame {

	private JPanel contentPane;
	private JButton btnExitLevel, btnUndo, btnGiveUp, btnSubmitWord;
	Theme level;

	/**
	 * Launch the application.
	 */
	public static void Theme(Theme level) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreviewTheme frame = new PreviewTheme("default", level, null, null, null);
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
	public PreviewTheme(String n, Theme l, Score oneStarScore, Score twoStarScore, Score threeStarScore) {

		initialize();

	}

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

		btnUndo = new JButton("");

		btnExitLevel = new JButton("Exit Level");

		btnGiveUp = new JButton("Reset");

		btnSubmitWord = new JButton("Submit Word");

	}

	public void initializeView() {
		btnUndo.setIcon(new ImageIcon(PreviewTheme.class.getResource("/images/undo-4-xxl.gif")));
		btnUndo.setBounds(913, 127, 40, 40);
		contentPane.add(btnUndo);

		btnExitLevel.setBounds(24, 82, 89, 23);
		contentPane.add(btnExitLevel);

		btnGiveUp.setBounds(24, 136, 89, 23);
		contentPane.add(btnGiveUp);

		btnSubmitWord.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSubmitWord.setBounds(797, 127, 106, 40);
		contentPane.add(btnSubmitWord);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(PreviewTheme.class.getResource("/images/starlevel.png")));
		label_2.setBounds(797, 217, 90, 90);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(PreviewTheme.class.getResource("/images/starlevel.png")));
		label_3.setBounds(797, 302, 90, 90);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(PreviewTheme.class.getResource("/images/starlevel.png")));
		label_4.setBounds(797, 387, 90, 90);
		contentPane.add(label_4);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PreviewTheme.class.getResource("/images/Grid.gif")));
		label.setBounds(392, 82, 400, 400);
		contentPane.add(label);

		JLabel lblPuzzle = new JLabel("Theme:");
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

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(PreviewTheme.class.getResource("/images/BackgroundBlank.gif")));
		label_1.setBounds(0, 0, 984, 531);
		contentPane.add(label_1);

	}

	public void initializeController() {
		btnExitLevel.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				LevelSelect levelSelect = new LevelSelect();
				levelSelect.setVisible(true);
				dispose();
			}
		});
	}

	public void setLevel(Theme t) {
		level = t;
	}
}
