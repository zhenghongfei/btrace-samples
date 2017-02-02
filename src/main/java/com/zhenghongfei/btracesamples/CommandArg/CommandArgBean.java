package com.zhenghongfei.btracesamples.CommandArg;

public class CommandArgBean {

	public static void main(String[] args) {
		CommandArgBean bean = new CommandArgBean();
		int i = 0;
		while (true) {
			bean.traceExecute(i++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void traceExecute(int i) {
		String name = "CommandTread" + i;
		Thread t = new Thread(name);
		t.start();
		System.out.println(name);
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
