package com.example.Service;

import com.example.dao.UserDao;
import com.example.pojo.Display;
import com.example.pojo.PAP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao dao;
    public Display judgeElderAccountAndPassword(PAP pap){
        Display display=dao.judgeElderAccountAndPwd(pap);
        System.out.println("display = "+display);
        if(display==null){
            return null;
        }
        return display;
    }

    public Display judgeAccount(PAP pap){
        Display display=dao.judgeAccount(pap);
        System.out.println("display = "+display);
        if(display==null){
            return null;
        }
        return display;
    }
}
