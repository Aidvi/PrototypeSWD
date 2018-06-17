package swd.prototype.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import swd.prototype.model.entities.Meeting;
import swd.prototype.model.repositories.CustomerRepository;
import swd.prototype.model.repositories.MeetingRepository;

import java.util.List;

@RestController
@RequestMapping("/meetings")
public class JsonController {


    @Autowired
    MeetingRepository mRepo = new MeetingRepository();

    @GetMapping(value = "/all")
    public String getMeetings() {
        String jsonMsg = null;
        try {
            List<Meeting> meetings = mRepo.readAll();
            ObjectMapper mapper = new ObjectMapper();
            jsonMsg = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(meetings);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("hejsa");
        System.out.println(jsonMsg);
        return jsonMsg;
    }
}
