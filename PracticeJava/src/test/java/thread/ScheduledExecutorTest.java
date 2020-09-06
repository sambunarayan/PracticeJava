package test.java.thread;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorTest {

	public static void main(String[] args) {
		ScheduledExecutorService service = null;
		try {
			service = Executors.newSingleThreadScheduledExecutor();
			Runnable task1 = ()-> System.out.println("task1");
			Callable<Date> task2 = () -> new Date();
			Runnable task3 = ()-> System.out.println("Task3 Executed : " + LocalDateTime.now());
			
			ScheduledFuture<?> result1 = service.schedule(task1, 3, TimeUnit.SECONDS);
			ScheduledFuture<Date> result2 = service.schedule(task2, 1, TimeUnit.MILLISECONDS);
			System.out.println(result2.get());
			
			ScheduledFuture<?> result3 = service.scheduleAtFixedRate(task3, 0, 1, TimeUnit.MINUTES);
			System.out.println(result3.get());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			service.shutdown();
		}
	}

}
