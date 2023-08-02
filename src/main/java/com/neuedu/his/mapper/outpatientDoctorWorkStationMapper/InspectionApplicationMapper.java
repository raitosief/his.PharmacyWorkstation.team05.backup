package com.neuedu.his.mapper.outpatientDoctorWorkStationMapper;

import com.neuedu.his.entity.CheckApply;
import com.neuedu.his.entity.MedicalRecord;
import com.neuedu.his.entity.Register;
import com.neuedu.his.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
//检查申请
public interface InspectionApplicationMapper {
	public List<Register> select(Register register);
	public List<CheckApply> getCheck(Integer ID);
	public String getItemName(Integer ID);
	public void addCheck(CheckApply newCheck);
	public Integer getItemID(CheckApply newCheck);
	public Integer getMedicalID(Integer RegistID);
	public void staging(CheckApply check);
	public Integer getState(Integer ID);
	public void open(CheckApply check);
	public void repeal(CheckApply check);
	public void dodelete(CheckApply check);
	public String getresult(CheckApply check);
}
