package com.example.monnifyintegration.controller;

import com.example.monnifyintegration.DTOs.Configs;
import com.example.monnifyintegration.DTOs.CreateInvoiceDto;
import com.example.monnifyintegration.DTOs.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticateController {

    private Configs config;


    public AuthenticateController(Configs config){
        this.config = config;
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDto> login(@RequestBody CreateInvoiceDto dto){
        //to do
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
