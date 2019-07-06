package com.isoft.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SysuserDaoTest {
    @org.junit.Test
    public void Test() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        SysuserDao dao = (SysuserDao) app.getBean("sysuserDao");
        System.out.println(dao.getAll());

//        SysuserDao dao = (SysuserDao) app.getBean("sysuserServiceImpl");


    }

}
