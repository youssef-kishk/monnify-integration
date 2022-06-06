package com.example.monnifyintegration.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public @Data class InvoiceDto {
    @JsonProperty("amount")  private double amount;
    @JsonProperty("invoiceReference") private String invoiceReference;
    @JsonProperty("invoiceStatus") private String invoiceStatus;
    @JsonProperty("description") private String description;
    @JsonProperty("accountReference") private String accountReference;
    @JsonProperty("contractCode") private String contractCode;

    @JsonProperty("customerEmail") private String customerEmail;
    @JsonProperty("customerName") private String customerName;
    @JsonProperty("expiryDate") private String expiryDate;
    @JsonProperty("createdBy") private String createdBy;
    @JsonProperty("createdOn") private String createdOn;
    @JsonProperty("accountNumber") private String accountNumber;
    @JsonProperty("accountName") private String accountName;
    @JsonProperty("bankName") private String bankName;
    @JsonProperty("bankCode") private String bankCode;
    @JsonProperty("redirectUrl") private String redirectUrl;

    @JsonProperty("transactionReference") private String transactionReference;
}
