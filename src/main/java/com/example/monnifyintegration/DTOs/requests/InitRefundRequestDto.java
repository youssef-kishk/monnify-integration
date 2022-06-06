package com.example.monnifyintegration.DTOs.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public @Data class InitRefundRequestDto {
    @JsonProperty("transactionReference") private String transactionReference;
    @JsonProperty("refundReference") private String refundReference;
    @JsonProperty("refundReason")  private String refundReason;
}
