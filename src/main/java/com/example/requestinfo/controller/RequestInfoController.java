package com.example.requestinfo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/rq-info")
public class RequestInfoController {

    @GetMapping
    public Map<String, String> getRequestInfo(HttpServletRequest request) {
        Map<String, String> response = new LinkedHashMap<>();
        response.put("getRemoteAddr", request.getRemoteAddr());
        response.put("getRemoteUser", request.getRemoteUser());
        response.put("getRemoteHost", request.getRemoteHost());
        response.put("getRemotePort", String.valueOf(request.getRemotePort()));
        response.put("getLocalAddr", request.getLocalAddr());
        response.put("getLocalName", request.getLocalName());

        response.put("getMethod", request.getMethod());
        response.put("getAuthType", request.getAuthType());
        response.put("getContextPath", request.getContextPath());
        response.put("getQueryString", request.getQueryString());

        response.put("getRequestURI", request.getRequestURI());

        response.put("getRequestedSessionId", request.getRequestedSessionId());
        response.put("getPathTranslated", request.getPathTranslated());
        response.put("getPathInfo", request.getPathInfo());
        response.put("getContentType", request.getContentType());

        response.put("getProtocol", request.getProtocol());


        response.put("getUserPrincipal", request.getUserPrincipal() == null ? null : request.getUserPrincipal().toString());
        response.put("getScheme", request.getScheme());
        response.put("getServerName", request.getServerName());

        response.put("getServerPort", String.valueOf(request.getServerPort()));
        response.put("getSession", request.getSession() == null ? null : request.getSession().toString());
        response.put("isRequestedSessionIdFromCookie", String.valueOf(request.isRequestedSessionIdFromCookie()));
        response.put("isRequestedSessionIdValid", String.valueOf(request.isRequestedSessionIdValid()));

        Cookie[] cookies = request.getCookies();
        response.put("getCookies", cookies == null ? null : Arrays.toString(cookies));


        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                System.out.println("================================");
                String header = headerNames.nextElement();

                String key = "Header: " + header;
                System.out.println(key);

                String value = "Value: " + request.getHeader(header);
                System.out.println(value);

                response.put(key, value);
            }
        }

        return response;

    }
}
