package com.hy.crmsystem.service.documentary.impl;

import com.hy.crmsystem.entity.documentary.Documentary;
import com.hy.crmsystem.mapper.documentary.DocumentaryMapper;
import com.hy.crmsystem.service.documentary.IDocumentaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
