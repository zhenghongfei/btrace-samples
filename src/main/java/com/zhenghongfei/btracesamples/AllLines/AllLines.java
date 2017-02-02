/*
 * Copyright (c) 2008, 2015, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the Classpath exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package com.zhenghongfei.btracesamples.AllLines;

import static com.sun.btrace.BTraceUtils.println;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

/*
 * This sample prints a line every time any line
 * of code of java.lang.Thread class is reached.
 * The line param may be set to any particular
 * value so that the probe fires only when that line
 * is reached. But, the value -1 means all line numbers.
 */
@BTrace
public class AllLines {
    @OnMethod(
        clazz="java.lang.Thread",method="init",
        location=@Location(value=Kind.LINE, line=369)
    )
    public static void online(@ProbeClassName String pcn, @ProbeMethodName String pmn,
    		 int line) {
    		println(pcn + "." + pmn +  ":" + line);
//        println(name);
//        println(str(stackSize));
    }
}
