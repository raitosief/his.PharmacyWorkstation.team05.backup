package com.neuedu.his.service.register;

import java.util.List;

import com.neuedu.his.entity.Invoice;

public interface BackNumberService {
	public List<Invoice> selectAllInvoice(Invoice invoice);
	public int updateInvoice(Invoice invoice);
	public int addInvoice(Invoice invoice);
	public int deleteInvoice(Invoice invoice);
}
