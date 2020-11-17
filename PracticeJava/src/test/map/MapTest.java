package test.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		
		Map<String, Map<Integer, Integer>> map = new HashMap<>();
		map.computeIfAbsent("A", (k)->new HashMap<>()).get(0);
	}
}
