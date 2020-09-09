package test.java.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelTest {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("a","b","c","d");
		Stream<String> seqStream = list.stream();
		Stream<String> paralStream = list.parallelStream();
		
		System.out.println("sequencial stream -> " + seqStream.isParallel());
		System.out.println("parallel stream -> " + paralStream.isParallel());
		
		seqStream.forEach(System.out::print);
		System.out.println();
		paralStream.forEach(System.out::print);
		System.out.println();
		
		// check speed
		IntStream stream = IntStream.rangeClosed(0, 3000);
		List<Integer> intList = stream.boxed().collect(Collectors.toList());
		
		long start = System.nanoTime();
		new ParallelTest().countSeqStream(intList);
		System.out.println("Sequencial Stream -> " + (System.nanoTime() - start));
		
		start = System.nanoTime();
		new ParallelTest().countParalStream(intList);
		System.out.println("Parallel Stream -> " + (System.nanoTime() - start));
	}
	
	void countSeqStream(List<Integer> list) {
		long count = list.stream().map(n->task(n)).count();
		System.out.println(count);
	}
	
	void countParalStream(List<Integer> list) {
		long count = list.parallelStream().map(n->task(n)).count();
		System.out.println(count);
	}
	
	int task(int num) {
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ++num;
	}

}
