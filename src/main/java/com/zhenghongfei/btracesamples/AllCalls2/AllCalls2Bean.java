package com.zhenghongfei.btracesamples.AllCalls2;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class AllCalls2Bean {
	public static void main(String[] args) {
		AllCalls2Bean bean = new AllCalls2Bean();
		bean.traceExecute();
	}

	private void traceExecute() {
		JFrame frame = new JFrame("test");

		JPanel panel = new JPanel();

		panel.setLayout(new GridLayout());
		panel.add(new JLabel("Name:"));
		panel.add(new JScrollPane(new JTextField()));

		frame.add(panel);
		frame.setSize(200, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
