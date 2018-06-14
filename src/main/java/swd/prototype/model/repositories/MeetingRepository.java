package swd.prototype.model.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import swd.prototype.model.entities.Meeting;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MeetingRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    public void createMeeting(Meeting meeting){
        String SQL = "INSERT INTO meeting (title, subject, details, dateTime, customerFK) VALUES (:title, :subject, :details, :dateTime, :customerFK)";
        Map namedParameters = new HashMap();
        namedParameters.put("title", meeting.getTitle());
        namedParameters.put("subject", meeting.getSubject());
        namedParameters.put("details", meeting.getDetails());
        namedParameters.put("dateTime", meeting.getDateTime());
        namedParameters.put("customerFK", meeting.getCustomerFK());
        System.out.println("test");
        System.out.println(template);
        System.out.println("test");

        template.update(SQL, namedParameters);

    }
}