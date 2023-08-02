package com.neuedu.his.service.outpatientDoctorWorkStationService;

import com.neuedu.his.entity.*;
import com.neuedu.his.mapper.outpatientDoctorWorkStationMapper.PatentPrescriptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PatentPrescriptionServiceImpl implements PatentPrescriptionService {
	@Autowired
	private PatentPrescriptionMapper dao;

	@Override
	public List<Register> select(Register register) {
		return dao.select(register);
	}

	@Override
	public List<DrugsTemplate> showTemp() {
		List<DrugsTemplate> HList = dao.getHList();
		List<DrugsTemplate> DList = dao.getDList();
		List<DrugsTemplate> PList = dao.getPList();
		List<DrugsTemplate> result = new ArrayList<>();
		;
		result.addAll(HList);
		result.addAll(DList);
		result.addAll(PList);
		return result;
	}

	@Override
	public Integer deleteTemp(Integer ID) {
		Integer userID = dao.getUserID(ID);
		if (userID != null && userID != 1) {
			return 0;
		}
		dao.deleteTemp(ID);
		dao.deleteTempDetail(ID);
		return 1;
	}

	@Override
	public List<DrugsDetailed> useTemp(Integer ID) {
		List<DrugsDetailed> ddList = dao.getDrugsDetailed(ID);
		DrugsDetailed[] ddArray = ddList.toArray(new DrugsDetailed[ddList.size()]);
		for (int i = 0; i < ddArray.length; ++i) {
			ddArray[i].setDrugsName(dao.getDrugName(ddArray[i].getDrugsID()));
		}
		ddList = Arrays.asList(ddArray);
		System.out.println(ddList);
		return ddList;
	}

	@Override
	public List<Prescription> getPrescription(Register register) {
		return dao.getPrescription(register);
	}

	@Override
	public void addPrescription(Prescription newPrescription) {
		Integer medicalID = dao.getMedicalID(newPrescription.getRegistID());
		newPrescription.setMedicalID(medicalID);
		newPrescription.setPrescriptionTime(new Date());
		dao.addPrescription(newPrescription);
		return;
	}

	@Override
	public List<PrescriptionDetailed> editPrescription(Integer preID) {
		List<PrescriptionDetailed> pdList = dao.editPrescription(preID);
		PrescriptionDetailed[] pdArray = pdList.toArray(new PrescriptionDetailed[pdList.size()]);
		for (int i = 0; i < pdArray.length; ++i) {
			pdArray[i].setDrugsName(dao.getDrugName(pdArray[i].getDrugsID()));
		}
		pdList = Arrays.asList(pdArray);
		return pdList;
	}

	@Override
	public Integer staging(Integer preID) {
		Integer state = dao.getState(preID);
		if (state == 2) {
			return 0;
		} else {
			dao.staging(preID);
		}
		return 1;
	}

	@Override
	public Integer open(Integer preID) {
		Integer state = dao.getState(preID);
		if (state != 1) {
			return 0;
		} else {
			dao.open(preID);
		}
		return 1;
	}

	@Override
	public Integer repeal(Integer preID) {
		Integer state = dao.getState(preID);
		if (state != 2) {
			return 0;
		} else {
			dao.repeal(preID);
		}
		return 1;
	}

	@Override
	public Integer dodelete(Integer preID) {
		Integer state = dao.getState(preID);
		if (state != 1) {
			return 0;
		} else {
			dao.dodelete(preID);
			dao.deleteDrugs(preID);
		}
		return 1;
	}

	@Override
	public Integer addDrugs(PrescriptionDetailed prescriptionDetailed) {
		Integer drugsID = dao.getDrugsID(prescriptionDetailed.getDrugsName());
		if (drugsID == null) {
			return 0;
		}
		return 1;
	}

	@Override
	public void deleteDrug(Integer ID) {
		dao.deleteDrug(ID);
	}

	@Override
	public void saveDrug(PrescriptionDetailed prescriptionDetailed) {
		if (prescriptionDetailed.getID() != null) {
			System.out.println("pre=" + prescriptionDetailed);
			dao.updateDrug(prescriptionDetailed);
		} else {
			Integer drugsID = dao.getDrugsID(prescriptionDetailed.getDrugsName());
			prescriptionDetailed.setDrugsID(drugsID);
			System.out.println(prescriptionDetailed);
			dao.saveDrug(prescriptionDetailed);
		}
	}

	@Override
	public Integer saveAsTemp(DrugsTemplate drugsTemplate) {
		DrugsTemplate bool = dao.tempIsExist(drugsTemplate);
		if (bool != null) {
			return 0;
		}
		
		drugsTemplate.setCreationTime(new Date());
		dao.saveTemp(drugsTemplate);

		DrugsTemplate drugstemp = dao.tempIsExist(drugsTemplate);
		Integer dtID = drugstemp.getID();
		Integer preID = drugsTemplate.getID();
		List<PrescriptionDetailed> pdList = dao.editPrescription(preID);
		PrescriptionDetailed[] pdArray = pdList.toArray(new PrescriptionDetailed[pdList.size()]);
		
		for (int i = 0; i < pdArray.length; ++i) {
			pdArray[i].setPrescriptionID(dtID);
			dao.saveTempDetail(pdArray[i]);
		}

		return 1;
	}
}
