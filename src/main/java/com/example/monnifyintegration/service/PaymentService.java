package com.example.monnifyintegration.service;

import com.example.monnifyintegration.DTOs.*;
import com.example.monnifyintegration.DTOs.requests.CreateInvoiceRequestDto;
import com.example.monnifyintegration.DTOs.requests.InitRefundRequestDto;
import com.example.monnifyintegration.converters.PaymentConverter;
import com.example.monnifyintegration.enums.HttpMethods;
import com.example.monnifyintegration.service.ports.IAuthorizeService;
import com.example.monnifyintegration.service.ports.IPaymentService;
import com.example.monnifyintegration.service.ports.IRequestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PaymentService implements IPaymentService {

    private Configs config;

    private IAuthorizeService authorizeService;
    private IRequestService requestService;

    public PaymentService(Configs config,IAuthorizeService authorizeService,IRequestService requestService){
        this.config = config;
        this.authorizeService = authorizeService;
        this.requestService = requestService;
    }
    public ResponseDto createInvoice(CreateInvoiceRequestDto requestDto) {
        CreateInvoiceDto createInvoice = PaymentConverter.GetCreateInvoiceDtoFromRequest(requestDto);
        //set default fields
        createInvoice.setContractCode(config.getContractCode());
        createInvoice.setInvoiceReference(LocalDateTime.now().toString());
        createInvoice.setExpiryDate(LocalDateTime.now(ZoneOffset.UTC).plusMinutes(120).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        createInvoice.setPaymentMethods(List.of("ACCOUNT_TRANSFER"));
        createInvoice.setCurrencyCode("NGN");
        TokenDto tokenDto = authorizeService.Authorize();
        ResponseDto res = new ResponseDto();
        if(tokenDto != null){
            try {
                String requestBody = new ObjectMapper()
                        .writerWithDefaultPrettyPrinter()
                        .writeValueAsString(createInvoice);
                String uri = config.getBaseUrl() + "/api/v1/invoice/create";
                res = requestService.sendRequest(tokenDto,uri,HttpMethods.POST, InvoiceDto.class,requestBody);

                if(!res.isRequestSuccessful()) throw new Exception(res.getResponseMessage());
            }
            catch (Exception ex){
                res.setResponseMessage(ex.getMessage());
            }
        }
        return res;
    }

    public ResponseDto getInvoice(String invoiceReference){
        TokenDto tokenDto = authorizeService.Authorize();
        ResponseDto res = new ResponseDto();
        if(tokenDto != null){
            try {
                String uri = config.getBaseUrl() + "/api/v1/invoice/" + invoiceReference + "/details";
                res = requestService.sendRequest(tokenDto,uri,HttpMethods.GET, InvoiceDto.class);

                if(!res.isRequestSuccessful()) throw new Exception(res.getResponseMessage());
            }
            catch (Exception ex){
                res.setResponseMessage(ex.getMessage());
            }
        }
        return res;
    }

    public ResponseDto cancelInvoice(String invoiceReference){
        TokenDto tokenDto = authorizeService.Authorize();
        ResponseDto res = new ResponseDto();
        if(tokenDto != null){
            try {
                res = requestService.sendRequest(tokenDto,config.getBaseUrl() + "/api/v1/invoice/" + invoiceReference + "/cancel",HttpMethods.DELETE, InvoiceDto.class);
                if(!res.isRequestSuccessful()) throw new Exception(res.getResponseMessage());
            }
            catch (Exception ex){
                res.setResponseMessage(ex.getMessage());
            }
        }
        return res;
    }


}
