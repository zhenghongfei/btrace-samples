package com.zhenghongfei.btracesamples.exception;

/**
 * 使用Btrace打印业务代码中未输出的异常信息
 * @author Hongfei
 */
public class ExceptionBean2 {

	@SuppressWarnings("null")
	public void traceException() {
		try {
			String i = null;
			i.toString();
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) throws Exception {
		ExceptionBean2 object = new ExceptionBean2();
		while (true) {
			object.traceException();
		}
	}
}