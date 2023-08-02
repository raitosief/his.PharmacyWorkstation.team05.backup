package com.neuedu.his.mapper.outpatientDoctorWorkStationMapper;

import com.neuedu.his.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
//门诊确诊
public interface OutpatientDiagnosisMapper {
	public List<Register> select(Register register);
    public MedicalRecord getRecord(MedicalRecord medicalRecord);
    public List<DiagnosisTemplate> getDiagnosisTemplate(String UserID);
    public void deleteDiagnosisTemplate(Integer ID);
    public void commitTemplate(DiagnosisTemplate diagnosisTemplate);
    public void confirm(MedicalRecord medicalRecord);
}
