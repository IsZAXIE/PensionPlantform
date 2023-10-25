package com.example.controller.CommunityController;

import com.example.Service.CommunityService.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommunityController {
    @Autowired
    CommunityService communityService;

    @RequestMapping("/community")
    public String community(){
        return "socialWorker/communityMenu";
    }

    @RequestMapping("/infoManagement")
    public String infoManagement(){
        return "socialWorker/infoManagement";
    }

    @RequestMapping("/warningInfo")
    public String warningInfo(){
        return "socialWorker/warningInfo";
    }
}
