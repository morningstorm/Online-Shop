package com.isoft.service.Impl;


import com.isoft.Util.MD5Tools;
import com.isoft.Util.StringUtil;
import com.isoft.dao.SysuserDao;
import com.isoft.entity.TbSysuser;
import com.isoft.service.SysuserService;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
public class SysuserServiceImpl implements SysuserService {

    @Autowired
    SysuserDao sysuserDao;


    @Override
    public boolean addUser(String sname, String spass, int srole) {
        // 数据校验
        if(StringUtil.isEmpty(sname) || StringUtil.isEmpty(spass)) {
            return false ;
        }
        spass = MD5Tools.MD5(spass) ;
        // 合格，请求dao的方法
        TbSysuser user = new TbSysuser() ;
        user.setSname(sname);
        user.setSpass(spass);
        user.setSrole(srole);
        boolean r = sysuserDao.add(user) >0 ? true : false ;
        return r ;
    }

    @Override
    public List<TbSysuser> getAll() {
        return sysuserDao.getAll() ;
    }

    @Override
    public TbSysuser loginCheck(String sname, String spass) {
        if(StringUtil.isEmpty(sname) || StringUtil.isEmpty(spass)) {
            return null ;
        }
        spass = MD5Tools.MD5(spass) ;
        return sysuserDao.login(sname , spass) ;
    }

    @Override
    public boolean rePass(Integer id, String newPass) {
        return false;
    }

    @Override
    public boolean updateState(Integer id, Integer status) {
        if(id == null || id < 1) {
            return false;
        }
        if(status == null || !(status==0||status==1)) {
            return false ;
        }
        return sysuserDao.updateState(id ,status) > 0 ;
    }

    @Override
    public boolean updateMoreState(Integer[] ids) {
        if(ids == null || ids.length < 1) {
            return false ;
        }
        return sysuserDao.updateMoreState(ids) > 0 ;
    }


}
