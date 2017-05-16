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
	 * Test range of values for both throws from frame
     */
	@Test
	public void testThrowRange() {
		int[] tempThrows = frameObject.getThrows();
		
		assertTrue("Incorrect number of throws: " + tempThrows.length, tempThrows.length == 2);
		assertTrue("1st throw out of range: " + tempThrows[0], Frame.MINTHROW <= tempThrows[0] && tempThrows[0] <= Frame.MAXTHROW);
		assertTrue("2st throw out of range: " + tempThrows[1], Frame.MINTHROW <= tempThrows[1] && tempThrows[1] <= Frame.MAXTHROW);
	}
	
	
	
	
}
