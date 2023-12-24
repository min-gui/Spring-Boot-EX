package io.security.basicsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class ViewController {

    @GetMapping
    @RequestMapping("/test/loginPage")
    public String loginForm() {
        return "html/loginForm";
    }
}
