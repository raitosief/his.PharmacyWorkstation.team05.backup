package com.neuedu.his.mapper.outpatientDoctorWorkStationMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.his.entity.MedicalRecord;
import com.neuedu.his.entity.Register;
import com.neuedu.his.entity.User;


//诊毕
@Mapper
public interface DiagnosisCompletedMapper {
    public List<Register> select(Register register);
    public MedicalRecord getRecord(MedicalRecord medicalRecord);
    public void commitEndPatient(Register register);
    public void commitEndMedicalRecord(MedicalRecord medicalRecord);
}
