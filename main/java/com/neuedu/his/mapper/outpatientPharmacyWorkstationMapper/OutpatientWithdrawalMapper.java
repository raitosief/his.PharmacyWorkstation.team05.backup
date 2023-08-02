package com.neuedu.his.mapper.outpatientPharmacyWorkstationMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.his.entity.Prescription;

@Mapper
public interface OutpatientWithdrawalMapper {
	 public List<Prescription> selectAll(Prescription u);
	    public int add(Prescription u);
	    public int update(String id,String amount);
	    public int delete(Prescription u);
	    public int updateAll(Prescription u );
	    public Prescription count(String caseNumber);
}
