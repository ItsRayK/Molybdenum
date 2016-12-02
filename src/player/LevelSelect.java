package player;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Board;
import entities.Puzzle;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LevelSelect extends JFrame {

	private JPanel contentPane;
	private JButton btnLevel1,btnLevel2,btnLevel3,btnLevel4,btnLevel5,btnLevel6,btnLevel7,btnLevel8,
								btnLevel9,btnLevel10,btnLevel11,btnLevel12,btnLevel13,btnLevel14,btnLevel15;
	private JLabel lvl1Stars,lvl2Stars,lvl3Stars,lvl4Stars,lvl5Stars,lvl6Stars,lvl7Stars,lvl8Stars,lvl9Stars,lvl10Stars,
								lvl11Stars,lvl12Stars,lvl13Stars,lvl14Stars,lvl15Stars;
	private JButton btnMainMenu, btnCustom;
	

	/**
	 * Launch the application.
	 */
	public static void Levels() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelSelect frame = new LevelSelect();
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
	public LevelSelect() {
		setTitle("Letter Craze");
		initialize();
	}
	
	private void initialize(){
		initializeModel();
		initializeView();
		initializeController();
	}

	private void initializeModel() {

		btnMainMenu = new JButton("Main Menu");
		btnCustom = new JButton("Custom Level");
		btnLevel1 = new JButton("Level 1");
		btnLevel2 = new JButton("Level 2");
		btnLevel3 = new JButton("Level 3");
		btnLevel4 = new JButton("Locked");
		btnLevel5 = new JButton("Locked");
		btnLevel6 = new JButton("Locked");
		btnLevel7 = new JButton("Locked");
		btnLevel8 = new JButton("Locked");
		btnLevel9 = new JButton("Locked");
		btnLevel10 = new JButton("Locked");
		btnLevel11 = new JButton("Locked");
		btnLevel12 = new JButton("Locked");
		btnLevel13 = new JButton("Locked");
		btnLevel14 = new JButton("Locked");
		btnLevel15 = new JButton("Locked");
		
		lvl1Stars = new JLabel("");
		lvl2Stars = new JLabel("");
		lvl3Stars = new JLabel("");
		lvl4Stars = new JLabel("");
		lvl5Stars = new JLabel("");
		lvl6Stars = new JLabel("");
		lvl7Stars = new JLabel("");
		lvl8Stars = new JLabel("");
		lvl9Stars = new JLabel("");
		lvl10Stars = new JLabel("");
		lvl11Stars = new JLabel("");
		lvl12Stars = new JLabel("");
		lvl13Stars = new JLabel("");
		lvl14Stars = new JLabel("");
		lvl15Stars = new JLabel("");


	}

	private void initializeView() {
 		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnLevel1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel1.setBounds(260, 155, 80, 80);
		contentPane.add(btnLevel1);
				
		btnMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMainMenu.setBounds(110, 155, 110, 30);
		contentPane.add(btnMainMenu);
		
		btnCustom.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCustom.setBounds(110, 190, 110, 30);
		contentPane.add(btnCustom);
		
		//ONLY BUTTONS 1 - 3 DO SOMETHING >> See initializeController
		
		btnLevel2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel2.setBounds(360, 155, 80, 80);
		contentPane.add(btnLevel2);
		
		btnLevel3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel3.setBounds(460, 155, 80, 80);
		contentPane.add(btnLevel3);
		
		btnLevel4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel4.setBounds(560, 155, 80, 80);
		contentPane.add(btnLevel4);
		
		btnLevel5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel5.setBounds(660, 155, 80, 80);
		contentPane.add(btnLevel5);
		
		btnLevel6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel6.setBounds(260, 255, 80, 80);
		contentPane.add(btnLevel6);
		
		btnLevel7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel7.setBounds(360, 255, 80, 80);
		contentPane.add(btnLevel7);
		
		btnLevel8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel8.setBounds(460, 255, 80, 80);
		contentPane.add(btnLevel8);
		
		btnLevel9.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel9.setBounds(560, 255, 80, 80);
		contentPane.add(btnLevel9);
		
		btnLevel10.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel10.setBounds(660, 255, 80, 80);
		contentPane.add(btnLevel10);
		
		btnLevel11.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel11.setBounds(260, 355, 80, 80);
		contentPane.add(btnLevel11);
		
		btnLevel12.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel12.setBounds(360, 355, 80, 80);
		contentPane.add(btnLevel12);
		
		btnLevel13.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel13.setBounds(460, 355, 80, 80);
		contentPane.add(btnLevel13);
		
		btnLevel14.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel14.setBounds(560, 355, 80, 80);
		contentPane.add(btnLevel14);
		
		btnLevel15.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel15.setBounds(660, 355, 80, 80);
		contentPane.add(btnLevel15);
		
		lvl1Stars.setIcon(new ImageIcon(LevelSelect.class.getResource("/images/StarsBlank.gif")));
		lvl1Stars.setBounds(277, 234, 46, 14);
		contentPane.add(lvl1Stars);
		
		lvl2Stars.setIcon(new ImageIcon(LevelSelect.class.getResource("/images/StarsBlank.gif")));
		lvl2Stars.setBounds(377, 234, 46, 14);
		contentPane.add(lvl2Stars);
		
		lvl3Stars.setIcon(new ImageIcon(LevelSelect.class.getResource("/images/StarsBlank.gif")));
		lvl3Stars.setBounds(477, 234, 46, 14);
		contentPane.add(lvl3Stars);
		
		lvl4Stars.setIcon(new ImageIcon(LevelSelect.class.getResource("/images/StarsBlank.gif")));
		lvl4Stars.setBounds(577, 234, 46, 14);
		contentPane.add(lvl4Stars);
		
		lvl5Stars.setIcon(new ImageIcon(LevelSelect.class.getResource("/images/StarsBlank.gif")));
		lvl5Stars.setBounds(677, 234, 46, 14);
		contentPane.add(lvl5Stars);
		
		lvl6Stars.setIcon(new ImageIcon(LevelSelect.class.getResource("/images/StarsBlank.gif")));
		lvl6Stars.setBounds(277, 334, 46, 14);
		contentPane.add(lvl6Stars);
		
		lvl7Stars.setIcon(new ImageIcon(LevelSelect.class.getResource("/images/StarsBlank.gif")));
		lvl7Stars.setBounds(377, 334, 46, 14);
		contentPane.add(lvl7Stars);
		
		lvl8Stars.setIcon(new ImageIcon(LevelSelect.class.getResource("/images/StarsBlank.gif")));
		lvl8Stars.setBounds(477, 334, 46, 14);
		contentPane.add(lvl8Stars);
		
		lvl9Stars.setIcon(new ImageIcon(LevelSelect.class.getResource("/images/StarsBlank.gif")));
		lvl9Stars.setBounds(577, 334, 46, 14);
		contentPane.add(lvl9Stars);
		
		lvl10Stars.setIcon(new ImageIcon(LevelSelect.class.getResource("/images/StarsBlank.gif")));
		lvl10Stars.setBounds(677, 334, 46, 14);
		contentPane.add(lvl10Stars);
		
		lvl11Stars.setIcon(new ImageIcon(LevelSelect.class.getResource("/images/StarsBlank.gif")));
		lvl11Stars.setBounds(277, 434, 46, 14);
		contentPane.add(lvl11Stars);
		
		lvl12Stars.setIcon(new ImageIcon(LevelSelect.class.getResource("/images/StarsBlank.gif")));
		lvl12Stars.setBounds(377, 434, 46, 14);
		contentPane.add(lvl12Stars);
		
		lvl13Stars.setIcon(new ImageIcon(LevelSelect.class.getResource("/images/StarsBlank.gif")));
		lvl13Stars.setBounds(477, 434, 46, 14);
		contentPane.add(lvl13Stars);
		
		lvl14Stars.setIcon(new ImageIcon(LevelSelect.class.getResource("/images/StarsBlank.gif")));
		lvl14Stars.setBounds(577, 434, 46, 14);
		contentPane.add(lvl14Stars);
		
		lvl15Stars.setIcon(new ImageIcon(LevelSelect.class.getResource("/images/StarsBlank.gif")));
		lvl15Stars.setBounds(677, 434, 46, 14);
		contentPane.add(lvl15Stars);
				

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(player.LevelSelect.class.getResource("/images/BackgroundTitle.gif")));
		bg.setBounds(0, 0, 994, 531);
		contentPane.add(bg);
		
		
	}

	private void initializeController() {
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Player temp = new Player();
				temp.setVisible(true);
				dispose();
			}
		});
		
		btnLevel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PuzzleView temp = new PuzzleView();
				temp.setVisible(true);
				dispose();
			}
		});
		
		btnLevel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LightningView temp = new LightningView();
				temp.setVisible(true);
				dispose();
			}
		});
		btnLevel3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ThemeView temp = new ThemeView();
				temp.setVisible(true);
				dispose();
			}
		});

	}
}
