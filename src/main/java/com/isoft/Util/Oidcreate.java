package com.isoft.Util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Oidcreate {

    //订单编号前缀
    public static final String PREFIX = "DD";
    //订单编号后缀
    private static long code;
    // 生成订单编号
    public static synchronized String getOid() {
        code++;
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        long m = Long.parseLong((str)) * 10000;
        m += code;
        return PREFIX + m;
    }
    public static void main(String[] args) {
        System.out.println(Oidcreate.getOid());
    }

}