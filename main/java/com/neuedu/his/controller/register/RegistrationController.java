package com.neuedu.his.controller.register;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.neuedu.his.entity.Invoice;
import com.neuedu.his.entity.Register;
import com.neuedu.his.service.register.RegisterService;
import com.neuedu.util.EnumCode;
import com.neuedu.util.ResultUtil;

@RestController
@RequestMapping("/register_clerk")
public class RegistrationController {
	@Autowired
	private RegisterService service;

	@RequestMapping("/register")
	// http://localhost:8892/register_clerk/register?CaseNumber='1'&RealName='1'&Gender=1&IDnumber='1'&BirthDate="2021-12-12"&Age=1&AgeType='1'&HomeAddress='1'&VisitDate='1'&Noon='1'&DeptID=1&UserID=1&RegistLeID=1&SettleID=1&IsBook='1'&RegistTime=1&RegisterID='2021-12-12'&VisitState=1
	public ResultUtil add(Register r) {
		System.out.println("添加信息："+r.getRegistLeID());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return new ResultUtil(EnumCode.OK.getValue(),"挂号成功",service.add(r));
	}
	@RequestMapping("/selectAll")
	// http://localhost:8892/register_clerk/selectAll?CaseNumber=60
	public ResultUtil selectAll(Register r) {
		System.out.println("查询执行了");
		return new ResultUtil(EnumCode.OK.getValue(), "查询成功",service.selectAll(r));
	}

	@RequestMapping("/print")
	public ResultUtil print(@RequestBody Register r) throws ParseException {
		System.out.println("打印执行了");
		System.out.println(r.getID());
		Invoice invoice1 = new Invoice();
		Invoice invoice2 = new Invoice();
		invoice1 = service.selectMaxInvoice();
		int invoicenum1 = Integer.parseInt(invoice1.getInvoiceNum());
		int invoicenum2 = invoicenum1 + 1;
		invoice2.setInvoiceNum(Integer.toString(invoicenum2));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Date nowDate = df.parse(df.format(new Date()));
		invoice2.setCreationTime(nowDate);
		invoice2.setState(4);
		invoice2.setDailyState(0);
		invoice2.setFeeType(51);
		invoice2.setRegistID(r.getID());
		BigDecimal sumMoney = new BigDecimal("0");
		BigDecimal bignum1 = new BigDecimal("50");
		BigDecimal bignum2 = new BigDecimal("8");
		BigDecimal bignum3 = new BigDecimal("1");
		if(r.getIsBook().charAt(0) =='1'){
			sumMoney = sumMoney.add(bignum3);
		}
		if(r.getRegistLeID() == 1){
			sumMoney = sumMoney.add(bignum1);
		}else if (r.getRegistLeID() == 2) {
			sumMoney = sumMoney.add(bignum2);
		}
		invoice2.setMoney(sumMoney);
		invoice2.setUserID(9);
		System.out.println("添加发票："+service.addInvoice(invoice2));
		return new ResultUtil(EnumCode.OK.getValue(), "打印成功",service.print(r));
	}

	@RequestMapping("selectInvoice")
	public ResultUtil selectInvoice(Invoice invoice) {
		System.out.println("查询发票执行了");
		return new ResultUtil(EnumCode.OK.getValue(), "查询发票成功",service.selectInvoice(invoice));
	}

	@RequestMapping("selectMaxInvoice")
	// http://localhost:8899/register_clerk/selectMaxInvoice
	public Invoice selectMaxInvoce() throws ParseException {
		Invoice invoice1 = new Invoice();
		invoice1 = service.selectMaxInvoice();
		Invoice invoice2 = new Invoice();
		invoice1 = service.selectMaxInvoice();
		int invoicenum1 = Integer.parseInt(invoice1.getInvoiceNum());
		int invoicenum2 = invoicenum1 + 1;
		invoice2.setInvoiceNum(Integer.toString(invoicenum2));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Date nowDate = df.parse(df.format(new Date()));
		invoice2.setCreationTime(nowDate);
		return invoice1;
	}
}
