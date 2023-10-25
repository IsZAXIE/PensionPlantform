package com.example.dao;

import com.example.pojo.Goods;
import com.example.pojo.Order;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
@Data
@NoArgsConstructor
public class ShoppingDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void storeOrder(Order order){
        String sql="Insert into order_table values(?,?,?,?,?,?,?,?)";
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                jdbcTemplate.update(sql,order.getElderId(),order.getGoodsId(),order.getNum(),order.getPrice()
                        ,order.getComment(),order.getTime(),order.getTransport(),order.getSignFor());
            }
        });
        thread.run();
    }

    public List<Goods> search_goods_type(String goods_type) {
        String sql = "Select goods.id, goods.type_id, goods.seller_id, goods.price, goods.description, goods.pro_date, goods.stock, goods.manufacture," +
                " goods.name, goods.exp_date from goods,goods_type where goods_type.name = ? and goods_type.id=goods.type_id;";
        return jdbcTemplate.query(sql,new String[] {goods_type}, BeanPropertyRowMapper.newInstance(Goods.class));
    }

    public Goods search_goods_id(String goods_id) {
        String sql = "Select id,description,name,price from goods where id = ? ;";
        return jdbcTemplate.queryForObject(sql,new String[] {goods_id}, BeanPropertyRowMapper.newInstance(Goods.class));
    }

}
