package io.security.basicsecurity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SecurityController {


    @GetMapping("/")
    public String index() {
        log.info("테스트 입니다.1");
        return "home";
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        log.info("테스트 입니다.");
        return "redirect:/loginForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        log.info("테스트 입니다.");
        return "html/loginForm";
    }

    @GetMapping("/test")
    public void test() {

        log.info("테스트 입니다.");
        throw new RuntimeException("test");
    }
}
