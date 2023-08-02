package com.neuedu.his.service.outpatientDoctorWorkStationService;

import com.neuedu.his.entity.CheckApply;
import com.neuedu.his.entity.MedicalRecord;
import com.neuedu.his.entity.Register;
import com.neuedu.his.entity.User;

import java.util.List;

//检查申请
public interface InspectionApplicationService {
	public List<Register> select(Register register);
	public List<CheckApply> getCheck(Integer id);
	public Integer addCheck(CheckApply newCheck);
	public Integer staging(CheckApply check);
	public Integer open(CheckApply check);
	public Integer repeal(CheckApply check);
	public Integer dodelete(CheckApply check);
	public String getresult(CheckApply check);
}
