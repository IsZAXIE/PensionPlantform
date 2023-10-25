package com.example.controller.FeesController;


import com.example.Service.ElderService.FeesService;
import com.example.pojo.Fee;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;

@Controller
public class FeesController {
    /*
    @Autowired
    FeesService feesService;
    @GetMapping("/waterFee")
    public String waterFee(Model model, HttpSession session){
        String id=(String) session.getAttribute("id");
        // this is use to test only
        List<Fee> fees=feesService.getWaterFees("pp+zbB3sUaH5RftAqRxZJEnfRJiFaEVW5GDcUgxkMXk=");
        // this is use when submit
//        List<Fee> fees=feesService.getWaterFees(id);

        model.addAttribute("fees",fees);
        return "elder/fee/waterFee";
    }
    @Controller
public class FeesController {
     */
    @Autowired
    FeesService feesService;
    Random r = new Random();

    @GetMapping("/waterFee")
    public String getwaterFee(Model model, HttpSession session) {
        double random = r.nextDouble(200);
        String pay_water_fee = String.format("%.2f", random);
        String id = (String) session.getAttribute("userId");
        // this is use to test only
        List<Fee> fees = feesService.getWaterFees(id);
        // this is use when submit
//        List<Fee> fees=feesService.getWaterFees(id);
        model.addAttribute("fees", fees);
        model.addAttribute("PayWaterFee", pay_water_fee);
        return "elder/fee/waterFee";
    }


    @RequestMapping("/payWaterFee")
    public String PaywaterFee(Model model, HttpSession session, @RequestParam("PayWaterFee") float PayWaterFee) {
        String id = (String) session.getAttribute("userId");
        // this is use to test only
        feesService.payWaterFees(id, PayWaterFee);
        // this is use when submi
//        List<Fee> fees=feesService.getPhoneFees(id);
        model.addAttribute("payfee", PayWaterFee);
        session.setAttribute("waterFee", true);
        return "elder/fee/feeSuccess";
    }

    @GetMapping("/phoneFee")
    public String getphoneFee(Model model, HttpSession session) {
        /*随机数设定需要缴费的金额*/
        double random = r.nextDouble(200);
        String pay_phone_fee = String.format("%.2f", random);
        String id = (String) session.getAttribute("userId");
        // this is use to test only
        List<Fee> fees = feesService.getPhoneFees(id);
        // this is use when submit
//        List<Fee> fees=feesService.getPhoneFees(id);
        model.addAttribute("fees", fees);
        model.addAttribute("PayPhoneFee", pay_phone_fee);
        return "elder/fee/phoneFee";
    }

    @RequestMapping("/payPhoneFee")
    public String PayphoneFee(Model model, HttpSession session, @RequestParam("PayPhoneFee") float PayPhoneFee) {
        String id = (String) session.getAttribute("userId");
        // this is use to test only
        feesService.payPhoneFees(id, PayPhoneFee);
        // this is use when submi
//        List<Fee> fees=feesService.getPhoneFees(id);
        model.addAttribute("payfee", PayPhoneFee);
        session.setAttribute("phoneFee", true);
        return "elder/fee/feeSuccess";
    }

    @GetMapping("/electricFee")
    public String getelectricFee(Model model, HttpSession session) {
        double random = r.nextDouble(200);
        String pay_electric_fee = String.format("%.2f", random);
        String id = (String) session.getAttribute("userId");
        // this is use to test only
        List<Fee> fees = feesService.getElectricFees(id);
        // this is use when submit
//        List<Fee> fees=feesService.getPhoneFees(id);
        model.addAttribute("fees", fees);
        model.addAttribute("PayElectricFee", pay_electric_fee);
        return "elder/fee/electricFee";
    }

    @RequestMapping("/payElectricFee")
    public String PayelectricFee(Model model, HttpSession session, @RequestParam("PayElectricFee") float PayElectricFee) {
        String id = (String) session.getAttribute("userId");
        // this is use to test only
        feesService.payElectricFees(id, PayElectricFee);
        // this is use when submi
//        List<Fee> fees=feesService.getPhoneFees(id);
        model.addAttribute("payfee", PayElectricFee);
        session.setAttribute("electricFee", true);

        return "elder/fee/feeSuccess";
    }

}
//}
