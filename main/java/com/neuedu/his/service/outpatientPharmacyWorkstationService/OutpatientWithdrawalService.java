package com.neuedu.his.service.outpatientPharmacyWorkstationService;

import java.util.List;

import com.neuedu.his.entity.Prescription;

public interface OutpatientWithdrawalService {
	 public List<Prescription> selectAll(Prescription  u);
	    public int update(String u,String Amount);
	    public int delete(Prescription u);
	    public Prescription updateAll(Prescription u);

}
