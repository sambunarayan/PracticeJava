package test.java12;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class JFRTest {

	public static void main(String[] args) throws InterruptedException {
		ProcessHandle proc = ProcessHandle.current();
		System.out.println("PID -> " + proc);
		final List<Integer> list = new ArrayList<>();
		ExecutorService service1 = Executors.newFixedThreadPool(3);
		service1.submit(()-> {
			int i = 0;
			while (i++ < 10) {
				System.out.println("thread1 ");
				try {
					list.add(i);
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		service1.submit(()-> {
			int i = 0;
			while (i++ < 100) {
				System.out.println("thread2 ");
				try {
					list.add(i);
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		service1.submit(()-> {
			int i = 0;
			while (i++ < 10) {
				System.out.println("thread3 ");
				try {
					list.add(i);
					TimeUnit.SECONDS.sleep(4);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		service1.submit(()-> {
			int i = 0;
			while (i++ < 10) {
				System.out.println("thread4 ");
				try {
					list.add(i);
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		TimeUnit.SECONDS.sleep(61);
	}

}
