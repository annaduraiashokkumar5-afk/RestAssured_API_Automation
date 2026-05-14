package com.api.base;

import com.api.models.request.UserManagementRequest;
import com.api.models.response.UserManagementResponse;
import io.restassured.response.Response;
import org.codehaus.groovy.control.io.ReaderSource;

public class UserManagementService extends BaseService{

    private static final String BASE_PATH = "api/users/";

    public Response fetchProfileDetails(String token){
        setAuthToken(token);
        return getRequest(BASE_PATH+"profile");
    }

    public Response updateUserProfile(String token, UserManagementRequest payload){
       setAuthToken(token);
       return putRequest(payload,BASE_PATH+"profile");
    }
}
