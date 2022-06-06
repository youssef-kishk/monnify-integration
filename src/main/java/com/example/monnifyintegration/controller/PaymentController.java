package com.example.monnifyintegration.controller;

import com.example.monnifyintegration.DTOs.ResponseDto;
import com.example.monnifyintegration.DTOs.requests.CreateInvoiceRequestDto;
import com.example.monnifyintegration.DTOs.requests.InitRefundRequestDto;
import com.example.monnifyintegration.service.ports.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @PostMapping("/invoice")
    public ResponseEntity<ResponseDto> createInvoice(@RequestBody CreateInvoiceRequestDto dto){

        ResponseDto res = paymentService.createInvoice(dto);
        HttpStatus code = HttpStatus.CREATED;
        if(res == null || !res.isRequestSuccessful()) code = HttpStatus.BAD_REQUEST;

        return new ResponseEntity<>(res, code);
    }

    @GetMapping("/invoice/{invoiceReference}")
    public  ResponseEntity<ResponseDto> getInvoiceDetails(@PathVariable String invoiceReference){
        ResponseDto res = paymentService.getInvoice(invoiceReference);
        HttpStatus code = HttpStatus.OK;
        if(res == null || !res.isRequestSuccessful()) code = HttpStatus.BAD_REQUEST;

        return new ResponseEntity<>(res, code);
    }

    @DeleteMapping("/invoice/{invoiceReference}")
    public ResponseEntity<ResponseDto> cancelInvoice(@PathVariable String invoiceReference){
        ResponseDto res = paymentService.cancelInvoice(invoiceReference);
        HttpStatus code = HttpStatus.OK;
        if(res == null || !res.isRequestSuccessful()) code = HttpStatus.BAD_REQUEST;

        return new ResponseEntity<>(res, code);
    }

    @PostMapping("/refund")
    public ResponseEntity<ResponseDto> initateRefund(@RequestBody InitRefundRequestDto dto){
        // TBD
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

}
