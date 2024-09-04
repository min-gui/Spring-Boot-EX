package com.demo.api.controller;

import com.demo.api.util.HttpRequestUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = {"/"})
public class MainTestController {

    @GetMapping("/test")
    @Operation(summary = "테스트", description = "테스트 입니다.")
    public void mainTestV1(@RequestParam(name = "request") String request){
        String ip = HttpRequestUtil.getClientIpAddress();
        RequestContextHolder.getRequestAttributes();
        log.info("ip : {}", ip);
        log.info("request : {}", request);
    }
}
