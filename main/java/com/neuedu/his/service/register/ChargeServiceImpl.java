package com.neuedu.his.service.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.his.entity.*;
import com.neuedu.his.mapper.register.ChargeMapper;

import java.util.List;

@Service
@Transactional
public class ChargeServiceImpl implements ChargeService {
	@Autowired
	private ChargeMapper dao;

	public List<CheckApply> selectByIDCheckAppy(int RegistID) {
		return dao.selectByIDCheckAppy(RegistID);
	}

	@Override
	public List<Prescription> selectByIDPrescription(int RegistID) {
		return dao.selectByIDPrescription(RegistID);
	}

	@Override
	public Fmeditem selectByID(int ID) {
		return dao.selectByID(ID);
	}

	@Override
	public List<PrescriptionDetailed> selectByDetailed(int PrescriptionID) {
		return dao.selectByDetailed(PrescriptionID);
	}

	@Override
	public Drugs selectByDrugID(int ID) {
		return dao.selectByDrugID(ID);
	}

	@Override
	public int updateCheckApply(Integer ID) {
		return dao.updateCheckApply(ID);
	}

	@Override
	public int updatePrescriptionDetailed(Integer ID) {
		return dao.updatePrescriptionDetailed(ID);
	}
}
