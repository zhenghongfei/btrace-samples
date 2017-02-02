package com.zhenghongfei.btracesamples.AllSync;

import java.util.concurrent.atomic.AtomicInteger;

public class AllSyncBean2 {
	public static void main(String[] args) {
		final AllSyncBean2 bean = new AllSyncBean2();
		final AtomicInteger ai = new AtomicInteger(0);
		while (true) {
			Thread t = new Thread() {
				public void run() {
					bean.traceExecute(ai.incrementAndGet());
				};
			};
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void traceExecute(int i) {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName() + i);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}
}
