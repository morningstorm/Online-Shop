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

    boolean addUser(String sname, String spass, int srole);

    /**
     * 查看所有管理员
     */
    List<TbSysuser> getAll() ;

    /**
     * 登录校验
     */
    TbSysuser loginCheck(String name, String pass) ;

    /**
     * 修改密码
     */
    boolean rePass(Integer id, String newPass) ;

    /**
     * 离职&在职操作
     */
    boolean updateState(Integer id, Integer status);

    /**
     * 批量离职操作
     */
    boolean updateMoreState(Integer[] ids) ;

}
