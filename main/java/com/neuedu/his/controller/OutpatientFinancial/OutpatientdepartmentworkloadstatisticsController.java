package com.neuedu.his.controller.OutpatientFinancial;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.his.entity.WorkloadStatistics;
import com.neuedu.his.service.OutpatientFinancial.OutpatientdepartmentworkloadstatisticsService;

@RestController
@RequestMapping("/outpatientworkload")
public class OutpatientdepartmentworkloadstatisticsController {
	
	@Autowired
	private OutpatientdepartmentworkloadstatisticsService service;
	
	@RequestMapping("/selectWorkloadStatistics")
	public List<WorkloadStatistics> selectWorkloadStatistics(WorkloadStatistics w){
		System.out.println("--w="+w);
		List<WorkloadStatistics> result = service.selectWorkloadStatistics(w);
		System.out.println("result: "+ result);
		return service.selectWorkloadStatistics(w);
	}
}

