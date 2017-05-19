import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;


public class TestGame {
	private Game gameObject;
	private Game tenFramesGame;
	private Game strikeGame;
	private Game spareGame;
	private Game gameStrikeAndSpare;
	private Game gameConsecutiveStrikes;
	private Game gameConsecutiveSpares;
	private Game gameSpareLast;
	private Game gameStrikeLast;
	private Game gameSpareLastStrikeBonus;
	private Game gameBestScore;
	
	@Before 
	public void setup() {
		gameObject = new Game();
		tenFramesGame = new Game(new int[][]{{1, 5}, {3, 6}, {7, 2},
				{3, 6}, {4, 4}, {5, 3}, {3, 3},
				{4, 5}, {8, 1}, {2, 6}});
		
		strikeGame = new Game(new int[][]{{10, 0}, {3, 6}, 
				{7, 2}, {3, 6}, {4, 4}, 
				{5, 3}, {3, 3},
				{4, 5}, {10, 0}, {10, 0}});
		spareGame = new Game(new int[][]{{9, 1}, {3, 6}, 
				{7, 2}, {3, 6}, {4, 4}, 
				{5, 3}, {3, 3},
				{4, 5}, {2, 8}, {7, 3}});
		gameStrikeAndSpare = new Game(new int[][]{{10, 0}, {4, 6}, 
				{7, 2}, {3, 6}, {4, 4}, 
				{5, 3}, {3, 3},
				{4, 5}, {10, 8}, {7, 3}});
		gameConsecutiveStrikes = new Game(new int[][]{{10, 0}, {10, 0}, 
				{7, 2}, {3, 6}, {4, 4}, 
				{5, 3}, {3, 3},
				{4, 5}, {10, 8}, {10, 3}});
		gameConsecutiveSpares = new Game(new int[][]{{8, 2}, {5, 5}, {7, 2}, {3, 6}, 
				{4, 4}, {5, 3}, {3, 3}, {4, 5}, {8, 1} ,{2, 6}});
		gameSpareLast = new Game(new int[][]{{1, 5}, {3, 6}, {7, 2}, {3, 6}, {4, 4},
				{5, 3}, {3, 3}, {4, 5}, {8, 1}, {2, 8, 7}});
		gameStrikeLast = new Game(new int[][]{{1, 5}, {3, 6}, {7, 2}, {3, 6}, {4, 4},
			{5, 3}, {3, 3}, {4, 5}, {8, 1}, {10, 0, 7, 2}});
		gameSpareLastStrikeBonus = new Game(new int[][]{{1, 5}, {3, 6}, {7, 2}, {3, 6}, {4, 4},
			{5, 3}, {3, 3}, {4, 5}, {8, 1}, {2, 8, 10, 2}});
		gameBestScore = new Game(new int[][]{{10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0},
			{10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0, 10, 10}}); 
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
	
	/* 
	 * Test scoring of game where the first frame and the last two frames are spares
     */
	@Test
	public void testSpareScoring() {
		int gameScore = spareGame.computeScore();
						
		assertTrue("Incorrect game score: " + gameScore, gameScore == 98);
	}
	
	/* 
	 * Test scoring of game where the first frame and the next to last frame are strikes
	 * and they are both followed by spares
     */
	@Test
	public void testStrikesBeforeSparesScoring() {
		int gameScore = gameStrikeAndSpare.computeScore();
						
		assertTrue("Incorrect game score: " + gameScore, gameScore == 116);
	}
	
	/* 
	 * Test scoring of game containing two consecutive strikes
     */
	@Test
	public void testConsecutiveStrikesScoring() {
		int gameScore = gameConsecutiveStrikes.computeScore();
						
		assertTrue("Incorrect game score: " + gameScore, gameScore == 125);
	}
	
	/* 
	 * Test scoring of game containing two consecutive spares
     */
	@Test
	public void testConsecutiveSparesScoring() {
		int gameScore = gameConsecutiveSpares.computeScore();
						
		assertTrue("Incorrect game score: " + gameScore, gameScore == 98);
	}
	
	/* 
	 * Test scoring of game where the last frame is a spare
     */
	@Test
	public void testFinalFrameIsSpareScoring() {
		int gameScore = gameSpareLast.computeScore();
						
		assertTrue("Incorrect game score: " + gameScore, gameScore == (83 + 7));
	}
	
	/* 
	 * Test scoring of game where the last frame is a strike
     */
	@Test
	public void testFinalFrameIsStrikeScoring() {
		int gameScore = gameStrikeLast.computeScore();
						
		assertTrue("Incorrect game score: " + gameScore, gameScore == (83 + 7 + 2));
	}
	
	/* 
	 * Test scoring of game where the last frame is a spare and bonus throw is a strike
     */
	@Test
	public void testFinalFrameIsSpareAndBonusIsStrikeScoring() {
		int gameScore = gameSpareLastStrikeBonus.computeScore();
						
		assertTrue("Incorrect game score: " + gameScore, gameScore == (83 + 10));
	}
	
	/* 
	 * Test scoring of game in which all frames are strikes, including bonus throw
     */
	@Test
	public void testPerfectGameScoring() {
		int gameScore = gameBestScore.computeScore();
						
		assertTrue("Incorrect game score: " + gameScore, gameScore == (280 + 10 + 10));
	}
}
