import java.util.Random;

public class Frame {
	private int firstThrow;
	private int secondThrow;
	private final int MINTHROW = 0;
	private final int MAXTHROW = 10;
	
	Frame(){
		Random rand = new Random();

	    firstThrow = rand.nextInt((MAXTHROW - MINTHROW) + 1) + MINTHROW;
	    secondThrow = rand.nextInt((MAXTHROW - MINTHROW) + 1) + MINTHROW;
	}
	
	public int[] getThrows(){
		int[] result = new int[]{firstThrow, secondThrow};
		
		return result;
	}
}
