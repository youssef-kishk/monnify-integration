package com.example.monnifyintegration.DTOs;

import lombok.Data;

public @Data class Configs {
    private String apiKey;
    private String apiSecret;
    private String baseUrl;
    private String contractCode;
    private String email;
    private String pass;
}
