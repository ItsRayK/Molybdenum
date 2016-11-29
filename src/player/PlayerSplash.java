package player;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class PlayerSplash extends JFrame {
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
					
					Timer timer = new Timer(3000, new ActionListener() {
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
	public PlayerSplash() {
		splash();	

	}


	private void splash(){
		initializeModel();
		initializeView();
	}

	private void initializeModel() {
		contentPane = new JPanel();
		
		

	}

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
