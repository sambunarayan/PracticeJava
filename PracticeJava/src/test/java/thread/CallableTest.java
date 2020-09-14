package test.java.thread;

import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {

	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<LocalDate> result = service.submit(()->LocalDate.now());
			System.out.println(result.get());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			service.shutdown();
		}
	}

}
