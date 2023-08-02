package com.neuedu.his.controller.outpatientPharmacyWorkstationController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.his.entity.Prescription;
import com.neuedu.his.service.outpatientPharmacyWorkstationService.OutpatientWithdrawalService;
import com.neuedu.util.EnumCode;
import com.neuedu.util.ResultUtil;

@RestController
@RequestMapping("/outpatientPharmacyWorkstation/outpatientWithdrawal")
public class OutpatientWithdrawalController {
	@Autowired
	private OutpatientWithdrawalService service;

		@RequestMapping("/selectAll")
		public ResultUtil selectAll(Prescription u){
			System.out.println(u);
			List<Prescription> list = service.selectAll(u);
			if(list != null){
				System.out.println("selectAll");
				return  new ResultUtil(EnumCode.OK.getValue(),"查询成功",list);
			}
			return new ResultUtil(EnumCode.UNAUTHORIZED.getValue(), "查询失败");
		}



		@RequestMapping("/update")
		public ResultUtil update(@RequestParam String id,@RequestParam String amount) {
			System.out.println("---u="+id+amount);
			int res = service.update(id,amount);
			if(res > 0){
				System.out.println("update");
				return  new ResultUtil(EnumCode.OK.getValue(),"退药成功");
			}
			return new ResultUtil(EnumCode.UNAUTHORIZED.getValue(), "退药失败");
		}

		@RequestMapping("/updateAll")
		public ResultUtil updateAll(@RequestParam String caseNumber) {
			System.out.println("caseNumber"+caseNumber);
			Prescription u = new Prescription();
			u.setCaseNumber(Integer.valueOf(caseNumber));
			Prescription res = service.updateAll(u);
			System.out.println(res);
			if(res != null){
				System.out.println("updateAll");
				return  new ResultUtil(EnumCode.OK.getValue(),"退药成功",res);
			}
			return new ResultUtil(EnumCode.UNAUTHORIZED.getValue(), "退药失败");
		}
}
