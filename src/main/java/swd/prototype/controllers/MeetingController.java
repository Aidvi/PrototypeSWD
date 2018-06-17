package swd.prototype.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import swd.prototype.model.entities.Meeting;
import swd.prototype.model.repositories.CustomerRepository;
import swd.prototype.model.repositories.MeetingRepository;

import javax.servlet.http.HttpSession;



@Controller
public class MeetingController {

    @Autowired
    MeetingRepository mRepo = new MeetingRepository();

    @Autowired
    CustomerRepository cRepo = new CustomerRepository();


    @GetMapping("/createMeeting")
    public String createMeeting(Model model, HttpSession session){
        model.addAttribute("meeting", new Meeting());
        model.addAttribute("customers", cRepo.readAll());

        if (sessionCheck(session)){
            return "createMeeting";
        } else {
            return "login";
        }
    }

    @PostMapping("/createMeeting")
    public String createMeeting(@ModelAttribute Meeting meeting, HttpSession session){

        System.out.println(meeting.toString());

        mRepo.createMeeting(meeting);

        if (sessionCheck(session)){
            return "createMeeting";
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
