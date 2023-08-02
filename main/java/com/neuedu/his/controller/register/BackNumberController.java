package com.neuedu.his.controller.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.neuedu.his.entity.Invoice;
import com.neuedu.his.service.register.BackNumberService;
import com.neuedu.his.service.register.RegisterService;
import com.neuedu.util.EnumCode;
import com.neuedu.util.ResultUtil;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/backnumber")
public class BackNumberController {
    @Autowired
    private BackNumberService service;

    @Autowired
    private RegisterService service1;
    @RequestMapping("/selectAllInvoice")
//    http://localhost:8892/backnumber/selectAllInvoice
    public ResultUtil selectAllInvoice(Invoice invoice) {
        return new ResultUtil(EnumCode.OK.getValue(), "发票查找成功",service.selectAllInvoice(invoice));
    }
    @RequestMapping("/addInvoice")
    public int addInvoice(Invoice invoice) {
        return service.addInvoice(invoice);
    }
    @RequestMapping("/updateInvoice")
    public ResultUtil updateInvoice(@RequestBody Invoice invoice) {
        System.out.println(invoice);
        System.out.println(invoice.getID());
        System.out.println("更新执行了");
        return new ResultUtil(EnumCode.OK.getValue(), "修改成功",service.updateInvoice(invoice));
    }
    @RequestMapping("/deleteInvoice")
    public int deleteInvoice(Invoice invoice) {
        return service.deleteInvoice(invoice);
    }

    @RequestMapping("/backNumber")
    public ResultUtil backNumber(@RequestBody Invoice invoice) throws ParseException {
        if(invoice.getState()==7) {
            return new ResultUtil(EnumCode.GONE.getValue(), "该发票已经退号",invoice);
        }
        service.updateInvoice(invoice);
        new Invoice();
        Invoice invoice1;
        invoice1 = service1.selectMaxInvoice();
        int invoicenum1 = Integer.parseInt(invoice1.getInvoiceNum());
        int invoicenum2 = invoicenum1 + 1;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date nowDate = df.parse(df.format(new Date()));
        invoice.setCreationTime(nowDate);
        invoice.setInvoiceNum(Integer.toString(invoicenum2));
        invoice.setBack(invoice.getInvoiceNum());
        BigDecimal bignum1 = new BigDecimal("-1");
        invoice.setMoney(invoice.getMoney().multiply(bignum1));
        invoice.setState(7);
        System.out.println("添加冲红发票"+service.addInvoice(invoice));
        return new ResultUtil(EnumCode.OK.getValue(), "退号成功",invoice);
    }
}
