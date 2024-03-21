package com.example.controller.UserController;


import com.alibaba.fastjson.JSONObject;
import com.example.Service.ElderService.SocialService;
import com.example.Service.UserService;
import com.example.pojo.Display;
import com.example.pojo.PAP;
import com.example.utils.AES;
import com.example.utils.HttpWriter;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    // use to get Announcement
    @Autowired
    SocialService socialService;


    @RequestMapping("/login")
    public void login(@RequestBody String s, Model model, HttpSession session, HttpServletResponse response) {
        Display display;
        JSONObject jsonObject = JSONObject.parseObject(s);
        PAP pap = new PAP();
        pap.setPhone(jsonObject.getObject("username", String.class));
        try {
            pap.setPwd(AES.encrypt(jsonObject.getObject("password", String.class)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        pap.setRole(jsonObject.getObject("role", String.class));
        System.out.println("pap : " + pap);
        /*
        // use only when test
        pap.setPhone("13012345678");
        pap.setPwd("DGYYLscQhABl66pHxebOkA==");
        display = userService.judgeAccountAndPassword(pap);
        */
        display = userService.judgeAccount(pap);


        //clean session
        session.removeAttribute("userId");
        session.removeAttribute("userAlias");
        session.removeAttribute("role");


        if(display==null){
            session.removeAttribute("msg");
            session.setAttribute("msg","账号或密码错误，请检查后重新输入");
            return ;
        }



        else  {
        System.out.println("LoginController :  display :"+display);
            session.setAttribute("userId", display.getId());
            session.setAttribute("userAlias", display.getAlias());
            session.removeAttribute("msg");
        }
        session.setAttribute("role", pap.getRole());

//        System.out.println("id = "+((Display)session.getAttribute("display")).getId());
//        System.out.println("alias = "+((Display)session.getAttribute("display")).getAlias());
//        return "elder/elderIndex";
    }


    // add element here
    @RequestMapping("/judgeLogin")
    public String loginSuccessfully(HttpSession session, Model model) {
        System.out.println("LoginController: session ::  userAlias :"+session.getAttribute("userAlias")+"; userId :"+session.getAttribute("userId"));
        String str = (String) session.getAttribute("userAlias");
        if (str == null) {
            model.addAttribute("warnMessage","账号或密码错误");
            return "login";
        }
        else {
            if (session.getAttribute("role").equals("elder")) {
                System.out.println("ELDER");
                model.addAttribute("alias", str);
                model.addAttribute("announcements", socialService.getAllAnnouncement());
                model.addAttribute("status", "非常健康");
//            model.addAttribute("alias",display.getAlias());
                return "elder/elderIndex";
            }
            // seller
            else if (session.getAttribute("role").equals("seller")) {
                model.addAttribute("alias",session.getAttribute("userAlias"));
                System.out.println("SELLER");
                return "seller/sellerMenu";
            }
            // community workers
            else if (session.getAttribute("role").equals("admin")) {
                model.addAttribute("alias",session.getAttribute("userAlias"));
                System.out.println("Admin");
                return "socialWorker/communityMenu";
            }
        }
        return "redirect:/login";
    }

    @RequestMapping("elder")
    public String returnIndex() {
        return "redirect:/judgeLogin";
    }


    @RequestMapping("/loginIndex")
    public String loginIndex(){
        return "login";
    }

}
