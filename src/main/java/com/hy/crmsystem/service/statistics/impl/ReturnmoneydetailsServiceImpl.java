package com.hy.crmsystem.service.statistics.impl;

import com.hy.crmsystem.entity.statistics.Returnmoneydetails;
import com.hy.crmsystem.mapper.statistics.ReturnmoneydetailsMapper;
import com.hy.crmsystem.service.statistics.IReturnmoneydetailsService;
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
public class ReturnmoneydetailsServiceImpl extends ServiceImpl<ReturnmoneydetailsMapper, Returnmoneydetails> implements IReturnmoneydetailsService {

}
