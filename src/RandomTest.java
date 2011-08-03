import java.util.Random;


public class RandomTest {

	public static void main(String[] args) {
		
		Random random = new Random();
		
		for (int i = 0; i < 100; i++) {
			System.out.format("%s\n", random.nextInt(10));
		}
	}
}
