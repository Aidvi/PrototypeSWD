package swd.prototype.model.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import swd.prototype.model.entities.User;
import swd.prototype.model.rowmappers.userRowMapper;

@Repository
public class UserRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;


    public User readUser(User currentUser){
        String sql = "SELECT * FROM user WHERE name ='" + currentUser.getUsername() + "' AND password =  '"+ currentUser.getPassword() + "'";

        SqlParameterSource namedParameters = new MapSqlParameterSource("username", String.valueOf(currentUser.getUsername()));
        User user = (User)template.queryForObject(sql, namedParameters, new userRowMapper());


        return user;
    }
}
