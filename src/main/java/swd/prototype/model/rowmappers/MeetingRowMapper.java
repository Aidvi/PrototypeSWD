package swd.prototype.model.rowmappers;

import org.springframework.jdbc.core.RowMapper;
import swd.prototype.model.entities.Meeting;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MeetingRowMapper implements RowMapper{

    public Meeting mapRow(ResultSet rs, int numRow) throws SQLException {

        Meeting meeting = new Meeting();
        meeting.setMeetingId(rs.getInt("meeting_id"));
        meeting.setTitle(rs.getString("title"));
        meeting.setSubject(rs.getString("subject"));
        meeting.setDetails(rs.getString("details"));
        meeting.setStart(rs.getTimestamp("start"));
        meeting.setEnd(rs.getTimestamp("end"));

        return meeting;
    }
}
