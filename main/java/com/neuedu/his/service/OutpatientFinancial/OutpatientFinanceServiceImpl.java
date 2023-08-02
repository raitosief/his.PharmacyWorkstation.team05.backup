package com.neuedu.his.service.OutpatientFinancial;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.his.entity.Invoice;
import com.neuedu.his.entity.OutpatientFinance;
import com.neuedu.his.mapper.OutpatientFiancial.OutpatientFinanceMapper;

@Service
public class OutpatientFinanceServiceImpl implements OutpatientFinanceService{
	@Autowired
	private OutpatientFinanceMapper dao;

	public List<Invoice> selectAll(OutpatientFinance o) {
		return dao.selectAll(o);
	}

	public int pass(Invoice i) {
		return dao.pass(i);
	}

	public int reiterate(Invoice i) {
		return dao.reiterate(i);
	}

	

	

	
	

}
