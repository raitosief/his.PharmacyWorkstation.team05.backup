package com.neuedu.his.service.OutpatientFinancial;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.his.entity.Expenseclass;
import com.neuedu.his.mapper.OutpatientFiancial.ExpenseclassMapper;


@Service
public class ExpenseclassServiceImpl implements ExpenseclassService{
	@Autowired
	private ExpenseclassMapper dao;
    
	
	
	public List<Expenseclass> selectAll(Expenseclass e) {
		return dao.selectAll(e);
	}

	public int add(Expenseclass e) {
		return dao.add(e);
	}

	public int update(Expenseclass e) {
		return dao.update(e);
	}

	public int delete(Expenseclass e) {
		return dao.delete(e);
	}


}
