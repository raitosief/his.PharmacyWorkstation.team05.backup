package com.neuedu.his.controller.outpatientDoctorWorkStationController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.his.entity.MedicalRecord;
import com.neuedu.his.entity.Register;
import com.neuedu.his.entity.User;
import com.neuedu.his.service.outpatientDoctorWorkStationService.DiagnosisCompletedService;
import com.neuedu.util.EnumCode;
import com.neuedu.util.ResultUtil;




@RestController
public class DiagnosisCompletedController {
	 @Autowired
	    private DiagnosisCompletedService service;

	    /*搜索患者*/
	    @RequestMapping("/outpatientDoctorWorkStation/DiagnosisCompleted/select")
	    public ResultUtil select2(Register user) {
	        System.out.println("搜索的姓名：" + user);
	        List<Register> result = new ArrayList<>();
	        Integer code = EnumCode.OK.getValue();
	        String msg = "搜索成功";
	        System.out.println("-----------1");
	        result = service.select(user);
	        System.out.println("搜索的结果：" + result);
	        return new ResultUtil(code, msg, result);
	    }


	    /*初始化患者的病历首页 */
	    @RequestMapping("/outpatientDoctorWorkStation/DiagnosisCompleted/initRecord")
	    public ResultUtil initRecord(MedicalRecord user) {
	        MedicalRecord result = new MedicalRecord();
	        Integer code = EnumCode.OK.getValue();
	        String msg = "已加载待诊毕病历首页";
	        try {
	            result = service.getRecord(user);
	        } catch (Exception e) {
	            code = EnumCode.EXCPTION_ERROR.getValue();
	            msg = "加载待诊毕病历首页失败";
	        }
	        return new ResultUtil(code, msg, result);
	    }

	    /*对患者进行诊毕操作(更新挂号表)*/
	    @RequestMapping("/outpatientDoctorWorkStation/DiagnosisCompleted/commitEndPatient")
	    public ResultUtil commitEndPatient(Register register) {
	        Integer code = EnumCode.OK.getValue();
	        String msg = "患者诊毕完成";
	        try {
	            service.commitEndPatient(register);
	        } catch (Exception e) {
	            code = EnumCode.INTERNAL_SERVER_ERROR.getValue();
	            msg = "患者诊毕失败";
	        }

	        return new ResultUtil(code, msg);
	    }

	    /*对患者进行诊毕操作(更新病历首页表)*/
	    @RequestMapping("/outpatientDoctorWorkStation/DiagnosisCompleted/commitEndMedicalRecord")
	    public ResultUtil commitEndMedicalRecord(MedicalRecord medicalRecord) {
	        Integer code = EnumCode.OK.getValue();
	        String msg = "病历诊毕完成";
	        try {
	            service.commitEndMedicalRecord(medicalRecord);
	        } catch (Exception e) {
	            code = EnumCode.EXCPTION_ERROR.getValue();
	            msg = "病历诊毕失败";
	        }

	        return new ResultUtil(code, msg);
	    }
}
