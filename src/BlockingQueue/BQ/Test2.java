package BlockingQueue.BQ;

import java.util.concurrent.ArrayBlockingQueue;

public class Test2 {
	 private int queueSize = 10;
	    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueSize);
	     
	    public static void main(String[] args)  {
	        Test2 test = new Test2();
	        Producer producer = test.new Producer();
	        Consumer consumer = test.new Consumer();
	         
//	        producer.start();
//	        consumer.start();
	        
			Thread t1 = new Thread(producer);
			//Thread t2 = new Thread(producer);
			Thread t3 = new Thread(consumer);

			t1.start();
			//t2.start();
			t3.start();
	    }
	     
	    class Consumer implements Runnable{
	         
	        @Override
	        public void run() {
	            consume();
	        }
	         
	        private void consume() {
	            while(true){
	                try {
	                    queue.take();
	                    System.out.println("从队列取走一个元素，队列剩余"+queue.size()+"个元素");
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	     
	    class Producer implements Runnable{
	         
	        @Override
	        public void run() {
	            produce();
	        }
	         
	        private void produce() {
	            while(true){
	                try {
	                    queue.put(1);
	                    System.out.println("向队列取中插入一个元素，队列剩余空间："+(queueSize-queue.size()));
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
}
