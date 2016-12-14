package player;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controllers.LoadLightningLevel;
import controllers.LoadPuzzleLevel;
import controllers.LoadThemeLevel;
import controllers.UpdateLevelSelectStars;
import entities.Board;
import entities.Lightning;
import entities.Puzzle;
import entities.Theme;
import player.LevelSelect;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

public class PlayCustomView extends JFrame {
	private JPanel contentPane;
	private JButton btnPlayLevel;
	private JList list;
	private DefaultListModel levelList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayCustomView frame = new PlayCustomView(null);
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
	public PlayCustomView(LevelSelect ls) {
		setTitle("Select a Level to Play");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 302, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnPlayLevel = new JButton("Play Level");
		btnPlayLevel.setBounds(10, 363, 266, 27);
		contentPane.add(btnPlayLevel);

		levelList = new DefaultListModel();

		list = new JList(levelList);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(10, 11, 266, 341);
		JScrollPane jsp = new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.setBounds(10, 11, 266, 341);
		contentPane.add(jsp);

		File folder = new File("savedLevels");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				if (!listOfFiles[i].getName().contains("Level")) {
					levelList.addElement(listOfFiles[i].getName());
				}
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}

		btnPlayLevel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String lvlname = (String) list.getSelectedValue();
				String path = "savedLevels/" + lvlname;
				if (lvlname != null) {
					try {
						String readCheck = Files.readAllLines(Paths.get(path)).get(41);
						if (readCheck.equals("Puzzle")) {
							LoadPuzzleLevel puzz = new LoadPuzzleLevel(lvlname.replace(".txt", ""),
									new Puzzle(lvlname.replace(".txt", ""), new Board()));
							puzz.loadPuzzle();
							System.out.println("Puzzle Loaded");
						} else if (readCheck.equals("Lightning")) {
							LoadLightningLevel temp = new LoadLightningLevel(lvlname.replace(".txt", ""),
									new Lightning(lvlname.replace(".txt", ""), new Board()));
							temp.loadLightning();
							System.out.println("Lightning Loaded");
						} else if (readCheck.equals("Theme")) {
							LoadThemeLevel temp = new LoadThemeLevel(lvlname.replace(".txt", ""),
									new Theme(lvlname.replace(".txt", ""), new Board()));
							temp.loadTheme();
							System.out.println("Theme Loaded");
						} else {
							System.out.println(readCheck);
						}
						dispose();
						ls.dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else{
					System.out.println("Please select a file.");
				}
			}
		});
	}
}
