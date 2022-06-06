package com.example.monnifyintegration.service.ports;

import com.example.monnifyintegration.DTOs.ResponseDto;
import com.example.monnifyintegration.DTOs.requests.CreateInvoiceRequestDto;

public interface IPaymentService {
    ResponseDto createInvoice(CreateInvoiceRequestDto requestDto);
    ResponseDto getInvoice(String invoiceReference);
    ResponseDto cancelInvoice(String invoiceReference);
}
