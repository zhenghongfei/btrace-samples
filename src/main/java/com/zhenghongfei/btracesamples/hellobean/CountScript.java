package com.zhenghongfei.btracesamples.hellobean;

import static com.sun.btrace.BTraceUtils.classOf;
import static com.sun.btrace.BTraceUtils.println;
import static com.sun.btrace.BTraceUtils.str;
import static com.sun.btrace.BTraceUtils.strcat;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnEvent;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.OnTimer;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;
import com.sun.btrace.annotations.TargetInstance;
import com.sun.btrace.annotations.TargetMethodOrField;

@BTrace
public class CountScript {

	private static volatile long newCount;
	private static volatile long sleepCount;

	@OnMethod(clazz = "com.zhenghongfei.btracesamples.hellobean.HelloBean", method = "<init>")
	public static void onNew() {
		newCount++;
	}

	@OnTimer(5000)
	public static void onNewCount() {
		println(strcat(str("Create HelloBean Count in 5s:"), str(newCount)));
	}

	@OnMethod(clazz = "/.*/", method = "hello", location = @Location(value = Kind.CALL, clazz = "/.*/", method = "sleep"))
	public static void traceExecute(@ProbeClassName String pcm, @ProbeMethodName String pmn,
			@TargetInstance Object instance, @TargetMethodOrField String method) {
		println("====== ");
		println(strcat("ProbeClassName: ", pcm));
		println(strcat("ProbeMethodName: ", pmn));
		println(strcat("TargetInstance: ", str(classOf(instance))));
		println(strcat("TargetMethodOrField : ", str(method)));
		sleepCount++;
	}

	@OnEvent(value = "sc")
	public static void getSleepCount() {
		println(strcat("HelloBean .hello method SleepCount: ", str(sleepCount)));
	}

	@OnEvent
	public static void event() {
		println("========================================");
	}
}