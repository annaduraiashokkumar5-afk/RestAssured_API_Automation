package com.api.base;

import com.api.models.request.AccountsRequest;
import io.restassured.response.Response;

public class AccountsService extends BaseService{

    private static final String BASE_PATH = "api/accounts";

    public Response accounts(String token, AccountsRequest payload){
        setAuthToken(token);
        return postRequest(payload, BASE_PATH);
    }
    public Response fetchAccounts(String token, String accountNumber){
        setAuthToken(token);
        return getRequest(BASE_PATH+"/"+accountNumber);
    }

    public Response fetchAllAccounts(String token){
        setAuthToken(token);
        return getRequest(BASE_PATH+"/user");
    }
}
