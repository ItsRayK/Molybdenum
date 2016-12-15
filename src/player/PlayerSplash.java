package player;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.awt.event.ActionEvent;


public class PlayerSplash extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					PlayerSplash frame = new PlayerSplash();
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
	public PlayerSplash() {
		UIManager.put("ToggleButton.select", Color.YELLOW);
		splash();	

	}


	/**
	 * Initialize the Splash Screen.
	 */
	private void splash(){
		initializeModel();
		initializeView();
	}

	/**
	 * Initialize everything that will be added to the JPanel.
	 */
	private void initializeModel() {
		contentPane = new JPanel();
		
		

	}

	/**
	 * Initialize where everything will be placed on the JPanel.
	 */
	private void initializeView() {
		
		
		setResizable(false);
		setTitle("Letter Craze");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 570);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String path = "src/SavedStars.txt";
				String scorePath = "src/SavedScores.txt";
				BufferedWriter bw;
				try {
					bw = new BufferedWriter(new FileWriter(path, false));
					for (int i = 0; i < 15; i++) {
						bw.write("3");
						bw.newLine();
						bw.flush();
						
					}
					bw.close();
				} catch (Exception e) {

				}
			}
		});
		btnNewButton.setToolTipText("ULTIMATE CHEATER!!!");
		btnNewButton.setBounds(5, 507, 30, 29);
		btnNewButton.setFocusPainted(false);
		contentPane.add(btnNewButton);

		JLabel bg = new JLabel("");
		bg.setBounds(5, 5, 984, 531);
		bg.setIcon(new ImageIcon(PlayerSplash.class.getResource("/images/PlayerSplash.gif")));
		contentPane.add(bg);
		
		
		
		
	}
}
