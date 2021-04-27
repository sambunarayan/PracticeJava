package test.java.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

class TestDto {
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}

class TestLogic {

	private Map<Integer, String> map = new HashMap<>();

	private String nowValue = "";

	public TestLogic() {
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
		map.put(5, "e");
	}

	public synchronized TestDto get(int key, long sleep) {
		TestDto dto = new TestDto();
		dto.setResult(map.get(key));
		try {
			nowValue = dto.getResult();
			System.out.println(Thread.currentThread().getName() + " [" + key + "] before sleep -> " + dto.getResult()
					+ ", " + nowValue);
			TimeUnit.MILLISECONDS.sleep(sleep);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println(Thread.currentThread().getName() + " [" + key + "] after sleep -> " + dto.getResult() + ", "
				+ nowValue);
		return dto;
	}
}

public class MultiThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final TestLogic logic = new TestLogic();
		new Thread(() -> logic.get(1, 5000)).start();
		System.out.println("Thread1 started.");
		new Thread(() -> logic.get(5, 2000)).start();
		System.out.println("Thread2 started.");
		new Thread(() -> logic.get(3, 1000)).start();
		System.out.println("Thread3 started.");
		new Thread(() -> logic.get(4, 3000)).start();
		System.out.println("Thread4 started.");
	}

}
