package test.codingtest.etc;

public class BulbSwitcher3 {

	// ***
	// leetCode.1375 Bulb Switcher3

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private int onLight = 0;

	public int numTimesAllBlue(int[] light) {
		int moment = 0;
		int len = 0;
		for (int i : light) {
			if (i > len) {
				len = i;
			}
		}
		int[] bulbs = new int[len + 1];
		for (int i = 0; i < light.length; i++) {
			switchOnRightBulb(bulbs, light[i] + 1);
			if (switchOnLeftBulb(bulbs, light[i]) && onLight == 0)
				moment++;
		}
		return moment;
	}

	private boolean switchOnLeftBulb(int[] bulbs, int idx) {
		if (idx == 1) {
			bulbs[idx] = 2;
			return true;
		}
		if (bulbs[idx - 1] == 0) {
			bulbs[idx] = 1;
			onLight++;
			return false;
		} else if (bulbs[idx - 1] == 1) {
			bulbs[idx] = 2;
			return false;
		} else {
			bulbs[idx] = 2;
			return true;
		}
	}

	private void switchOnRightBulb(int[] bulbs, int idx) {
		if (idx >= bulbs.length) {
			return;
		}
		if (bulbs[idx] == 1) {
			bulbs[idx] = 2;
			onLight--;
		}
	}
}
