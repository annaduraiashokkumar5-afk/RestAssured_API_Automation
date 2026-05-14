package com.api.tests;

import com.api.base.AccountsService;
import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.AccountsResponse;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(com.api.listeners.TestListener.class)
public class FetchAllAccountDetailsAPITest {

    @Test
    public void fetchAllAccountDetailsTest(){
        LoginRequest loginRequest = new LoginRequest("annaduraiashokkumar5@gmail.com","Ashok@1234");
        AuthService auth = new AuthService();
        Response response = auth.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        AccountsService accountsService = new AccountsService();
        response = accountsService.fetchAllAccounts(loginResponse.getToken());
        List<AccountsResponse> accountsResponse = response.jsonPath().getList("",AccountsResponse.class);
        System.out.println(response.asPrettyString());
        System.out.println(accountsResponse.get(3).getAccountNumber());
        Assert.assertEquals(accountsResponse.get(3).getAccountNumber(),"8070595367");
    }
}
