package com.zhenghongfei.btracesamples.hellobean;

import static com.sun.btrace.BTraceUtils.field;
import static com.sun.btrace.BTraceUtils.get;
import static com.sun.btrace.BTraceUtils.println;
import static com.sun.btrace.BTraceUtils.str;
import static com.sun.btrace.BTraceUtils.strcat;
import static com.sun.btrace.BTraceUtils.timeMillis;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.OnTimer;
import com.sun.btrace.annotations.Return;
import com.sun.btrace.annotations.Self;
import com.sun.btrace.annotations.TLS;

@BTrace
public class TimeScript1 {
	@TLS
	private static volatile long beginTime;
	private static volatile long totalTimes;

	@OnMethod(clazz = "com.zhenghongfei.btracesamples.hellobean.HelloBean", method = "hello")
	public static void startHello() {
		beginTime = timeMillis();
	}

	@OnMethod(clazz = "com.zhenghongfei.btracesamples.hellobean.HelloBean", method = "hello", location = @Location(Kind.RETURN))
	public static void traceExecute(@Self com.zhenghongfei.btracesamples.hellobean.HelloBean helloBean, int sleepTime,
			@Return boolean result) {
		long endTime = timeMillis();
		totalTimes += (long) get(field("com.zhenghongfei.btracesamples.hellobean.HelloBean", "totalTimes"), helloBean);
		println(strcat(strcat("hello method used time is:", str(endTime - beginTime)), "ms"));
		println(strcat(strcat("hello method sleep time is:", str(sleepTime)), "ms"));
		println(strcat("hello method result is:", str(result)));
	}

	@OnTimer(5000)
	public static void onTime() {
		println(strcat(str("hello method total time in 5s is:"), str(totalTimes)));
	}
}