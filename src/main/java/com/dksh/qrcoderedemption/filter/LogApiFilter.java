package com.dksh.qrcoderedemption.filter;


import com.dksh.qrcoderedemption.controller.QRCodeRedemptionController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogApiFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(OncePerRequestFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {

        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);
        chain.doFilter(requestWrapper, responseWrapper);

        logAPI(request, response);
        logBody(requestWrapper, responseWrapper);

        responseWrapper.copyBodyToResponse();
    }

    private void logAPI(HttpServletRequest request, HttpServletResponse response) {
        int httpStatus = response.getStatus();
        String httpMethod = request.getMethod();
        String uri = request.getRequestURI();
        String params = request.getQueryString();

        if (params != null) {
            uri += "?" + params;
        }
        LOGGER.info(String.join(" ", String.valueOf(httpStatus), httpMethod, uri));
        System.out.println(String.join(" ", String.valueOf(httpStatus), httpMethod, uri));
    }

    private void logBody(ContentCachingRequestWrapper request, ContentCachingResponseWrapper response) {
        String requestBody = getContent(request.getContentAsByteArray());
        System.out.println("Request: " + requestBody);
        LOGGER.info("Request: " + requestBody);
        String responseBody = getContent(response.getContentAsByteArray());
        System.out.println("Response: " + responseBody);
        LOGGER.info("Response: " + responseBody);
    }

    private String getContent(byte[] content) {
        String body = new String(content);
        return body.replaceAll("[\n\t]", "");
    }

}
