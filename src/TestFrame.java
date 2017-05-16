import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Assert;

public class TestFrame {
	protected Frame frameObject;
	
	@Before 
	public void setup() {
		frameObject = new Frame();
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
	
	
}
