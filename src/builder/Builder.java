package builder;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import player.Player;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Builder extends JFrame {
	private JPanel contentPane;
	private JButton createPuzzleBtn, createLightningBtn, createThemeBtn;
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
	
	private void initialize(){
		initializeModel();
		initializeController();
		initializeView();
	}
	
	private void initializeModel(){
		contentPane = new JPanel();
		
		createPuzzleBtn = new JButton("Build Puzzle");
		createLightningBtn = new JButton("Build Lightning");
		createThemeBtn = new JButton("Build Theme");
		
		lblBuilder = new JLabel("Level Builder");
		
	}
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
		createPuzzleBtn.setBounds(326, 247, 355, 61);
		contentPane.add(createPuzzleBtn);
		
		createLightningBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		createLightningBtn.setBounds(326, 247+70, 355, 61);
		contentPane.add(createLightningBtn);
		
		createThemeBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		createThemeBtn.setBounds(326, 247+140, 355, 61);
		contentPane.add(createThemeBtn);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(Player.class.getResource("/images/BackgroundTitle.gif")));
		bg.setBounds(0, 0, 994, 541);
		contentPane.add(bg);
		
		
	}
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
	}
		}
