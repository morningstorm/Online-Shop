package com.isoft.service.Impl;

import com.isoft.Util.StringUtil;
import com.isoft.bean.Page;
import com.isoft.dao.GoodsDao;
import com.isoft.entity.TbGoods;
import com.isoft.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    GoodsDao goodsDao;

//    添加商品
    @Override
    public boolean addGoods(TbGoods tbGoods) {
        if(null==tbGoods||StringUtil.isEmpty(tbGoods.getGid()) || StringUtil.isEmpty(tbGoods.getGname()) || null==tbGoods.getGprice() || null==tbGoods.getGstatus())
        {
            return false;
        }
//        请求addGoods方法
        TbGoods tbGoods1=new TbGoods();
        tbGoods1.setGid("5");
        tbGoods1.setGname("抱枕");
        tbGoods1.setGprice((double) 30);
        tbGoods1.setGstatus(1);
        boolean result =goodsDao.addGoods(tbGoods1)>0?true:false;
        return result;
    }


    //    更新一个商品的状态
    @Override
    public boolean updateStatus(Integer id, Integer gstatus) {
        if(null == id || id <1 || null == gstatus || gstatus <0 || gstatus >1){
            return false;
        }
        if(gstatus == 0){
            return goodsDao.updateStatus(id,1)>0;
        }
        if(gstatus == 1){
            return goodsDao.updateStatus(id,0)>0;
        }
        return false;
    }

//    更新商品信息
    @Override
    public boolean updatemessage(TbGoods tbgoods) {
        if(tbgoods == null || tbgoods.getId() == null || tbgoods.getId() <1 ){
            return false;
        }
        boolean result =goodsDao.updatemessage(tbgoods)>0?true:false;
        return result;
    }

//    分页查看
    @Override
    public Page<TbGoods> pageData(String gname, Integer typeId, Integer gstatus, Integer pagenumber, Integer size, String sortColumnName, String orderSort) {
        int rowCount = goodsDao.GoodsTotal(gname,gstatus,typeId);
        List<TbGoods> datas=goodsDao.selectgoods((pagenumber-1)*size,size,gname,sortColumnName,orderSort,gstatus,typeId);
        Page<TbGoods> page=new Page<>();
        page.setPage(pagenumber);
        page.setSize(size);
        page.setRowCount(rowCount);
        page.setPageData(datas);
        return page;
    }
}
