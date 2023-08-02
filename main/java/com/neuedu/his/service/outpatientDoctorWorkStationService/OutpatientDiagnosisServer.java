package com.neuedu.his.service.outpatientDoctorWorkStationService;

import com.neuedu.his.entity.*;
import java.util.List;

//门诊确诊
public interface OutpatientDiagnosisServer {
	public List<Register> select(Register register);
    public MedicalRecord getRecord(MedicalRecord medicalRecord);
    public List<DiagnosisTemplate> getDiagnosisTemplate(String UserID);
    public void deleteDiagnosisTemplate(Integer ID);
    public void commitTemplate(DiagnosisTemplate diagnosisTemplate);
    public void confirm(MedicalRecord medicalRecord);
}
