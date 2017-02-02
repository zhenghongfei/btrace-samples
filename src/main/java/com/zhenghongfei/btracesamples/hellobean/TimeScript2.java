package com.zhenghongfei.btracesamples.hellobean;

import static com.sun.btrace.BTraceUtils.println;
import static com.sun.btrace.BTraceUtils.str;
import static com.sun.btrace.BTraceUtils.strcat;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Duration;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.OnTimer;
import com.sun.btrace.annotations.Return;

@BTrace
public class TimeScript2 {

	private static volatile long totalTimes;

	@OnMethod(clazz = "com.zhenghongfei.btracesamples.hellobean.HelloBean", method = "hello", location = @Location(Kind.RETURN))
	public static void traceExecute(@Duration long duration, int sleepTime, @Return boolean result) {

		long usedTime = duration / 1000000;

		totalTimes += usedTime;

		println(strcat(strcat("hello method used time is:", str(usedTime)), "ms"));

		println(strcat(strcat("hello method sleep time is:", str(sleepTime)), "ms"));
		println(strcat("hello method result is:", str(result)));
	}

	@OnTimer(5000)
	public static void onTime() {
		println(strcat(str("hello method total time in 5s is:"), str(totalTimes)));
	}
}