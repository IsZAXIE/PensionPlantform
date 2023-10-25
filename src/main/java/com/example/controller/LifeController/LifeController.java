package com.example.controller.LifeController;

import com.example.Service.ElderService.SocialService;
import com.example.pojo.Post;
import com.example.utils.MyTime;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LifeController {

    @Autowired
    SocialService socialService;

    @RequestMapping("/life")
    public String life(Model model){
        model.addAttribute("posts",socialService.getAllPost());
        return "elder/life/post";
    }

    @GetMapping("/newPost")
    public String newPostGet(){
        return "elder/life/newPost";
    }

    @PostMapping("/newPost")
    public String newPostPost(Post post, HttpSession session){

        // post.publisherName is encrypted id although name is 'name'
        post.setPublisherName((String) session.getAttribute("userId"));
        post.setTime(MyTime.getTime());
        System.out.println("LifeController : newPost = "+post);
        socialService.saveNewPost(post);
        return "redirect:/life";
    }

    @RequestMapping("/postFinish")
    public String postFinish(@RequestBody String str){
        System.out.println(str);
        return "elder/life/post";
    }
    @RequestMapping("/fees")
    public String fees(){
        return "elder/fee/lifeFee";
    }

    @RequestMapping("/personalChat")
    public String personalChat(){
        return "elder/life/personalChat";
    }


}
