package com.example.financeiro.controllers;

import com.example.financeiro.payload.HelloResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/financeiro")
public class FinanceiroController {

    @GetMapping(path = "/hello", produces = "application/json")
    @ApiResponse(description = "Say Hello")
    public HelloResponse getHelloResponse(){
        return HelloResponse.builder().text("Hello").build();
    }
}