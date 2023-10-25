package com.example.controller.UserController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestUserController {
    @RequestMapping("/forget")
    public String forget(){
        return "请联系社区工作人员";
    }
}
