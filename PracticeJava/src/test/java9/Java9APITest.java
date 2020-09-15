package test.java9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

import test.java9.flows.MySubscriber;
import test.java9.flows.SecondSubscriber;
import test.java9.inter.SampleInter;

public class Java9APITest {
	
	public static void main(String[] args) throws Throwable {
		// List, Map Factory Method
		List<String> list = List.of("a", "b", "c");
		System.out.println(list);
		Map<Integer, String> map = Map.of(1, "a", 2, "b", 3, "c");
		System.out.println(map);
		Map<Integer, Integer> map2 = Map.of(1 , 100, 2, 200, 3, 300);
		System.out.println(map2);
		
		// private interface
		SampleInter inter = new SampleInterImpl();
		inter.show(inter.createMsg(1));
		
		// ProccessHandle
		ProcessHandle currentProcess = ProcessHandle.current();
		System.out.println("Current Process Id:" + currentProcess.pid());
		
		Optional<ProcessHandle> op = ProcessHandle.of(3116L);
		if (op.isPresent()) {
			op.get().destroy();
			System.out.println("pid destoried");
		}
		
		// try-with-resource
		BufferedReader reader = new BufferedReader(new FileReader("input/test.txt"));
		try (reader) {
			String str = null;
			while ((str = reader.readLine()) != null) {
				System.out.println(str);
			}
		}
		
		// CompletableFuture
		int a = 2;
		int b = 5;
		System.out.println("Before CompletableFuture -> " + LocalDateTime.now());
		CompletableFuture.supplyAsync(()->a + b, CompletableFuture.delayedExecutor(5, TimeUnit.SECONDS))
			.thenAccept(result->System.out.println(LocalDateTime.now() + " result -> " + result));
		System.out.println("After CompletableFuture -> " + LocalDateTime.now());
//		executor.execute(()->System.out.println("Executed. " + LocalDateTime.now()));
		
		
		// reactive
		SubmissionPublisher<String> publisher = new SubmissionPublisher<>();  
		  
	    //Register Subscriber  
		MySubscriber<String> subscriber = new MySubscriber<>();  
	    publisher.subscribe(subscriber);  
	    publisher.subscribe(new SecondSubscriber<>());
	    
	    System.out.println("subscribers list : " + publisher.getSubscribers());
	    
	    //Publish items  
	    System.out.println("Publishing Items...");  
	    String[] items = {"1", "x", "2", "x", "3", "x"};  
	    Arrays.asList(items).stream().forEach(i -> publisher.submit(i));  
	    publisher.close();  
	    
	    TimeUnit.SECONDS.sleep(10);
	}

}
