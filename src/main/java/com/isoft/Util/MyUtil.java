package com.isoft.Util;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;
import com.isoft.entity.TbUser;

public class MyUtil {

        //获得时间字符串
        public static String getStringID() {
            String id=null;
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            id=simpleDateFormat.format(date);
            return id;
        }

        //获得用户id
        public static Integer getUserId(HttpSession session) {
            TbUser auser = (TbUser) session.getAttribute("auser");
            return auser.getId();
        }

}

