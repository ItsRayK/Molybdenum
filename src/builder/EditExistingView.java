package builder;

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

import controllers.UpdateLevelSelectStars;
import player.LevelSelect;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

/**
 * The Builder class to edit existing levels.
 * <p>
 * This allows the user to edit an existing level in case they want to make
 * changes for a certain level that will be played by the <code>Player.java</code>.
 * 
 * Creation date: (12/5/2016)
 * 
 * @author Thomas Hagen, Rachel Hahn, Rayyan Khan, Hannah Olshansky, Lauren
 *         Pontbriant (Molybdenum)
 * 
 */

public class EditExistingView extends JFrame {
	private JPanel contentPane;
	private JButton btnEditLevel;
	private JList list;
	private DefaultListModel levelList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditExistingView frame = new EditExistingView(null);
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
	public EditExistingView(Builder b) {
		setTitle("Select a Level to Edit");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 302, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnEditLevel = new JButton("Edit Level");
		btnEditLevel.setBounds(10, 363, 266, 27);
		contentPane.add(btnEditLevel);

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
				System.out.println("File " + listOfFiles[i].getName());
				levelList.addElement(listOfFiles[i].getName());
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}

		btnEditLevel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String lvlname = (String) list.getSelectedValue();
				String path = "savedLevels/" + lvlname;
				if (lvlname != null) {
					try {
						String readCheck = Files.readAllLines(Paths.get(path)).get(41);
						if (readCheck.equals("Puzzle")) {
							PuzzleBuilder puzz = new PuzzleBuilder();
							int k = 4;
							for (int i = 0; i < 6; i++) {
								for (int j = 0; j < 6; j++) {
									if (Files.readAllLines(Paths.get(path)).get(k).equals("false")) {
										puzz.getCheckBox()[i][j].setSelected(false);
									}
									k++;
								}
							}
							puzz.setNameText(lvlname.replaceAll(".txt", ""));
							puzz.setWordLimit(Files.readAllLines(Paths.get(path)).get(40));
							puzz.set1StarScoreText(Files.readAllLines(Paths.get(path)).get(1));
							puzz.set2StarScoreText(Files.readAllLines(Paths.get(path)).get(2));
							puzz.set3StarScoreText(Files.readAllLines(Paths.get(path)).get(3));
							puzz.setVisible(true);
							System.out.println("Puzzle Builder Loaded");
						} else if (readCheck.equals("Lightning")) {
							LightningBuilder puzz = new LightningBuilder();
							int k = 4;
							for (int i = 0; i < 6; i++) {
								for (int j = 0; j < 6; j++) {
									if (Files.readAllLines(Paths.get(path)).get(k).equals("false")) {
										puzz.getCheckBox()[i][j].setSelected(false);
									}
									k++;
								}
							}

							puzz.setNameText(lvlname.replaceAll(".txt", ""));
							puzz.setTimeLimit(Files.readAllLines(Paths.get(path)).get(40));
							puzz.set1StarScoreText(Files.readAllLines(Paths.get(path)).get(1));
							puzz.set2StarScoreText(Files.readAllLines(Paths.get(path)).get(2));
							puzz.set3StarScoreText(Files.readAllLines(Paths.get(path)).get(3));
							puzz.setVisible(true);
							System.out.println("Lightning Builder Loaded");
						} else if (readCheck.equals("Theme")) {
							ThemeBuilder puzz = new ThemeBuilder();
							int k = 4;
							int l = 42;
							for (int i = 0; i < 6; i++) {
								for (int j = 0; j < 6; j++) {
									if (Files.readAllLines(Paths.get(path)).get(k).equals("false")) {
										puzz.getCheckBox()[i][j].setSelected(false);
									}
									if (!Files.readAllLines(Paths.get(path)).get(l).equals("null")) {
										puzz.getLetterField()[i][j].setText(Files.readAllLines(Paths.get(path)).get(l));
										;
									}
									k++;
									l++;
								}
							}
							int m = 78;
							while (!Files.readAllLines(Paths.get(path)).get(m).equals("endofdocument")) {
								puzz.setWordsToFind(Files.readAllLines(Paths.get(path)).get(m));
								m++;
							}
							puzz.setNameText(lvlname.replaceAll(".txt", ""));
							puzz.setThemeName(Files.readAllLines(Paths.get(path)).get(40));
							puzz.set1StarScoreText(Files.readAllLines(Paths.get(path)).get(1));
							puzz.set2StarScoreText(Files.readAllLines(Paths.get(path)).get(2));
							puzz.set3StarScoreText(Files.readAllLines(Paths.get(path)).get(3));

							puzz.setVisible(true);
							System.out.println("Theme Builder Loaded");
						} else {
							System.out.println(readCheck);
						}
						b.dispose();
						dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					System.out.println("Please select a file.");
				}
			}

		});
	}

	public JButton getBtnEditLevel() {
		return btnEditLevel;
	}
}
