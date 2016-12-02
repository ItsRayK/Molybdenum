package builder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import entities.Board;
import entities.Letter;
import entities.Lightning;
import player.LightningView;
import player.PuzzleView;

public class LightningBuilder extends JFrame {

	private JPanel contentPane;
	private JTextField txtSetTime;
	private JTextField txt1StarThresh;
	private JTextField txt2StarThresh;
	private JTextField txt3StarThresh;
	private JTextField txtlevelName;
	private JButton btnBack, btnPreview, btnDelete, btnSaveLevel;
	private JLabel lblScoreThresholds, lblLevelTypeLightning;
	private JCheckBox checkBox[][] = new JCheckBox[6][6];
	int i, j;
	Lightning lightning = new Lightning("default", new Board());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LightningBuilder frame = new LightningBuilder();
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
	public LightningBuilder() {
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

		lblScoreThresholds = new JLabel("Score Thresholds:");
		txt1StarThresh = new JTextField();
		txt2StarThresh = new JTextField();
		txt3StarThresh = new JTextField();

		txtlevelName = new JTextField();
		lblLevelTypeLightning = new JLabel("Level Type: Lightning");
		txtSetTime = new JTextField();

		btnSaveLevel = new JButton("Save Level");
		btnBack = new JButton("Main Menu");
		btnPreview = new JButton("Preview");
		btnDelete = new JButton("Delete");

	}

	private void initializeView() {
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {

				checkBox[i][j] = new JCheckBox("", true);
				checkBox[i][j].setBounds(534 + i * 66, 91 + j * 66, 20, 20);
				contentPane.add(checkBox[i][j]);

			}

		}

		lblScoreThresholds.setBounds(172, 154, 120, 14);
		contentPane.add(lblScoreThresholds);

		txt1StarThresh.setText("(Score required for 1 star)");
		txt1StarThresh.setColumns(10);
		txt1StarThresh.setBounds(172, 170, 171, 20);
		contentPane.add(txt1StarThresh);

		txt2StarThresh.setText("(Score required for 2 stars)");
		txt2StarThresh.setColumns(10);
		txt2StarThresh.setBounds(172, 195, 171, 20);
		contentPane.add(txt2StarThresh);

		txt3StarThresh.setText("(Score required for 3 stars)");
		txt3StarThresh.setColumns(10);
		txt3StarThresh.setBounds(172, 220, 171, 20);
		contentPane.add(txt3StarThresh);

		txtlevelName.setText("(Level Name)");
		txtlevelName.setBounds(10, 126, 95, 20);
		contentPane.add(txtlevelName);
		txtlevelName.setColumns(10);

		lblLevelTypeLightning.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelTypeLightning.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLevelTypeLightning.setBounds(10, 86, 510, 32);
		contentPane.add(lblLevelTypeLightning);

		JLabel gridImg = new JLabel("");
		gridImg.setIcon(new ImageIcon(PuzzleBuilder.class.getResource("/images/Grid.gif")));
		gridImg.setBounds(530, 86, 400, 400);
		contentPane.add(gridImg);

		JLabel lblTime = new JLabel("Timer:");
		lblTime.setBounds(172, 129, 37, 14);
		contentPane.add(lblTime);

		txtSetTime.setText("(Set Time)");
		txtSetTime.setBounds(217, 126, 86, 20);
		contentPane.add(txtSetTime);
		txtSetTime.setColumns(10);

		btnSaveLevel.setBounds(10, 95, 95, 23);
		contentPane.add(btnSaveLevel);

		btnBack.setBounds(10, 161, 95, 23);
		contentPane.add(btnBack);

		btnPreview.setBounds(10, 190, 95, 23);
		contentPane.add(btnPreview);

		btnDelete.setBounds(10, 219, 95, 23);
		contentPane.add(btnDelete);

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(LightningBuilder.class.getResource("/images/BackgroundBlank.gif")));
		bg.setBounds(0, 0, 994, 541);
		contentPane.add(bg);
	}

	private void initializeController() {

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
							lightning.getBoard().activateSquare(i, j);
						else
							lightning.getBoard().deActivateSquare(i, j);
					}
				}
				LightningView lightningView = new LightningView(txtlevelName.getText(), lightning);
				lightningView.setVisible(true);
			}
		});
	}
}
