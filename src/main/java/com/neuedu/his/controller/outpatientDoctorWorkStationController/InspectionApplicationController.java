package com.neuedu.his.controller.outpatientDoctorWorkStationController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.his.entity.CheckApply;
import com.neuedu.his.entity.MedicalRecord;
import com.neuedu.his.entity.Register;
import com.neuedu.his.service.outpatientDoctorWorkStationService.InspectionApplicationService;
import com.neuedu.util.EnumCode;
import com.neuedu.util.ResultUtil;

import java.util.ArrayList;
import java.util.List;

/*检查申请控制类*/
@RestController
public class InspectionApplicationController {

    @Autowired
    private InspectionApplicationService service;

    /*搜索患者*/
    @RequestMapping("/outpatientDoctorWorkStation/inspectionApplication/select")
    public ResultUtil select(Register user) {
        System.out.println("搜索的姓名：" + user);
        List<Register> result = new ArrayList<>();
        Integer code = EnumCode.OK.getValue();
        String msg = "搜索成功";
        result = service.select(user);
        System.out.println("搜索的结果：" + result);
        return new ResultUtil(code, msg, result);
    }
    
    /*搜索患者检查项目*/
    @RequestMapping("/outpatientDoctorWorkStation/inspectionApplication/getCheck")
    public ResultUtil getCheck(Integer ID) {
    	System.out.println("ID1:" + ID);
        List<CheckApply> result = new ArrayList<>();
        Integer code = EnumCode.OK.getValue();
        String msg = "搜索成功";
        result = service.getCheck(ID);
        System.out.println("搜索的结果：" + result);
        return new ResultUtil(code, msg, result);
    }

    /*搜索患者检查项目*/
    @RequestMapping("/outpatientDoctorWorkStation/inspectionApplication/addCheck")
    public ResultUtil addCheck(CheckApply newcheck) {
    	System.out.println("newcheck:" + newcheck);
        Integer code = EnumCode.OK.getValue();
        int bool = service.addCheck(newcheck);
        String msg;
        if(bool == 0) {
        	msg = "插入失败";
        }else {
        	msg = "插入成功";
        }
        return new ResultUtil(code, msg, bool);
    }
    
    /*暂存患者检查项目*/
    @RequestMapping("/outpatientDoctorWorkStation/inspectionApplication/staging")
    public ResultUtil staging(CheckApply check) {
    	System.out.println("check:" + check);
        Integer code = EnumCode.OK.getValue();
        Integer bool = service.staging(check);
        String msg;
        if(bool == 0) {
        	msg = "暂存失败";
        }else {
        	msg = "暂存成功";
        }
        return new ResultUtil(code, msg,bool);
    }
    
    /*开立存患者检查项目*/
    @RequestMapping("/outpatientDoctorWorkStation/inspectionApplication/open")
    public ResultUtil open(CheckApply check) {
    	System.out.println("check:" + check);
        Integer code = EnumCode.OK.getValue();
        Integer bool = service.open(check);
        String msg;
        if(bool == 0) {
        	msg = "开立失败";
        }else {
        	msg = "开立成功";
        }
        return new ResultUtil(code, msg,bool);
    }
    
    /*废除存患者检查项目*/
    @RequestMapping("/outpatientDoctorWorkStation/inspectionApplication/repeal")
    public ResultUtil repeal(CheckApply check) {
    	System.out.println("check:" + check);
        Integer code = EnumCode.OK.getValue();
        Integer bool = service.repeal(check);
        String msg;
        if(bool == 0) {
        	msg = "废除失败";
        }else {
        	msg = "废除成功";
        }
        return new ResultUtil(code, msg,bool);
    }
    
    /*删除存患者检查项目*/
    @RequestMapping("/outpatientDoctorWorkStation/inspectionApplication/dodelete")
    public ResultUtil dodelete(CheckApply check) {
    	System.out.println("check:" + check);
        Integer code = EnumCode.OK.getValue();
        Integer bool = service.dodelete(check);
        String msg;
        if(bool == 0) {
        	msg = "废除失败";
        }else {
        	msg = "废除成功";
        }
        return new ResultUtil(code, msg,bool);
    }
    
    /*查看患者检查项目结果*/
    @RequestMapping("/outpatientDoctorWorkStation/inspectionApplication/getresult")
    public ResultUtil getresult(CheckApply check) {
    	System.out.println("check:" + check);
        Integer code = EnumCode.OK.getValue();
        String result = service.getresult(check);
        String msg;
        if(result == null) {
        	msg = "查看结果失败";
        }else {
        	msg = "查看结果成功";
        }
        return new ResultUtil(code, msg,result);
    }
}
