import java.util.Random;

public class Frame {
	private Frame nextFrame;
	private int firstThrow;
	private int secondThrow;
	private int firstBonusThrow;
	public static final int MINTHROW = 0;
	public static final int MAXTHROW = 10;
	
	Frame(Frame next){
		nextFrame = next;
		firstBonusThrow = 0;
		
		Random rand = new Random();

	    firstThrow = rand.nextInt((MAXTHROW - MINTHROW) + 1) + MINTHROW;
	    
	    if(firstThrow < 10)
	    	secondThrow = rand.nextInt((MAXTHROW - MINTHROW) + 1) + MINTHROW;
	    else
	    	secondThrow = 0;
	}
	
	Frame(int first, int second, Frame next){
		nextFrame = next;
		firstBonusThrow = 0;
		
		firstThrow = first;
		if(firstThrow < 10)
			secondThrow = second;
		else
	    	secondThrow = 0;
	}
	
	Frame(int first, int second, int firstBonus){
		nextFrame = null;
		firstBonusThrow = firstBonus;
		
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
	
	private int computeConsecutiveStrikes(Frame next){
		int result = 0;
		
		if(next != null){
			if(next.getThrows()[0] == 10){
				result += computeConsecutiveStrikes(next.next());
			}
			result += next.getThrows()[0];
		}
		
		return result;
	}
	
	public int computeScore(){
		int result = firstThrow;
		if(firstThrow == 10){
			if(nextFrame != null){
				if(nextFrame.getThrows()[0] == 10)
					result += computeConsecutiveStrikes(nextFrame);
				else
					result += (nextFrame.getThrows()[0] + nextFrame.getThrows()[1]);
			}
		}
		else{
			result += secondThrow;
			if(result == 10){
				result += ((nextFrame != null) ? nextFrame.getThrows()[0] : firstBonusThrow);
			}
		}
		
		return result;
	}
}
