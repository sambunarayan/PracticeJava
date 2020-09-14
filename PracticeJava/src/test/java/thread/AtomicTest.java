package test.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class IntegerTest {
	private Integer noSyncInteger;
	private Integer syncInteger;
	private final AtomicInteger atomicInteger;
	
	public IntegerTest() {
		noSyncInteger = 0;
		syncInteger = 0;
		atomicInteger = new AtomicInteger(0);
	}
	
	public void addInteger() {
		noSyncInteger++;
	}
	
	synchronized public void addSyncInteger() {
		syncInteger++;
	}
	
	public void addAtomicInteger() {
		atomicInteger.getAndIncrement();
	}
	
	public void showData() {
		System.out.println("int : " + noSyncInteger);
		System.out.println("syncInt : " + syncInteger);
		System.out.println("atomicInt : " + atomicInteger.get());
	}
}

public class AtomicTest {
	public static void main(String[] args) throws InterruptedException {
		IntegerTest obj = new IntegerTest();
		exec(()->obj.addInteger());
		exec(()->obj.addSyncInteger());
		exec(()->obj.addAtomicInteger());
		obj.showData();
	}
	
	private static void exec(Runnable task) throws InterruptedException {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(100);
			for (int i = 0; i <10000; i++) {
				service.submit(task);
			}
			service.awaitTermination(10, TimeUnit.SECONDS);
		} finally {
			if (service != null) service.shutdown();
		}
	}
}
