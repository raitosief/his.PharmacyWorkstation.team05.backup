package com.neuedu.his.mapper.register;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.his.entity.Invoice;

import java.util.Date;
import java.util.List;

@Mapper
public interface DailySettlementMapper {
	public List<Invoice> selectAllInvoice(Date start_time, Date end_time);
	public int updateInvoice(Invoice invoice);
}
