package com.neuedu.his.service.outpatientDoctorWorkStationService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.his.entity.CheckApply;
import com.neuedu.his.mapper.outpatientDoctorWorkStationMapper.PersonalWorkloadStatisticsMapper;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//个人工作量统计
@Service
@Transactional
public class PersonalWorkloadStatisticsServiceImpl implements PersonalWorkloadStatisticsService{
    @Autowired
    private PersonalWorkloadStatisticsMapper dao;


    @Override
    public List<CheckApply> selectByID(CheckApply c) {
    	System.out.println("startTime:"+ c.getStartTime());
    	System.out.println("endTime:"+c.getEndTime());
        List<CheckApply> checkList =  dao.selectByID(c);
        System.out.println(checkList);
        CheckApply[] checkArray = checkList.toArray(new CheckApply[checkList.size()]);
        List<BigDecimal> costList = new ArrayList<BigDecimal>();
        List<String> nameList = new ArrayList<String>();
        for(int i = 0;i < checkArray.length;++i) {
        	costList.add(dao.selectTotalCost(checkArray[i].getRegistID()));
        	nameList.add(dao.selectName(checkArray[i].getRegistID()));
        }
        
        String[] nameArray = nameList.toArray(new String[nameList.size()]);
        BigDecimal[] costArray = costList.toArray(new BigDecimal[costList.size()]);
        for(int i = 0;i < checkArray.length;++i) {
    		checkArray[i].setTotalCost(costArray[i]);
    		checkArray[i].setRegisterName(nameArray[i]);
    	}
        checkList = Arrays.asList(checkArray);
        return checkList;
    }
}
