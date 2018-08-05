package thread;

public class threadTest extends Thread {

	
	public void run(){
		for(int i = 1; i <= 10; i++) {  //(3)
            System.out.println(getName() + ":" + i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
            }
        }
	}
	
	public static void main(String[] args) {
		threadTest t1 = new threadTest();
		threadTest t2 = new threadTest();
		
		t1.start();
		t2.start();
	}

}
