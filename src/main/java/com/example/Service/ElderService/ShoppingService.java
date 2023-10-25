package com.example.Service.ElderService;

import com.example.dao.ShoppingDao;
import com.example.pojo.Goods;
import com.example.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingService {
    @Autowired
    ShoppingDao shoppingDao;


    public void pay(List<Order> orders) {
        for(Order order:orders){
            System.out.println("ShoppingService : order = "+order);
            shoppingDao.storeOrder(order);
        }
    }
    public List<Goods> search_goods_type(String goods_type) {
        return shoppingDao.search_goods_type(goods_type);
    }
    public Goods search_goods_id(String goods_id) {
        return shoppingDao.search_goods_id(goods_id);
    }
}
