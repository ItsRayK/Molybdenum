package builder;

import static org.junit.Assert.*;

import org.junit.Test;

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
	public void testPuzzleBuilder() {
		PuzzleBuilder pb = setupPuzzleBuilder();
		pb.getCheckBox()[0][0].setSelected(false);
		pb.set1StarScoreText("1");
		pb.set2StarScoreText("3");
		pb.set3StarScoreText("3");

		pb.setWordLimit("5");
		pb.getBtnPreview().doClick();
		pb.getBtnSaveLevel().doClick();
		pb.getBtnDelete().doClick();
		pb.getBtnBack().doClick();

	}

	@Test
	public void testLightningBuilder() {
		LightningBuilder lb = setupLightningBuilder();

		lb.getCheckBox()[0][0].setSelected(false);
		lb.set1StarScoreText("1");
		lb.set2StarScoreText("3");
		lb.set3StarScoreText("4");

		lb.setTimeLimit("5");
		lb.setName("Lightning Test");

		lb.getBtnPreview().doClick();
		lb.getBtnSaveLevel().doClick();
		lb.getBtnDelete().doClick();
		lb.getBtnBack().doClick();

	}

	@Test
	public void testThemeBuilder() {
		ThemeBuilder tb = setupThemeBuilder();
		tb.getCheckBox()[0][0].setSelected(false);
		tb.set1StarScoreText("1");
		tb.set2StarScoreText("3");
		tb.set3StarScoreText("3");

		tb.setName("Lightning Test");
		tb.setWordsToFind("Test");
		tb.getBtnPreview().doClick();
		tb.getBtnSaveLevel().doClick();
		tb.getBtnDelete().doClick();
		tb.getBtnBack().doClick();

	}

}
