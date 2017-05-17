import java.util.Random;

public class Frame {
	private Frame nextFrame;
	private int firstThrow;
	private int secondThrow;
	public static final int MINTHROW = 0;
	public static final int MAXTHROW = 10;
	
	Frame(Frame next){
		nextFrame = next;
		
		Random rand = new Random();

	    firstThrow = rand.nextInt((MAXTHROW - MINTHROW) + 1) + MINTHROW;
	    
	    if(firstThrow < 10)
	    	secondThrow = rand.nextInt((MAXTHROW - MINTHROW) + 1) + MINTHROW;
	    else
	    	secondThrow = 0;
	}
	
	Frame(int first, int second, Frame next){
		nextFrame = next;
		
		firstThrow = first;
		if(firstThrow < 10)
			secondThrow = second;
		else
	    	secondThrow = 0;
	}
	
	public Frame next(){
		return nextFrame;
	}
	
	public int[] getThrows(){
		return new int[]{firstThrow, secondThrow};
	}
	
	public int computeScore(){
		int result = firstThrow;
		if(firstThrow == 10){
			result += ((nextFrame != null) ? (nextFrame.getThrows()[0] + nextFrame.getThrows()[1]) : 0);
		}
		else{
			result += secondThrow;
			if(result == 10){
				result += ((nextFrame != null) ? nextFrame.getThrows()[0] : 0);
			}
		}
		
		return result;
	}
}
