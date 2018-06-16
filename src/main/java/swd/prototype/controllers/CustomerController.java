package swd.prototype.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import swd.prototype.model.entities.Customer;
import swd.prototype.model.repositories.CustomerRepository;
import javax.servlet.http.HttpSession;

import java.sql.SQLException;

@Controller
public class CustomerController {

    @Autowired
    CustomerRepository cRepo = new CustomerRepository();

    @GetMapping("/readAll")
    public String getCustomerView(Model model, HttpSession session){

        model.addAttribute("customerList", cRepo.readAll());
        model.addAttribute("customer", new Customer());


        if (sessionCheck(session)){
            return "customerView";
        } else {
            return "login";
        }
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute("customer") Customer c) throws SQLException{
        System.out.println(c);
        cRepo.create(c);

        return "redirect:/readAll";
    }

    @GetMapping("/read")
    public String getCustomer(){

        return "redirect:/readAll";
    }

    private boolean sessionCheck(HttpSession session){
        if(session.getAttribute("status") != null && session.getAttribute("status").equals("1")){
            return true;
        } else {
            return false;
        }
    }

}
