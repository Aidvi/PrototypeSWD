package swd.prototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import swd.prototype.controllers.CustomerController;
import swd.prototype.controllers.MeetingController;
import swd.prototype.model.entities.Meeting;
import swd.prototype.model.repositories.MeetingRepository;

@SpringBootApplication
public class PrototypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrototypeApplication.class, args);

	}
}
