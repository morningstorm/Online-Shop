package com.isoft.dao;

import com.isoft.entity.TbGoods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsDao {
//    添加商品
    @Insert("insert into tb_goods values(null,#{gid},#{gname},#{gprice},#{gpicture},#{gmessage},1,#{typeId})")
    int addGoods(TbGoods goods);
//    查询所有商品
    @Select("select * from tb_goods")
    List<TbGoods> selectgoods();
}
