package com.hy.crmsystem.service.contract.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crmsystem.entity.contract.Openpaper;
import com.hy.crmsystem.mapper.contract.OpenpaperMapper;
import com.hy.crmsystem.service.contract.IOpenpaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OpenpaperServiceImpl extends ServiceImpl<OpenpaperMapper, Openpaper> implements IOpenpaperService {
    @Autowired
    OpenpaperMapper openpaperMapper;
}
