package builder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import entities.Letter;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		lblScoreThresholds = new JLabel("Score Thresholds:");

		txt1StarThresh = new JTextField();
		txt2StarThresh = new JTextField();
		txt3StarThresh = new JTextField();

		tfThemeName = new JTextField();
		txtlevelName = new JTextField();
		
		
	}
	
	private void initializeView(){
		
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				Letter l = new Letter();
				l.randomLetter();
				
				checkBox = new JCheckBox[6][6];
				checkBox[i][j] = new JCheckBox("");
				checkBox[i][j].setBounds(534 + i * 66, 91 + j * 66, 20, 20);
				contentPane.add(checkBox[i][j]);
				
				tfDesiredLetter = new JTextField[6][6];
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
		
		lblScoreThresholds.setBounds(179, 304, 120, 14);
		contentPane.add(lblScoreThresholds);
		
		txt1StarThresh.setText("(Score required for 1 star)");
		txt1StarThresh.setColumns(10);
		txt1StarThresh.setBounds(179, 320, 171, 20);
		contentPane.add(txt1StarThresh);
		
		txt2StarThresh.setText("(Score required for 2 stars)");
		txt2StarThresh.setColumns(10);
		txt2StarThresh.setBounds(179, 345, 171, 20);
		contentPane.add(txt2StarThresh);
		
		txt3StarThresh.setText("(Score required for 3 stars)");
		txt3StarThresh.setColumns(10);
		txt3StarThresh.setBounds(179, 370, 171, 20);
		contentPane.add(txt3StarThresh);
		
		tfThemeName.setText("(Theme Name)");
		tfThemeName.setBounds(227, 126, 144, 20);
		contentPane.add(tfThemeName);
		tfThemeName.setColumns(10);
		
		txtlevelName.setText("(Level Name)");
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
		
		JTextPane wordList = new JTextPane();
		wordList.setText("(one line per word)");
		wordList.setBounds(179, 179, 184, 119);
		contentPane.add(wordList);
				
		JLabel lblWordsToBeFound = new JLabel("Words to be found:");
		lblWordsToBeFound.setBounds(179, 154, 184, 14);
		contentPane.add(lblWordsToBeFound);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(ThemeBuilder.class.getResource("/images/BackgroundBlank.gif")));
		bg.setBounds(0, 0, 994, 541);
		contentPane.add(bg);
	}
	
	private void initializeController(){
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Builder mainMenu = new Builder();
				mainMenu.setVisible(true);
				dispose();
			}
		});
	}
	
		
		
		
		
		
		
						
		
		
	
}
