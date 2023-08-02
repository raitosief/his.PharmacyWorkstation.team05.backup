package com.neuedu.his.service.outpatientDoctorWorkStationService;



import java.util.List;

import com.neuedu.his.entity.CheckApply;

//个人工作量统计
public interface PersonalWorkloadStatisticsService {
    public List<CheckApply> selectByID(CheckApply c);
}
