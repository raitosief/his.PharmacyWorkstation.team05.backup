package com.neuedu.his.mapper.outpatientDoctorWorkStationMapper;

import com.neuedu.his.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PatentPrescriptionMapper {
	public List<Register> select(Register register);
	public List<Prescription> getPrescription(Register register);
	public Integer getUserID(Integer ID);
	public void deleteTemp(Integer ID);
	public void deleteTempDetail(Integer ID);
	public List<DrugsDetailed> getDrugsDetailed(Integer ID);
	public List<DrugsTemplate> getHList();
	public List<DrugsTemplate> getDList();
	public List<DrugsTemplate> getPList();
	public void addPrescription(Prescription newPrescription);
	public Integer getMedicalID(Integer RegistID);
	public List<PrescriptionDetailed> editPrescription(Integer preID);
	public String getDrugName(Integer drugID);
	public Integer getState(Integer preID);
	public void staging(Integer preID);
	public void open(Integer preID);
	public void repeal(Integer preID);
	public void dodelete(Integer preID);
	public void deleteDrugs(Integer preID);
	public Integer getDrugsID(String DrugsName);
	public void deleteDrug(Integer ID);
	public void updateDrug(PrescriptionDetailed prescriptionDetailed);
	public void saveDrug(PrescriptionDetailed prescriptionDetailed);
	public DrugsTemplate tempIsExist(DrugsTemplate drugsTemplate);
	public void saveTemp(DrugsTemplate drugsTemplate);
	public void saveTempDetail(PrescriptionDetailed prescriptionDetailed);
}
