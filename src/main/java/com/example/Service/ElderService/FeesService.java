package com.example.Service.ElderService;

import com.example.dao.FeesDao;
import com.example.pojo.Fee;
import com.example.utils.MyTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FeesService {

    @Autowired
    FeesDao feesDao;


    public List<Fee> getWaterFees(String id) {
        return feesDao.getWaterFee(id);
    }

    public void payWaterFees(String id, float fee) {
        String time = new MyTime().getTime();
        feesDao.payWaterFee(id, fee, time);
    }

    public List<Fee> getPhoneFees(String id) {
        return feesDao.getPhoneFee(id);
    }


    public void payPhoneFees(String id, float fee) {
        String time = new MyTime().getTime();
        feesDao.payPhoneFee(id, fee, time);
    }

    public List<Fee> getElectricFees(String id) {
        return feesDao.getElectricFee(id);
    }

    public void payElectricFees(String id, float fee) {
        String time = new MyTime().getTime();
        feesDao.payElectricFee(id, fee, time);
    }

    /*
    public List<Fee> getWaterFees(String id){
        return feesDao.getWaterFee(id);
    }
     */


}
