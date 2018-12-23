package com.zuul.bootc.tool;

import cn.hutool.core.lang.Console;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;

public class MyTool {

    public static void main(String[] arg){
        String json="{\n" +
                "\t\"size\": 2,\n" +
                "\t\"storeCode\": \"roor\",\n" +
                "\t\"projId\": \"9999\",\n" +
                "\t\"businessDate\": \"2018-10-07\",\n" +
                "\t\"lists\": [{\t\n" +
                "\t\t\"orderId\": \"1233121\",\n" +
                "\t\t\"orderNo\": \"a123456789\",\n" +
                "\t\t\"refundNo\": \"3232\",\n" +
                "\t\t\"payTime\": \"2018-10-07 14:45:35\",\n" +
                "\t\t\"fee\": \"100\",\n" +
                "\t\t\"refundFee\": \"0\",\n" +
                "\t\t\"divided\": \"50\",\n" +
                "\t\t\"teadeState\": \"0\",\n" +
                "\t\t\"income\": \"50\"\n" +
                "\t}, {\t\n" +
                "\t\t\"orderId\": \"1233131\",\n" +
                "\t\t\"orderNo\": \"a123456788\",\n" +
                "\t\t\"refundNo\": \"123456\",\n" +
                "\t\t\"payTime\": \"2018-10-07 14:45:35\",\n" +
                "\t\t\"fee\": \"100\",\n" +
                "\t\t\"refundFee\": \"60\",\n" +
                "\t\t\"divided\": \"30\",\n" +
                "\t\t\"teadeState\": \"1\",\n" +
                "\t\t\"income\": \"30\"\n" +
                "\t}]\n" +
                "}";
        String url="http://check.wingct.com/ny/api/order.do";
        String result2 = HttpRequest.post(url).body(json)
                //.header(Header.USER_AGENT, "Hutool http")//头信息，多个头信息多次调用此方法即可
                //.form(paramMap)//表单内容
                .timeout(20000)//超时，毫秒
                .execute().body();
        Console.log(result2);
    }
}
