package test.search;

public class OpenHashTest {

	public static void main(String[] args) {
		OpenHash<String, Integer> openHash = new OpenHash<>(4);
		System.out.println("firt input ------------- ");
		openHash.add("A", 1);
		openHash.show();
		System.out.println("second show ------------- ");
		openHash.add("B", 2);
		openHash.add("C", 3);
		openHash.show();
		System.out.println("3 show ------------- ");
		openHash.add("D", 3);
		openHash.show();
		
		// is full
		openHash.add("E", 4);
		
		// removed
		System.out.println("remove B ->" + openHash.remove("B"));
		openHash.remove("B");
		openHash.show();
		
		// retry add
		System.out.println("retry add  ------------- ");
		openHash.add("E", 4);
		openHash.show();
	}

}
