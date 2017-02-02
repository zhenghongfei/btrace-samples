package com.zhenghongfei.btracesamples.Deadlock;

public class DeadlockBean implements Runnable {

	private int flag = 1;
	private static final Object o1 = new Object();
	private static final Object o2 = new Object();

	public static void main(String[] args) {
		DeadlockBean td1 = new DeadlockBean();
		DeadlockBean td2 = new DeadlockBean();
		td1.flag = 1;
		td2.flag = 0;
		Thread t1 = new Thread(td1);
		Thread t2 = new Thread(td2);
		t1.start();
		t2.start();
	}

	public void run() {
		System.out.println("flag = " + flag);
		if (flag == 1) {
			synchronized (o1) {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				synchronized (o2) {
					System.out.println("1");
				}
			}
		}
		if (flag == 0) {
			synchronized (o2) {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				synchronized (o1) {
					System.out.println("0");
				}
			}
		}
	}
}
