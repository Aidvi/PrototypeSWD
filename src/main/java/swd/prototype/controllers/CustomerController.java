package swd.prototype.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import swd.prototype.model.entities.Customer;
import swd.prototype.model.repositories.CustomerRepository;

import java.sql.SQLException;

@Controller
public class CustomerController {

    @Autowired
    CustomerRepository cRepo = new CustomerRepository();

    @GetMapping("/readAll")
    public String getCustomerView(Model model){

        model.addAttribute("customerList", cRepo.readAll());
        model.addAttribute("customer", new Customer());

        return "customerView";
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

}
