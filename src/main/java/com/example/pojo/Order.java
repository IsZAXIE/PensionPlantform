package com.example.pojo;

import com.example.utils.MyTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String elderId;
    private int goodsId;
    private int num;
    private float price;
    private String comment;
    private String time;
    private byte transport;
    private byte signFor;

    public static Order parseOrder(Settle settle,String elderId){
        Order order=new Order();
        order.setElderId(elderId);
        order.setGoodsId(Integer.parseInt(settle.getId()));
        order.setNum(settle.getNum());
        order.setPrice(settle.getTotalMoney());
        order.setComment("");
        order.setTime(MyTime.getTime());
        order.setTransport((byte) 0);
        order.setSignFor((byte) 0);
        return order;
    }
}
