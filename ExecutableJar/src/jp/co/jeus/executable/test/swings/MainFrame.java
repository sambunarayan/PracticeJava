package jp.co.jeus.executable.test.swings;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame {
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setSize(new Dimension(100, 100));
		jf.setLocation(550, 300);
		jf.add(new JLabel("Test Frame"));
		jf.setVisible(true);
	}
}
