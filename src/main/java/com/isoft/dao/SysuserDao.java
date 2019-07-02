package com.isoft.dao;

import com.isoft.entity.TbSysuser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**功能：
 *添加管理员
 * 逻辑删除-离职
 * 根据id将多个人的状态设置为离职
 * 更新信息
 * 登录校验
 * 修改密码
 * 查看所有管理员
 */
public interface SysuserDao {
    /**
     * 添加管理员
     */
    @Insert("insert into tb_sysuser " +
            "values(null , #{sname} , #{spass} , #{smobile} , 1 , #{Srole})")
    int add(TbSysuser user) ;

    /**
     * 逻辑删除-离职
     * @Param state:0--离职，1--在职
     */
    @Update("update tb_sysuser set status=#{status} where id = #{id}")
    int updateState(@Param("id") int id , @Param("status") int status);

    /**
     * 根据id将多个人的状态设置为离职
     */
    int updateMoreState(Integer[] ids) ;

    /**
     * 更新信息
     */
    int update(TbSysuser tbSysuser);

    /**
     * 登录校验
     */
    @Select("select * from tb_sysuser where sname=#{sname} and spass=#{spass} and state=1")
    TbSysuser login(@Param("sname") String sname, @Param("spass") String spass) ;

    /**
     * 修改密码
     */
    @Update("update tb_sysuser set spass=#{newPass} where id=#{id}")
    int repass(@Param("id") Integer id, @Param("newPass") String newPass) ;

    /**
     * 查看所有管理员
     */
    @Select("select * from tb_sysuser")
    List<TbSysuser> getAll();
}
