package com.neuedu.his.service.register;

import java.util.List;

import com.neuedu.his.entity.PatientCosts;


public interface RegisteredTollCollectorService {
    public List<PatientCosts> selectAll(PatientCosts u);
}
