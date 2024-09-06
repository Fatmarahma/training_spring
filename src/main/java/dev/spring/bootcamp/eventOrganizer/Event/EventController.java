package dev.spring.bootcamp.eventOrganizer.Event;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class EventController {
//    @GetMapping("/hello")
//    String home() {
//        return "Hello,Guest!";
//    }
    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

//    GET ALL DATA
    @GetMapping
    public List<Event> findAll (){
        return eventRepository.findAll();
    }
//GET DATA BY ID
//    @GetMapping("/api/events/{id}")
//    Event findById(@PathVariable Integer id){
//        return eventRepository.findById(id);
//}

//GET DATA BY ID method2

    @GetMapping("/{id}")
    Event findById(@PathVariable Integer id){
        Optional<Event> event = eventRepository.findById(id);
        if (event.isEmpty()) {
            throw new EventNotFoundException();

        }
        return event.get();
    }

//    POST
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Event event){
        eventRepository.create(event);
    }



//    put
@ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update (@Valid @RequestBody Event event,
    @PathVariable Integer id) {
    eventRepository.update(event,id);
    }

//    DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        eventRepository.delete(id);
    }

    @GetMapping("/location")
      List<Event> findByLocation(
                @RequestParam String location) {
        return eventRepository.findByLocation(location);
        }
}
