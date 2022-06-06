package com.example.monnifyintegration.service;

import com.example.monnifyintegration.DTOs.ResponseDto;
import com.example.monnifyintegration.DTOs.TokenDto;
import com.example.monnifyintegration.converters.MonnifyConverter;
import com.example.monnifyintegration.enums.HttpMethods;
import com.example.monnifyintegration.service.ports.IRequestService;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class RequestService implements IRequestService {

    public ResponseDto sendRequest(TokenDto tokenDto, String uri, HttpMethods method, Class resBodyClass, String... body) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + (tokenDto.getToken()));
        HttpRequest request = null;
        switch (method){
            case GET:
                request = builder.GET().build();
                break;
            case POST:
                request = builder.POST(HttpRequest.BodyPublishers.ofString(body[0])).build();
                break;
            case DELETE:
                request = builder.DELETE().build();
                break;
            default:
                break;
        }
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        return  MonnifyConverter.GetResponseData(response.body(),resBodyClass);
    }

}
