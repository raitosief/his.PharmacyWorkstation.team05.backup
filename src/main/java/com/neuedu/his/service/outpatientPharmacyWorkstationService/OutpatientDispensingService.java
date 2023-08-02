package com.neuedu.his.service.outpatientPharmacyWorkstationService;

import java.util.List;

import com.neuedu.his.entity.Prescription;

public interface OutpatientDispensingService {
	public List<Prescription> selectAll(Prescription u);
	public int update(String u);
}
