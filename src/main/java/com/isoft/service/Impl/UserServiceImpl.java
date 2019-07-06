package com.isoft.service.Impl;

import com.isoft.Util.MD5Tools;
import com.isoft.Util.StringUtil;
import com.isoft.bean.Page;
import com.isoft.dao.UserDao;
import com.isoft.entity.TbUser;
import com.isoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public TbUser loginCheck(String uid, String upass){
        if(StringUtil.isEmpty(uid) || StringUtil.isEmpty(upass)) {
            return null ;
        }
            return userDao.login( uid, upass) ;
    }

    @Override
    public boolean addUser(String uname, String uid, String upass, String usex,
                           String umobile, String uaddress, String uemail) {
        if(StringUtil.isEmpty(uname) || StringUtil.isEmpty(uid) || StringUtil.isEmpty(upass)
                || StringUtil.isEmpty(usex)|| StringUtil.isEmpty(uaddress)) {
            return false ;
        }
        upass = MD5Tools.MD5(upass) ;
        // 合格，请求dao的方法
        TbUser user = new TbUser() ;
        user.setUid(uid);
        user.setUname(uname);
        user.setUpass(upass);
        user.setUmobile(umobile);
        user.setUsex(usex);
        user.setUaddress(uaddress);
        user.setUemail(uemail);
        boolean r = userDao.add(uname, uid, upass, usex, umobile, uaddress, uemail) >0 ? true : false ;
        return r ;
    }

    @Override
    public Page<TbUser> pageData(String uname, String umobile, String usex,
                          Integer pagenumber, Integer size, String sortColumnName,
                          String orderSort){
        int rowCount = userDao.UserTotal(uname,umobile,usex);
        List<TbUser> datas=userDao.selectuser((pagenumber-1)*size,size,uname,sortColumnName,orderSort,usex,umobile);
        Page<TbUser> page=new Page<>();
        page.setPage(pagenumber);
        page.setSize(size);
        page.setRowCount(rowCount);
        page.setPageData(datas);
        return page;
    }

}
