package com.hy.crmsystem.service.bussinessOppo.impl;

import com.hy.crmsystem.entity.bussinessOppo.Businessoppo;
import com.hy.crmsystem.mapper.bussinessOppo.BusinessoppoMapper;
import com.hy.crmsystem.service.bussinessOppo.IBusinessoppoService;
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
public class BusinessoppoServiceImpl extends ServiceImpl<BusinessoppoMapper, Businessoppo> implements IBusinessoppoService {

}
