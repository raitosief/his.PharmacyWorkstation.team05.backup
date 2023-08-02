package com.neuedu.his.mapper.outpatientDoctorWorkStationMapper;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.his.entity.CheckApply;

import java.math.BigDecimal;
import java.util.List;

@Mapper
//个人工作量统计
public interface PersonalWorkloadStatisticsMapper {
    public List<CheckApply> selectAll(CheckApply u);
    public BigDecimal selectTotalCost(Integer registerID);
    public String selectName(Integer registerID);
    public List<CheckApply> selectByID(CheckApply c);
}
