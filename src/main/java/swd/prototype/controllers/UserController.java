package swd.prototype.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import swd.prototype.model.entities.User;
import swd.prototype.model.repositories.UserRepository;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository = new UserRepository();

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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user, Model model, HttpSession session){
        User currentUser = userRepository.readUser(user);
        if (currentUser != null){

            PasswordService pwdService = new PasswordService();

            if (pwdService.checkMatch(user.getPassword(), currentUser.getPassword())){
                session.setAttribute("status", "1");
                System.out.println("Logget på");
            } else {
                session.setAttribute("status", "0");
                System.out.println("Ikke logget på");
                return "login";
            }
        }
        return "redirect:/index";
    }

    private boolean sessionCheck(HttpSession session){
        if(session.getAttribute("status") != null && session.getAttribute("status").equals("1")){
            return true;
        } else {
            return false;
        }
    }
}
