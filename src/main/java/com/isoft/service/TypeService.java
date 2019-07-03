package com.isoft.service;

import com.isoft.entity.TbType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface TypeService {
    //    添加商品类别
    boolean IncreaseVariety(String lbname);

    //    查询所有商品类别
    List<TbType> selectAll();

    //    删除商品类别
    boolean deleteVariety(Integer id);

    //    修改商品类别名
    boolean modifyVariety(Integer id,String lbname);
}
