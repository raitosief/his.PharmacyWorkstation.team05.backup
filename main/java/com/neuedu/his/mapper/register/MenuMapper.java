package com.neuedu.his.mapper.register;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.his.entity.User;
import com.neuedu.his.entity.Menu;

import java.util.List;

@Mapper
public interface MenuMapper {
    public List<Menu> selectAll(User u);
}
