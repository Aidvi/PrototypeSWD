package swd.prototype.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import swd.prototype.model.entities.Meeting;
import swd.prototype.model.entities.User;
import swd.prototype.model.repositories.MeetingRepository;
import swd.prototype.model.repositories.UserRepository;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository = new UserRepository();

    @Autowired
    MeetingRepository meetingRepository = new MeetingRepository();

    @GetMapping(value = {"", "/", "index"})
    public String index(HttpSession session){

        if (sessionCheck(session)){
            return "calenderView";
        } else {
            return "login";
        }
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user",new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpSession session){
        User currentUser = userRepository.findUser(user);
        if (currentUser != null){

                session.setAttribute("status", "1");
                System.out.println("Logget på");
            } else {
                session.setAttribute("status", "0");
                System.out.println("Ikke logget på");
                return "login";
            }
        return "redirect:/calenderView";
    }
    @GetMapping("/calenderView")
    public String calenderView(HttpSession session){

        meetingRepository.createMeeting(new Meeting("", "", "", null, 1));

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
