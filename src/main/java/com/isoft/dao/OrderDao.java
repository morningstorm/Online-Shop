package com.isoft.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import com.isoft.entity.TbOrder;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {
    @Select("select * from tb_order")
    List<TbOrder> getAll();
    /**
     * 用户个人订单
     * @param auser_id
     */
    @Select("select amount,status,orderdate,message,address,oid from tb_order where auser_id=#{auser_id}")
    List<TbOrder> getUserOrder(Integer auser_id);
//后台操作

    /**
     * 根据订单编号查询
     * @param oid
     */

    @Select("select * from tb_order where oid=#{oid}")
    TbOrder getByOid(String oid) ;

    @Select("select * from tb_order where status=#{status}")
    List<TbOrder> getByStatus(Integer status) ;
    /**
     * 根据用户id查询
     */
    @Select("select * from tb_order where  auser_id=#{auser_id}")
    List<TbOrder> getByauser_id(Integer auser_id) ;

    /**
     * 修改状态
     * @param id
     * @param ：0--未支付，1--未发货,2--已发货，3--已取消，4--已完成
     */

    @Update("update tb_order set status=2 where id=#{id}")
    int updateStatus(@Param("id") Integer id);
    /**
     *
     * @param id
     */
    @Update("update tb_order set status=3 where id=#{id}")
    int delOne(@Param("id") Integer id);

    /**
     *
     * @param id
     */
    @Update("update tb_order set status=4 where id=#{id}")
    int okOne(@Param("id") Integer id);

    @Update("update tb_order set status=1 where id=#{id}")
    int pay(@Param("id") Integer id);
    /**
     *
     * @param ids
     */
    int updateMoreStatus(Integer[] ids);
    /**
     *
     * @param ids
     */
    int delMore(Integer[] ids);

    List<TbOrder> selectorder(@Param("offset") Integer offset, @Param("size") Integer size,
                               @Param("order") String order, @Param("orderSort") String orderSort,
                              @Param("status") Integer status, @Param("auserId") Integer auserId
    );
    //    行数
    int OrderTotal( @Param("status") Integer status, @Param("auserId") Integer auserId);


    @Insert("insert into tb_orderinfo (order_id, goods_id, num) select #{ordersn}, goods_id, num from tb_cart where auser_id = #{auser_id} ")
    int addOrderInfo(Map<String, Object> map);

    //@Select("select num gshoppingnum, goods_gid gid from tb_cart where auser_id=#{auser_id}")
    //List<Map<String, Object>> selectGoodsShop(Integer uid);

   // @Update("update tb_goods set gstore=gstore-#{gshoppingnum} where gid=#{gid}")
    //int updateStore(Map<String, Object> map);


}
