package dev.spring.bootcamp.eventOrganizer.Event;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

public record Event(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startOn,
        LocalDateTime completeOn,
        @Positive
        Integer participant,
        Location location
) {
//    public Integer getId (){
//        return id;
//    }
        public Event{
                if (!completeOn.isAfter(startOn)){
                        throw new IllegalArgumentException("Complete must be after start");
                }
        }
}
