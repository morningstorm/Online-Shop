package com.isoft.service.Impl;


import com.isoft.Util.MyUtil;
import com.isoft.Util.StringUtil;
import com.isoft.bean.Page;
import com.isoft.dao.OrderDao;
import com.isoft.entity.TbOrder;
import com.isoft.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;


    @Override
    public List<TbOrder> getAll() {
        return orderDao.getAll() ;
    }

    @Override
    public TbOrder getByOid(String oid) {
        return orderDao.getByOid(oid);
    }

    @Override
    public List<TbOrder> getUserOrder(Integer auser_id) {
        return orderDao.getUserOrder(auser_id);
    }

    @Override
    public List<TbOrder> getByauser_id(Integer auser_id) {
        return orderDao.getByauser_id(auser_id);
    }

    @Override
    public List<TbOrder> getByStatus(Integer status) {
        return orderDao.getByStatus(status);
    }


    @Override
    public boolean updateStatus(Integer id) {
        if(id == null || id < 1) {
            return false;
        }
        return orderDao.updateStatus(id) > 0 ;
    }

    @Override
    public boolean delOne(Integer id) {
        if(id == null || id < 1) {
            return false;
        }
        return orderDao.delOne(id) > 0 ;
    }

    @Override
    public boolean okOne(Integer id) {
        if(id == null || id < 1) {
            return false;
        }
        return orderDao.okOne(id) > 0 ;
    }

    @Override
    public boolean pay(Integer id) {
        if(id == null || id < 1) {
            return false;
        }
        return orderDao.pay(id) > 0 ;
    }


/*
        @Override

        public String orderSubmit(Model model, HttpSession session, Double amount) {

            Order order = new Order();

            order.setAmount(amount);

            order.setBusertable_id(MyUtil.getUserId(session));

            //生成订单，并将主键返回order

            orderDao.addOrder(order);

            //生成订单详情

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("ordersn", order.getId());

            map.put("uid", MyUtil.getUserId(session));

            orderDao.addOrderDetail(map);

            //更新商品库存

            //更新商品库存1.查询商品购买量，以便更新库存使用

            List<Map<String, Object>> list = orderDao.selectGoodsShop(MyUtil.getUserId(session));

            //更新商品库存2.根据商品购买量更新库存

            for (Map<String, Object> map2 : list) {

                orderDao.updateStore(map2);

            }

            //清空购物车

            orderDao.clear(MyUtil.getUserId(session));

            model.addAttribute("ordersn", order.getId());

            return "before/orderdone";

        }



        @Override

        public String pay(Integer ordersn) {

            orderDao.pay(ordersn);

            return "befeore/paydone";

 */

    @Override
    public boolean updateMoreStatus(Integer[] ids) {
        if(ids == null || ids.length < 1) {
            return false ;
        }
        return orderDao.updateMoreStatus(ids) > 0 ;
    }

    @Override
    public boolean delMore(Integer[] ids) {
        if(ids == null || ids.length < 1) {
            return false ;
        }
        return orderDao.delMore(ids) > 0 ;
    }


    @Override
    public Page<TbOrder> pageData( Integer auserId, Integer status, Integer pagenumber, Integer size, String sortColumnName, String orderSort) {
        int rowCount = orderDao.OrderTotal(status,auserId);
        List<TbOrder> datas=orderDao.selectorder((pagenumber-1)*size,size,sortColumnName,orderSort,status,auserId);
        Page<TbOrder> page=new Page<>();
        page.setPage(pagenumber);
        page.setSize(size);
        page.setRowCount(rowCount);
        page.setPageData(datas);
        return page;
    }

}
