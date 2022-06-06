package com.example.monnifyintegration.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

public @Data class ResponseDto implements Serializable {
    @JsonProperty("requestSuccessful")
    private boolean requestSuccessful;
    @JsonProperty("responseMessage")
    private String responseMessage;
    @JsonProperty("responseCode")
    private String responseCode;
    @JsonProperty("responseBody")
    private Object responseBody;
}
