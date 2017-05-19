import java.util.ArrayList;
import java.util.List;

public class Game {
	private Frame firstFrame; 
	private Frame lastFrame;
	
	Game(){
		firstFrame = new Frame(null);
		lastFrame = firstFrame;
		for(int i = 1; i < (9); i++){
			Frame newFrame = new Frame(null); 
			lastFrame.setNext(newFrame); 
			lastFrame = newFrame;
		}
		Frame newFrame = new Frame(null); 
		lastFrame.setNext(newFrame); 
		lastFrame = newFrame;
	}
	
	Game(int[][] f){
		firstFrame = new Frame(f[0][0],f[0][1], null);
		lastFrame = firstFrame;
		for(int i = 1; i < (f.length - 1); i++){
			Frame newFrame = new Frame(f[i][0],f[i][1], null); 
			lastFrame.setNext(newFrame); 
			lastFrame = newFrame;
		}
		int end = (f.length-1);
		Frame newFrame = new Frame(f[end][0],f[end][1], ((f[end].length > 2) ? f[end][2] : 0), ((f[end].length > 3) ? f[end][3] : 0)); 
		lastFrame.setNext(newFrame); 
		lastFrame = newFrame;
	}
	
	public List<int[]> getAllThrows(){
		List<int[]> tempResult = new ArrayList<int[]>();
		
		Frame iter = firstFrame;
		
		for(; iter != null; iter = iter.next()){
			tempResult.add(iter.getThrows());
		}
		
		return tempResult;
	}
	
	public int computeScore(){
		int result = 0;
			
		Frame iter = firstFrame;
		
		for(; iter != null; iter = iter.next()){
			result += iter.computeScore();
		}
		
		return result;
	}
}
