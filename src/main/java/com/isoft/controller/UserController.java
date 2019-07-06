package com.isoft.controller;

import com.isoft.Util.StringUtil;
import com.isoft.bean.Page;
import com.isoft.entity.TbUser;
import com.isoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("login")
    @ResponseBody
    //登录
    public TbUser loginCheck(String loginname , String  loginpass) {
        if(StringUtil.isEmpty(loginname) || StringUtil.isEmpty(loginpass)) {
            return null ;
        }
            return userService.loginCheck(loginname , loginpass) ;
    }

    @RequestMapping("register")
    @ResponseBody
    //注册
    public Map<String , Boolean> add(String uname, String uid, String upass, String usex,
                                     String umobile, String uaddress, String uemail) {
        boolean r = userService.addUser(uname, uid, upass, usex, umobile, uaddress, uemail) ;
        Map<String , Boolean> map = new HashMap<>() ;
        map.put("result" , r) ;
        return map ;
    }

    @RequestMapping("getData")
    @ResponseBody
    //    分页查询所有商品
    public Map<String ,Object> getData(String uname, String order, String orderSort, String usex,
                                       String umobile, Integer pageNumber, Integer pageSize){
        if(uname == ""){
            uname = null;
        }
        if(order == ""){
            order = null;
            orderSort =null;
        }
        if(null != orderSort || !("asc".equalsIgnoreCase(orderSort) || "desc".equalsIgnoreCase(orderSort) )) {
            orderSort = "asc" ;
        }
        Page<TbUser> page=userService.pageData(uname,umobile,usex,pageNumber,pageSize,order,orderSort);
        Map<String , Object> map = new HashMap<>() ;
        map.put("total" , page.getRowCount()) ;
        map.put("rows" , page.getPageData()) ;
        return map ;
    }

    @RequestMapping("addstate")
    @ResponseBody
    public Map<String , Boolean> addState(Integer id){
        boolean r = userService.addState(id) ;
        Map<String , Boolean> map = new HashMap<>() ;
        map.put("result" , r) ;
        return map ;
    }


    @RequestMapping("delstate")
    @ResponseBody
    public Map<String , Boolean> delState(Integer id){
        boolean r = userService.delState(id) ;
        Map<String , Boolean> map = new HashMap<>() ;
        map.put("result" , r) ;
        return map ;
    }
}
