package com.hy.crmsystem.service.bussinessOppo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crmsystem.entity.bussinessOppo.Businessoppo;
import com.hy.crmsystem.entity.bussinessOppo.ForumLunTan;
import com.hy.crmsystem.entity.customerManager.Customer;
import com.hy.crmsystem.entity.systemManager.User;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
public interface IBusinessoppoService extends IService<Businessoppo> {
    IPage<Businessoppo> pages(@Param("page") Integer page, @Param("limit") Integer limit, @Param("businessoppo") Businessoppo businessoppo, @Param("session") HttpSession session);

/*    public List<Businessoppo> listQueryAll(@Param("businessoppo") Businessoppo businessoppo);*/
    public  Businessoppo selectByName(String bid);

    public Customer selectBusinessoppo(String bid);

    public String selectCount(String type);

    public List<String> selectById2(String bid);
   /* public Integer selectNewCount(String type);*/
   public List<ForumLunTan> select1(@Param("id")String [] id);
    public List<User> selectUser();

    //查询客户
    public Customer selectCustomer(String cname);
    public Customer selectMaxCustomer();
}
