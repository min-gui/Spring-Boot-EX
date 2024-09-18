package com.demo.api.controller

import com.demo.api.service.TestService
import com.demo.api.util.HttpRequestUtil
import io.swagger.v3.oas.annotations.Operation
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.RequestContextHolder

@RestController
@RequestMapping("/order")
class OrderController(private val testService: TestService) {
    private val log = LoggerFactory.getLogger(MainTestController::class.java)

    @GetMapping("/shop")
    @Operation(summary = "kotlin 테스트", description = "kotlin 테스트 입니다.")
    fun mainTestV1(@RequestParam(name = "request") request: String) {
        val ip = HttpRequestUtil.getClientIpAddress()
        RequestContextHolder.getRequestAttributes()
        log.info("ip : {}", ip)
        log.info("request : {}", request)

        testService.testVoid()
    }
}
