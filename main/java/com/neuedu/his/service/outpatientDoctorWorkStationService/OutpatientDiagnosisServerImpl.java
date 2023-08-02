package com.neuedu.his.service.outpatientDoctorWorkStationService;

import com.neuedu.his.entity.*;
import com.neuedu.his.mapper.outpatientDoctorWorkStationMapper.OutpatientDiagnosisMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//门诊确诊
@Transactional
public class OutpatientDiagnosisServerImpl implements OutpatientDiagnosisServer {
	@Autowired
	private OutpatientDiagnosisMapper dao;

	@Override
	public List<Register> select(Register register) {
		return dao.select(register);
	}

	@Override
	public MedicalRecord getRecord(MedicalRecord medicalRecord) {
		return dao.getRecord(medicalRecord);
	}

	@Override
	public List<DiagnosisTemplate> getDiagnosisTemplate(String UserID) {
		return dao.getDiagnosisTemplate(UserID);
	}

	@Override
	public void deleteDiagnosisTemplate(Integer ID) {
		dao.deleteDiagnosisTemplate(ID);
	}

	@Override
	public void commitTemplate(DiagnosisTemplate diagnosisTemplate) {
		dao.commitTemplate(diagnosisTemplate);
	}

	@Override
	public void confirm(MedicalRecord medicalRecord) {
		dao.confirm(medicalRecord);
	}

}
