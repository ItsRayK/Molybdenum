package builder;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class BuilderSplash extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					BuilderSplash frame = new BuilderSplash();
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
	public BuilderSplash() {
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
		bg.setIcon(new ImageIcon(BuilderSplash.class.getResource("/images/BuilderSplash.gif")));
		contentPane.add(bg);
		
		
		
		
	}
}
