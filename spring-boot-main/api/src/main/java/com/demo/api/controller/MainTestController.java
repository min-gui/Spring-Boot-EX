package com.demo.api.controller;

import com.demo.api.model.res.TestResponse;
import com.demo.api.service.TestService;
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

    private final TestService testService;

    @GetMapping("/test")
    @Operation(summary = "테스트", description = "테스트 입니다.")
    public void mainTestV1(@RequestParam(name = "request") String request){
        String ip = HttpRequestUtil.getClientIpAddress();
        RequestContextHolder.getRequestAttributes();
        log.info("ip : {}", ip);
        log.info("request : {}", request);

        testService.testVoid();

    }

    @GetMapping("/test2")
    @Operation(summary = "테스트2", description = "테스트 입니다.")
    public TestResponse mainTestV2(@RequestParam(name = "request") String request){
        String ip = HttpRequestUtil.getClientIpAddress();
        RequestContextHolder.getRequestAttributes();
        log.info("ip : {}", ip);
        log.info("request : {}", request);

        return TestResponse.builder().resultCode("0000").build();
    }
}
