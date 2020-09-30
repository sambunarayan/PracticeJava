package test.datastructure;

public class StackTest {

	public static void main(String[] args) {
		IntStack intStack = new IntStack(4);
		System.out.println("push 2 :" + intStack.push(2));
		System.out.println("push 1 :" + intStack.push(1));
		System.out.println("peek -> " + intStack.peek());
		System.out.println("push 3 :" + intStack.push(3));
		System.out.println("peek -> " + intStack.peek());
		System.out.println("pop -> " + intStack.pop());
		System.out.println("peek -> " + intStack.peek());
		System.out.println("push 4 :" + intStack.push(4));
		System.out.println("pop -> " + intStack.pop());
		System.out.println("pop -> " + intStack.pop());
		System.out.println("pop -> " + intStack.pop());
		System.out.println("pop -> " + intStack.pop());
	}

}
