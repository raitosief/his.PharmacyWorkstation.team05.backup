package com.neuedu.his.controller.outpatientDoctorWorkStationController;

import com.neuedu.his.entity.*;
import com.neuedu.his.service.outpatientDoctorWorkStationService.PatentPrescriptionService;
import com.neuedu.util.EnumCode;
import com.neuedu.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*成药处方控制类*/
@RestController
public class PatentPrescriptionController {

    @Autowired
    private PatentPrescriptionService service;

    /*搜索患者*/
    @RequestMapping("/outpatientDoctorWorkStation/patentPrescription/select")
    public ResultUtil select(Register user) {
        System.out.println("搜索的姓名：" + user);
        List<Register> result = new ArrayList<>();
        Integer code = EnumCode.OK.getValue();
        String msg = "搜索成功";
        result = service.select(user);
        System.out.println("搜索的结果：" + result);
        return new ResultUtil(code, msg, result);
    }
    
    /*显示组套*/
    @RequestMapping("/outpatientDoctorWorkStation/patentPrescription/showtemp")
    public ResultUtil showTemp() {
        List<DrugsTemplate> result = new ArrayList<>();
        Integer code = EnumCode.OK.getValue();
        String msg = "搜索成功";
        result = service.showTemp();
        System.out.println("搜索的结果：" + result);
        return new ResultUtil(code, msg, result);
    }
    
    /*删除组套*/
    @RequestMapping("/outpatientDoctorWorkStation/patentPrescription/deletetemp")
    public ResultUtil deleteTemp(Integer ID) {
      	Integer bool = service.deleteTemp(ID);
        Integer code = EnumCode.OK.getValue();
        String msg;
        if(bool == 0) {
        	msg = "删除失败";
        }else {
        	msg = "删除成功";
        }
        return new ResultUtil(code, msg,bool);
    }
    
    /*使用组套*/
    @RequestMapping("/outpatientDoctorWorkStation/patentPrescription/usetemp")
    public ResultUtil useTemp(Integer ID) {
      	List<DrugsDetailed> result = service.useTemp(ID);
        Integer code = EnumCode.OK.getValue();
        String msg = "使用成功";
        return new ResultUtil(code, msg,result);
    }
    
    
    /*搜索患者处方*/
    @RequestMapping("/outpatientDoctorWorkStation/patentPrescription/getprescription")
    public ResultUtil getPrescription(Register user) {
    	System.out.println("xixi");
        System.out.println("搜索的姓名：" + user);
        List<Prescription> result = new ArrayList<>();
        Integer code = EnumCode.OK.getValue();
        String msg = "搜索成功";
        result = service.getPrescription(user);
        System.out.println("搜索的结果：" + result);
        return new ResultUtil(code, msg, result);
    }
    
    /*增方*/
    @RequestMapping("/outpatientDoctorWorkStation/patentPrescription/addprescription")
    public ResultUtil addPrescription(Prescription newPrescription) {
        System.out.println("搜索的姓名：" + newPrescription);
        Integer code = EnumCode.OK.getValue();
        service.addPrescription(newPrescription);
        String msg = "增方成功";
        return new ResultUtil(code, msg);
    }
    
    /*编辑处方*/
    @RequestMapping("/outpatientDoctorWorkStation/patentPrescription/editprescription")
    public ResultUtil editPrescription(Integer preID) {
        System.out.println("搜索的姓名：" + preID);
        Integer code = EnumCode.OK.getValue();
        List<PrescriptionDetailed> result = service.editPrescription(preID);
        String msg = "编辑成功";
        return new ResultUtil(code, msg,result);
    }
    
    /*暂存处方*/
    @RequestMapping("/outpatientDoctorWorkStation/patentPrescription/staging")
    public ResultUtil staging(Integer preID) {
        Integer code = EnumCode.OK.getValue();
        System.out.println(preID);
        Integer bool = service.staging(preID);
        String msg;
        if(bool == 0) {
        	msg = "暂存失败";
        }else {
        	msg = "暂存成功";
        }
        return new ResultUtil(code, msg,bool);
    }
    
    /*开立处方*/
    @RequestMapping("/outpatientDoctorWorkStation/patentPrescription/open")
    public ResultUtil open(Integer preID) {
        Integer code = EnumCode.OK.getValue();
        System.out.println(preID);
        Integer bool = service.open(preID);
        String msg;
        if(bool == 0) {
        	msg = "暂存失败";
        }else {
        	msg = "暂存成功";
        }
        return new ResultUtil(code, msg,bool);
    }
    
    /*作废处方*/
    @RequestMapping("/outpatientDoctorWorkStation/patentPrescription/repeal")
    public ResultUtil repeal(Integer preID) {
        Integer code = EnumCode.OK.getValue();
        System.out.println(preID);
        Integer bool = service.repeal(preID);
        String msg;
        if(bool == 0) {
        	msg = "暂存失败";
        }else {
        	msg = "暂存成功";
        }
        return new ResultUtil(code, msg,bool);
    }
    
    /*删除处方*/
    @RequestMapping("/outpatientDoctorWorkStation/patentPrescription/dodelete")
    public ResultUtil dodelete(Integer preID) {
        Integer code = EnumCode.OK.getValue();
        System.out.println(preID);
        Integer bool = service.dodelete(preID);
        String msg;
        if(bool == 0) {
        	msg = "暂存失败";
        }else {
        	msg = "暂存成功";
        }
        return new ResultUtil(code, msg,bool);
    }
    
    /*增药*/
    @RequestMapping("/outpatientDoctorWorkStation/patentPrescription/adddrugs")
    public ResultUtil addDrugs(PrescriptionDetailed prescriptionDetailed) {
        Integer code = EnumCode.OK.getValue();
        System.out.println(prescriptionDetailed);
        Integer bool = service.addDrugs(prescriptionDetailed);
        String msg;
        if(bool == 0) {
        	msg = "增药失败";
        }else {
        	msg = "增药成功";
        }
        return new ResultUtil(code, msg,bool);
    }
    
    /*删药*/
    @RequestMapping("/outpatientDoctorWorkStation/patentPrescription/deletedrug")
    public ResultUtil deleteDrug(Integer ID) {
        Integer code = EnumCode.OK.getValue();
        service.deleteDrug(ID);
        String msg = "删除成功";
        return new ResultUtil(code, msg);
    }
    
    /*保存*/
    @RequestMapping("/outpatientDoctorWorkStation/patentPrescription/savedrug")
    public ResultUtil saveDrug(PrescriptionDetailed prescriptionDetailed) {
    	System.out.println(prescriptionDetailed);
        Integer code = EnumCode.OK.getValue();
        service.saveDrug(prescriptionDetailed);
        String msg = "删除成功";
        return new ResultUtil(code, msg);
    }
    
    
    /*存为组套*/
    @RequestMapping("/outpatientDoctorWorkStation/patentPrescription/saveastemp")
    public ResultUtil saveAsTemp(DrugsTemplate drugsTemplate) {
      	Integer bool = service.saveAsTemp(drugsTemplate);
        Integer code = EnumCode.OK.getValue();
        String msg;
        if(bool == 0) {
        	msg = "存为组套失败";
        }
        else {
        	msg = "存为组套成功";
        }
        return new ResultUtil(code, msg,bool);
    }
}
