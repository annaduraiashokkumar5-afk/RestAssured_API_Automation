package com.api.tests;

import com.api.base.AuthService;
import com.api.base.TransactionService;
import com.api.models.request.LoginRequest;
import com.api.models.request.TransferFundRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.TransferFundResponse;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)
public class TransferFundAPITest {
    @Test
    public void transferFundTest(){
        LoginRequest loginRequest = new LoginRequest("annaduraiashokkumar5@gmail.com","Ashok@1234");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        TransferFundRequest transferFundRequest = new TransferFundRequest("7864540966", "7863604103", 50, "Test transfer");
        TransactionService transactionService = new TransactionService();
        response = transactionService.transferFunds(loginResponse.getToken(), transferFundRequest);
        TransferFundResponse transferFundResponse = response.as(TransferFundResponse.class);
        Assert.assertEquals(transferFundResponse.getStatus(), "SUCCESS");
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("TransferFundResponse_Schema.json"));
    }
}