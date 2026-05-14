package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.UserManagementRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserManagementResponse;
import com.beust.ah.A;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)
public class UpdateUserDetailsAPITest {

    @Test
    public void updateUserDetailsTest(){
        LoginRequest loginRequest = new LoginRequest("annaduraiashokkumar5@gmail.com","Ashok@1234");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        UserManagementRequest userManagementRequest = new UserManagementRequest("Arun","Raj","annaduraiashokkumar5@gmail.com","2269712345");
        UserManagementService userManagementService = new UserManagementService();
        response = userManagementService.updateUserProfile(loginResponse.getToken(),userManagementRequest);
        UserManagementResponse userManagementResponse = response.as(UserManagementResponse.class);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(userManagementResponse.getFirstName(),"Arun");
        Assert.assertEquals(userManagementResponse.getLastName(),"Raj");
        Assert.assertEquals(userManagementResponse.getMobileNumber(),"2269712345");


    }
}
