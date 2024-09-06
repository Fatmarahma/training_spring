package dev.spring.bootcamp.eventOrganizer.Event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class EventOrganizerApplication {

	private static final Logger log = LoggerFactory.getLogger(EventOrganizerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EventOrganizerApplication.class, args);

		log.info("Application running!");

     var helloworld = new HelloWorld();
		System.out.println(helloworld.sayHelloWorld());

	}
//	@Bean
//	CommandLineRunner runner(
//	){
//		return args -> {
//			Event event = new Event(1,"konser A", LocalDateTime.now(),LocalDateTime.now().plusHours(5),1000, Location.JAKARTA);
//			log.info("Event: "+ event);
//		};
//	}

}
