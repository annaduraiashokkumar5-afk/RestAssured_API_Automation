package com.api.tests;

import com.api.base.AuthService;
import com.api.models.response.ForgotPasswordResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordAPITest {


    @Test
    public void forgotPasswordTest(){
        AuthService auth = new AuthService();
        Response response = auth.forgotPassword("annaduraiashokkumar5@gmail.com");
        ForgotPasswordResponse forgotPasswordResponse = response.as(ForgotPasswordResponse.class);

        System.out.println(response.asPrettyString());
        System.out.println(forgotPasswordResponse.getMessage());
        Assert.assertEquals(forgotPasswordResponse.getMessage(), "If your email exists in our system, you will receive reset instructions.");
    }
}
