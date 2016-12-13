package builder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controllers.GetStateOfLightningBuilder;
import controllers.GetStateOfThemeBuilder;
import entities.Board;
import entities.Letter;
import entities.Lightning;
import entities.Theme;

public class ThemeBuilder extends JFrame {

	private JPanel contentPane;
	private JTextField tfThemeName;
	private JTextField tfDesiredLetter[][];
	private JTextField txt1StarThresh;
	private JTextField txt2StarThresh;
	private JTextField txt3StarThresh;
	private JTextField txtlevelName;
	private JCheckBox checkBox[][];
	private JButton btnBack, btnPreview, btnDelete, btnSaveLevel;
	private JLabel lblScoreThresholds, lblLevelTypeTheme, lblThemeName;
	private JTextPane wordList;

	Theme theme = new Theme("default", new Board());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemeBuilder frame = new ThemeBuilder();
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
	public ThemeBuilder() {
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
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1000, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnSaveLevel = new JButton("Save Level");
		btnBack = new JButton("Main Menu");
		btnPreview = new JButton("Preview");
		btnDelete = new JButton("Delete");

		lblLevelTypeTheme = new JLabel("Level Type: Theme");
		lblThemeName = new JLabel("Theme:");
		lblScoreThresholds = new JLabel("Star Thresholds:");

		txt1StarThresh = new JTextField();
		txt2StarThresh = new JTextField();
		txt3StarThresh = new JTextField();

		tfThemeName = new JTextField();
		txtlevelName = new JTextField();

	}

	private void initializeView() {
		checkBox = new JCheckBox[6][6];
		tfDesiredLetter = new JTextField[6][6];
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				Letter l = new Letter();
				l.randomLetter();

				checkBox[i][j] = new JCheckBox("");
				checkBox[i][j].setBounds(534 + i * 66, 91 + j * 66, 20, 20);
				checkBox[i][j].setSelected(true);
				contentPane.add(checkBox[i][j]);

				tfDesiredLetter[i][j] = new JTextField("");

				tfDesiredLetter[i][j].setBounds(550 + i * 66, 110 + j * 66, 30, 30);
				tfDesiredLetter[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				contentPane.add(tfDesiredLetter[i][j]);

			}

		}

		lblLevelTypeTheme.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelTypeTheme.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLevelTypeTheme.setBounds(10, 86, 510, 32);
		contentPane.add(lblLevelTypeTheme);

		JLabel gridImg = new JLabel("");
		gridImg.setIcon(new ImageIcon(PuzzleBuilder.class.getResource("/images/Grid.gif")));
		gridImg.setBounds(530, 86, 400, 400);
		contentPane.add(gridImg);

		lblThemeName.setBounds(179, 129, 56, 14);
		contentPane.add(lblThemeName);

		lblScoreThresholds.setBounds(179, 379, 120, 14);
		contentPane.add(lblScoreThresholds);

		txt1StarThresh.setText("");
		TextPrompt star1prompt = new TextPrompt("# Words found for 1 star", txt1StarThresh);

		txt1StarThresh.setColumns(10);
		txt1StarThresh.setBounds(179, 395, 171, 20);
		contentPane.add(txt1StarThresh);

		txt2StarThresh.setText("");
		TextPrompt star2prompt = new TextPrompt("# Words found for 2 star", txt2StarThresh);

		txt2StarThresh.setColumns(10);
		txt2StarThresh.setBounds(179, 420, 171, 20);
		contentPane.add(txt2StarThresh);

		txt3StarThresh.setText("");
		TextPrompt star3prompt = new TextPrompt("# Words found for 3 star", txt3StarThresh);

		txt3StarThresh.setColumns(10);
		txt3StarThresh.setBounds(179, 445, 171, 20);
		contentPane.add(txt3StarThresh);

		tfThemeName.setText("");
		TextPrompt themeNamePrompt = new TextPrompt("Theme Name", tfThemeName);

		tfThemeName.setBounds(227, 126, 144, 20);
		contentPane.add(tfThemeName);
		tfThemeName.setColumns(10);

		txtlevelName.setText("");
		TextPrompt lvlNamePrompt = new TextPrompt("Level Name", txtlevelName);
		txtlevelName.setBounds(10, 126, 95, 20);
		contentPane.add(txtlevelName);
		txtlevelName.setColumns(10);

		btnSaveLevel.setBounds(10, 95, 95, 23);
		contentPane.add(btnSaveLevel);

		btnBack.setBounds(10, 161, 95, 23);
		contentPane.add(btnBack);

		btnPreview.setBounds(10, 190, 95, 23);
		contentPane.add(btnPreview);

		btnDelete.setBounds(10, 219, 95, 23);
		contentPane.add(btnDelete);

		wordList = new JTextPane();
		wordList.setText("");
		TextPrompt wordListPrompt = new TextPrompt("(one word per line)", wordList);
		wordList.setBounds(179, 179, 184, 195);
		contentPane.add(wordList);
		
		JLabel lblWordsToBeFound = new JLabel("Words to be found:");
		lblWordsToBeFound.setBounds(179, 154, 184, 14);
		contentPane.add(lblWordsToBeFound);

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(ThemeBuilder.class.getResource("/images/BackgroundBlank.gif")));
		bg.setBounds(0, 0, 994, 541);
		contentPane.add(bg);
	}

	private void initializeController() {
		ThemeBuilder themeBuilder = this;
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Builder mainMenu = new Builder();
				mainMenu.setVisible(true);
				dispose();
			}
		});
		btnSaveLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetStateOfThemeBuilder getState = new GetStateOfThemeBuilder(themeBuilder, theme);
				getState.saveLevel();
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetStateOfThemeBuilder getState = new GetStateOfThemeBuilder(themeBuilder, theme);
				getState.deletePuzzle();
			}
		});
		btnPreview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				GetStateOfThemeBuilder state = new GetStateOfThemeBuilder(themeBuilder, theme);
				state.makePreview();
			}
		});
		
	}

	public JCheckBox[][] getCheckBox() {
		return checkBox;
	}

	public void setCheckBox(JCheckBox checkBox[][]) {
		this.checkBox = checkBox;
	}

	public JTextField[][] getLetterField() {
		return tfDesiredLetter;
	}

	public JTextField getTxt1StarThresh() {
		return txt1StarThresh;
	}

	public JTextField getTxt2StarThresh() {
		return txt2StarThresh;
	}

	public JTextField getTxt3StarThresh() {
		return txt3StarThresh;
	}

	public String getWordsToFind() {
		return wordList.getText();
	}
	
	public JTextPane getWordList(){
		return wordList;
	}
	public void setWordsToFind(String s){
		wordList.setText(s + "\r\n" + wordList.getText());
	}
	public String getNameText() {
		return txtlevelName.getText();
	}

	public String getThemeNameText() {
		return tfThemeName.getText();
	}
	public void setThemeName(String s) {
		tfThemeName.setText(s);
	}
	
	public void set1StarScoreText(String s) {
		txt1StarThresh.setText(s);
	}
	
	public void set2StarScoreText(String s) {
		txt2StarThresh.setText(s);
	}
	
	public void set3StarScoreText(String s) {
		txt3StarThresh.setText(s);
	}
	
	public void setNameText(String s) {
		txtlevelName.setText(s);
	}

}
