package com.example.dao;

import com.example.pojo.Fee;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Data
@NoArgsConstructor
public class FeesDao {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Fee> getWaterFee(String id) {
        String sql = "Select fee, time from water_fee where elder_id = ?;";
        return jdbcTemplate.query(sql, new String[]{id}, BeanPropertyRowMapper.newInstance(Fee.class));
    }

    public void payWaterFee(String id, float fee, String time) {
        String sql = "INSERT INTO water_fee (elder_id,fee,time) " + "VALUES (?,?,?)";
        jdbcTemplate.update(sql, id, fee, time);
    }

    public List<Fee> getPhoneFee(String id) {
        String sql = "Select fee, time from phone_fee where elder_id = ?;";
        return jdbcTemplate.query(sql, new String[]{id}, BeanPropertyRowMapper.newInstance(Fee.class));
    }

    public void payPhoneFee(String id, float fee, String time) {
        String sql = "INSERT INTO phone_fee (elder_id,fee,time) " + "VALUES (?,?,?)";
        jdbcTemplate.update(sql, id, fee, time);
    }

    public List<Fee> getElectricFee(String id) {
        String sql = "Select fee, time from electric_fee where elder_id = ?;";
        return jdbcTemplate.query(sql, new String[]{id}, BeanPropertyRowMapper.newInstance(Fee.class));
    }

    public void payElectricFee(String id, float fee, String time) {
        String sql = "INSERT INTO electric_fee (elder_id,fee,time) " + "VALUES (?,?,?)";
        jdbcTemplate.update(sql, id, fee, time);
    }




/*
    public List<Fee> getWaterFee(String id){
        String sql="Select fee, time from water_fee where elder_id = ?;";
        return jdbcTemplate.query(sql, new String[]{id}, BeanPropertyRowMapper.newInstance(Fee.class));
    }
    */
}
