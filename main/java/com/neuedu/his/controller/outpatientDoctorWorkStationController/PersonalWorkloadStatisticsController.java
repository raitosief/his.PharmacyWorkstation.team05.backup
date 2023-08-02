package com.neuedu.his.controller.outpatientDoctorWorkStationController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.his.entity.CheckApply;
import com.neuedu.his.service.outpatientDoctorWorkStationService.PersonalWorkloadStatisticsService;
import com.neuedu.util.EnumCode;
import com.neuedu.util.ResultUtil;
import java.util.List;

@RestController
@RequestMapping("/outpatientDoctorWorkStation/personalWorkloadStatistics")
//个人工作量统计
public class PersonalWorkloadStatisticsController {
    @Autowired
    private PersonalWorkloadStatisticsService service;

    /*进行个人工作量查询*/
    @RequestMapping("/selectByID")
    public ResultUtil selectByID(CheckApply c){
        List<CheckApply> res = service.selectByID(c);
        if(res != null){
            System.out.println("执行了查询语句");
            return  new ResultUtil(EnumCode.OK.getValue(),"刷新成功",res);
        }
        return new ResultUtil(EnumCode.UNAUTHORIZED.getValue(), "查询失败");
    }
}
