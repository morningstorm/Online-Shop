package com.isoft.service.Impl;

import com.isoft.Util.StringUtil;
import com.isoft.dao.TypeDao;
import com.isoft.entity.TbType;
import com.isoft.service.TypeService;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeDao typeDao  ;

    @Override
    public boolean IncreaseVariety(String lbname) {
        //数据校验
        if(StringUtil.isEmpty(lbname)){
            return false;
        }
        //请求TypeDao的方法
        TbType tbtype=new TbType();
        tbtype.setLbname(lbname);
        boolean result =typeDao.IncreaseVariety(lbname)>0?true:false;
        return result;
    }

    @Override
    public List<TbType> selectAll() {
        return typeDao.selectAll();
    }

    @Override
    public boolean deleteVariety(Integer id) {
        if(null == id || id < 1){
            return false;
        }
        return typeDao.deleteVariety(id)>0;
    }

    @Override
    public boolean modifyVariety(Integer id, String lbname) {
        if(null == id || id < 1){
            return false;
        }
        if(StringUtil.isEmpty(lbname)){
            return false;
        }
        return typeDao.modifyVariety(id,lbname)>0;
    }
}
