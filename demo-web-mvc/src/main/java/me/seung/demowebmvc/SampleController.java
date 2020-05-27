package me.seung.demowebmvc;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
public class SampleController {

    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @GetMapping("/events/form")
    public String eventsForm(Model model) {
        Event newEvent = new Event();
        newEvent.setId(123);
        newEvent.setName("test123");
        model.addAttribute("event", newEvent);
        return "/events/form";
    }


    @GetMapping("/events/{id}")
    @ResponseBody
    public Event getEvent(@PathVariable Integer id) {
        Event event = new Event();
        event.setId(id);
        return event;
    }

    @PostMapping("/events2")
    @ResponseBody
    public Event getEvent2(@RequestParam String name) {
        Event event = new Event();
        event.setName(name);
        return event;
    }

    @PostMapping("/events/name")
    public String createEvent(@Validated @ModelAttribute Event event, BindingResult bindingResult
                                , RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(c ->{
                System.out.println(c.toString());
            });
            return "events/form";
        }
        // save

        //redirectAttributes.addAttribute("id", event.getId());
        //redirectAttributes.addAttribute("name", event.getName());
        redirectAttributes.addFlashAttribute("newEvent", event);
        return "redirect:/events/list";
    }

    @GetMapping("/events/list")
    public String listEvent(Model model,
                            //@RequestParam Integer id, @RequestParam String name,
                            @ModelAttribute("newEvent") Event newEvent ) {

        //Event newEvent = new Event();
        //newEvent.setId(id);
        //newEvent.setName(name);

        Event newEvent2 = (Event) model.asMap().get("newEvent");

        Event event = new Event();
        event.setId(000);
        event.setName("default");

        // select
        List<Event> eventList = new ArrayList<>();
        eventList.add(newEvent);
        eventList.add(newEvent2);
        eventList.add(event);
        model.addAttribute(eventList);

        return "/events/list";
    }
}
