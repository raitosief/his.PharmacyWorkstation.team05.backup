package com.neuedu.his.mapper.register;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.his.entity.PatientCosts;

import java.util.List;


@Mapper
public interface RegisteredTollCollectorMapper {

    public List<PatientCosts> selectAll(PatientCosts u);
}
