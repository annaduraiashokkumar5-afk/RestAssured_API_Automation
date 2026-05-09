package com.api.Filter;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingFilter implements Filter {

    private static final Logger Logger = LogManager.getLogger(LoggingFilter.class);
    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {
       logRequest(filterableRequestSpecification);
       Response response = filterContext.next(filterableRequestSpecification, filterableResponseSpecification);
       logResponse(response);
        return response;  //test for assertion
    }

    public void logRequest(FilterableRequestSpecification filterableRequestSpecification){
        Logger.info("BASE URI:"+ filterableRequestSpecification.getBaseUri());
        Logger.info("Request Header:"+ filterableRequestSpecification.getHeaders());
        Logger.info("Request PayLoad:"+ filterableRequestSpecification.getBody());

    }
    public void logResponse(Response response){
        Logger.info("Status Code:"+ response.getStatusCode());
        Logger.info("Response Header:"+ response.getHeaders());
        Logger.info("Response Body:"+ response.getBody().prettyPrint());
    }
}
