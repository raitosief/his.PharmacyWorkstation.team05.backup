package com.neuedu.his.mapper.register;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.his.entity.Invoice;

import java.util.List;

@Mapper
public interface BackNumberMapper {
	public List<Invoice> selectAllInvoice(Invoice invoice);
	public int updateInvoice(Invoice invoice);
	public int addInvoice(Invoice invoice);
	public int deleteInvoice(Invoice invoice);
}
