package swd.prototype.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CalenderController {

    @GetMapping("/calenderView")
    public String calenderView(HttpSession session){



        if (sessionCheck(session)){
            return "calenderView";
        } else {
            return "login";
        }
    }

    private boolean sessionCheck(HttpSession session){
        if(session.getAttribute("status") != null && session.getAttribute("status").equals("1")){
            return true;
        } else {
            return false;
        }
    }
}
