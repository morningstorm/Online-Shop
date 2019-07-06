package com.isoft.dao;

import com.isoft.bean.Page;
import com.isoft.entity.TbUser;
import com.isoft.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoTest {

    @Test
    public void test(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao dao = (UserDao) app.getBean("userDao");
//        System.out.println(dao.getAll());
        UserDao dao = (UserDao) app.getBean("userDao");
        System.out.println(
                dao.add("li","U009","123","男",null,"天",null)
        );
//        System.out.println(dao.selectuser(1,3,"li","id","desc","男",null));
//        System.out.println(dao.UserTotal("li","男",null));
//        System.out.println(dao.UserTotal(null,null,null));

//        UserService userService=(UserService) app.getBean("userServiceImpl");
//        Page<TbUser> pages=userService.pageData(null,null,null,1,3,"id","desc");
//        System.out.println(pages);
    }

}