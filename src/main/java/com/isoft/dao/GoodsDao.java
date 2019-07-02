package com.isoft.dao;

import com.isoft.entity.TbGoods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GoodsDao {
//    添加商品
    int addGoods(TbGoods tbGoods);
//    分页查询所有商品
    List<TbGoods> selectgoods(@Param("offset") Integer offset,@Param("size") Integer size,
                              @Param("gname") String gname,@Param("order")String order,
                              @Param("gstatus") Integer gstatus,@Param("typeId") Integer typeId
    );
//    行数
    int GoodsTotal(@Param("gname") String gname,@Param("order")String order,
                   @Param("gstatus") Integer gstatus,@Param("typeId") Integer typeId
    );
//    修改商品状态
    @Update("update tb_goods set gstatus=#{gstatus} where id=#{id}")
    int updateStatus(@Param("id") Integer id, @Param("gstatus") Integer gstatus);
//    修改商品信息
    int updatemessage(TbGoods tbgoods);
}
