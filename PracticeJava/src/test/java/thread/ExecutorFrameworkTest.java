package test.java.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorFrameworkTest {
	public static void main(String[] args) {

		/**
		 * Test that already executed threads are not interrupted by shutdown().
		 */
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			System.out.println("service.execute()");
			String s = "*";
			for (int i = 0; i < 3; i++) {
				service.execute(() -> {
					System.out.print("thread task");
					for (int a = 0; a < 5; a++) {
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
						}
						System.out.print(s);
					}
					System.out.println();
				});
			}
		} finally {
			service.shutdown();
			System.out.println("ex.shutdown()");
		}

		/**
		 * Test Future
		 */
		try {
			service = Executors.newSingleThreadExecutor();
			Future<?> result1 = service.submit(() -> {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
				System.out.println("hello");
			});
			System.out.println("isCancelled() -> " + result1.isCancelled());
			System.out.println("isDone() -> " + result1.isDone());
			System.out.println("get() -> " + result1.get());
			System.out.println("isDone() -> " + result1.isDone());

			Future<Boolean> result2 = service.submit(() -> System.out.println("hello"), Boolean.TRUE);
			System.out.println("get() -> " + result2.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {

		}
	}
}
