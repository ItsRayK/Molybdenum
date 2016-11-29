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
	private JButton btnLevel1;

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

	private void initializeModel() {

		btnLevel1 = new JButton("Level 1");


	}

	private void initializeView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnLevel1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLevel1.setBounds(259, 155, 80, 80);
		contentPane.add(btnLevel1);
		

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

	}
}
