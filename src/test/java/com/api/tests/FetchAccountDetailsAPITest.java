package com.api.tests;

import com.api.base.AccountsService;
import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.AccountsResponse;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FetchAccountDetailsAPITest {

    @Test
    public void fetchAccountDetailsTest(){
        LoginRequest loginRequest = new LoginRequest("annaduraiashokkumar5@gmail.com","Ashok@1234");
        AuthService auth = new AuthService();
        Response response = auth.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        AccountsService accountsService = new AccountsService();
        response = accountsService.fetchAccounts(loginResponse.getToken(),"7864731230");
        AccountsResponse accountsResponse = response.as(AccountsResponse.class);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(accountsResponse.getStatus(),"ACTIVE");
    }
}
