package com.neuedu.his.mapper.OutpatientFiancial;





import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.his.entity.Invoice;
import com.neuedu.his.entity.OutpatientFinance;

@Mapper
public interface OutpatientFinanceMapper {
	//用来放门诊日结页面的方法
	public List<Invoice> selectAll(OutpatientFinance o);//根据收费员姓名和时间搜索对应的发票,返回发票
	public int pass(Invoice i);//审核通过
	public int reiterate(Invoice i);//打回重申
}
