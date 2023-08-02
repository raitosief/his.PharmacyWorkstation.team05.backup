package com.neuedu.his.service.outpatientPharmacyWorkstationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.his.entity.Prescription;
import com.neuedu.his.mapper.outpatientPharmacyWorkstationMapper.OutpatientWithdrawalMapper;

@Service
@Transactional
public class OutpatientWithdrawalServiceImpl implements OutpatientWithdrawalService {
	@Autowired
    private OutpatientWithdrawalMapper dao;

    @Override
    public List<Prescription> selectAll(Prescription u) {

        return dao.selectAll(u);
    }


    @Override
    public int update(String id,String amount) {

        return dao.update(id,amount);
    }

    @Override
    public int delete(Prescription u) {

        return dao.delete(u);
    }

    @Override
    public Prescription updateAll(Prescription u ) {
        dao.updateAll(u);
        return  u;
    }

   
}
