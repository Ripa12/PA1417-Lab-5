import java.util.ArrayList;
import java.util.List;

public class Game {
	private Frame[] frames;
	
	Game(){
		frames = new Frame[]{new Frame(), new Frame(), new Frame(),
				new Frame(), new Frame(), new Frame(), new Frame(),
				new Frame(), new Frame(), new Frame()};
	}
	
	Game(Frame[] f){
		frames = f;
	}
	
	public List<int[]> getAllThrows(){
		List<int[]> tempResult = new ArrayList<int[]>();
		
		for(int i = 0; i < frames.length; i++){
			tempResult.add(frames[i].getThrows());
		}
		
		return tempResult;
	}
}
