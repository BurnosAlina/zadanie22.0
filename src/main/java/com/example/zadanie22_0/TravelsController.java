package com.example.zadanie22_0;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TravelsController {

    private MailService mailService;

    public TravelsController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/contact")
    String contact() {
        return "contact";
    }

    @PostMapping("/send")
    String sendEmail(@RequestParam String name,
                     @RequestParam String email,
                     @RequestParam String mailText) {
        mailService.send(name, email, mailText);
        return "sent";
    }
}
