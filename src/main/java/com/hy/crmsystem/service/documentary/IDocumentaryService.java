package com.hy.crmsystem.service.documentary;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crmsystem.entity.bussinessOppo.Businessoppo;
import com.hy.crmsystem.entity.documentary.Documentary;
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
public interface IDocumentaryService extends IService<Documentary> {

    IPage<Documentary> pages(@Param("page") Integer page, @Param("limit") Integer limit, @Param("documentary") Documentary documentary, @Param("session") HttpSession session);

    public List<Documentary> listQueryAll(@Param("documentary") Documentary documentary);
    public List<Businessoppo> selectBname();
    public List<Documentary> selectTheme(String theme);
    public List<Documentary> selectDocByBus(Integer bid);
    public void updateBusTime(Integer bid);
}
