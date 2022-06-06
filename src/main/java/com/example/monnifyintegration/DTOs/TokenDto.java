package com.example.monnifyintegration.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public @Data class TokenDto {

    @JsonProperty("accessToken")
    private String token;

    @JsonProperty("expiresIn")
    private double expiresIn;
}
