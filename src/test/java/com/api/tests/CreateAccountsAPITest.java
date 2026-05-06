package com.api.tests;

import com.api.base.AccountsService;
import com.api.base.AuthService;
import com.api.models.request.AccountsRequest;
import com.api.models.request.LoginRequest;
import com.api.models.response.AccountsResponse;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountsAPITest {

    @Test
    public void createAccountsTest(){
        LoginRequest loginRequest = new LoginRequest("annaduraiashokkumar5@gmail.com","Ashok@1234");
        AuthService auth = new AuthService();
        Response response = auth.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        AccountsRequest accountsRequest = new AccountsRequest("SAVINGS", "MAIN_BRANCH");
        AccountsService accountsService = new AccountsService();
        response = accountsService.accounts(loginResponse.getToken(),accountsRequest);
        AccountsResponse accountsResponse = response.as(AccountsResponse.class);
        System.out.println(response.asPrettyString());
        System.out.println(accountsResponse.getBranch());
        Assert.assertEquals(accountsResponse.getAccountType(),"SAVINGS");
        Assert.assertEquals(accountsResponse.getBranch(),"MAIN_BRANCH");
    }
}
