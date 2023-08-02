package com.neuedu.his.service.register;

import java.util.List;

import com.neuedu.his.entity.Invoice;
import com.neuedu.his.entity.PatientCosts;
import com.neuedu.his.entity.Register;

public interface RegisterService {
	public List<Register> selectAll(Register r);
	public Register selectById(Register r);
	public int add(Register r);
	public int delete(Register r);
	public int update(Register r);
	public Invoice print(Register r);
	public Invoice selectInvoice(Invoice invoice);
	public Invoice selectMaxInvoice();
	public int addInvoice(Invoice invoice);
	public int addPatientCosts(PatientCosts patientCosts);
}
