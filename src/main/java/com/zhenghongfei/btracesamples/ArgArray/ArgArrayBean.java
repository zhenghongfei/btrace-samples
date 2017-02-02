package com.zhenghongfei.btracesamples.ArgArray;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class ArgArrayBean {
	public static void main(String[] args) {
		ArgArrayBean bean = new ArgArrayBean();
		while (true) {
			bean.traceExecute();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void traceExecute() {
		InputStream fis = null;
		try {
			fis = this.getClass().getResourceAsStream("/test.txt");
			byte[] readData = new byte[1024];
			fis.read(readData);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
