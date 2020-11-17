package test.datastructure;

import test.exception.EmptyInStackException;
import test.exception.OverflowInStackException;

public class IntStack {
	
	private int[] arr;
	private int capacity = 13;
	private int top = -1;
	
	public IntStack() {
		arr = new int[capacity];
	}
	
	public IntStack(int capacity) {
		this.capacity = capacity;
		arr = new int[this.capacity];
	}
	
	public boolean push(int e) {
		if (top >= capacity - 1) {
			System.out.println("Stack is full.");
			throw new OverflowInStackException();
		}
		arr[++top] = e;
		return true;
	}
	
	public int pop() {
		if (top < 0) {
			System.out.println("Stack is empty.");
			throw new EmptyInStackException();
		}
		return arr[top--];
	}
	
	public int peek() {
		if (top < 0) {
			System.out.println("Stack is empty.");
			throw new EmptyInStackException();
		}
		return arr[top];
	}
	
	public boolean isEmpty() {
		return top < 0;
	}
	
	public int size() {
		return top + 1;
	}
}
