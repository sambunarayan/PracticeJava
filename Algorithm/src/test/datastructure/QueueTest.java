package test.datastructure;

public class QueueTest {

	public static void main(String[] args) {
		IntQueue que = new IntQueue(5);
		que.show();
		System.out.println("add 1 : " + que.add(1));
		System.out.println("add 3 : " + que.add(3));
		System.out.println("add 4 : " + que.add(4));
		System.out.println("peek  : " + que.peek());
		System.out.println("poll  : " + que.poll());
		System.out.println("peek  : " + que.peek());
		System.out.println("size  : " + que.size());
		que.show();
		System.out.println("add 1 : " + que.add(1));
		System.out.println("peek  : " + que.peek());
		System.out.println("poll  : " + que.poll());
		System.out.println("peek  : " + que.peek());
		que.show();
		System.out.println("poll  : " + que.poll());
		que.show();
		System.out.println("poll  : " + que.poll());
		que.show();
		System.out.println("add 10 : " + que.add(10));
		System.out.println("add 11 : " + que.add(11));
		System.out.println("add 12 : " + que.add(12));
		que.show();
		System.out.println("add 13 : " + que.add(13));
		System.out.println("add 14 : " + que.add(14));
		que.show();
		System.out.println("poll  : " + que.poll());
		que.show();
	}

}
