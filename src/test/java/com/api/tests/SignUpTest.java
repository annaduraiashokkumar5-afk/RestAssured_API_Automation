package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.api.listeners.TestListener.class)
public class SignUpTest {


    @Test
    public void createSignUpTest(){
        SignUpRequest signUpRequest=new SignUpRequest.Builder()
                .username("annadurai7")
                .email("annaduraiashokkumar7@gmail.com")
                .firstName("Ashok")
                .lastName("Kumar")
                .password("Test@123")
                .mobileNumber("9003869315")
                .build();
        AuthService authService = new AuthService();
        Response response=authService.signUp(signUpRequest);
        System.out.println(response.asPrettyString());
    }
}
