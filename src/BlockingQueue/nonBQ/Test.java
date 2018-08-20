package BlockingQueue.nonBQ;

import java.util.PriorityQueue;

public class Test {
	private int MaxSize = 10;
	private PriorityQueue<Integer> queue = new PriorityQueue<>();
	
	public static void main(String[] args)  {
        Test test = new Test();
        
        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(producer);
        Thread t3 = new Thread(consumer);
        
        t1.start();
        t2.start();
        t3.start();
    }
	
	
	class Consumer implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			consume();
		}
		
		private void consume() {
			while(true) {
				synchronized(queue) {
					while(queue.size()==0) {
						//queue is empty , wait
						try {
							System.out.println("queue is empty , wait for element");
							queue.wait();
						}catch(InterruptedException e){
							e.printStackTrace();
							queue.notify();
						}
						
					}
					
					queue.poll();
					queue.notify();
					System.out.println("get one element from queue, left "+queue.size()+"elements");
				}
			}
		}
		
	}
	
	class Producer implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			produce();
		}
		
		private void produce() {
			while(true) {
				synchronized(queue) {
					while(queue.size()==MaxSize) {
						//queue is full , wait
						
						try {
							System.out.println("queue is full , wait for space");
							queue.wait();
						}catch(InterruptedException e){
							e.printStackTrace();
							queue.notify();
						}
					}
					
					queue.offer(1);
					queue.notify();
					System.out.println("put one element to queue, left space "+(MaxSize-queue.size())+"elements");
				}
			}
		}
		
	}
}
