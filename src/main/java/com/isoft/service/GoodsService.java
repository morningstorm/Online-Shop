package com.isoft.service;

//描述商品管理员操作所需要的业务逻辑功能

import com.isoft.bean.Page;
import com.isoft.entity.TbGoods;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface GoodsService {
    //    添加商品
    boolean addGoods(TbGoods tbGoods);
    //    分页查询所有商品
    Page<TbGoods> pageData(String gname, Integer typeId, Integer gstatus,
                           Integer pagenumber, Integer size, String sortColumnName,
                           String orderSort);

    //    修改商品状态
    boolean updateStatus(Integer id, Integer gstatus);
    //    修改商品信息
    boolean updatemessage(TbGoods tbgoods);
}
