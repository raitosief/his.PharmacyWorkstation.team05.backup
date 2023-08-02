package com.neuedu.his.controller.outpatientPharmacyWorkstationController;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.his.entity.Drugs;
import com.neuedu.his.service.outpatientPharmacyWorkstationService.DrugCatalogueManaGementService;
import com.neuedu.util.EnumCode;
import com.neuedu.util.ResultUtil;

//药品目录管理
@RestController
@RequestMapping("/outpatientPharmacyWorkstation/drugCatalogueManagement")
public class DrugCatalogueManaGementController {
	@Autowired
	private DrugCatalogueManaGementService service;

	@RequestMapping("/selectAll")
	public ResultUtil selectAll(Drugs u) {
		System.out.println(u);
		List<Drugs> list = service.selectAll(u);
		if (list != null) {

			return new ResultUtil(EnumCode.OK.getValue(), "查询成功", service.selectAll(u));
		}
		return new ResultUtil(EnumCode.UNAUTHORIZED.getValue(), "查询失败");
	}

	@RequestMapping("/add")
	public ResultUtil add(Drugs u) {
		System.out.println(u);
		int res = service.add(u);
		if (res == 1) {

			return new ResultUtil(EnumCode.OK.getValue(), "添加药品信息成功");
		}
		return new ResultUtil(EnumCode.UNAUTHORIZED.getValue(), "添加药品信息失败");
	}

	@RequestMapping("/update")
	public ResultUtil update(@RequestParam Integer id, @RequestParam String drugsCode, @RequestParam String drugsName,
			@RequestParam String drugsFormat, @RequestParam String drugsUnit, @RequestParam String manufacturer,
			@RequestParam Integer drugsDosageID, @RequestParam Integer drugsTypeID, @RequestParam BigDecimal drugsPrice,
			@RequestParam String mnemonicCode, @RequestParam String lastUpdateDate) {
		System.out.println("---u=" + id + "555555555" + drugsDosageID);
		int res = service.update(id, drugsCode, drugsName, drugsFormat, drugsUnit, manufacturer, drugsDosageID,
				drugsTypeID, drugsPrice, mnemonicCode, lastUpdateDate);
		if (res == 1) {

			return new ResultUtil(EnumCode.OK.getValue(), "更新药品信息成功");
		}
		return new ResultUtil(EnumCode.UNAUTHORIZED.getValue(), "更新药品信息失败");
	}

	@RequestMapping("/delete")
	public ResultUtil delete(@RequestParam String id) {

		int res = service.delete(id);
		System.out.println("-------------" + id);
		if (res == 1) {

			return new ResultUtil(EnumCode.OK.getValue(), "药品信息删除成功");
		}
		return new ResultUtil(EnumCode.UNAUTHORIZED.getValue(), "药品信息删除失败");
	}

}
