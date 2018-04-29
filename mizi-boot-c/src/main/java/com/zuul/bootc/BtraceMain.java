package com.zuul.bootc;

import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.Reflective.name;
import static com.sun.btrace.BTraceUtils.Strings.str;
import static com.sun.btrace.BTraceUtils.Strings.strcat;
import static com.sun.btrace.BTraceUtils.probeClass;
import static com.sun.btrace.BTraceUtils.probeMethod;
import static com.sun.btrace.BTraceUtils.timeMillis;
import static java.sql.DriverManager.println;
import static jdk.nashorn.internal.objects.Global.print;

@BTrace(unsafe=true)
public class BtraceMain {
    @TLS
    private static long startTime=0;

    @OnMethod(
            clazz="/.+/",           //所有类
            method="/.+/"    //被监控的方法
    )

    public static void startMethod(){
        startTime=timeMillis();
    }

    @SuppressWarnings("deprecation")
    @OnMethod(
            clazz="/.+/",
            method="/.+/"    ,//被监控的方法
            location=@Location(Kind.RETURN))
    public static void endMethod(){
        print(strcat(strcat(name(probeClass()),"."),probeMethod()));
        print("[");
        print(strcat("Time taken: ",str(timeMillis()-startTime)));
        println("]");

    }

}
