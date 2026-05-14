package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserManagementResponse;
import com.beust.ah.A;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)
public class FetchUserDetailsAPITest {
    @Test
    public void fetchUserDetailsTest(){
        LoginRequest loginRequest = new LoginRequest("annaduraiashokkumar5@gmail.com", "Ashok@1234");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        UserManagementService userManagementService = new UserManagementService();
        response = userManagementService.fetchProfileDetails(loginResponse.getToken());
        UserManagementResponse userManagementResponse = response.as(UserManagementResponse.class);
        System.out.println(response.asPrettyString());
        Assert.assertNotNull(userManagementResponse.getEmail());
    }

}
