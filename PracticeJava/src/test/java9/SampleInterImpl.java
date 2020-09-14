package test.java9;

import test.java9.inter.SampleInter;

public class SampleInterImpl implements SampleInter {

	@Override
	public String createMsg(int i) {
		return "MSG : " + i;
	}
	
}
