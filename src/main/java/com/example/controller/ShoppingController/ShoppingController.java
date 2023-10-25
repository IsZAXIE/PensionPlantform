package com.example.controller.ShoppingController;

import com.example.Service.ElderService.ShoppingService;
import com.example.pojo.Goods;
import com.example.pojo.Order;
import com.example.pojo.Settle;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ShoppingController {

    @Autowired
    ShoppingService shoppingService;

    @RequestMapping("/shopping")
    public String shopping(){
        return "elder/shopping/shopping";
    }

/*
    @RequestMapping("/detail")
    public String detail(){
        return "elder/shopping/detail";
    }
    */


    @RequestMapping("/chosen")
    public String chosen(HttpSession session, Model model, HttpServletResponse response){
        if(session.getAttribute("settles")==null){
            response.setContentType("text/html; charset=utf-8");
            PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            out.print("<script>alert('购物车为空');</script>");
            return "elder/shopping/shopping";
        }
        List<Settle> settles=(List<Settle>) session.getAttribute("settles");
        model.addAttribute("settles",settles);
        int num = 0;
        float cost = 0;
        for(Settle settle:settles){
            num+=settle.getNum();
            cost+=settle.getTotalMoney();
        }
        model.addAttribute("settlesNum",num);
        model.addAttribute("totalCost",cost);
        return "elder/shopping/chosen";
    }

    @RequestMapping("/pay")
    public String pay(HttpSession session,Model model){
        List<Settle> settles=(List<Settle>) session.getAttribute("settles");
        String id=(String) session.getAttribute("userId");
        List<Order> orders=new ArrayList<>();
        for(Settle settle:settles){
            orders.add(Order.parseOrder(settle,id));
        }
        shoppingService.pay(orders);
        session.removeAttribute("settles");
        return "redirect:/shopping";
    }


}
