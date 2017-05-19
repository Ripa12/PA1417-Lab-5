import java.util.Random;

public class Frame {
	private Frame nextFrame;
	private int firstThrow;
	private int secondThrow;
	private int firstBonusThrow;
	private int secondBonusThrow;
	public static final int MINTHROW = 0;
	public static final int MAXTHROW = 10;
	
	Frame(Frame next){
		nextFrame = next;
		firstBonusThrow = 0;
		secondBonusThrow = 0;
		
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
		secondBonusThrow = 0;
		
		firstThrow = first;
		if(firstThrow < 10)
			secondThrow = second;
		else
	    	secondThrow = 0;
	}
	
	Frame(int first, int second, int firstBonus, int secondBonus){
		nextFrame = null;
		firstBonusThrow = firstBonus;
		secondBonusThrow = secondBonus;
		
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
	
	private int computeConsecutiveStrikes(Frame next, int countdown){
		int result = 0;
		
		if(next != null){
			result = next.firstThrow;
			if((result == 10) && (countdown > 0)){
				if(next.nextFrame == null)
					result += next.firstBonusThrow;
				else
					result += computeConsecutiveStrikes(next.nextFrame, (countdown - 1));
			}
		}
		
		return result;
	}
	
	public int computeScore(){
		int result = firstThrow;
		if(firstThrow == 10){
			if(nextFrame != null){
				if(nextFrame.firstThrow == 10)
					result += computeConsecutiveStrikes(nextFrame, 1);
				else
					result += (nextFrame.firstThrow + nextFrame.secondThrow);
			}
			else{
				result += (firstBonusThrow + secondBonusThrow);
			}
		}
		else{
			result += secondThrow;
			if(result == 10){
				result += ((nextFrame != null) ? nextFrame.firstThrow : firstBonusThrow);
			}
		}
		
		return result;
	}
}
