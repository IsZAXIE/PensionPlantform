/*
package com.example.controller.ShoppingController;

import com.example.Service.ElderService.ShoppingService;
import com.example.pojo.Goods;
import com.example.pojo.Settle;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ShoppingLinkController {
    @Autowired
    ShoppingService shoppingService;
    @GetMapping("st")
    public String GoodsSearch(Model model,@RequestParam("goods_type") String goods_type){
        List<Goods> goods = shoppingService.search_goods_type(goods_type);
        */
/*        model.addAttribute("goods_type",goods_type);*//*

        model.addAttribute("goods",goods);
        return "elderoppingst";
    }

    @GetMapping("/detail")
    public String PositionGoods(Model model,@RequestParam("goods_id") String goods_id){
        Goods good = shoppingService.search_goods_id(goods_id);
        model.addAttribute("good",good);
        return "elderopping/detail";
    }

    @PostMapping("/AddIntoCar")
    public String AddIntoCar(HttpSession session,
                             @RequestParam("id") String id,
                             @RequestParam("info") String info,
                             @RequestParam("price") float price,
                             @RequestParam("num") Integer num
    ){
        Settle settle =new Settle();
        settle.setId(id);
        settle.setInfo(info);
        settle.setPrice(price);
        settle.setNum(num);
        settle.setTotalMoney(num*price);
        session.setAttribute("settles",settle);
        System.out.println(settle.getNum());
        return "elderoppingopping";
    }

}*/

package com.example.controller.ShoppingController;

import com.example.Service.ElderService.ShoppingService;
import com.example.pojo.Goods;
import com.example.pojo.Settle;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShoppingLinkController {
    @Autowired
    ShoppingService shoppingService;

    @GetMapping("/list")
    public String GoodsSearch(Model model,@RequestParam("goods_type") String goods_type){
        List<Goods> goods = shoppingService.search_goods_type(goods_type);
        /*        model.addAttribute("goods_type",goods_type);*/
        model.addAttribute("goods",goods);
        return "elder/shopping/list";
    }

    @GetMapping("/detail")
    public String PositionGoods(Model model,@RequestParam("goods_id") String goods_id){
        Goods good = shoppingService.search_goods_id(goods_id);
        model.addAttribute("good",good);
        return "elder/shopping/detail";
    }

    @PostMapping("/AddIntoCar")
    public String AddIntoCar(HttpSession session,
                             @RequestParam("id") String id,
                             @RequestParam("info") String info,
                             @RequestParam("price") float price,
                             @RequestParam("num") Integer num
    ){
        List<Settle>settles = (List<Settle>) session.getAttribute("settles");
        session.removeAttribute("settles");
        if(settles==null){
            settles=new ArrayList<>();
        }
        Settle settle =new Settle();
        settle.setId(id);
        settle.setInfo(info);
        settle.setPrice(price);
        settle.setNum(num);
        settle.setTotalMoney(num*price);
        settles.add(settle);
        session.setAttribute("settles",settles);
        System.out.println(settle.getNum());
        return "elder/shopping/shopping";
    }

}
