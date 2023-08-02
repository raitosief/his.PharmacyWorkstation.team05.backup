package com.neuedu.his.service.OutpatientFinancial;



import java.util.List;

import org.springframework.stereotype.Service;

import com.neuedu.his.entity.Expenseclass;


@Service
public interface ExpenseclassService {
	public List<Expenseclass> selectAll(Expenseclass e);
	public int add(Expenseclass e);
	public int update(Expenseclass e);
	public int delete(Expenseclass e);

}
