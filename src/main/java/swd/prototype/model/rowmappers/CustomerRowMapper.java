package swd.prototype.model.rowmappers;

import swd.prototype.model.entities.Customer;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper{

    public Customer mapRow(ResultSet rs, int numRow) throws SQLException {

        Customer customer = new Customer();
        customer.setCustomer_id(rs.getInt("customer_id"));
        customer.setCvr(rs.getString("cvr"));
        customer.setCompany(rs.getString("company"));
        customer.setStreetadress(rs.getString("streetadress"));
        customer.setPostelCode(rs.getString("postalCode"));
        customer.setContact_name(rs.getString("name"));
        customer.setContact_lastname(rs.getString("lastname"));
        customer.setContact_email(rs.getString("email"));
        customer.setContact_phone(rs.getString("phone"));

        return customer;
    }
}
