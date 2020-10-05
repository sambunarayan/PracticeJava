package test.datastructure;

import test.exception.EmptyInQueueException;
import test.exception.OverflowInQueueException;

public class IntQueue {

	private int[] arr;
	private int front = 0;
	private int rear = 0;
	private int capacity = 13;
	private int size = 0;

	public IntQueue() {
		arr = new int[capacity];
	}

	public IntQueue(int capacity) {
		this.capacity = capacity;
		arr = new int[this.capacity = capacity];
	}

	public boolean add(int e) {
		if (size >= capacity) {
			System.out.println("Queue is full.");
			throw new OverflowInQueueException();
		}
		arr[rear++] = e;
		size++;
		if (rear >= capacity) {
			rear = 0;
		}
		return true;
	}

	public int poll() {
		if (size <= 0) {
			System.out.println("Queue is empty.");
			throw new EmptyInQueueException();
		}
		int e = arr[front++];
		size--;
		if (front >= capacity) {
			front = 0;
		}
		return e;
	}
	
	public int peek() {
		if (size <= 0) {
			System.out.println("Queue is empty.");
			throw new EmptyInQueueException();
		}
		return arr[front];
	}
	
	public int size() {
		return size;
	}
	
	public void show() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (i == front) {
				sb.append("[");
				if (size == 0) {
					sb.append("],");
					continue;
				}
			}
			int tmp = rear - 1;
			if (tmp < 0) {
				tmp = capacity - 1;
			}
			if (tmp == i && size != 0) {
				sb.append(arr[i] + "],");
			} else {
				sb.append(arr[i] + ",");
			}
		}
		System.out.println("-----------------------------------------------");
		System.out.println(sb.toString().substring(0, sb.toString().length() - 1));
		System.out.println("-----------------------------------------------");
	}
}
