package com.isoft.controller;

import com.isoft.dao.TypeDao;
import com.isoft.entity.TbGoods;
import com.isoft.entity.TbType;
import com.isoft.service.Impl.TypeServiceImpl;
import com.isoft.service.TypeService;
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
@RequestMapping("/Type")
public class TypeController {
    @Autowired
    TypeService typeService;

    @RequestMapping("increase")
    @ResponseBody
    public Map<String , Boolean> increase(String lbname){
        boolean result= typeService.IncreaseVariety(lbname);
        Map<String,Boolean> map=new HashMap<>();
        map.put("result",result);
        return map;
    }

    @RequestMapping("selectAll")
    @ResponseBody
    public List<TbType> selectAll() {
        return typeService.selectAll();
    }

    @RequestMapping("delete")
    @ResponseBody
    public Map<String , Boolean> deleteVariety(Integer id) {
        boolean result= typeService.deleteVariety(id);
        Map<String,Boolean> map=new HashMap<>();
        map.put("result",result);
        return map;
    }

    @RequestMapping("alter")
    @ResponseBody
    public Map<String , Boolean> modifyVariety(Integer id, String lbname) {
        TbType tbType=new TbType();
        tbType.setId(id);
        tbType.setLbname(lbname);
        boolean result= typeService.modifyVariety(id,lbname);
        Map<String,Boolean> map=new HashMap<>();
        map.put("result",result);
        return map;
    }
}
