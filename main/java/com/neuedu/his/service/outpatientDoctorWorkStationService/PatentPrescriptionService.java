package com.neuedu.his.service.outpatientDoctorWorkStationService;

import com.neuedu.his.entity.*;

import java.util.List;
import java.util.Map;

public interface PatentPrescriptionService {
	public List<Register> select(Register register);
	public List<DrugsTemplate> showTemp();
	public Integer deleteTemp(Integer ID);
	public List<DrugsDetailed> useTemp(Integer ID);
	public List<Prescription> getPrescription(Register register);
	public void addPrescription(Prescription newPrescription);
	public List<PrescriptionDetailed> editPrescription(Integer preID);
	public Integer staging(Integer preID);
	public Integer open(Integer preID);
	public Integer repeal(Integer preID);
	public Integer dodelete(Integer preID);
	public Integer addDrugs(PrescriptionDetailed prescriptionDetailed);
	public void deleteDrug(Integer ID);
	public void saveDrug(PrescriptionDetailed prescriptionDetailed);
	public Integer saveAsTemp(DrugsTemplate drugsTemplate);
}
