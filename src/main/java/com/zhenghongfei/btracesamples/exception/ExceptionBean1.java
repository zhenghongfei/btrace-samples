package com.zhenghongfei.btracesamples.exception;

/**
 * 使用Btrace打印业务代码中异常被吞没的信息：
 * <p>
 * <li>JDK5、6、7异常次数为：20707
 * <li>JDK8异常次数为：115717
 */
public class ExceptionBean1 {

	@SuppressWarnings("null")
	public void traceException() {
		try {
			String o = null;
			o.toString();
		} catch (Exception e) {
			if (e.getStackTrace().length == 0) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		ExceptionBean1 object = new ExceptionBean1();
		while (true) {
			object.traceException();
		}
	}
}