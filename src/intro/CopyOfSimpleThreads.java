package intro;

public class CopyOfSimpleThreads {

	// Display a message, preceded by the name of the current thread
	static void threadMessage(String message) {
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s%n", threadName, message);
	}

	private static class MessageLoop implements Runnable {
		public void run() {
			String importantInfo[] = { "111", "222", "333", "444" };
			
			int counter = 0;
			

			while (true) {
				
				if (Thread.currentThread().isInterrupted())
					return;

				int i = counter%4;
				counter++;
				
				// Print a message
				threadMessage(importantInfo[i]);
				System.out.println("isInterrupted: "+Thread.currentThread().isInterrupted());
			}

		}
	}

	public static void main(String args[]) throws InterruptedException {

		// Delay, in milliseconds before we interrupt MessageLoop
		// thread (default one hour).
		long patience = 1000 * 30;

		threadMessage("Starting MessageLoop thread");
		long startTime = System.currentTimeMillis();
		Thread t = new Thread(new MessageLoop());
		t.start();

		threadMessage("Waiting for MessageLoop thread to finish");
		
		// loop until MessageLoop thread exits
		while (t.isAlive()) {
			
			threadMessage("Still waiting...");
			// Wait maximum of 1 second for MessageLoop thread to
			// finish.
			t.join(1000);
			boolean hasPatience = (System.currentTimeMillis() - startTime) > patience;
			
			if (hasPatience && t.isAlive()) {
				threadMessage("Tired of waiting!");
				t.interrupt();
				// Shouldn't be long now -- wait indefinitely
				//t.join();
			}

		}
		threadMessage("Finally!");
	}
}
