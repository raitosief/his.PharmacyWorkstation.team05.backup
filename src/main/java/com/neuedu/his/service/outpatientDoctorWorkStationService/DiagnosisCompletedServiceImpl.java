package com.neuedu.his.service.outpatientDoctorWorkStationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.his.entity.MedicalRecord;
import com.neuedu.his.entity.Register;
import com.neuedu.his.entity.User;
import com.neuedu.his.mapper.outpatientDoctorWorkStationMapper.DiagnosisCompletedMapper;

@Service
//诊毕
@Transactional
public class DiagnosisCompletedServiceImpl implements DiagnosisCompletedService {
	@Autowired
	private DiagnosisCompletedMapper dao;


	@Override
	public List<Register> select(Register register) {
		return dao.select(register);
	}

	@Override
	public MedicalRecord getRecord(MedicalRecord medicalRecord) {
		return dao.getRecord(medicalRecord);
	}

	@Override
	public void commitEndPatient(Register register) {
		dao.commitEndPatient(register);
	}

	@Override
	public void commitEndMedicalRecord(MedicalRecord medicalRecord) {
		dao.commitEndMedicalRecord(medicalRecord);
	}
}
