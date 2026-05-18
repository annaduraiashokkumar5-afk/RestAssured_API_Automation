package com.api.base;

import com.api.models.request.TransferFundRequest;
import io.restassured.response.Response;

public class TransactionService extends BaseService{

    private static final String BASE_PATH = "/api/transactions/";

    public Response transferFunds(String token, TransferFundRequest payload){
        setAuthToken(token);
        return postRequest(payload, BASE_PATH+"transfer");
    }
}
