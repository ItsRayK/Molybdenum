package builder;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class PuzzleBuilder extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtstarScore;
	private JTextField txtscoreRequiredFor;
	private JTextField txtscoreRequiredFor_1;
	private JTextField txtlevelName;

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
		setResizable(false);
		setTitle("Letter Craze Builder");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(554, 108, 21, 23);
		contentPane.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		checkBox_1.setBounds(617, 108, 21, 23);
		contentPane.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("");
		checkBox_2.setBounds(688, 108, 21, 23);
		contentPane.add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("");
		checkBox_3.setBounds(755, 108, 21, 23);
		contentPane.add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("");
		checkBox_4.setBounds(820, 108, 21, 23);
		contentPane.add(checkBox_4);
		
		JCheckBox checkBox_5 = new JCheckBox("");
		checkBox_5.setBounds(887, 108, 21, 23);
		contentPane.add(checkBox_5);
		
		JCheckBox checkBox_6 = new JCheckBox("");
		checkBox_6.setBounds(554, 171, 21, 23);
		contentPane.add(checkBox_6);
		
		JCheckBox checkBox_7 = new JCheckBox("");
		checkBox_7.setBounds(617, 171, 21, 23);
		contentPane.add(checkBox_7);
		
		JCheckBox checkBox_8 = new JCheckBox("");
		checkBox_8.setBounds(688, 171, 21, 23);
		contentPane.add(checkBox_8);
		
		JCheckBox checkBox_9 = new JCheckBox("");
		checkBox_9.setBounds(755, 171, 21, 23);
		contentPane.add(checkBox_9);
		
		JCheckBox checkBox_10 = new JCheckBox("");
		checkBox_10.setBounds(820, 171, 21, 23);
		contentPane.add(checkBox_10);
		
		JCheckBox checkBox_11 = new JCheckBox("");
		checkBox_11.setBounds(887, 171, 21, 23);
		contentPane.add(checkBox_11);
		
		JCheckBox checkBox_12 = new JCheckBox("");
		checkBox_12.setBounds(554, 240, 21, 23);
		contentPane.add(checkBox_12);
		
		JCheckBox checkBox_13 = new JCheckBox("");
		checkBox_13.setBounds(617, 240, 21, 23);
		contentPane.add(checkBox_13);
		
		JCheckBox checkBox_14 = new JCheckBox("");
		checkBox_14.setBounds(688, 240, 21, 23);
		contentPane.add(checkBox_14);
		
		JCheckBox checkBox_15 = new JCheckBox("");
		checkBox_15.setBounds(755, 240, 21, 23);
		contentPane.add(checkBox_15);
		
		JCheckBox checkBox_16 = new JCheckBox("");
		checkBox_16.setBounds(820, 240, 21, 23);
		contentPane.add(checkBox_16);
		
		JCheckBox checkBox_17 = new JCheckBox("");
		checkBox_17.setBounds(887, 240, 21, 23);
		contentPane.add(checkBox_17);
		
		JCheckBox checkBox_18 = new JCheckBox("");
		checkBox_18.setBounds(554, 305, 21, 23);
		contentPane.add(checkBox_18);
		
		JCheckBox checkBox_19 = new JCheckBox("");
		checkBox_19.setBounds(617, 305, 21, 23);
		contentPane.add(checkBox_19);
		
		JCheckBox checkBox_20 = new JCheckBox("");
		checkBox_20.setBounds(688, 305, 21, 23);
		contentPane.add(checkBox_20);
		
		JCheckBox checkBox_21 = new JCheckBox("");
		checkBox_21.setBounds(755, 305, 21, 23);
		contentPane.add(checkBox_21);
		
		JCheckBox checkBox_22 = new JCheckBox("");
		checkBox_22.setBounds(820, 305, 21, 23);
		contentPane.add(checkBox_22);
		
		JCheckBox checkBox_23 = new JCheckBox("");
		checkBox_23.setBounds(887, 305, 21, 23);
		contentPane.add(checkBox_23);
		
		JCheckBox checkBox_24 = new JCheckBox("");
		checkBox_24.setBounds(554, 374, 21, 23);
		contentPane.add(checkBox_24);
		
		JCheckBox checkBox_25 = new JCheckBox("");
		checkBox_25.setBounds(617, 374, 21, 23);
		contentPane.add(checkBox_25);
		
		JCheckBox checkBox_26 = new JCheckBox("");
		checkBox_26.setBounds(688, 374, 21, 23);
		contentPane.add(checkBox_26);
		
		JCheckBox checkBox_27 = new JCheckBox("");
		checkBox_27.setBounds(755, 374, 21, 23);
		contentPane.add(checkBox_27);
		
		JCheckBox checkBox_28 = new JCheckBox("");
		checkBox_28.setBounds(820, 374, 21, 23);
		contentPane.add(checkBox_28);
		
		JCheckBox checkBox_29 = new JCheckBox("");
		checkBox_29.setBounds(887, 374, 21, 23);
		contentPane.add(checkBox_29);
		
		JCheckBox checkBox_30 = new JCheckBox("");
		checkBox_30.setBounds(554, 440, 21, 23);
		contentPane.add(checkBox_30);
		
		JCheckBox checkBox_31 = new JCheckBox("");
		checkBox_31.setBounds(617, 440, 21, 23);
		contentPane.add(checkBox_31);
		
		JCheckBox checkBox_32 = new JCheckBox("");
		checkBox_32.setBounds(688, 440, 21, 23);
		contentPane.add(checkBox_32);
		
		JCheckBox checkBox_33 = new JCheckBox("");
		checkBox_33.setBounds(755, 440, 21, 23);
		contentPane.add(checkBox_33);
		
		JCheckBox checkBox_34 = new JCheckBox("");
		checkBox_34.setBounds(820, 440, 21, 23);
		contentPane.add(checkBox_34);
		
		JCheckBox checkBox_35 = new JCheckBox("");
		checkBox_35.setBounds(887, 440, 21, 23);
		contentPane.add(checkBox_35);
		
		txtstarScore = new JTextField();
		txtstarScore.setText("(Score required for 1 star)");
		txtstarScore.setBounds(182, 168, 171, 20);
		contentPane.add(txtstarScore);
		txtstarScore.setColumns(10);
		
		txtscoreRequiredFor = new JTextField();
		txtscoreRequiredFor.setText("(Score required for 2 stars)");
		txtscoreRequiredFor.setColumns(10);
		txtscoreRequiredFor.setBounds(182, 193, 171, 20);
		contentPane.add(txtscoreRequiredFor);
		
		txtscoreRequiredFor_1 = new JTextField();
		txtscoreRequiredFor_1.setText("(Score required for 3 stars)");
		txtscoreRequiredFor_1.setColumns(10);
		txtscoreRequiredFor_1.setBounds(182, 218, 171, 20);
		contentPane.add(txtscoreRequiredFor_1);
		
		JLabel lblScoreThresholds = new JLabel("Score Thresholds:");
		lblScoreThresholds.setBounds(182, 152, 120, 14);
		contentPane.add(lblScoreThresholds);
		
		JButton btnSaveLevel = new JButton("Save Level");
		btnSaveLevel.setBounds(10, 95, 95, 23);
		contentPane.add(btnSaveLevel);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setBounds(10, 167, 95, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblLevelTypePuzzle = new JLabel("Level Type: Puzzle");
		lblLevelTypePuzzle.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelTypePuzzle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLevelTypePuzzle.setBounds(10, 86, 510, 32);
		contentPane.add(lblLevelTypePuzzle);
		
		textField = new JTextField();
		textField.setBounds(251, 126, 102, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtlevelName = new JTextField();
		txtlevelName.setText("(Level Name)");
		txtlevelName.setBounds(10, 126, 95, 20);
		contentPane.add(txtlevelName);
		txtlevelName.setColumns(10);
		
		JButton button = new JButton("Preview");
		button.setBounds(10, 219, 95, 23);
		contentPane.add(button);
		
		JLabel lblWordLimit = new JLabel("Word Limit:");
		lblWordLimit.setBounds(182, 129, 70, 14);
		contentPane.add(lblWordLimit);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(PuzzleBuilder.class.getResource("/images/Grid.gif")));
		label_1.setBounds(530, 86, 400, 400);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PuzzleBuilder.class.getResource("/images/BackgroundBlank.gif")));
		label.setBounds(0, 0, 994, 541);
		contentPane.add(label);
	}
}
