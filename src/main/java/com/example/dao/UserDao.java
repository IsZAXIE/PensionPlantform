package com.example.dao;

import com.example.pojo.Display;
import com.example.pojo.PAP;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Data
@NoArgsConstructor
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public Display judgeElderAccountAndPwd(PAP pap){
        String sql="Select id,alias from elder where (phone= ? and password = ?);";
        try{
            Display display = jdbcTemplate.queryForObject(sql,new String[]{pap.getPhone(), pap.getPwd()}, BeanPropertyRowMapper.newInstance(Display.class));
            return display;
        }catch (EmptyResultDataAccessException e){
            System.out.println("No Data Access.");
            return null;
        }
    }

    public Display judgeAccount(PAP pap){
        String tableName;
        if(pap.getRole().equals("elder")){
            tableName="elder";
        }
        else if (pap.getRole().equals("admin")){
            tableName="community_user";
        }
        else {
            tableName="seller";
        }
        String sql="Select id,alias from "+tableName+" where (phone= ? and password = ?);";
        try{
            Display display = jdbcTemplate.queryForObject(sql,new String[]{pap.getPhone(), pap.getPwd()}, BeanPropertyRowMapper.newInstance(Display.class));
            return display;
        }catch (EmptyResultDataAccessException e){
            System.out.println("No Data Access.");
            return null;
        }
    }
}
