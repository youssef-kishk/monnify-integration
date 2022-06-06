package com.example.monnifyintegration.service.ports;

import com.example.monnifyintegration.DTOs.ResponseDto;
import com.example.monnifyintegration.DTOs.TokenDto;
import com.example.monnifyintegration.enums.HttpMethods;

import java.net.URISyntaxException;

public interface IRequestService {
    ResponseDto sendRequest(TokenDto tokenDto, String uri, HttpMethods method, Class resBodyClass, String... body) throws Exception;
}
