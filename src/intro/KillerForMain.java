package intro;

public class KillerForMain implements Runnable{
	
	private static Thread mainThread;

	public static void main(String[] args) throws InterruptedException {
		
		mainThread = Thread.currentThread();
		
		new Thread(new KillerForMain()).start();
		
		System.out.println("Main: sleep!");
		Thread.currentThread().join(); //ждет своей смерти, пока кто-нибудь его убьет!
		System.out.println("Main: wake up!");
	}

	@Override
	public void run() {
		
		try {
			
			System.out.println("Other thread: sleep!");
			Thread.currentThread().sleep(2000);
			System.out.println("Other thread: wake up!");
			
			System.out.println("shoot to main");
			mainThread.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
