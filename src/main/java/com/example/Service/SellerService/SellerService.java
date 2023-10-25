package com.example.Service.SellerService;

import com.example.dao.SellerDao.SellerDao;
import com.example.dao.ShoppingDao;
import com.example.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SellerService {

    @Autowired
    SellerDao sellerDao;

    public void AddGoods(Goods goods) throws IOException {
        sellerDao.AddGood(goods);
    }

    public List<Goods> getInventory(String id){
        return sellerDao.getInventory(id);
    }
}
