package com.isoft.controller;

import com.isoft.Util.StringUtil;
import com.isoft.entity.TbSysuser;
import com.isoft.service.SysuserService;
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
@RequestMapping("/sys")
public class SysuserController {

    @Autowired
    SysuserService sysuserService ;

    @RequestMapping(value = "login")
    @ResponseBody
    public TbSysuser loginCheck(String loginname , String  loginpass) {
        if(StringUtil.isEmpty(loginname) || StringUtil.isEmpty(loginpass)) {
            return null ;
        }
        return sysuserService.loginCheck(loginname , loginpass) ;
    }

    @RequestMapping("add")
    @ResponseBody
    public Map<String , Boolean> add(String uname , String upass , int role) {
        boolean r = sysuserService.addUser(uname , upass , role) ;
        Map<String , Boolean> map = new HashMap<>() ;
        map.put("result" , r) ;
        return map ;
    }

    @RequestMapping("getall")
    @ResponseBody
    public List<TbSysuser> getAll() {
        return sysuserService.getAll() ;
    }

    @RequestMapping("updatestate")
    @ResponseBody
    public Map<String , Boolean> updateState(Integer id , Integer state){
        boolean r = sysuserService.updateState(id ,state) ;
        Map<String , Boolean> map = new HashMap<>() ;
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
        r = sysuserService.updateMoreState(ids) ;
        map.put("result" , r) ;
        return map ;
    }

}
