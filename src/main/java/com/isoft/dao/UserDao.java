package com.isoft.dao;


import com.isoft.entity.TbUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    //前台登录
    @Select("select * from tb_user where uid = #{uid} and upass = #{upass}")
    TbUser login(@Param("uid") String uid, @Param("upass") String upass);

    //注册
    int add(@Param("uname") String uname,@Param("uid") String uid,
            @Param("upass") String upass,@Param("usex") String usex,
            @Param("umobile") String umobile,@Param("uaddress") String uaddress,
            @Param("uemail") String uemail);


    @Update("update tb_user set status=1 where id = #{id}")
    int addState(@Param("id") int id);//在职操作

    @Update("update tb_user set status=0 where id = #{id}")
    int delState(@Param("id") int id);//离职操作

    //查看所有用户信息
    @Select("select * from tb_user")
    List<TbUser> getAll();

    //分页查找
    List<TbUser> selectuser(@Param("offset") Integer offset, @Param("size") Integer size,
                              @Param("uname") String uname, @Param("order") String order, @Param("orderSort") String orderSort,
                              @Param("usex") String usex, @Param("umobile") String umobile
    );

    //行数
    int UserTotal(@Param("uname") String uname, @Param("usex") String usex, @Param("umobile") String umobile);


}
