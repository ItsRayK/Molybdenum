package player;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

		btnLevel1 = new JButton("Level 1");
		btnLevel2 = new JButton("Level 2");
		btnLevel3 = new JButton("Level 3");
		btnLevel4 = new JButton("Level 4");
		btnLevel5 = new JButton("Level 5");
		btnLevel6 = new JButton("Level 6");
		btnLevel7 = new JButton("Level 7");
		btnLevel8 = new JButton("Level 1");
		btnLevel9 = new JButton("Level 9");
		btnLevel10 = new JButton("Level 10");
		btnLevel11 = new JButton("Level 11");
		btnLevel12 = new JButton("Level 12");
		btnLevel13 = new JButton("Level 13");
		btnLevel14 = new JButton("Level 14");
		btnLevel15 = new JButton("Level 15");


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
		
		//ONLY BUTTON 1 DOES SOMETHING >> See initializeController
		
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
		

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(player.LevelSelect.class.getResource("/images/BackgroundTitle.gif")));
		bg.setBounds(0, 0, 994, 531);
		contentPane.add(bg);
		
		
	}

	private void initializeController() {
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
