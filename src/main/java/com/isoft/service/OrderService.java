package com.isoft.service;



import com.isoft.bean.Page;
import com.isoft.entity.TbOrder;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;

@Service
public interface OrderService {
    List<TbOrder> getAll() ;
    TbOrder getByOid(String oid);
    List<TbOrder> getUserOrder(Integer auser_id) ;
    List<TbOrder> getByauser_id(Integer auser_id) ;
    List <TbOrder> getByStatus(Integer status) ;
    boolean updateStatus(Integer id) ;
    boolean updateMoreStatus(Integer[] ids);
    boolean delOne(Integer id) ;
    boolean delMore(Integer[] ids) ;
    boolean okOne(Integer id) ;
    //String orderSubmit(Model model,HttpSession session,Double amount);
    boolean pay(Integer id);
    Page<TbOrder> pageData( Integer auserId, Integer status,
                           Integer pagenumber, Integer size, String sortColumnName,
                           String orderSort);
}
