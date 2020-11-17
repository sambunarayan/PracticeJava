package test.java10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Java10APITest {
	
	// private var a; Field‚É‚ÍéŒ¾•s‰Â
	
	public static void main(String[] args) {
		
		// Local-Variable Type Inference
		var list = List.of(1, 2, 3, 4,5);
		var copyList = List.copyOf(list);
		var list3 = new ArrayList<String>() {
			{
				add("a");
				add("c");
				add("e");
				add("f");
				System.out.println("contains ? " + contains("a"));
			}
		};
		list.forEach((i)->System.out.print(i + " "));
		System.out.println();
		copyList.forEach((i)->System.out.print(i + " "));
		System.out.println();
		list3.forEach((i)->System.out.print(i + " "));
		System.out.println();
		var map = Map.of(1,"a", 2, "b", 3, "c");
		var copyMap = Map.copyOf(map);
		System.out.println("map : " + map);
		System.out.println("copyMap : " + copyMap);
		
		// Optional
		var op = Optional.of("A");
		var throwOp = Optional.empty();
		try {
			System.out.println("Optional->" + op.orElseThrow());
			System.out.println("Optional->" + throwOp.orElseThrow());
		} catch (NoSuchElementException ex) {
			System.out.println("Optional throws Exception");
		}
	}
}
