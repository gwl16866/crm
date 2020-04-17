package com.hy.crmsystem.mapper.systemManager;

import com.hy.crmsystem.entity.systemManager.Dept;
import com.hy.crmsystem.entity.systemManager.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DeptMapper {


    @Select("select * from dept")
    public List<Dept> selectdept();

}
