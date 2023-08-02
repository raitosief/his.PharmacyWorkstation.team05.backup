package com.neuedu.his.service.outpatientDoctorWorkStationService;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Primary;

import com.neuedu.his.entity.MedicalRecord;
import com.neuedu.his.entity.Register;
import com.neuedu.his.entity.User;

//诊毕service
public interface DiagnosisCompletedService {
    public MedicalRecord getRecord(MedicalRecord medicalRecord);
    public void commitEndPatient(Register register);
    public void commitEndMedicalRecord(MedicalRecord medicalRecord);
    public List<Register> select(Register register);
}
