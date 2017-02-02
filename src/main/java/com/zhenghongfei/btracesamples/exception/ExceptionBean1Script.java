package com.zhenghongfei.btracesamples.exception;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;

/**
 * 开启非安全模式，可以直接调用待监控应用程序中类的方法,以下两个参数同时开启
 * <p>
 * <li>bin/btrace.bat -Dcom.sun.btrace.unsafe=true
 * <li>@BTrace(unsafe=true)
 *
 * @author Hongfei
 */
@BTrace(unsafe = true)
public class ExceptionBean1Script {

	@OnMethod(clazz = "com.zhenghongfei.btracesamples.exception.ExceptionBean1",
			method = "traceException",
			location = @Location(Kind.CATCH))
	public static void traceCatch(Exception e) {
		e.printStackTrace();
	}
}