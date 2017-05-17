import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Assert;

public class TestFrame {
	protected Frame frameObject;
	protected Frame frameZeroScore;
	protected Frame frameTenScore;
	protected Frame frameStrike;
	
	@Before 
	public void setup() {
		frameObject = new Frame();
		frameZeroScore = new Frame(0, 0);
		frameTenScore = new Frame(5, 5);
		frameStrike = new Frame(10, 0);
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
	 * where both throws hit half of the pins
     */
	@Test
	public void testComputeScoreHalfOfPins() {
		assertTrue("Incorrect score computed: " + frameTenScore.computeScore(), frameTenScore.computeScore() == (10));
	}
	
	/* 
	 * Test if second throw of a frame is equal to zero after a strike
     */
	@Test
	public void testStrike() {
		assertTrue("First throw is not a strike: " + frameStrike.getThrows()[0], frameStrike.getThrows()[0] == (10));
		assertTrue("Second throw is not pointless: " + frameStrike.getThrows()[1], frameStrike.getThrows()[1] == (0));
	}
	
}
