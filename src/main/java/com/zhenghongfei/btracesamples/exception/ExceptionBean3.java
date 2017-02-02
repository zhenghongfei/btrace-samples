package com.zhenghongfei.btracesamples.exception;

/**
 * 使用Btrace打印业务代码中抛出的异常信息
 *
 * @author Hongfei
 */
public class ExceptionBean3 {

	@SuppressWarnings("null")
	public void traceException() {
		try {
			String i = null;
			i.toString();
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static void main(String[] args) throws Exception {
		ExceptionBean3 object = new ExceptionBean3();
		while (true) {
			try {
				object.traceException();
			} catch (Exception e) {
			}
		}
	}
}