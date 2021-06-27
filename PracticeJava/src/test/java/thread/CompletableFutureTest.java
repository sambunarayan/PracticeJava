package test.java.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTest {
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

	public String print2(String s) {
		for (int i = 0; i < 10; i++) {
			System.out.println(s + i);
			try {
				Thread.sleep(100L);
			} catch (InterruptedException e) {
			}
		}
		return "print 2 OK ";
	}

	public void print3(String s) {
		for (int i = 0; i < 10; i++) {
			System.out.println("print3 " + s + i);
			try {
				Thread.sleep(100L);
			} catch (InterruptedException e) {
			}
		}
	}

	public static void main(String[] args) {
		CompletableFuture<Void> future = null;
		try {
			future = CompletableFuture.supplyAsync(() -> new CompletableFutureTest().print())
					.thenApply((s) -> new CompletableFutureTest().print2(s))
					.thenAcceptAsync((s) -> new CompletableFutureTest().print3(s));
			future.get(13, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end of proc");
	}

}
