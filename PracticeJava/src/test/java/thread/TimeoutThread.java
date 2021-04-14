package test.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TimeoutThread {

	public String print() {
		for (int i = 0; i < 10; i++) {
			System.out.println("print " + i);
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
			}
		}
		return "OK";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService service = Executors.newCachedThreadPool();
		Future<String> future = null;
		try {
			future = service.submit(() -> new TimeoutThread().print());
			future.get(2000, TimeUnit.MILLISECONDS);
		} catch (TimeoutException e) {
			e.printStackTrace();
			System.out.println("isShutdown " + service.isShutdown());
			System.out.println("isTerminated " + service.isTerminated());
			service.shutdown();
			System.out.println("isShutdown " + service.isShutdown());
			System.out.println("shutdown now " + service.shutdownNow());
			try {
				long awaitStart = System.currentTimeMillis();
				System.out.println("await termination");
				service.awaitTermination(2000, TimeUnit.MILLISECONDS);
				System.out.println("end await termination " + (System.currentTimeMillis() - awaitStart));
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end of proc");
	}

}
