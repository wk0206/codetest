package BlockingQueue.BQ;

import java.util.concurrent.ArrayBlockingQueue;

public class TestBQ {
	private static int MaxSize = 10;
	private static ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(MaxSize);

	public static void main(String[] args) {
		TestBQ test = new TestBQ();

		Producer producer = test.new Producer();
		Consumer consumer = test.new Consumer();
		Thread t1 = new Thread(producer);
		// Thread t2 = new Thread(producer);
		Thread t3 = new Thread(consumer);

		t1.start();
		// t2.start();
		t3.start();
	}

	class Consumer implements Runnable {

		@Override
		public void run() {
			consume();
		}

		private void consume() {
			while (true) {
				try {
					queue.take();
					System.out.println("queue is empty , wait for element");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	class Producer implements Runnable {

		@Override
		public void run() {
			produce();
		}

		private void produce() {
			while (true) {
				try {
					queue.put(1);
					System.out.println("put one element to queue, left space " + (MaxSize - queue.size()) + "elements");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}