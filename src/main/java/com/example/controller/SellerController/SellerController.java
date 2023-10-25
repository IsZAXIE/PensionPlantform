package com.example.controller.SellerController;


import com.example.Service.ElderService.ShoppingService;
import com.example.Service.SellerService.SellerService;
import com.example.dao.SellerDao.SellerDao;
import com.example.pojo.Goods;
import com.example.utils.AES;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class SellerController {
    @Autowired
    SellerService sellerService;

    @PostMapping("/addGoods")
    public String addGoods(Goods goods){
        System.out.println(goods);
        try {
            goods.setSeller_id(AES.encrypt(goods.getSeller_id()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            sellerService.AddGoods(goods);
        }catch (IOException e){
            e.printStackTrace();
        }
        return "redirect:/seller";
    }
   /*
   @RequestMapping ("/AddGoods")
    public void AddGoods (@RequestBody Goods goods) throws IOException {
        System.out.println(goods.getId());
    }
    */

    @GetMapping("addgoods")
    public String addGoodsGet(){
        return "seller/addgoods";
    }

    @RequestMapping("/seller")
    public String seller(Model model,HttpSession session){
        model.addAttribute("alias",session.getAttribute("userAlias"));
        return "seller/sellerMenu";
    }

    @RequestMapping("/viewInventory")
    public String viewInventory(HttpSession session,Model model){
        String id =(String) session.getAttribute("userId");
        List<Goods> items = sellerService.getInventory(id);
        for(Goods item:items){
            System.out.println("List : item"+item);
        }
        model.addAttribute("items",items);
        return "seller/viewInventory";
    }
}
