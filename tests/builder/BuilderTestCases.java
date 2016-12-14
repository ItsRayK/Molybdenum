package builder;

import static org.junit.Assert.*;

import java.io.*;
import java.nio.file.*;

import org.junit.Test;

import player.PlayCustomView;
import player.PlayerSplash;

public class BuilderTestCases {
	private PuzzleBuilder setupPuzzleBuilder() {
		PuzzleBuilder pB = new PuzzleBuilder();
		return pB;
	}

	private LightningBuilder setupLightningBuilder() {
		LightningBuilder lB = new LightningBuilder();
		return lB;
	}

	private ThemeBuilder setupThemeBuilder() {
		// TODO Auto-generated method stub
		ThemeBuilder tB = new ThemeBuilder();
		return tB;
	}

	@Test
	public void testPuzzleBuilder() throws IOException {
		PuzzleBuilder pb = setupPuzzleBuilder();
		EditExistingView custom = new EditExistingView(new Builder());
		String path = "savedLevels/Puzzle Test.txt";

		pb.getCheckBox()[0][0].setSelected(false);
		pb.set1StarScoreText("1");
		pb.set2StarScoreText("3");
		pb.set3StarScoreText("3");
		pb.setNameText("Puzzle Test");
		pb.setWordLimit("5");
		pb.getBtnPreview().doClick();
		pb.getBtnSaveLevel().doClick();

		assertEquals("Puzzle Test", Files.readAllLines(Paths.get(path)).get(0));
		assertEquals("1", Files.readAllLines(Paths.get(path)).get(1));
		assertEquals("3", Files.readAllLines(Paths.get(path)).get(2));
		assertEquals("3", Files.readAllLines(Paths.get(path)).get(3));
		assertEquals("5", Files.readAllLines(Paths.get(path)).get(40));
		
		pb.getBtnDelete().doClick();
		pb.getBtnBack().doClick();
		BuilderSplash bS = new BuilderSplash();
		bS.dispose();
		custom.dispose();

	}

	@Test
	public void testLightningBuilder() throws IOException {
		LightningBuilder lb = setupLightningBuilder();
		String path = "savedLevels/Lightning Test.txt";
		
		lb.getCheckBox()[0][0].setSelected(false);
		lb.set1StarScoreText("1");
		lb.set2StarScoreText("3");
		lb.set3StarScoreText("4");

		lb.setTimeLimit("20");
		lb.setNameText("Lightning Test");

		lb.getBtnPreview().doClick();
		lb.getBtnSaveLevel().doClick();
		
		assertEquals("Lightning Test", Files.readAllLines(Paths.get(path)).get(0));
		assertEquals("1", Files.readAllLines(Paths.get(path)).get(1));
		assertEquals("3", Files.readAllLines(Paths.get(path)).get(2));
		assertEquals("4", Files.readAllLines(Paths.get(path)).get(3));
		assertEquals("20", Files.readAllLines(Paths.get(path)).get(40));
		
		lb.getBtnDelete().doClick();
		lb.getBtnBack().doClick();

	}

	@Test
	public void testThemeBuilder() throws IOException {
		ThemeBuilder tb = setupThemeBuilder();
		String path = "savedLevels/Theme Test.txt";
		
		tb.getCheckBox()[0][0].setSelected(false);
		tb.set1StarScoreText("1");
		tb.set2StarScoreText("3");
		tb.set3StarScoreText("4");

		tb.setNameText("Theme Test");
		tb.setWordsToFind("Test");
		tb.getBtnPreview().doClick();
		tb.getBtnSaveLevel().doClick();
		
		assertEquals("Theme Test", Files.readAllLines(Paths.get(path)).get(0));
		assertEquals("1", Files.readAllLines(Paths.get(path)).get(1));
		assertEquals("3", Files.readAllLines(Paths.get(path)).get(2));
		assertEquals("4", Files.readAllLines(Paths.get(path)).get(3));
		assertEquals("Test", Files.readAllLines(Paths.get(path)).get(78));
		
		tb.getBtnDelete().doClick();
		tb.getBtnBack().doClick();
		
		
			
				
			

		

	}

}
