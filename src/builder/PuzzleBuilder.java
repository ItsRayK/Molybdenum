package builder;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controllers.GetStateOfPuzzleBuilder;
import controllers.LoadPuzzleLevel;
import entities.Board;
import entities.Letter;
import entities.Puzzle;
import player.PuzzleView;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
	Puzzle puzzle = new Puzzle("default", new Board());

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
		
		setTxt1StarThresh(new JTextField());
		txt2StarThresh = new JTextField();
		txt2StarThresh.setBounds(182, 193, 171, 20);
		txt3StarThresh = new JTextField();
		txt3StarThresh.setBounds(182, 218, 171, 20);
		
		lblScoreThresholds = new JLabel("<html> <b> * </b> Score Thresholds:</html>");
		btnSaveLevel = new JButton("Save Level");
		btnBack = new JButton("Main Menu");
		btnPreview = new JButton("Preview");
		btnDelete = new JButton("Delete");
		lblLevelTypePuzzle = new JLabel("Level Type: Puzzle");
		tfWordLimit = new JTextField();
		txtlevelName = new JTextField("");


	}

	private void initializeView() {

		for (i = 0; i <= 5; i++) {
			for (j = 0; j <= 5; j++) {
				getCheckBox()[i][j] = new JCheckBox("", true);
				getCheckBox()[i][j].setBounds(534 + i * 66, 91 + j * 66, 20, 20);
				contentPane.add(getCheckBox()[i][j]);

			}

		}
		contentPane.setLayout(null);
		getTxt1StarThresh().setText("");
		TextPrompt star1prompt = new TextPrompt("Score required for 1 star", txt1StarThresh);
		contentPane.add(getTxt1StarThresh());
		getTxt1StarThresh().setColumns(10);

		txt2StarThresh.setText("");
		TextPrompt star2prompt = new TextPrompt("Score required for 2 stars", txt2StarThresh);
		txt2StarThresh.setColumns(10);
		contentPane.add(txt2StarThresh);

		txt3StarThresh.setText("");
		TextPrompt star3prompt = new TextPrompt("Score required for 3 stars", txt3StarThresh);
		txt3StarThresh.setColumns(10);
		contentPane.add(txt3StarThresh);

		lblScoreThresholds.setBounds(182, 152, 120, 14);
		contentPane.add(lblScoreThresholds);

		btnSaveLevel.setBounds(10, 95, 95, 23);
		contentPane.add(btnSaveLevel);

		btnBack.setBounds(10, 171, 95, 23);
		contentPane.add(btnBack);

		btnPreview.setBounds(10, 200, 95, 23);
		contentPane.add(btnPreview);

		btnDelete.setBounds(10, 230, 95, 23);
		contentPane.add(btnDelete);

		lblLevelTypePuzzle.setBounds(10, 86, 510, 32);
		lblLevelTypePuzzle.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelTypePuzzle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblLevelTypePuzzle);

		tfWordLimit.setBounds(251, 126, 102, 20);
		contentPane.add(tfWordLimit);
		tfWordLimit.setColumns(10);

		txtlevelName.setBounds(10, 146, 95, 20);
		TextPrompt levelNameprompt = new TextPrompt("<html><text color = black></text>Level Name</html>", txtlevelName);
		contentPane.add(txtlevelName);
		txtlevelName.setColumns(10);
		
		JLabel lblLevelName = new JLabel("*Level Name");
		lblLevelName.setBounds(10, 126, 95, 20);
		contentPane.add(lblLevelName);

		JLabel lblWordLimit = new JLabel("Word Limit:");
		lblWordLimit.setBounds(182, 129, 70, 14);
		contentPane.add(lblWordLimit);

		JLabel lblRequiredNote = new JLabel("*Required Fields");
		lblRequiredNote.setBounds(182, 248, 110, 14);
		contentPane.add(lblRequiredNote);

		JLabel gridImg = new JLabel("");
		gridImg.setBounds(530, 86, 400, 400);
		gridImg.setIcon(new ImageIcon(PuzzleBuilder.class.getResource("/images/Grid.gif")));
		contentPane.add(gridImg);

		JLabel bg = new JLabel("");
		bg.setBounds(0, 0, 994, 541);
		bg.setIcon(new ImageIcon(PuzzleBuilder.class.getResource("/images/BackgroundBlank.gif")));
		contentPane.add(bg);

	}

	public void initializeController() {
		PuzzleBuilder puzzleBuilder = this;
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Builder mainMenu = new Builder();
				mainMenu.setVisible(true);
				dispose();
			}
		});

		btnPreview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetStateOfPuzzleBuilder getState = new GetStateOfPuzzleBuilder(puzzleBuilder, puzzle);
				getState.makePreview();
			}
		});

		btnSaveLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetStateOfPuzzleBuilder getState = new GetStateOfPuzzleBuilder(puzzleBuilder, puzzle);
				getState.saveLevel();
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetStateOfPuzzleBuilder getState = new GetStateOfPuzzleBuilder(puzzleBuilder, puzzle);
				getState.deletePuzzle();
			}
		});
	}

	// Getters and Setters of variables
	public String getNameText() {
		return txtlevelName.getText();
	}

	public JCheckBox[][] getCheckBox() {
		return checkBox;
	}

	public void setCheckBox(JCheckBox checkBox[][]) {
		this.checkBox = checkBox;
	}

	public JTextField getTxt1StarThresh() {
		return txt1StarThresh;
	}

	public void setTxt1StarThresh(JTextField txt1StarThresh) {
		this.txt1StarThresh = txt1StarThresh;
		txt1StarThresh.setBounds(182, 168, 171, 20);
	}

	public JTextField getTxt2StarThresh() {
		return txt2StarThresh;
	}

	public JTextField getTxt3StarThresh() {
		return txt3StarThresh;
	}
	
	public JTextField getMaxWords(){
		return tfWordLimit;
	}

}
