package com.neuedu.his.service.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.his.entity.PatientCosts;
import com.neuedu.his.mapper.register.RegisteredTollCollectorMapper;

import java.util.List;

@Service
@Transactional
public class RegisteredTollCollectorServiceImpl implements RegisteredTollCollectorService {

    @Autowired
    RegisteredTollCollectorMapper dao;

    @Override
    public List<PatientCosts> selectAll(PatientCosts u) {

        return dao.selectAll(u);
    }

}
