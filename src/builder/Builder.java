package builder;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controllers.LoadLightningLevel;
import controllers.LoadPuzzleLevel;
import controllers.LoadThemeLevel;
import entities.Board;
import entities.Lightning;
import entities.Puzzle;
import entities.Theme;
import player.Player;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;

/**
 * The over-arching class for the Builder for LetterCraze.
 * <p>
 * This allows the user to build levels to play in <code>Player.java</code>. 
 * The most important method for developers is <code>initialize</code> which 
 * is invoked when the Builder is started.
 * <p>
 * <code>initialize</code> must satisfy three responsibilities:
 * <ol>
 * <li>Initialize the model</li>
 * <li>Initialize the view</li>
 * <li>Initialize the controllers</li>
 * </ol>
 * <p>
 * Most <code>initialize</code> methods will follow this suggested format:
 * <br>
 * 
 * <pre>
 * &lt;blockquote&gt;
 *  public void initialize() {
 *    initializeModel();
 *    initializeView();
 *    initializeController();
 *  
 *    // Prepare initial builder setup.
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
 * This constructs a model of basic elements found in the Builder for LetterCraze -- 
 * a button to create a puzzle level, lightning level, and theme level, and anything
 * required for the GUI (e.g. labels and panes). Each model element has a name 
 * unique to the model. 
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
 * to View Widgets. These controllers react to the buttons being pressed. 
 * The controllers manage the user's interaction with the Builder.
 * <p>
 * <p>
 * Creation date: (12/5/2016)
 * 
 * @author Thomas Hagen, Rachel Hahn, Rayyan Khan, Hannah Olshansky, Lauren Pontbriant (Molybdenum)
 *
 */

public class Builder extends JFrame {
	/** The JPanel to manage the Builder. */
	private JPanel contentPane;
	
	/** The JButtons that will be added to the JPanel for the user to press. */
	private JButton createPuzzleBtn, createLightningBtn, createThemeBtn, editExistingBtn;
	
	/** The JLabel that will be added to the JPanel for the user to read. */
	private JLabel lblBuilder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuilderSplash frame = new BuilderSplash();
					Builder mainMenu = new Builder();
					
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
	public Builder() {	
		initialize();
	}
	
	/**
	 * Initialize the Builder.
	 */
	private void initialize(){
		initializeModel();
		initializeView();
		initializeController();
	}
	
	/**
	 * Initialize everything that will be added to the JPanel.
	 */
	private void initializeModel(){
		contentPane = new JPanel();
		
		createPuzzleBtn = new JButton("Build New Puzzle");
		createLightningBtn = new JButton("Build New Lightning");
		createThemeBtn = new JButton("Build New Theme");
		editExistingBtn = new JButton("Edit an Existing Level");
		
		
		lblBuilder = new JLabel("Level Builder");
		
	}
	
	/**
	 * Initialize where all the models will be placed on the JPanel.
	 */
	private void initializeView(){
		setResizable(false);
		setTitle("Letter Craze");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 570);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBuilder = new JLabel("Level Builder");
		lblBuilder.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblBuilder.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuilder.setBounds(326, 132, 355, 61);
		contentPane.add(lblBuilder);
		
		createPuzzleBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		createPuzzleBtn.setBounds(326, 200, 355, 61);
		contentPane.add(createPuzzleBtn);
		
		createLightningBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		createLightningBtn.setBounds(326, 200+70, 355, 61);
		contentPane.add(createLightningBtn);
		
		createThemeBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		createThemeBtn.setBounds(326, 200+140, 355, 61);
		contentPane.add(createThemeBtn);
		
		editExistingBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editExistingBtn.setBounds(326, 200+140+70, 355, 61);
		contentPane.add(editExistingBtn);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(Player.class.getResource("/images/BackgroundTitle.gif")));
		bg.setBounds(0, 0, 994, 541);
		contentPane.add(bg);
		
		
	}
	
	/**
	 * Initialize what happens when the buttons on the JPanel are pressed. 
	 */
	private void initializeController(){
		createPuzzleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PuzzleBuilder level = new PuzzleBuilder();
				level.setVisible(true);
				dispose();
			}
		});
		
		createLightningBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LightningBuilder level = new LightningBuilder();
				level.setVisible(true);
				dispose();
			}
		});
		
		createThemeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemeBuilder level = new ThemeBuilder();
				level.setVisible(true);
				dispose();
			}
		});
		
		editExistingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditExistingView view = new EditExistingView();
				view.setVisible(true);
				dispose();

				
			}
		});
	}
		}
