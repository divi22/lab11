package exercise;

import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise2 {
	
public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		ThreadDemo runnable = new ThreadDemo();
		service.execute(runnable);
		service.shutdown();		
	}

}

class ThreadDemo   implements Runnable {

	@Override
	public void run() {
		while(true) {
			System.out.println("Current time: " + java.time.LocalTime.now());
			try {
				
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
