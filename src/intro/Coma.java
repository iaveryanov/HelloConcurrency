package intro;

/*
 * ѕоток, который живет вечно, если его никто не interrupt со стороны
 */
public class Coma{
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Main: sleep!");
		Thread.currentThread().join(); //ждет своей смерти, пока кто-нибудь его убьет!
		System.out.println("Main: wake up!");
	}
}
