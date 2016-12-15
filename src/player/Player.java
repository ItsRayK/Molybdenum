package player;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The over-arching class for the Player for LetterCraze.
 * <p>
 * This allows the user to play levels created by <code>Builder.java</code>. The
 * most important method for developers is <code>initialize</code> which is
 * invoked when the Player is started.
 * <p>
 * <code>initialize</code> must satisfy three responsibilities:
 * <ol>
 * <li>Initialize the model</li>
 * <li>Initialize the view</li>
 * <li>Initialize the controllers</li>
 * </ol>
 * <p>
 * Most <code>initialize</code> methods will follow this suggested format: <br>
 * 
 * <pre>
 * &lt;blockquote&gt;
 *  public void initialize() {
 *    initializeModel();
 *    initializeView();
 *    initializeController();
 *  
 *    // Prepare initial player setup.
 *    ...
 *  }
 *  &lt;/blockquote&gt;
 * </pre>
 * 
 * where <code>initializeModel</code>,<code>initializeView</code>, and
 * <code>initializeControllers</code> are protected methods of the plugin.
 * <p>
 * <b>Initialize the Model </b>
 * <p>
 * This constructs a model of basic elements found in the Player for
 * LetterCraze -- buttons to select a level, clear stars, anything required
 * to play a level (letter toggle buttons, submit word and undo buttons, etc.), 
 * and anything required for the GUI (e.g. labels and panes). Each model
 * element has a name unique to the model.
 * <p>
 * <b>Initialize the View </b>
 * <p>
 * Each model element can be represented by exactly one View Widget. Each View
 * Widget is placed at a specific (x,y) location within the coordinates of the
 * JPanel, and has a calculated width, and height.
 * <p>
 * <b>Initialize the Controllers </b>
 * <p>
 * The real power is in the way controller objects are constructed and attached
 * to View Widgets. These controllers react to the buttons being pressed. The
 * controllers manage the user's interaction with the Player.
 * <p>
 * <p>
 * Creation date: (12/5/2016)
 * 
 * @author Thomas Hagen, Rachel Hahn, Rayyan Khan, Hannah Olshansky, Lauren
 *         Pontbriant (Molybdenum)
 *
 */

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

	private void initialize() {
		initializeModel();
		initializeControllers();
		initializeView();
	}

	/**
	 * Initialize everything that will be added to the JPanel.
	 */
	private void initializeModel() {
		contentPane = new JPanel();

		levelSelectBtn = new JButton("Level Select");

		quitBtn = new JButton("Quit Game");

	}

	/**
	 * Initialize where everything will be placed in the JPanel.
	 */
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
		levelSelectBtn.setFocusPainted(false);
		contentPane.add(levelSelectBtn);

		quitBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		quitBtn.setBounds(326, 247, 355, 61);
		quitBtn.setFocusPainted(false);
		contentPane.add(quitBtn);

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(Player.class.getResource("/images/BackgroundTitle.gif")));
		bg.setBounds(0, 0, 994, 541);
		contentPane.add(bg);
	}

	/**
	 * Initialize what happens when buttons on the JPanel are pressed.
	 */
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
