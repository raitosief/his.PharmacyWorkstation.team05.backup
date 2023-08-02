package com.neuedu.his.controller.outpatientDoctorWorkStationController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.his.entity.DiagnosisTemplate;
import com.neuedu.his.entity.MedicalRecord;
import com.neuedu.his.entity.Register;
import com.neuedu.his.service.outpatientDoctorWorkStationService.OutpatientDiagnosisServer;
import com.neuedu.util.EnumCode;
import com.neuedu.util.ResultUtil;

import java.util.ArrayList;
import java.util.List;

/* 门诊确诊控制类*/
@RestController
public class OutpatientDiagnosisController {
    @Autowired
    private OutpatientDiagnosisServer service;

    /*搜索患者*/
    @RequestMapping("/outpatientDoctorWorkStation/outpatientDiagnosis/select")
    public ResultUtil select(Register user) {
        System.out.println("搜索的姓名：" + user);
        List<Register> result = new ArrayList<>();
        Integer code = EnumCode.OK.getValue();
        String msg = "搜索成功";
        result = service.select(user);
        System.out.println("搜索的结果：" + result);
        return new ResultUtil(code, msg, result);
    }
    
    /*初始化患者的门诊病历首页*/
    @RequestMapping("/outpatientDoctorWorkStation/outpatientDiagnosis/initRecord")
    public ResultUtil initRecord(MedicalRecord user) {
        MedicalRecord result = new MedicalRecord();
        Integer code = EnumCode.OK.getValue();
        String msg = "已加载门诊病历首页";
        try {
            result = service.getRecord(user);
        } catch (Exception e) {
            code = EnumCode.EXCPTION_ERROR.getValue();
            msg = "加载门诊病历首页失败";
        }
        return new ResultUtil(code, msg, result);
    }

    /*生成诊断模板*/
    @PostMapping("/outpatientDoctorWorkStation/outpatientDiagnosis/getDiagnosisTemplate")
    public ResultUtil getRecordTemplate() {
        List<DiagnosisTemplate> result = new ArrayList<>();
        Integer code = EnumCode.OK.getValue();
        String msg = "生成个人诊断模板成功";
        try {
            result = service.getDiagnosisTemplate("1");
        } catch (Exception e) {
            code = EnumCode.EXCPTION_ERROR.getValue();
            msg = "生成个人诊断模板失败";
        }
        return new ResultUtil(code, msg, result);
    }

    /* 删除诊断模板 */
    @RequestMapping("/outpatientDoctorWorkStation/outpatientDiagnosis/deleteDiagnosisTemplate")
    public ResultUtil deleteRecordTemplate(Integer id) {
    	System.out.println(id);
        Integer code = EnumCode.OK.getValue();
        String msg = "删除成功";
        try {
            service.deleteDiagnosisTemplate(id);
        } catch (Exception e) {
            code = EnumCode.EXCPTION_ERROR.getValue();
            msg = "删除失败";
        }

        return new ResultUtil(code, msg);
    }

    /* 添加诊断模板*/
    @RequestMapping("/outpatientDoctorWorkStation/outpatientDiagnosis/commitTemplate")
    public ResultUtil commitTemplate(DiagnosisTemplate diagnosisTemplate) {
        System.out.println("即将添加的模板：" + diagnosisTemplate);
        Integer code = EnumCode.OK.getValue();
        String msg = "添加成功";
        try {
            service.commitTemplate(diagnosisTemplate);
        } catch (Exception e) {
            code = EnumCode.EXCPTION_ERROR.getValue();
            msg = "添加失败";
        }

        return new ResultUtil(code, msg);
    }

    /* 确诊患者并更新病历信息  */
    @RequestMapping("/outpatientDoctorWorkStation/outpatientDiagnosis/confirm")
    public ResultUtil confirm(MedicalRecord medicalRecord) {
        System.out.println("即将更新的病历信息：" + medicalRecord);
        Integer code = EnumCode.OK.getValue();
        String msg = "更新成功";
        try {
            service.confirm(medicalRecord);
        } catch (Exception e) {
            code = EnumCode.EXCPTION_ERROR.getValue();
            msg = "更新失败";
        }

        return new ResultUtil(code, msg);
    }


}
