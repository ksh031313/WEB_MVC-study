package me.seung.demowebmvc;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/events")
public class EventApi {

    @PostMapping
    public Event createEvent(HttpEntity<Event> request) {
        //save
        // body뿐아니라 head도 접근가능
        //request.getHeaders().getContentType();
        return request.getBody();
    }

    @PostMapping
    public Event createEvent2(@RequestBody Event event) {
        //save
        return event;
    }
}
