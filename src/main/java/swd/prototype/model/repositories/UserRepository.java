package swd.prototype.model.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import swd.prototype.model.entities.User;
import swd.prototype.model.rowmappers.userRowMapper;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;
    
    public User findUser(User currentUser){

        String sql = "SELECT * FROM user WHERE username = :username AND password = :password";

        Map<String, String> parameters = new HashMap<>();
        parameters.put("username", currentUser.getUsername());
        parameters.put("password", currentUser.getPassword());

        User user = null;
        try {
            user = (User)template.queryForObject(sql, parameters, new userRowMapper());
        } catch (DataAccessException e) {
            System.out.println("Username and Password wrong");
        }

        return user;
    }
}
