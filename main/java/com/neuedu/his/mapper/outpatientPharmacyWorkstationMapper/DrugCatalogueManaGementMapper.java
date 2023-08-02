package com.neuedu.his.mapper.outpatientPharmacyWorkstationMapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.his.entity.Drugs;
//药品目录管理
@Mapper
public interface DrugCatalogueManaGementMapper {

	 public List<Drugs> selectAll(Drugs u);
	    public int add(Drugs u);
	    public int update(Integer ID, String DrugsCode, String DrugsName, String DrugsFormat, String DrugsUnit, String Manufacturer, Integer DrugsDosageID, Integer DrugsTypeID, BigDecimal DrugsPrice, String MnemonicCode,String LastUpdateDate);
	    public int delete(String id);
	    public Drugs selectById(Drugs u);
}
