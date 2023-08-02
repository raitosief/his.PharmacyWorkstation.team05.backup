package com.neuedu.his.service.outpatientPharmacyWorkstationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.his.entity.Prescription;
import com.neuedu.his.mapper.outpatientPharmacyWorkstationMapper.OutpatientDispensingMapper;

@Service
@Transactional
public class OutpatientDispensingServiceImpl implements OutpatientDispensingService {
		@Autowired
		private OutpatientDispensingMapper dao;
		@Override
		public List<Prescription> selectAll(Prescription u) {
			return
					dao.selectAll(u);
		}
		 @Override
		    public int update(String id) {

		        return dao.update(id);
		    }
}
