package controller;

import business.SendGridService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/mail")
public class SendGridController {

    @PostMapping
    public IOException sendTestEmail() throws IOException {return SendGridService.sendTestMail();}

}
