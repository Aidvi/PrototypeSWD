package swd.prototype.model.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import swd.prototype.model.entities.Customer;
import swd.prototype.model.rowmappers.CustomerRowMapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    public List readAll(){

        String sql = "SELECT * FROM customer AS c INNER JOIN swdprototype.contact AS co ON c.contactFK = co.contact_id";

        List customerList = (List) template.query("SELECT * FROM customer AS c INNER JOIN swdprototype.contact AS co ON c.contactFK = co.contact_id", new CustomerRowMapper( ));

        return customerList;
    }

    public void create(Customer c) throws SQLException{

        try{
            String sql2 = "INSERT INTO contact (name, lastname, email, phone) " +
                    "VALUES (:name, :lastname, :email, :phone)";

            Map parameters2 = new HashMap<>();
            parameters2.put("name", c.getContact_name());
            parameters2.put("lastname", c.getContact_lastname());
            parameters2.put("email", c.getContact_email());
            parameters2.put("phone", c.getContact_phone());

            template.update(sql2, parameters2);

            String sql1 = "INSERT INTO customer (customer_id, cvr, company, streetadress, postalCode, contactFK) " +
                    "VALUES (LAST_INSERT_ID(), :cvr, :company, :streetadress, :postalCode, LAST_INSERT_ID()) ";
            Map parameters1 = new HashMap<>();

            parameters1.put("cvr", c.getCvr());
            parameters1.put("company", c.getCompany());
            parameters1.put("streetadress", c.getStreetadress());
            parameters1.put("postalCode", c.getPostelCode());


            template.update(sql1, parameters1);

        }catch (DataAccessException e){
            e.printStackTrace();
        }

    }

    public Customer read(int id){

        return null;
    }

    public int getIndex(){

        String sql = "SELECT FROM ";



        return 0;
    }


}
