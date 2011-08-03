package intro;

public class HelloRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("new thread!");
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Thread t = new Thread(new HelloRunnable());
		t.setName("new-thread");
		
		t.start();
	}

}
