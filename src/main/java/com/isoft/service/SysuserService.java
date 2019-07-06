package com.isoft.service;

import com.isoft.entity.TbGoods;
import com.isoft.entity.TbSysuser;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface SysuserService {
    /**
     *  添加管理员
     */
    boolean addUser(String sid, String sname, String spass,String smobile, Integer srole);

    /**
     * 查看所有管理员
     */
    List<TbSysuser> getAll() ;

    /**
     * 登录校验
     */
    TbSysuser loginCheck(String sid, String spass) ;


    /**
     * 修改密码
     */
    boolean rePass(Integer id, String newPass, String spass) ;

    /**
     * 离职&在职操作
     */
    boolean addState(Integer id);
    boolean delState(Integer id);

    /**
     * 用户信息更改操作
     */
    boolean updated(Integer id,String sname, String smobile, Integer srole);

    /**
     * 批量离职操作
     */
    boolean updateMoreState(Integer[] ids) ;

}
