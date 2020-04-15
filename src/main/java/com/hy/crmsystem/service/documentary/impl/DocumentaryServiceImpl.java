package com.hy.crmsystem.service.documentary.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crmsystem.entity.customerManager.Kehuiganlizonghe;
import com.hy.crmsystem.entity.documentary.Documentary;
import com.hy.crmsystem.mapper.documentary.DocumentaryMapper;
import com.hy.crmsystem.service.documentary.IDocumentaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mr.Gao
 * @since 2020-04-02
 */
@Service
@Transactional
public class DocumentaryServiceImpl extends ServiceImpl<DocumentaryMapper, Documentary> implements IDocumentaryService {
    @Autowired
     private DocumentaryMapper documentaryMapper;
    @Override
    public IPage<Documentary> pages(@Param("page") Integer page, @Param("limit")Integer limit, @Param("documentary")Documentary documentary, @Param("session")HttpSession session) {
        Page<Documentary> accountsPage = new Page<>(page, limit);
        return documentaryMapper.queryAll(accountsPage,documentary);
    }

    @Override
    public List<Documentary> listQueryAll(@Param("documentary")Documentary documentary) {
        return documentaryMapper.listQueryAll(documentary);
    }

}
