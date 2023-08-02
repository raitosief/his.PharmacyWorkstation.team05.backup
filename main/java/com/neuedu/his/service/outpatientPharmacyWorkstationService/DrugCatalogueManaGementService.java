package com.neuedu.his.service.outpatientPharmacyWorkstationService;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.neuedu.his.entity.Drugs;

@Service
public interface DrugCatalogueManaGementService {
	 public List<Drugs> selectAll(Drugs u);
	    public Drugs selectById(Drugs u);
	    public int add(Drugs u);
	    public int update(Integer ID, String DrugsCode, String DrugsName, String DrugsFormat, String DrugsUnit, String Manufacturer, Integer DrugsDosageID, Integer DrugsTypeID, BigDecimal DrugsPrice, String MnemonicCode,String LastUpdateDate);
	    public int delete(String id);
}
