package com.neuedu.his.service.outpatientDoctorWorkStationService;

import com.neuedu.his.entity.CheckApply;
import com.neuedu.his.entity.MedicalRecord;
import com.neuedu.his.entity.Register;
import com.neuedu.his.entity.User;
import com.neuedu.his.mapper.outpatientDoctorWorkStationMapper.InspectionApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
//检查申请
@Transactional
public class InspectionApplicationServiceImpl implements InspectionApplicationService {
	@Autowired
	private InspectionApplicationMapper dao;

	@Override
	public List<Register> select(Register register) {
		return dao.select(register);
	}
	
	@Override
	public List<CheckApply> getCheck(Integer id){
		System.out.println("xixi"+ id);
        List<CheckApply> checkList =  dao.getCheck(id);
        System.out.println(checkList);
        CheckApply[] checkArray = checkList.toArray(new CheckApply[checkList.size()]);
        for(int i = 0;i < checkArray.length;++i) {
        	String itemName = dao.getItemName(checkArray[i].getItemID());
        	checkArray[i].setItemName(itemName);
        }
        return checkList;
	}
	
	@Override
	public Integer addCheck(CheckApply newCheck){
		System.out.println("xixi"+ newCheck);
		Integer itemID = dao.getItemID(newCheck);
		if(itemID == null) {
			return 0;
		}
		System.out.println(newCheck.getRegistID());
		Integer medicalID = dao.getMedicalID(newCheck.getRegistID());
//		System.out.println(medicalID);
		newCheck.setMedicalID(medicalID);
		newCheck.setName(newCheck.getItemName());
		newCheck.setItemID(itemID);
		dao.addCheck(newCheck);
		return 1;
	}
	
	@Override
	public Integer staging(CheckApply check) {
		Integer state = dao.getState(check.getID());
		if(state == 2) {
			return 0;
		}
		else{
			dao.staging(check);
		}
		return 1;
	}
	
	@Override
	public Integer open(CheckApply check) {
		Integer state = dao.getState(check.getID());
		if(state == 2) {
			return 0;
		}
		else{
			dao.open(check);
		}
		return 1;
	}
	
	@Override
	public Integer repeal(CheckApply check) {
		Integer state = dao.getState(check.getID());
		if(state != 2) {
			return 0;
		}
		else{
			dao.repeal(check);
		}
		return 1;
	}
	
	@Override
	public Integer dodelete(CheckApply check) {
		Integer state = dao.getState(check.getID());
		if(state != 1) {
			return 0;
		}
		else{
			dao.dodelete(check);
		}
		return 1;
	}
	
	@Override
	public String getresult(CheckApply check) {
		Integer state = dao.getState(check.getID());
		if(state != 2) {
			return null;
		}
		else{
			return dao.getresult(check);
		}
	}
	
	
}
