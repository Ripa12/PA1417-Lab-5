import java.util.Random;

public class Frame {
	private int firstThrow;
	private int secondThrow;
	public static final int MINTHROW = 0;
	public static final int MAXTHROW = 10;
	
	Frame(){
		Random rand = new Random();

	    firstThrow = rand.nextInt((MAXTHROW - MINTHROW) + 1) + MINTHROW;
	    
	    if(firstThrow < 10)
	    	secondThrow = rand.nextInt((MAXTHROW - MINTHROW) + 1) + MINTHROW;
	    else
	    	secondThrow = 0;
	}
	
	Frame(int first, int second){
		firstThrow = first;
		if(firstThrow < 10)
			secondThrow = second;
		else
	    	secondThrow = 0;
	}
	
	public int[] getThrows(){
		return new int[]{firstThrow, secondThrow};
	}
	
	public int computeScore(){	
		return firstThrow + secondThrow;
	}
	
	public int computeScore(Frame subsequentFrame){
		return firstThrow + ((firstThrow == 10) ?  subsequentFrame.computeScore() : secondThrow);
	}
}
