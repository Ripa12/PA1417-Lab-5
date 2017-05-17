import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;


public class TestGame {
	protected Game gameObject;
	protected Game tenFramesGame;
	protected Game strikeGame;
	
	@Before 
	public void setup() {
		gameObject = new Game();
		tenFramesGame = new Game(new Frame[]{new Frame(1, 5), new Frame(3, 6), new Frame(7, 2),
				new Frame(3, 6), new Frame(4, 4), new Frame(5, 3), new Frame(3, 3),
				new Frame(4, 5), new Frame(8, 1), new Frame(2, 6)});
		
		strikeGame = new Game(new Frame[]{new Frame(10, 0), new Frame(3, 6), 
				new Frame(7, 2), new Frame(3, 6), new Frame(4, 4), 
				new Frame(5, 3), new Frame(3, 3),
				new Frame(4, 5), new Frame(10, 0), new Frame(10, 0)});
	}
	
	/* 
	 * Check if frames from game-object are valid 
	 * and that game contain 10 frames in total
     */
	@Test
	public void testGameFrames() {
		int[][] frames = new int[][]{{1, 5},{3, 6},{7, 2},{3, 6}, 
				{4, 4},{5, 3},{3, 3},{4, 5},{8, 1},{2, 6}};
		
		List<int[]> tempFrames = tenFramesGame.getAllThrows();
						
		assertTrue("Incorrect number of frames: " + tempFrames.size(), tempFrames.size() == 10);
		Assert.assertArrayEquals(frames, tempFrames.toArray());
	}
	
	/* 
	 * Check if random game contain 10 frames in total
     */
	@Test
	public void testRandomGame() {
		List<int[]> tempFrames = gameObject.getAllThrows();
						
		assertTrue("Incorrect number of frames: " + tempFrames.size(), tempFrames.size() == 10);
	}
	
	/* 
	 * Check if computed score for a game is correct
     */
	@Test
	public void testScoreOfGame() {
		int gameScore = tenFramesGame.computeScore();
						
		assertTrue("Incorrect game score: " + gameScore, gameScore == 81);
	}
	
	/* 
	 * Test scoring of game where the first frame and the last two frames are strikes
     */
	@Test
	public void testStrikeScoring() {
		int gameScore = strikeGame.computeScore();
						
		assertTrue("Incorrect game score: " + gameScore, gameScore == 107);
	}
}
