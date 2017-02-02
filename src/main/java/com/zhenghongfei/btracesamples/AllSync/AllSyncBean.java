package com.zhenghongfei.btracesamples.AllSync;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class AllSyncBean {
	public static void main(String[] args) {
		AllSyncBean bean = new AllSyncBean();
		bean.traceExecute();
	}

	private void traceExecute() {
		JFrame frame = new JFrame("test");

		JPanel panel = new JPanel();

		panel.setLayout(new GridLayout());
		JButton btn = new JButton("Name:");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				Thread t = new Thread() {
					@Override
					public void run() {
						System.out.println(e.getSource().toString());
					}
				};
				t.start();
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
