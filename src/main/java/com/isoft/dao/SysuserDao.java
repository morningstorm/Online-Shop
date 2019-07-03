package com.isoft.dao;

import com.isoft.entity.TbSysuser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

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
@Repository
public interface SysuserDao {
    /**
     * 添加管理员
     */
    @Insert("insert into tb_sysuser " +
            "values(null ,#{sid}, #{sname} , #{spass} , #{smobile} , 1 , #{srole});")
    int add(TbSysuser user) ;

    /**
     * 查看所有管理员
     */
    @Select("select * from tb_sysuser")
    List<TbSysuser> getAll();

    /**
     * 逻辑删除-离职
     * @Param state:0--离职，1--在职
     */
    @Update("update tb_sysuser set status=1 where id = #{id}")
    int addState(@Param("id") int id);

    @Update("update tb_sysuser set status=0 where id = #{id}")
    int delState(@Param("id") int id);

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
    @Select("select * from tb_sysuser where sid=#{sid} and spass=#{spass} and status=1")
    TbSysuser login(@Param("sid") String sid, @Param("spass") String spass) ;

    /**
     * 修改密码
     */
    @Update("update tb_sysuser set spass=#{newPass} where id=#{id} and spass=#{spass}")
    int repass(@Param("id") Integer id, @Param("newPass") String newPass, @Param("spass") String spass) ;

}
