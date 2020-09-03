package test.java.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	public static void main(String[] args) {
		ExecutorService service = null;
		try {
//			service = Executors.newCachedThreadPool();
			service = Executors.newFixedThreadPool(2);
			
			Runnable task = () -> {
				String name = Thread.currentThread().getName();
				System.out.println(name + " : start");
				try { TimeUnit.SECONDS.sleep(3); } catch (Exception e) {}
				System.out.println(name + " : end");
			};
			for (int i = 0; i < 5; i++) {
				service.execute(task);
			}
		} finally {
			service.shutdown();
		}
	}
}
