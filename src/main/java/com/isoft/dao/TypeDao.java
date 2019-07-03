package com.isoft.dao;

import com.isoft.entity.TbType;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeDao {
//    添加商品类别
    @Insert("insert into tb_type values(null,#{lbname})")
    int IncreaseVariety(String lbname);
//    查询所有商品类别
    @Select("select * from tb_type")
    List<TbType> selectAll();
//    删除商品类别
    @Delete("delete from tb_type where id=#{id}")
    int deleteVariety(Integer id);
//    修改商品类别名
    @Update("update tb_type set lbname=#{lbname} where id=#{id}")
    int modifyVariety(@Param("id") Integer id, @Param("lbname") String lbname);
}
