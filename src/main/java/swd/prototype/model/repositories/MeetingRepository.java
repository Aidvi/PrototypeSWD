package swd.prototype.model.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import swd.prototype.model.entities.Meeting;
import swd.prototype.model.rowmappers.CustomerRowMapper;
import swd.prototype.model.rowmappers.MeetingRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MeetingRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    public void createMeeting(Meeting meeting){
        String SQL = "INSERT INTO meeting (title, subject, details, startDime, endDate, customerFK) VALUES (:title, :subject, :details, :startDate, endDate, :customerFK)";
        Map namedParameters = new HashMap();
        namedParameters.put("title", meeting.getTitle());
        namedParameters.put("subject", meeting.getSubject());
        namedParameters.put("details", meeting.getDetails());
        namedParameters.put("startDate", meeting.getStart());
        namedParameters.put("endDate", meeting.getEnd());



        template.update(SQL, namedParameters);

    }


    public List readAll(){

        String sql = "SELECT * FROM meeting";

        List meetings = (List) template.query(sql, new MeetingRowMapper( ));

        return meetings;
    }
}
