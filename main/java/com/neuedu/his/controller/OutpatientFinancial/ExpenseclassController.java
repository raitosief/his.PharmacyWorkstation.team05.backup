package com.neuedu.his.controller.OutpatientFinancial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.his.entity.Expenseclass;
import com.neuedu.his.service.OutpatientFinancial.ExpenseclassService;


@RestController
@RequestMapping("/expenseclass")
public class ExpenseclassController {    //   这里是费用科目管理控制层，在这里对费用科目进行增删改查功能
	@Autowired
	
	private ExpenseclassService service;
	
	@RequestMapping("/selectAll")
	// http://localhost:8080/expenseclass/selectAll?ExpName=挂号费
	public List<Expenseclass> selectAll(Expenseclass e){
		
		return service.selectAll(e);
		
	}

	@RequestMapping("/add")
	// http://localhost:8080/expenseclass/add?uname=tom8&pass=888&relname=张三8
	public int add(Expenseclass e){
		
		return service.add(e);
	}
	@RequestMapping("/update")
//	http://localhost:8080/expenseclass/update?uname=tom82&pass=8882&realname=张三82&id=17
	public int update(Expenseclass e){
		
		return service.update(e);
	}

	@RequestMapping("/delete")
//	http://localhost:8080/expenseclass/delete?id=17
	public int delete(Expenseclass e){
		System.out.println("--e="+e);
		return service.delete(e);
	}
	

}
