package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.Events;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    private static List<String> events = new ArrayList<>();

    @GetMapping
    public String displayAllEvents(Model model) {
//        model.addAttribute("events", events);
        model.addAttribute("event", Arrays.asList(
                new Events("LaDee", "Dah"),
                new Events("BuccaDe", "Beppo"),
                new Events("Leedell", "Lee")
        ));
        return "events/eventsExerciseTable";
    }

    @GetMapping("create")
    public String displayCreateEventForm() {
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String eventName) {
        events.add(eventName);
        return "redirect:";
    }


}
