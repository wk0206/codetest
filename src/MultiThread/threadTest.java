package MultiThread;

public class threadTest extends Thread {

	public Integer count = 0;

	private threadTest() {
		this.count = 0;
	}

	@Override
	public void run() {
		// synchronized(count) {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.currentThread().getName() + ":" + count);
			count++;
		}
		// }

	}

	class innerClazzExtendThread extends Thread {
		public Integer count = 0;
		private Object o;

		innerClazzExtendThread(Object o) {
			this.o = o;
		}

		@Override
		public void run() {
			synchronized (this) {
				for (int i = 0; i < 5; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println(Thread.currentThread().getName() + ":" + count);
					count++;
				}

				// System.out.println(Thread.currentThread().getName() + ":" + " after
				// synchronized");
			}
		}

	}

	public static void main(String[] args) {
		threadTest t1 = new threadTest();
		threadTest t2 = new threadTest();
		t1.setName("test1");
		t2.setName("test2");

		// t1.start();
		// t2.start();

		rab r1 = new rab();
		// rab r2 = new rab();
		Thread t3 = new Thread(r1, "runnable 1");
		Thread t4 = new Thread(r1, "runnable 2");

		// t3.start();
		// t4.start();

		clazzExtendThread t5 = new clazzExtendThread();
		clazzExtendThread t6 = new clazzExtendThread();

		t5.setName("clazzExtendThread 1");
		t6.setName("clazzExtendThread 2");

		// t5.start();
		// t6.start();

		threadTest instance = new threadTest();
		innerClazzExtendThread t7 = instance.new innerClazzExtendThread(instance);
		innerClazzExtendThread t8 = instance.new innerClazzExtendThread(instance);

		t7.start();
		t8.start();

	}
}

class rab implements Runnable {
	public Integer count = 0;

	rab() {

	}

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 10; i++) {

				System.out.println(Thread.currentThread().getName() + ":" + count);
				count++;
			}
		}

		System.out.println(Thread.currentThread().getName() + ":" + " after synchronized");
	}

}

class clazzExtendThread extends Thread {
	public Integer count = 0;

	clazzExtendThread() {

	}

	@Override
	public void run() {
		synchronized (count) {
			for (int i = 0; i < 30; i++) {

				System.out.println(Thread.currentThread().getName() + ":" + count);
				count++;
			}
		}

		System.out.println(Thread.currentThread().getName() + ":" + " after synchronized");
	}
}