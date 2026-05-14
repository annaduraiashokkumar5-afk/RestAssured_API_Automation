package com.api.tests;

import com.api.base.AccountsService;
import com.api.base.AuthService;
import com.api.models.request.AccountsRequest;
import com.api.models.request.LoginRequest;
import com.api.models.response.AccountsResponse;
import com.api.models.response.LoginResponse;
import com.api.utils.LogUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.api.listeners.TestListener.class)
public class CreateAccountsAPITest {

    @Test
    public void createAccountsTest(){
        LogUtil.info("Starting the createAccountsTest");
        LoginRequest loginRequest = new LoginRequest("annaduraiashokkumar5@gmail.com","Ashok@1234");
        AuthService auth = new AuthService();
        Response response = auth.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        LogUtil.info("Login successful, token received: " + loginResponse.getToken());
        AccountsRequest accountsRequest = new AccountsRequest("SAVINGS", "MAIN_BRANCH");
        AccountsService accountsService = new AccountsService();
        response = accountsService.accounts(loginResponse.getToken(),accountsRequest);
        AccountsResponse accountsResponse = response.as(AccountsResponse.class);
        LogUtil.info("Account creation response received: " + response.asPrettyString());
        System.out.println(response.asPrettyString());
        System.out.println(accountsResponse.getBranch());
        Assert.assertEquals(accountsResponse.getAccountType(),"SAVINGS");
        LogUtil.pass("Account type assertion passed");
        Assert.assertEquals(accountsResponse.getBranch(),"MAIN_BRANCH");
        LogUtil.pass("Branch assertion passed");
    }
}
