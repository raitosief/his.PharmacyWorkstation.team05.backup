package com.neuedu.his.mapper.OutpatientFiancial;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.his.entity.WorkloadStatistics;




@Mapper
public interface OutpatientdepartmentworkloadstatisticsMapper {
public List<WorkloadStatistics> selectWorkLoadStatistics(WorkloadStatistics w);
}
