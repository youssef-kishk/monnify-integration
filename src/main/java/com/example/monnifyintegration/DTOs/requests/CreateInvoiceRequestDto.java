package com.example.monnifyintegration.DTOs.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public @Data class CreateInvoiceRequestDto {
    @JsonProperty("amount") private double amount;
    @JsonProperty("customerName")  private String customerName;
    @JsonProperty("customerEmail") private String customerEmail;
    @JsonProperty("accountReference") private String accountReference;
    @JsonProperty("description") private String description;
}
