package com.isoft.controller;

import com.isoft.Util.StringUtil;
import com.isoft.bean.Page;
import com.isoft.entity.TbGoods;
import com.isoft.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("/Goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping("addGoods")
    @ResponseBody
//    添加商品
    public Map<String , Boolean> addGoods(String gid,String gname,Double gprice,String gpicture,
                                          String gmessage,Integer gstatus,Integer type_id)
    {
        if(gid == ""){
            gid = null;
        }
        if(gname == ""){
            gname = null;
        }
        if(gpicture == ""){
            gpicture = null;
        }
        if(gmessage == ""){
            gmessage = null;
        }
        TbGoods tbGoods=new TbGoods();
        tbGoods.setGid(gid);
        tbGoods.setGname(gname);
        tbGoods.setGprice(gprice);
        tbGoods.setGpicture(gpicture);
        tbGoods.setGmessage(gmessage);
        tbGoods.setGstatus(gstatus);
        tbGoods.setTypeId(type_id);
        boolean result= goodsService.addGoods(tbGoods);
        Map<String,Boolean> map=new HashMap<>();
        map.put("result",result);
        return map;
    }

    @RequestMapping("updateStatus")
    @ResponseBody
    //    修改商品状态
    public Map<String , Boolean> updateStatus(Integer id,Integer gstatus){
        boolean result= goodsService.updateStatus(id,gstatus);
        Map<String,Boolean> map=new HashMap<>();
        map.put("result",result);
        return map;
    }

    @RequestMapping("updatemessage")
    @ResponseBody
    //    修改商品信息
     public Map<String , Boolean> updatemessage(String gname,Double gprice,String gmessage,Integer type_id){
         TbGoods tbGoods=new TbGoods();
         tbGoods.setGname(gname);
         tbGoods.setGprice(gprice);
         tbGoods.setGmessage(gmessage);
         tbGoods.setTypeId(type_id);
         boolean result= goodsService.updatemessage(tbGoods);
         Map<String,Boolean> map=new HashMap<>();
         map.put("result",result);
         return map;
    }

    @RequestMapping("getData")
    @ResponseBody
    //    分页查询所有商品
    public  Map<String ,Object> getData(String gname,String order,String orderSort,Integer type_id,
                                        Integer gstatus,Integer pageNumber,Integer pageSize){
        if(gname == ""){
            gname = null;
        }
        if(order == ""){
            order = null;
            orderSort =null;
        }
        if(null != orderSort || !("asc".equalsIgnoreCase(orderSort) || "desc".equalsIgnoreCase(orderSort) )) {
            orderSort = "asc" ;
        }
        Page<TbGoods> page=goodsService.pageData(gname,type_id,gstatus,pageNumber,pageSize,order,orderSort);
        Map<String , Object> map = new HashMap<>() ;
        map.put("total" , page.getRowCount()) ;
        map.put("rows" , page.getPageData()) ;
        return map ;
    }
}
