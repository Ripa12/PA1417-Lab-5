import java.util.Random;

public class Frame {
	private int firstThrow;
	private int secondThrow;
	public static final int MINTHROW = 0;
	public static final int MAXTHROW = 10;
	
	Frame(){
		Random rand = new Random();

	    firstThrow = rand.nextInt((MAXTHROW - MINTHROW) + 1) + MINTHROW;
	    secondThrow = rand.nextInt((MAXTHROW - MINTHROW) + 1) + MINTHROW;
	}
	
	public int[] getThrows(){
		return new int[]{firstThrow, secondThrow};
	}
}
