package com.neuedu.his.mapper.OutpatientFiancial;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.his.entity.Expenseclass;

@Mapper
public interface ExpenseclassMapper {//存放费用科目的方法
	public List<Expenseclass> selectAll(Expenseclass e);
	public int add(Expenseclass e);
	public int update(Expenseclass e);
	public int delete(Expenseclass e);

}