package com.example.utils;

import com.example.pojo.HealthInfo;

import java.text.NumberFormat;

public class GetHealthInfo {
    public HealthInfo getHealthInfo(){
        HealthInfo healthInfo=new HealthInfo();
        healthInfo.setTime(MyTime.getTime());
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(1);
        healthInfo.setBloodSugar(nf.format(Math.random()*4+4));



        return healthInfo;
//    int
    }
}
