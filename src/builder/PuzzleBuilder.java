package builder;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import entities.Board;
import entities.Letter;
import entities.Puzzle;
import player.PuzzleView;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PuzzleBuilder extends JFrame {

	private JPanel contentPane;
	private JTextField tfWordLimit;
	private JTextField txt1StarThresh;
	private JTextField txt2StarThresh;
	private JTextField txt3StarThresh;
	private JTextField txtlevelName;
	private JButton btnBack, btnPreview, btnDelete, btnSaveLevel;
	private JLabel lblScoreThresholds, lblLevelTypePuzzle;
	private JCheckBox checkBox[][] = new JCheckBox[6][6];
	int i, j;
	Puzzle puzzle = new Puzzle("test", new Board());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PuzzleBuilder frame = new PuzzleBuilder();
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
	public PuzzleBuilder() {
		initialize();
	}

	private void initialize() {
		initializeModel();
		initializeView();
		initializeController();
	}

	private void initializeModel() {
		setResizable(false);
		setTitle("Letter Craze Builder");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txt1StarThresh = new JTextField();
		txt2StarThresh = new JTextField();
		txt3StarThresh = new JTextField();

	}

	private void initializeView() {

		for (i = 0; i <= 5; i++) {
			for (j = 0; j <= 5; j++) {
				checkBox[i][j] = new JCheckBox("");
				checkBox[i][j].setBounds(534 + i * 66, 91 + j * 66, 20, 20);
				contentPane.add(checkBox[i][j]);

			}

		}

		txt1StarThresh.setText("(Score required for 1 star)");
		txt1StarThresh.setBounds(182, 168, 171, 20);
		contentPane.add(txt1StarThresh);
		txt1StarThresh.setColumns(10);

		txt2StarThresh.setText("(Score required for 2 stars)");
		txt2StarThresh.setColumns(10);
		txt2StarThresh.setBounds(182, 193, 171, 20);
		contentPane.add(txt2StarThresh);

		txt3StarThresh.setText("(Score required for 3 stars)");
		txt3StarThresh.setColumns(10);
		txt3StarThresh.setBounds(182, 218, 171, 20);
		contentPane.add(txt3StarThresh);

		lblScoreThresholds = new JLabel("Score Thresholds:");
		lblScoreThresholds.setBounds(182, 152, 120, 14);
		contentPane.add(lblScoreThresholds);

		btnSaveLevel = new JButton("Save Level");
		btnSaveLevel.setBounds(10, 95, 95, 23);
		contentPane.add(btnSaveLevel);

		btnBack = new JButton("Main Menu");
		btnBack.setBounds(10, 161, 95, 23);
		contentPane.add(btnBack);

		btnPreview = new JButton("Preview");
		btnPreview.setBounds(10, 190, 95, 23);
		contentPane.add(btnPreview);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(10, 219, 95, 23);
		contentPane.add(btnDelete);

		lblLevelTypePuzzle = new JLabel("Level Type: Puzzle");
		lblLevelTypePuzzle.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelTypePuzzle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLevelTypePuzzle.setBounds(10, 86, 510, 32);
		contentPane.add(lblLevelTypePuzzle);

		tfWordLimit = new JTextField();
		tfWordLimit.setBounds(251, 126, 102, 20);
		contentPane.add(tfWordLimit);
		tfWordLimit.setColumns(10);

		txtlevelName = new JTextField();
		txtlevelName.setText("(Level Name)");
		txtlevelName.setBounds(10, 126, 95, 20);
		contentPane.add(txtlevelName);
		txtlevelName.setColumns(10);

		JLabel lblWordLimit = new JLabel("Word Limit:");
		lblWordLimit.setBounds(182, 129, 70, 14);
		contentPane.add(lblWordLimit);

		JLabel gridImg = new JLabel("");
		gridImg.setIcon(new ImageIcon(PuzzleBuilder.class.getResource("/images/Grid.gif")));
		gridImg.setBounds(530, 86, 400, 400);
		contentPane.add(gridImg);

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(PuzzleBuilder.class.getResource("/images/BackgroundBlank.gif")));
		bg.setBounds(0, 0, 994, 541);
		contentPane.add(bg);

	}

	public void initializeController() {
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Builder mainMenu = new Builder();
				mainMenu.setVisible(true);
				dispose();
			}
		});

		btnPreview.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				for (i = 0; i <= 5; i++) {
					for (j = 0; j <= 5; j++) {
						if (checkBox[i][j].isSelected())
							puzzle.getBoard().deActivateSquare(i, j);
					}
				}
				PuzzleView puzzleView = new PuzzleView();
				puzzleView.setLevel(puzzle);
				puzzleView.setVisible(true);
				dispose();
			}
		});

	}

}
