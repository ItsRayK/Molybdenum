package player;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.concurrent.TimeUnit;


public class Player extends JFrame {
	private JPanel contentPane;
	JButton levelSelectBtn;
	JButton quitBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerSplash frame = new PlayerSplash();
					Player mainMenu = new Player();
					
					frame.setVisible(true);
					
					Timer timer = new Timer(3500, new ActionListener() {
				        public void actionPerformed(ActionEvent evt) {
				        	mainMenu.setVisible(true);
							frame.dispose();
				        }
				    });
				    timer.setRepeats(false);
				    timer.start();
				    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Player() {
		initialize();

	}
	
	private void initialize(){
		initializeModel();
		initializeControllers();
		initializeView();
	}

	private void initializeModel() {
		contentPane = new JPanel();
		
		levelSelectBtn = new JButton("Level Select");
		
		quitBtn = new JButton("Quit Game");
		

	}

	private void initializeView() {
		setResizable(false);
		setTitle("Letter Craze");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 570);
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		levelSelectBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		levelSelectBtn.setBounds(326, 175, 355, 61);
		contentPane.add(levelSelectBtn);

		
		quitBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		quitBtn.setBounds(326, 247, 355, 61);
		contentPane.add(quitBtn);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(Player.class.getResource("/images/BackgroundTitle.gif")));
		bg.setBounds(0, 0, 994, 541);
		contentPane.add(bg);
	}
	
	private void initializeControllers() {
		levelSelectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LevelSelect level = new LevelSelect();
				level.setVisible(true);
				dispose();
			}
		});
		
		quitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
}
