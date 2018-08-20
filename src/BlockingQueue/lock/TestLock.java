package BlockingQueue.lock;

public class TestLock {

	public static void main(String[] args) {
		lockTest task = new lockTest();

		Thread t1 = new Thread(new Producer(task));
		Thread t3 = new Thread(new Producer(task));
		Thread t7 = new Thread(new Producer(task));
		Thread t8 = new Thread(new Producer(task));
		Thread t2 = new Thread(new Consumer(task));
		Thread t4 = new Thread(new Consumer(task));
		Thread t5 = new Thread(new Consumer(task));
		Thread t6 = new Thread(new Consumer(task));
		
		t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        
	}

}
