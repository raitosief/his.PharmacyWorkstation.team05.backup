package com.neuedu.his.service.outpatientPharmacyWorkstationService;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.neuedu.his.entity.Drugs;
import com.neuedu.his.mapper.outpatientPharmacyWorkstationMapper.DrugCatalogueManaGementMapper;


@Service
@Transactional
public class DrugCatalogueManaGementServiceImpl implements DrugCatalogueManaGementService{
	  @Autowired
	    private DrugCatalogueManaGementMapper dao;

	    @Override
	    public List<Drugs> selectAll(Drugs u) {
	        return dao.selectAll(u);
	    }

	    @Override
	    public Drugs selectById(Drugs u) {
	        return null;
	    }

	    @Override
	    public int add(Drugs u) {
	        return dao.add(u);
	    }


	    @Override
	    public int update(Integer ID, String DrugsCode, String DrugsName, String DrugsFormat, String DrugsUnit, String Manufacturer, Integer DrugsDosageID, Integer DrugsTypeID, BigDecimal DrugsPrice, String MnemonicCode,String LastUpdateDate) {
	        return dao.update(ID,DrugsCode,DrugsName,DrugsFormat,DrugsUnit,Manufacturer,DrugsDosageID,DrugsTypeID,DrugsPrice,MnemonicCode,LastUpdateDate);
	    }

	    @Override
	    public int delete(String id) {
	        System.out.println(id);

	        return dao.delete(id);
}
}
