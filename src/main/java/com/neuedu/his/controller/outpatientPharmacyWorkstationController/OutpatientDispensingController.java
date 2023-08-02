package com.neuedu.his.controller.outpatientPharmacyWorkstationController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.his.entity.Prescription;
import com.neuedu.his.service.outpatientPharmacyWorkstationService.OutpatientDispensingService;
import com.neuedu.util.EnumCode;
import com.neuedu.util.ResultUtil;

@RestController
@RequestMapping("/outpatientPharmacyWorkstation/outpatientDispensing")
public class OutpatientDispensingController{
	@Autowired
	private OutpatientDispensingService service;

	@RequestMapping("/selectAll")
	public ResultUtil selectAll(Prescription u){
		System.out.println(u);
		List<Prescription> list = service.selectAll(u);
		System.out.println(list);
		if(list != null){
			System.out.println("doselectAllOK");
			return  new ResultUtil(EnumCode.OK.getValue(),"查询成功",list);
		}
		return new ResultUtil(EnumCode.UNAUTHORIZED.getValue(), "查询失败");
	}



	@RequestMapping("/update")
	public ResultUtil update(@RequestParam String id) {
		System.out.println("---u="+id);
		int res = service.update(id);
		if(res > 0){
			System.out.println("执行了修改语句");
			return  new ResultUtil(EnumCode.OK.getValue(),"取药成功");
		}
		return new ResultUtil(EnumCode.UNAUTHORIZED.getValue(), "取药失败");
	}



}

