package BlockingQueue.lock;

public class Consumer implements Runnable {

	private lockTest lock;

	public Consumer(lockTest lt) {
		this.lock = lt;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			lock.sub();	
		}
	}

}
