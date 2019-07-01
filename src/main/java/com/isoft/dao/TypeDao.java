package com.isoft.dao;

import com.isoft.entity.TbType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TypeDao {
//    添加商品类别
    @Insert("insert into tb_type values(null,#{lbname})")
    int IncreaseVariety(String lbname);
//    查询所有商品类别
    @Select("select * from tb_type")
    List<TbType> selectAll();
//    删除商品类别

//    修改商品类别名
}
