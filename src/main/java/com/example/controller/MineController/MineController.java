package com.example.controller.MineController;

import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MineController {

    @RequestMapping("/mine")
    public String mine(){
        return "elder/mine/changePersonInfo";
    }

    @RequestMapping("/mine/infoeditor")
    public String infoEditor(@RequestBody String jsonInfo){
        System.out.println("MineController : RequestBody = "+jsonInfo);
        return "elder/mine/changePersonInfo";
    }
    @RequestMapping("/mine/{uri}")
    public void catchURL(@RequestBody String jsonInfo, @PathVariable("uri") String d){
        System.out.println("MineController : "+"uri = "+d+"\tRequestBody = "+jsonInfo);
    }
}
