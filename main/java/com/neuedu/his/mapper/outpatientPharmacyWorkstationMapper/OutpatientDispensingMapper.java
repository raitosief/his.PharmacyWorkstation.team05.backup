package com.neuedu.his.mapper.outpatientPharmacyWorkstationMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.his.entity.Prescription;

@Mapper
public interface OutpatientDispensingMapper {
	public List<Prescription> selectAll(Prescription u);
	public int update(String u);
}
