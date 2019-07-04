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
    public boolean addUser(String sid, String sname, String spass,String smobile, Integer srole) {
        // 数据校验
        if(StringUtil.isEmpty(sid) || StringUtil.isEmpty(sname) || StringUtil.isEmpty(spass)) {
            return false ;
        }
        if (srole == null) {return false;}
        spass = MD5Tools.MD5(spass) ;
        // 合格，请求dao的方法
        TbSysuser user = new TbSysuser() ;
        user.setSid(sid);
        user.setSname(sname);
        user.setSpass(spass);
        user.setSmobile(smobile);
        user.setSrole(srole);
        boolean r = sysuserDao.add(user) >0 ? true : false ;
        return r ;
    }

    @Override
    public List<TbSysuser> getAll() {
        return sysuserDao.getAll() ;
    }

    @Override
    public TbSysuser loginCheck(String sid, String spass, int srole) {
        if(StringUtil.isEmpty(sid) || StringUtil.isEmpty(spass)) {
            return null ;
        }
        if(srole==0||srole==1||srole==2){
            spass = MD5Tools.MD5(spass) ;
            return sysuserDao.login(sid , spass , srole) ;
        }
        return null;
    }

    @Override
    public boolean rePass(Integer id, String newPass, String spass) {
        if(id == null || id < 1) {
            return false;
        }
        if(StringUtil.isEmpty(newPass) || StringUtil.isEmpty(spass)) {
            return false;
        }
        return sysuserDao.repass(id, MD5Tools.MD5(newPass), MD5Tools.MD5(spass))>0;
    }

    @Override
    public boolean addState(Integer id) {
        if(id == null || id < 1) {
            return false;
        }
        return sysuserDao.addState(id) > 0 ;
    }

    @Override
    public boolean delState(Integer id) {
        if(id == null || id < 1) {
            return false;
        }
        return sysuserDao.delState(id) > 0 ;
    }

    @Override
    public boolean updated(Integer id,String sname, String smobile, Integer srole) {
        if(id == null || id < 1) {
            return false ;
        }
        return sysuserDao.update(id,sname,smobile,srole)>0;
    }

    @Override
    public boolean updateMoreState(Integer[] ids) {
        if(ids == null || ids.length < 1) {
            return false ;
        }
        return sysuserDao.updateMoreState(ids) > 0 ;
    }


}
