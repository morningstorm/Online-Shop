package com.isoft.service;

import com.isoft.bean.Page;
import com.isoft.entity.TbUser;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    TbUser loginCheck(String uid, String upass) ;

    boolean addUser(String uname,String uid, String upass,String usex,
                    String umobile,String uaddress, String uemail) ;

    Page<TbUser> pageData(String uname, String umobile, String usex,
                          Integer pagenumber, Integer size, String sortColumnName,
                          String orderSort);

    /**
     * 离职&在职操作
     */
    boolean addState(Integer id);
    boolean delState(Integer id);
}
