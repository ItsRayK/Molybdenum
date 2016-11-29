package player;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


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
					Player frame = new Player();
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
	public Player() {
		
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
<<<<<<< HEAD
		
		quitBtn.addActionListener(new ActionListener() {
=======
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

	}

	private void initComponents() {
		setResizable(false);
		setTitle("Letter Craze");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNewButton = new JButton("Level Select");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(326, 175, 355, 61);
		contentPane.add(btnNewButton);

		button = new JButton("Quit Game" + "");
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));

		button.addActionListener(new ActionListener() {
>>>>>>> branch 'master' of https://github.com/ItsRayK/Molybdenum.git
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
}
