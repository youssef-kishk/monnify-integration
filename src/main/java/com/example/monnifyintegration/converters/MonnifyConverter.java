package com.example.monnifyintegration.converters;

import com.example.monnifyintegration.DTOs.ResponseDto;
import com.example.monnifyintegration.DTOs.TokenDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public final class MonnifyConverter {
    public static ResponseDto GetResponseData(String content,Class bodyClass ) throws JsonProcessingException {
        ResponseDto res= new ObjectMapper().readValue(content, ResponseDto.class);
        res.setResponseBody(new ObjectMapper().convertValue(res.getResponseBody(), bodyClass));
        return res;
    }
}
