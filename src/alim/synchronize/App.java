package alim.synchronize;

/**
 * Imagine thread A and thread B invokes a synchronous method,  thread B will wait for thread A
 * until it releases the intrinsic lock.
 * @author v-almett
 *
 */

public class App {

	private int count = 0;
	
	//Intrinsic lock
	public synchronized void increment(){
		count++;
	}
	
	public static void main(String[] args) {
		App app = new App();
		app.doWork();
	}

	public void doWork(){
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				for(int i = 0 ;i<10000;i++){
					increment();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				for(int i = 0 ;i<10000;i++){
					increment();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Count is: "+ count);
	}
}
