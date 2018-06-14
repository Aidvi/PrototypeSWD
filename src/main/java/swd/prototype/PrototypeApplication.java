package swd.prototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import swd.prototype.model.entities.Meeting;
import swd.prototype.model.repositories.MeetingRepository;

@SpringBootApplication
public class PrototypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrototypeApplication.class, args);

	}
}
