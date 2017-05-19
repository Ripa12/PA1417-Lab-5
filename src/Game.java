import java.util.ArrayList;
import java.util.List;

public class Game {
	private Frame firstFrame; 
	
	Game(){
		firstFrame = new Frame(new Frame(new Frame(new Frame(new Frame(new Frame(new Frame(new Frame(new Frame(new Frame(null))))))))));
	}
	
	Game(int[][] f){
		// ToDo: Refactor this line
		firstFrame = new Frame(f[0][0],f[0][1],new Frame(f[1][0],f[1][1],new Frame(f[2][0],f[2][1],new Frame(f[3][0],f[3][1],new Frame(f[4][0],f[4][1],new Frame(f[5][0],f[5][1],new Frame(f[6][0],f[6][1],new Frame(f[7][0],f[7][1],new Frame(f[8][0],f[8][1],new Frame(f[9][0],f[9][1],((f[9].length > 2) ? f[9][2] : 0), ((f[9].length > 3) ? f[9][3] : 0)))))))))));
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
