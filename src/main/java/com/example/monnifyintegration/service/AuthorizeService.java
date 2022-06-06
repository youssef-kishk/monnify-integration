package com.example.monnifyintegration.service;

import com.example.monnifyintegration.DTOs.Configs;
import com.example.monnifyintegration.DTOs.ResponseDto;
import com.example.monnifyintegration.DTOs.TokenDto;
import com.example.monnifyintegration.converters.MonnifyConverter;
import com.example.monnifyintegration.service.ports.IAuthorizeService;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

@Service
public class AuthorizeService implements IAuthorizeService {

    private Configs config;

    public AuthorizeService(Configs config){
        this.config = config;
    }

    public TokenDto Authorize() {
        String key = config.getApiKey() + ":" + config.getApiSecret();
        String clientIDSecretInBase64 = Base64.getEncoder().encodeToString(key.getBytes());
        ResponseDto res;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(config.getBaseUrl() + "/api/v1/auth/login"))
                    .header("accept", "application/json")
                    .header("Authorization", "Basic "+ clientIDSecretInBase64)
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            res = MonnifyConverter.GetResponseData(response.body(),TokenDto.class);
            if(!res.isRequestSuccessful()) throw new Exception("Auth request failed");
        }
        catch (Exception ex){
            System.out.println(ex);
            return null;
        }

        return  (TokenDto) res.getResponseBody();
    }
}
