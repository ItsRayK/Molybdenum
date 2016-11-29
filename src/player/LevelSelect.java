package player;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LevelSelect extends JFrame {

	private JPanel contentPane;
	private JButton btnLevel1;
	private JButton btnLevel2;
	private JButton btnLevel3;


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
		initializeModel();
		initializeView();
		initializeController();
	}

	private void initializeView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 570);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnLevel1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel1.setBounds(259, 155, 80, 80);
		contentPane.add(btnLevel1);
		
	}

	private void initializeModel() {
		
		contentPane = new JPanel();
		
		
		btnLevel1 = new JButton("Level 1");
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(LevelSelect.class.getResource("/images/BackgroundTitle.gif")));
		lblNewLabel.setBounds(0, 0, 994, 531);
		contentPane.add(lblNewLabel);
		
	}

	private void initializeController() {
		btnLevel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PuzzleView temp = new PuzzleView();
				temp.setVisible(true);
				dispose();
			}
		});
	}
}
