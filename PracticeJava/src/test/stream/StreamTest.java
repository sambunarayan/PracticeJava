package test.stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Test1Dto> list1 = new ArrayList<>();
		Test1Dto dto1 = new Test1Dto();
		dto1.setId("id123");
		dto1.setName("name123");
		Test1Dto dto2 = new Test1Dto();
		dto2.setId("id456");
		dto2.setName("name456");
		Test1Dto dto3 = new Test1Dto();
		dto3.setId("id789");
		dto3.setName("name789");
		list1.add(dto1);
		list1.add(dto2);
		list1.add(dto3);

		List<Test1Dto> list2 = new ArrayList<>();
		Test1Dto dto4 = new Test1Dto();
		dto4.setId("id456");
		dto4.setName("name456");
		Test1Dto dto5 = new Test1Dto();
		dto5.setId("id457");
		dto5.setName("name457");
		Test1Dto dto6 = new Test1Dto();
		dto6.setId("id780");
		dto6.setName("name780");
		list2.add(dto4);
		list2.add(dto5);
		list2.add(dto6);

		// Distinct of Stream.
		List<Test1Dto> combineList = Stream.concat(list1.stream(), list2.stream()).distinct()
				.collect(Collectors.toList());

		// FlatMap

		System.out.println(combineList);

		//
		List<Test2Dto> list3 = new ArrayList<>();
		Test2Dto dto7 = new Test2Dto();
		dto7.setId("id123");
		dto7.setName("name123");
		Test2Dto dto8 = new Test2Dto();
		dto8.setId("id456");
		dto8.setName("name456");
		Test2Dto dto9 = new Test2Dto();
		dto9.setId("id789");
		dto9.setName("name789");
		list3.add(dto7);
		list3.add(dto8);
		list3.add(dto9);

		List<Test2Dto> list4 = new ArrayList<>();
		Test2Dto dto10 = new Test2Dto();
		dto10.setId("id456");
		dto10.setName("name456");
		Test2Dto dto11 = new Test2Dto();
		dto11.setId("id457");
		dto11.setName("name457");
		Test2Dto dto12 = new Test2Dto();
		dto12.setId("id780");
		dto12.setName("name780");
		list4.add(dto10);
		list4.add(dto11);
		list4.add(dto12);
		// Distinct of Stream.
		List<Test2Dto> combine2List = Stream.concat(list3.stream(), list4.stream()).distinct()
				.collect(Collectors.toList());

		// FlatMap

		System.out.println(combine2List);
		System.out.println(dto8.equals(dto10));

		Set<Test2Dto> dtoSet = new HashSet<>(list3);
		dtoSet.addAll(list4);
		System.out.println(dtoSet);
	}

}
