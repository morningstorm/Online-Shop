package com.isoft.dao;

import com.isoft.bean.Page;
import com.isoft.entity.TbGoods;
import com.isoft.service.GoodsService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class GoodsDaoTest {
    @Test
    public void test() throws Exception{
//        SqlSession sqlsession=null;
//        sqlsession=new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml")).openSession();
//        GoodsDao goodsDao=sqlsession.getMapper(GoodsDao.class);
//        List<TbGoods> list=goodsDao.selectgoods();
//        TbGoods goods=new TbGoods(null,"1","手机",3599,null,null,1,1);
//        int rowCount=goodsDao.addGoods(goods);
//        System.out.println(rowCount);

        //字段提示
//        List<TbGoods> selectgoods(@Param("offset") Integer offset,@Param("size") Integer size,
//                @Param("gname") String gname,@Param("order")String order,
//                @Param("gstatus") Integer gstatus,@Param("typeID") Integer typeId
//    );

//        List<TbGoods> list=goodsDao.selectgoods(0,3,"手","gprice",1,1);
//        TbGoods tbGoods=new TbGoods();
//        tbGoods.setId(2);
//        tbGoods.setGprice(300);
//        tbGoods.setTypeId(2);
//        System.out.println(goodsDao.updatemessage(tbGoods));
//        sqlsession.commit();
//
//        if(null != sqlsession){
//            sqlsession.close();
//            sqlsession=null;
//        }
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml") ;
        GoodsService goodsService=(GoodsService) app.getBean("goodsServiceImpl");
        Page<TbGoods> pages=goodsService.pageData("飞机",null,1,1,3,"gprice","desc");
        System.out.println(pages);
    }
}