package com.zhenghongfei.btracesamples.AllCalls3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class AllCalls3Bean {

	public static void main(String[] args) {
		AllCalls3Bean bean = new AllCalls3Bean();
		bean.traceExecute();
	}

	private void traceExecute() {
		JFrame frame = new JFrame("test");

		JPanel panel = new JPanel();

		panel.setLayout(new GridLayout());
		JButton btn = new JButton("Name:");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
			}
		});
		panel.add(btn);
		panel.add(new JScrollPane(new JTextField()));

		frame.add(panel);
		frame.setSize(200, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}