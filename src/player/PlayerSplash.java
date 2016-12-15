package player;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


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

		JLabel bg = new JLabel("");
		bg.setBounds(5, 5, 984, 531);
		bg.setIcon(new ImageIcon(PlayerSplash.class.getResource("/images/PlayerSplash.gif")));
		contentPane.add(bg);
		
		
		
		
	}
}
