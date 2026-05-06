package com.api.tests;

import com.api.base.AuthService;

import com.api.models.request.LoginRequest;

import com.api.models.response.LoginResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginAPITest {
    //@Test(description = "Verify if Login API is working")
    public void loginTest(){
        RestAssured.baseURI="http://64.227.160.186:8080";
        RequestSpecification x =RestAssured.given();
        RequestSpecification y =x.header("Content-Type", "application/json");
        RequestSpecification z =y.body("{\"username\": \"annaduraiashokkumar5@gmail.com\",\"password\": \"Ashok@1234\"}");
        Response response=z.post("/api/auth/login");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(),200);
        
    }

    //@Test(description = "Verify if Login API is working")
    public void loginTest1(){
        Response response =  RestAssured.given().baseUri("http://64.227.160.186:8080")
                .header("Content-Type", "application/json")
                .body("{\"username\": \"annaduraiashokkumar5@gmail.com\",\"password\": \"Ashok@1234\"}")
                .post("/api/auth/login");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(),200);

    }
    @Test
    public void loginTest2(){
        LoginRequest loginRequest = new LoginRequest("annaduraiashokkumar5@gmail.com","Ashok@1234");
        AuthService auth = new AuthService();
        Response response = auth.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);

        System.out.println(response.asPrettyString());
        System.out.println(loginResponse.getEmail());
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertTrue(loginResponse.getToken() != null);
        Assert.assertEquals(loginResponse.getId(),5140);
    }


}
