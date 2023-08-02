package com.neuedu.his.service.OutpatientFinancial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.his.entity.WorkloadStatistics;
import com.neuedu.his.mapper.OutpatientFiancial.OutpatientdepartmentworkloadstatisticsMapper;

@Service
public class OutpatientdepartmentworkloadstatisticsServiceImpl implements OutpatientdepartmentworkloadstatisticsService{
	@Autowired
	private OutpatientdepartmentworkloadstatisticsMapper dao;

	public List<WorkloadStatistics> selectWorkloadStatistics(WorkloadStatistics w) {
		
		return dao.selectWorkLoadStatistics(w);
	}
	
	
	
}
