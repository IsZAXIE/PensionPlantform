package com.example.dao.SellerDao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.pojo.Goods;
import com.example.pojo.GoodsByte;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Data
@NoArgsConstructor
public class SellerDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void AddGood(Goods goods) throws IOException {
        String sql = "INSERT INTO goods (id,type_id,seller_id,price,image,description,pro_date,stock,manufacture,name,exp_date) "
                +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?);";
        byte[] image_byte = goods.getImage().getBytes();

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                jdbcTemplate.update(sql, goods.getId(), goods.getTypeID(), goods.getSeller_id(), goods.getPrice(), image_byte, goods.getDescription(),
                        goods.getProDate(), goods.getStock(), goods.getManufacture(), goods.getName(), goods.getExpDate());
            }
        });
        thread.run();
    }

    public List<Goods> getInventory(String id) {
        String sql = "Select id,name,manufacture,stock from goods where seller_id = ?;";
/*
        String sql = "Select * from goods where seller_id = ?;";
        List<GoodsByte> tempList = jdbcTemplate.query(sql, new String[]{id}, BeanPropertyRowMapper.newInstance(GoodsByte.class));
        List<Goods> goodsList = new ArrayList<>();
        for (GoodsByte goodsTemp : tempList) {
            String jsonString = JSON.toJSONString(goodsTemp);

            Goods goodsSingle = JSONObject.parseObject(jsonString, Goods.class);
            goodsList.add(goodsSingle);

        }
*/
        return jdbcTemplate.query(sql, new String[]{id}, BeanPropertyRowMapper.newInstance(Goods.class));
    }

}