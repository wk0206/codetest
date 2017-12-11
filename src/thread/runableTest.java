package thread;


public class runableTest implements Runnable{
	private String name;  
	
	public runableTest(String name){
		this.name=name;
	}
	
	public static void main(String[] args) {
		runableTest mt1=new runableTest("线程a");  
		runableTest mt2=new runableTest("线程b");  
		new Thread(mt1).start();  
		new Thread(mt2).start(); 

	}

	
	public void run(){
		for(int i=0;i<100;i++){  
		System.out.println("线程开始："+this.name+",i="+i); 
		}
	}

}
