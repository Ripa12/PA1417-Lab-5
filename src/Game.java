import java.util.ArrayList;
import java.util.List;

public class Game {
	private Frame[] frames;
	
	Game(){
		frames = new Frame[]{new Frame(0, 0), new Frame(0, 0), new Frame(0, 0),
				new Frame(0, 0), new Frame(0, 0), new Frame(0, 0), new Frame(0, 0),
				new Frame(0, 0), new Frame(0, 0), new Frame(0, 0)};
	}
	
	Game(Frame[] f){
		frames = f;
	}
	
	public List<int[]> getAllThrows(){
		int[][] result = null;
		List<int[]> tempResult = new ArrayList<int[]>();
		
		for(int i = 0; i < frames.length; i++){
			tempResult.add(frames[i].getThrows());
		}
		
		return tempResult;
	}
}
