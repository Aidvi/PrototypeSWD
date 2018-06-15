package swd.prototype.model.rowmappers;

import org.springframework.jdbc.core.RowMapper;
import swd.prototype.model.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper {

    public User mapRow(ResultSet rs, int numRow) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));

        return user;
    }
}
