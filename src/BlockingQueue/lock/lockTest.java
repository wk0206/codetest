package BlockingQueue.lock;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lockTest {

	//private BlockingQueue<String> queue = new ArrayBlockingQueue(10);

	private final Lock lock = new ReentrantLock();

	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();

	private static int count = 0;

	private List<String> list = new LinkedList<>();

	public void add() {
		lock.lock();

		try {
			while (list.size() == 10) {
				notFull.await();
			}

			count++;
			list.add("add Banana" + count);
			System.out.println("The Lists Size is " + list.size());
			System.out.println("The Current Thread is " + Thread.currentThread().getName());
			System.out.println("==============================");

			notEmpty.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

	public void sub() {
		lock.lock();

		try {
			while (list.size() == 0) {
				notEmpty.await();
			}

			// sub something
			String str = list.get(0);
			list.remove(0);
			System.out.println("The Token Banana is [" + str + "]");
			System.out.println("The Current Thread is " + Thread.currentThread().getName());
			System.out.println("==============================");
			count--;
			
			notFull.signal();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

}
