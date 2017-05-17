import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Assert;

public class TestFrame {
	private Frame frameObject;
	private Frame frameZeroScore;
	private Frame frameNinePoints;
	
	private Frame frameStrike;
	private Frame frameStrikeAndNull;
	private Frame frameDoubleStrike;
	private Frame frameStrikeBeforeSpare;
	
	private Frame frameSpareAndNull;
	private Frame frameSpare;
	private Frame frameSecondSpare;
	
	@Before 
	public void setup() {
		frameObject = new Frame(null);
		frameZeroScore = new Frame(0, 0, null);
		frameNinePoints = new Frame(4, 5, null);
		
		frameStrike = new Frame(10, 5, frameNinePoints);	
		frameStrikeAndNull = new Frame(10, 5, null);
		frameDoubleStrike = new Frame(10, 5, new Frame(10, 0, frameNinePoints));	
		frameStrikeBeforeSpare = new Frame(10, 5, new Frame(2, 8, null));
		
		frameSpare = new Frame(2, 8, frameNinePoints);
		frameSpareAndNull = new Frame(2, 8, 7);
		frameSecondSpare = new Frame(0, 10, frameNinePoints);
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
		int score = frameStrike.computeScore();
		assertTrue("Score for strike is not correct: " + score, score == (19));
	}
	
	/* 
	 * Test that score is correctly computed for a spare
     */
	@Test
	public void testSpareScore() {
		int score = frameSpare.computeScore();
		assertTrue("Score for spare is not correct: " + score, score == (14));
	}
	
	/* 
	 * Test that score is correctly computed for a spare where
	 * the first throw is a total miss
     */
	@Test
	public void testSecondSpareScore() {
		int score = frameSecondSpare.computeScore();
		assertTrue("Score for spare is not correct: " + score, score == (14));
	}
	
	/* 
	 * Test scoring for spare that is the last spare in the game
     */
	@Test
	public void testFinalSpareScore() {
		int score = frameSpareAndNull.computeScore();
		assertTrue("Score for spare is not correct: " + score, score == (10 + 7));
	}
	
	/* 
	 * Test computeScore for a strike followed by a spare
     */
	@Test
	public void testStrikeBeforeSpareScore() {
		int score = frameStrikeBeforeSpare.computeScore();
		assertTrue("Score for strike is not correct: " + score, score == (20));
	}
	
	/* 
	 * Test computeScore for a strike followed by another strike
     */
	@Test
	public void testStrikeFollowedByStrikeScore() {
		int score = frameDoubleStrike.computeScore();
		assertTrue("Score for strike is not correct: " + score, score == (24));
	}
	
}
