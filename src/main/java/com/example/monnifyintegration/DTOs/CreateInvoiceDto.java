package com.example.monnifyintegration.DTOs;

import lombok.Data;

import java.util.List;

public @Data class CreateInvoiceDto {

    private double amount; //M
    private String customerName; //M
    private String customerEmail; //M
    private String accountReference;
    private String description;
    private String currencyCode; //M
    private String contractCode; //M
    private String redirectUrl;
    private String invoiceReference; //M
    private List<String> paymentMethods;
    private String expiryDate;
}
