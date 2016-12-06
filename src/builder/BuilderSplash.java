package builder;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * The class for the Builder Splash Screen.
 * <p>
 * This creates a Splash Screen that appears before the Builder application. 
 * 
 * Creation date: (12/5/2016)
 * 
 * @author Thomas Hagen, Rachel Hahn, Rayyan Khan, Hannah Olshansky, Lauren Pontbriant (Molybdenum)
 * 
 */


public class BuilderSplash extends JFrame {
	/**
	 * The JPanel to manage the Builder Splash Screen.
	 */
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
		bg.setIcon(new ImageIcon(BuilderSplash.class.getResource("/images/BuilderSplash.gif")));
		contentPane.add(bg);
		
		
		
		
	}
}
