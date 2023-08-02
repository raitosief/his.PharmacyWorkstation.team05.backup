package com.neuedu.his.service.OutpatientFinancial;




import java.util.List;

import org.springframework.stereotype.Service;

import com.neuedu.his.entity.Invoice;
import com.neuedu.his.entity.OutpatientFinance;


@Service
public interface OutpatientFinanceService {//门诊日结
	public List<Invoice> selectAll(OutpatientFinance o);//根据收费员id和时间搜索对应的发票,返回发票
	public int pass(Invoice i);//审核通过
	public int reiterate(Invoice i);//打回重申

}
