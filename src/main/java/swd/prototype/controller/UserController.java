package swd.prototype.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import swd.prototype.model.repository.UserRepository;

public class UserController {

    @Autowired
    UserRepository userRepository = new UserRepository();

    @GetMapping("/")
    public String index(){
        return "index";
    }

    public String login(){
        return "";
    }
}
