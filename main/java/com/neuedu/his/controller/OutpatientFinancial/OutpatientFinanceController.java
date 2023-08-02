package com.neuedu.his.controller.OutpatientFinancial;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.his.entity.Invoice;
import com.neuedu.his.entity.OutpatientFinance;
import com.neuedu.his.entity.User;
import com.neuedu.his.service.OutpatientFinancial.OutpatientFinanceService;
@RestController
@RequestMapping("/outpatientfinance")
public class OutpatientFinanceController {//门诊日结模块
	
	@Autowired
	private OutpatientFinanceService service;
	
//	http:localhost:8080/outpatientfinance/selectAll?UserName=root
	@RequestMapping("selectAll")
	public List<Invoice> selectAll(OutpatientFinance o){

		return service.selectAll(o);
	}
	
	@RequestMapping("/pass")
	public int pass(Invoice i){
		return service.pass(i);
	}
	
	@RequestMapping("/reiterate")
	public int reiterate(Invoice i){
		return service.reiterate(i);
	}

}
