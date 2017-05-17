import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Assert;

public class TestFrame {
	protected Frame frameObject;
	protected Frame frameZeroScore;
	protected Frame frameNinePoints;
	protected Frame frameStrike;
	protected Frame frameSpare;
	
	@Before 
	public void setup() {
		frameObject = new Frame();
		frameZeroScore = new Frame(0, 0);
		frameStrike = new Frame(10, 5);
		frameNinePoints = new Frame(4, 5);
		frameSpare = new Frame(2, 8);
	}
	
	/* 
	 * Test range of the values for both throws from frame 
	 * and the length of the returned array
     */
	@Test
	public void testGetThrows() {
		int[] tempThrows = frameObject.getThrows();
		
		assertTrue("Incorrect number of throws: " + tempThrows.length, tempThrows.length == 2);
		assertTrue("1st throw out of range: " + tempThrows[0], Frame.MINTHROW <= tempThrows[0] && tempThrows[0] <= Frame.MAXTHROW);
		assertTrue("2st throw out of range: " + tempThrows[1], Frame.MINTHROW <= tempThrows[1] && tempThrows[1] <= Frame.MAXTHROW);
	}
	
	/* 
	 * Test the computed score for one single frame
     */
	@Test
	public void testComputeScore() {
		int[] tempThrows = frameObject.getThrows();
		
		assertTrue("Incorrect score computed: " + frameObject.computeScore(), frameObject.computeScore() == (tempThrows[0] + tempThrows[1]));
	}
	
	/* 
	 * Test the computed score for one single frame
	 * where both throws miss every pin
     */
	@Test
	public void testComputeScoreZeroPins() {
		assertTrue("Incorrect score computed: " + frameZeroScore.computeScore(), frameZeroScore.computeScore() == (0));
	}
	
	/* 
	 * Test the computed score for one single frame
	 * that equals nine points
     */
	@Test
	public void testComputeScoreNinePoints() {
		assertTrue("Incorrect score computed: " + frameNinePoints.computeScore(), frameNinePoints.computeScore() == (9));
	}
	
	/* 
	 * Test if second throw of a frame is equal to zero after a strike
     */
	@Test
	public void testStrike() {
		assertTrue("First throw is not a strike: " + frameStrike.getThrows()[0], frameStrike.getThrows()[0] == (10));
		assertTrue("Second throw is not pointless: " + frameStrike.getThrows()[1], frameStrike.getThrows()[1] == (0));
	}
	
	/* 
	 * Test if score is correctly computed for a strike
     */
	@Test
	public void testStrikeScore() {
		int score = frameStrike.computeScore(frameNinePoints);
		assertTrue("Score for strike is not correct: " + score, score == (19));
	}
	
	/* 
	 * Test that score is correctly computed for a spare
     */
	@Test
	public void testSpareScore() {
		int score = frameSpare.computeScore(frameNinePoints);
		assertTrue("Score for spare is not correct: " + score, score == (14));
	}
	
}
