package test.java.executor;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {

	void a() {
		System.out.println("a ");
	}

	void b() {
		System.out.println("b ");
	}

	void c() {
		System.out.println("c ");
	}

	void exec(CyclicBarrier c1, CyclicBarrier c2) {
		try {
		a();
		c1.await();
		b();
		c2.await();
		c();
		} catch (BrokenBarrierException | InterruptedException e) {} 
	}

	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(3);
			CyclicBarrier c1 = new CyclicBarrier(3);
			CyclicBarrier c2 = new CyclicBarrier(4, () -> System.out.println("task "));

			for (int i = 0; i < 3; i++) {
				service.execute(() -> new CyclicBarrierTest().exec(c1, c2));
			}
		} finally {
			service.shutdown();
		}
	}

}
