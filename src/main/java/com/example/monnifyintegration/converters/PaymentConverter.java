package com.example.monnifyintegration.converters;

import com.example.monnifyintegration.DTOs.CreateInvoiceDto;
import com.example.monnifyintegration.DTOs.requests.CreateInvoiceRequestDto;

public final class PaymentConverter {

    public  static CreateInvoiceDto GetCreateInvoiceDtoFromRequest(CreateInvoiceRequestDto requestDto){
        CreateInvoiceDto createInvoice = new CreateInvoiceDto();
        createInvoice.setAmount(requestDto.getAmount());
        createInvoice.setCustomerName(requestDto.getCustomerName());
        createInvoice.setCustomerEmail(requestDto.getCustomerEmail());
        createInvoice.setAccountReference(requestDto.getAccountReference());
        createInvoice.setDescription(requestDto.getDescription());
        return createInvoice;
    }
}
