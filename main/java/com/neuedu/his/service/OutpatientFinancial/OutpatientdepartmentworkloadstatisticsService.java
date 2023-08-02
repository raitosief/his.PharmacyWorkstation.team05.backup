package com.neuedu.his.service.OutpatientFinancial;

import java.util.List;

import org.springframework.stereotype.Service;

import com.neuedu.his.entity.WorkloadStatistics;

@Service
public interface OutpatientdepartmentworkloadstatisticsService{
	public List<WorkloadStatistics> selectWorkloadStatistics(WorkloadStatistics w);
}