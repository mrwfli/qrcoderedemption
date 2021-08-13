package com.dksh.qrcoderedemption.filter;

import com.dksh.qrcoderedemption.controller.QRCodeRedemptionController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogProcessTimeFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(OncePerRequestFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        long startTime = System.currentTimeMillis();
        chain.doFilter(request, response);
        long processTime = System.currentTimeMillis() - startTime;

        System.out.println(processTime + " ms");
        LOGGER.info(processTime + " ms");
    }
}
