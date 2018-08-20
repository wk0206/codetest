package BlockingQueue.lock;

public class Producer implements Runnable {

	private lockTest lock;
	
	public Producer(lockTest lt) {
		this.lock=lt;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			lock.add();	
		}
		
	}

}
