package player;

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

import player.LevelSelect;

public class ThemeView extends JFrame {

	private JPanel contentPane;
	private JButton btnExitLevel;

	/**
	 * Launch the application.
	 */
	public static void Theme() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemeView frame = new ThemeView();
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
	public ThemeView() {
		
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

	private void initComponents() {
		setTitle("Letter Craze");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setIcon(new ImageIcon(ThemeView.class.getResource("/images/undo-4-xxl.gif")));
		button.setBounds(913, 127, 40, 40);
		contentPane.add(button);
		
		JButton btnP = new JButton("P");
		btnP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnP.setBounds(396, 86, 60, 60);
		contentPane.add(btnP);
		
		JButton btnU = new JButton("U");
		btnU.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnU.setBounds(462, 86, 60, 60);
		contentPane.add(btnU);
		
		JButton button_3 = new JButton("L");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_3.setBounds(594, 86, 60, 60);
		contentPane.add(button_3);
		
		JButton btnG = new JButton("G");
		btnG.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnG.setBounds(528, 86, 60, 60);
		contentPane.add(btnG);
		
		JButton btnO_1 = new JButton("O");
		btnO_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnO_1.setBounds(661, 86, 60, 60);
		contentPane.add(btnO_1);
		
		JButton btnP_2 = new JButton("P");
		btnP_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnP_2.setBounds(727, 86, 60, 60);
		contentPane.add(btnP_2);
		
		JButton btnI = new JButton("I");
		btnI.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnI.setBounds(396, 152, 60, 60);
		contentPane.add(btnI);
		
		JButton btnP_1 = new JButton("P");
		btnP_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnP_1.setBounds(462, 152, 60, 60);
		contentPane.add(btnP_1);
		
		JButton button_9 = new JButton("L");
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_9.setBounds(528, 152, 60, 60);
		contentPane.add(button_9);
		
		JButton button_10 = new JButton("L");
		button_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_10.setBounds(594, 152, 60, 60);
		contentPane.add(button_10);
		
		JButton btnO = new JButton("O");
		btnO.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnO.setBounds(661, 152, 60, 60);
		contentPane.add(btnO);
		
		JButton btnD = new JButton("D");
		btnD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnD.setBounds(727, 152, 60, 60);
		contentPane.add(btnD);
		
		JButton btnT = new JButton("T");
		btnT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnT.setBounds(396, 219, 60, 60);
		contentPane.add(btnT);
		
		JButton button_14 = new JButton("L");
		button_14.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_14.setBounds(462, 219, 60, 60);
		contentPane.add(button_14);
		
		JButton btnE_1 = new JButton("E");
		btnE_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnE_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnE_1.setBounds(528, 219, 60, 60);
		contentPane.add(btnE_1);
		
		JButton btnR = new JButton("R");
		btnR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnR.setBounds(594, 219, 60, 60);
		contentPane.add(btnR);
		
		JButton button_17 = new JButton("L");
		button_17.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_17.setBounds(661, 219, 60, 60);
		contentPane.add(button_17);
		
		JButton btnG_2 = new JButton("H");
		btnG_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnG_2.setBounds(727, 219, 60, 60);
		contentPane.add(btnG_2);
		
		JButton button_19 = new JButton("L");
		button_19.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_19.setBounds(396, 284, 60, 60);
		contentPane.add(button_19);
		
		JButton btnB = new JButton("B");
		btnB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnB.setBounds(462, 284, 60, 60);
		contentPane.add(btnB);
		
		JButton btnO_2 = new JButton("O");
		btnO_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnO_2.setBounds(594, 284, 60, 60);
		contentPane.add(btnO_2);
		
		JButton btnX = new JButton("X");
		btnX.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnX.setBounds(528, 284, 60, 60);
		contentPane.add(btnX);
		
		JButton btnG_1 = new JButton("G");
		btnG_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnG_1.setBounds(661, 284, 60, 60);
		contentPane.add(btnG_1);
		
		JButton btnE = new JButton("E");
		btnE.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnE.setBounds(727, 284, 60, 60);
		contentPane.add(btnE);
		
		JButton btnA = new JButton("A");
		btnA.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnA.setBounds(396, 350, 60, 60);
		contentPane.add(btnA);
		
		JButton button_26 = new JButton("L");
		button_26.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_26.setBounds(462, 350, 60, 60);
		contentPane.add(button_26);
		
		JButton btnU_1 = new JButton("U");
		btnU_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnU_1.setBounds(528, 350, 60, 60);
		contentPane.add(btnU_1);
		
		JButton btnB_1 = new JButton("B");
		btnB_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnB_1.setBounds(594, 350, 60, 60);
		contentPane.add(btnB_1);
		
		JButton button_29 = new JButton("L");
		button_29.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_29.setBounds(661, 350, 60, 60);
		contentPane.add(button_29);
		
		JButton button_30 = new JButton("L");
		button_30.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_30.setBounds(727, 350, 60, 60);
		contentPane.add(button_30);
		
		JButton btnS = new JButton("S");
		btnS.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnS.setBounds(396, 417, 60, 60);
		contentPane.add(btnS);
		
		JButton button_32 = new JButton("L");
		button_32.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_32.setBounds(462, 417, 60, 60);
		contentPane.add(button_32);
		
		JButton btnT_1 = new JButton("T");
		btnT_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnT_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnT_1.setBounds(528, 417, 60, 60);
		contentPane.add(btnT_1);
		
		JButton btnZ = new JButton("Z");
		btnZ.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnZ.setBounds(594, 417, 60, 60);
		contentPane.add(btnZ);
		
		JButton button_35 = new JButton("L");
		button_35.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_35.setBounds(661, 417, 60, 60);
		contentPane.add(button_35);
		
		JButton btnA_1 = new JButton("A");
		btnA_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnA_1.setBounds(727, 417, 60, 60);
		contentPane.add(btnA_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(ThemeView.class.getResource("/images/starlevel.png")));
		label_2.setBounds(797, 217, 90, 90);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(ThemeView.class.getResource("/images/starlevel.png")));
		label_3.setBounds(797, 302, 90, 90);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(ThemeView.class.getResource("/images/starlevel.png")));
		label_4.setBounds(797, 387, 90, 90);
		contentPane.add(label_4);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ThemeView.class.getResource("/images/Grid.gif")));
		label.setBounds(392, 82, 400, 400);
		contentPane.add(label);
		
		JLabel lblPuzzle = new JLabel("Theme: Dogs");
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
}
