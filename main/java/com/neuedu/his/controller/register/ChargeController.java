package com.neuedu.his.controller.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.his.entity.*;
import com.neuedu.his.service.register.ChargeService;
import com.neuedu.his.service.register.RegisterService;
import com.neuedu.util.EnumCode;
import com.neuedu.util.ResultUtil;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/charge")
public class ChargeController {
    @Autowired
    private ChargeService service;
    @Autowired
    private RegisterService registerService;
    //获取患者所有非药品费用
    @RequestMapping("/allItem")
    // http://localhost:8899/charge/allItem?ID=35
    public ResultUtil selectAllFmeditem(Register register) {
        List<CheckApply> checkApply = service.selectByIDCheckAppy(register.getID());
        ArrayList<Fmeditem> fmeditems = new ArrayList<Fmeditem>();
        System.out.println(checkApply);
        ArrayList<Integer> itemID = new ArrayList<Integer>();
        for(CheckApply itme1 : checkApply){
            Integer temp= itme1.getItemID();
            //所有未收费项目小于2
            if (itme1.getState() <= 2) {
                itemID.add(temp);
            }
        }
        for (Integer itme : itemID){
            fmeditems.add(service.selectByID(itme));
        }
        System.out.println("非药品"+fmeditems);
        return new ResultUtil(EnumCode.OK.getValue(), "ok",fmeditems);
    }
    //获取患者所有药物费用
    @RequestMapping("/allDrugs")
    // http://localhost:8899/charge/allDrugs?ID=35
    public ResultUtil selectAllDrugs(Register register) {
        List<Prescription> prescriptions = service.selectByIDPrescription(register.getID());
        ArrayList<PrescriptionDetailed> prescriptionDetaileds = new ArrayList<PrescriptionDetailed>();
        ArrayList<Drugs> drugs = new ArrayList<Drugs>();
        for (Prescription item : prescriptions) {
            List<PrescriptionDetailed> temp = service.selectByDetailed(item.getID());
            prescriptionDetaileds.addAll(temp);//Prescription 和PrescriptionDetailed联合
        }
        for (PrescriptionDetailed item1 : prescriptionDetaileds) {
            if (item1.getState() == 2) {
                drugs.add(service.selectByDrugID(item1.getDrugsID()));
            }
        }
        System.out.println(drugs);
        return new ResultUtil(EnumCode.OK.getValue(), "ok",drugs);
    }
 
    
    
    @RequestMapping("/allCharge")
    // http://localhost:8899/charge/allCharge?ID=35
    public ResultUtil allCharge(Register register) throws ParseException {
    
        Invoice invoice = new Invoice();
        System.out.println("挂号ID"+register.getID());
        
        ResultUtil resultUtil1 = selectAllFmeditem(register);
        ResultUtil resultUti2 = selectAllDrugs(register);
      
        ArrayList<Drugs> drugs = (ArrayList<Drugs>) resultUti2.getData();
        ArrayList<Fmeditem> fmeditems = (ArrayList<Fmeditem>) resultUtil1.getData();
      ArrayList<CheckApply>checkapplys= (ArrayList<CheckApply>) resultUtil1.getData();
//        ArrayList<PrescriptionDetailed> prescriptionDetailed = (ArrayList<PrescriptionDetailed>) resultUti2.getData();
        System.out.println("fmeditems"+fmeditems);
        System.out.println("drugs"+drugs);
        BigDecimal sumMoney = new BigDecimal("0");

        
        List<Prescription> prescriptions = service.selectByIDPrescription(register.getID());
        ArrayList<PrescriptionDetailed> prescriptionDetaileds = new ArrayList<PrescriptionDetailed>();
        ArrayList<Drugs> drugs1 = new ArrayList<Drugs>();
        for (Prescription item : prescriptions) {
            List<PrescriptionDetailed> temp = service.selectByDetailed(item.getID());
            prescriptionDetaileds.addAll(temp);//Prescription 和PrescriptionDetailed联合
        }
        for (PrescriptionDetailed item1 : prescriptionDetaileds) {
            System.out.println("prescriptionDetailed ID="+item1.getID());//输出验证下获取到的prescriptionDetailed表中的ID
            service.updatePrescriptionDetailed(item1.getID());// 根据prescriptionDetailed中ID来更新prescriptionDetailedID表
         
        }
        
        for (Drugs item : drugs) {
            sumMoney = sumMoney.add(item.getDrugsPrice());
                  
            Invoice invoice8 = registerService.selectMaxInvoice();
            int invoicenum8 = Integer.parseInt(invoice8.getInvoiceNum());
            int invoicenum9 = invoicenum8 + 1;
            PatientCosts patientCosts = new PatientCosts();
            patientCosts.setInvoiceID(invoicenum9);
            patientCosts.setRegistID(register.getID());
            BigDecimal bigDecimal8 = new BigDecimal("1");
            patientCosts.setAmount(bigDecimal8);
            patientCosts.setCreateOperID(10);
            SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            Date nowDate1 = df1.parse(df1.format(new Date()));
            patientCosts.setCreatetime(nowDate1);
            patientCosts.setFeeType(51);
            patientCosts.setPayTime(nowDate1);
            patientCosts.setRegisterID(10);
            patientCosts.setDeptID(1);
            patientCosts.setPrice(item.getDrugsPrice());
            patientCosts.setItemType(2);
            patientCosts.setItemID(item.getId());
            patientCosts.setName(item.getDrugsName());
            System.out.println("明细表："+patientCosts);
            registerService.addPatientCosts(patientCosts);
        }
         
    
     
        for (Fmeditem item1 : fmeditems) {
            sumMoney = sumMoney.add(item1.getPrice());//加上非药品部分金额
        }
        
        
        List<CheckApply> checkApply = service.selectByIDCheckAppy(register.getID());
       
        for(CheckApply itme1 : checkApply){
            Integer temp= itme1.getID();
            service.updateCheckApply(temp);//更新updateCheckApply表
            System.out.println("CeckApply id:"+temp);
        }
      
        System.out.println("总消费："+sumMoney);
        Invoice invoice1 = registerService.selectMaxInvoice();
        int invoicenum1 = Integer.parseInt(invoice1.getInvoiceNum());
        int invoicenum2 = invoicenum1 + 1;
        invoice.setInvoiceNum(Integer.toString(invoicenum2));
        invoice.setMoney(sumMoney);
        invoice.setState(1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date nowDate = df.parse(df.format(new Date()));
        invoice.setCreationTime(nowDate);
        invoice.setFeeType(51);
        invoice.setDailyState(0);
        invoice.setUserID(9);
        registerService.addInvoice(invoice);
        return new ResultUtil(EnumCode.OK.getValue(), "收费成功",invoice);
    }
}
