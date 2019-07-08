package com.isoft.controller;

import com.isoft.Util.StringUtil;
import com.isoft.bean.Page;
import com.isoft.entity.TbOrder;
import com.isoft.service.OrderService;
import com.isoft.service.Impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService ;

    @RequestMapping("getall")
    @ResponseBody
    public List<TbOrder> getAll() {
        return orderService.getAll() ;
    }

    @RequestMapping("getByOid")
    @ResponseBody
    public TbOrder getByOid(String oid) {
        return orderService.getByOid( oid);
    }
    @RequestMapping("getByauser_id")
    @ResponseBody
    public List<TbOrder> getByauser_id(int auser_id) {
        return orderService.getByauser_id(auser_id) ;
    }
    @RequestMapping("getByStatus")
    @ResponseBody
    public List<TbOrder> getByStatus(int status) {
        return orderService.getByStatus(status) ;
    }
    @RequestMapping("updateStatus")
    @ResponseBody
    public Map<String , Boolean> updateStatus(Integer id){
        boolean r = orderService.updateStatus(id) ;
        Map<String , Boolean> map = new HashMap<>() ;
        map.put("result" , r) ;
        return map ;
    }
    @RequestMapping("delOne")
    @ResponseBody
    public Map<String , Boolean> delOne(Integer id){
        boolean r = orderService.delOne(id) ;
        Map<String , Boolean> map = new HashMap<>() ;
        map.put("result" , r) ;
        return map ;
    }
    @RequestMapping("okOne")
    @ResponseBody
    public Map<String , Boolean> okOne(Integer id){
        boolean r = orderService.okOne(id) ;
        Map<String , Boolean> map = new HashMap<>() ;
        map.put("result" , r) ;
        return map ;
    }
    @RequestMapping("Pay")
    @ResponseBody
    public Map<String , Boolean> pay(Integer id){
        boolean r = orderService.pay(id) ;
        Map<String , Boolean> map = new HashMap<>() ;
        map.put("result" , r) ;
        return map ;
    }

    @RequestMapping("updateMoreStatus")
    @ResponseBody
    public Map<String , Boolean> updateMoreStatus(String idStr) {
        System.out.println(idStr);
        Map<String , Boolean> map = new HashMap<>() ;
        boolean r = false ;
        if(StringUtil.isEmpty(idStr)) {
            map.put("result" , r) ;
            return map ;
        }

        String[] tempArr = idStr.split(",") ;
        Integer[] ids = new Integer[tempArr.length] ;
        try {
            for (int i = 0; i < tempArr.length; i++) {
                ids[i] = Integer.parseInt(tempArr[i]);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            map.put("result" , r) ;
            return map ;
        }
        r = orderService.updateMoreStatus(ids);
        map.put("result" , r) ;
        return map ;
    }

    @RequestMapping("delMore")
    @ResponseBody
    public Map<String , Boolean> delMore(String idStr) {
        System.out.println(idStr);
        Map<String , Boolean> map = new HashMap<>() ;
        boolean r = false ;
        if(StringUtil.isEmpty(idStr)) {
            map.put("result" , r) ;
            return map ;
        }

        String[] tempArr = idStr.split(",") ;
        Integer[] ids = new Integer[tempArr.length] ;
        try {
            for (int i = 0; i < tempArr.length; i++) {
                ids[i] = Integer.parseInt(tempArr[i]);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            map.put("result" , r) ;
            return map ;
        }
        r = orderService.delMore(ids);
        map.put("result" , r) ;
        return map ;
    }
    @RequestMapping("getData")
    @ResponseBody
    //    分页查询所有商品
    public  Map<String ,Object> getData(String order,String orderSort,Integer auser_id, Integer status,Integer pageNumber,Integer pageSize){
//        if(auser_id == null){ auser_id = null; }
//        if(status == null){ status = null; }
        if(order == ""){ order = null; orderSort =null; }
        if(null != orderSort || !("asc".equalsIgnoreCase(orderSort) || "desc".equalsIgnoreCase(orderSort) )) { orderSort = "asc" ; }
        Page<TbOrder> page=orderService.pageData(auser_id,status,pageNumber,pageSize,order,orderSort);
        Map<String , Object> map = new HashMap<>() ;
        map.put("total" , page.getRowCount()) ;
        map.put("rows" , page.getPageData()) ;
        return map ;
    }

}
