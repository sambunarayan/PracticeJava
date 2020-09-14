package test.java9.inter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface SampleInter {
	
	private String getTime() {
		return LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
	}
	
	default void show(String str) {
		System.out.println(getTime() + ":" + str);
	}
	
	public String createMsg(int i);
}
