package intro;

public class SleepMessages {
	
	private static String[] msg = {"hi", "hello", "привет"};
	
	public static void main(String[] args) throws InterruptedException {
		
		for (String oneMsg : msg) {
			System.out.println(oneMsg);
			Thread.sleep(4000);
		}
		
	}
	
}
