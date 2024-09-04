package com.demo.api.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

public class HttpRequestUtil {

    private static final String[] IP_HEADER_CANDIDATES = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR"
    };

    //각자의 프록시 서버가 있을 경우, 프록시 서버 따라 proxy-header 를 설정 해야 된다. 예 Nginx : X-Real-IP, X-Forwarded-For
    public static String getClientIpAddress() {

        if (Objects.isNull(RequestContextHolder.getRequestAttributes())) {
            return "0.0.0.0";
        }

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        for (String header: IP_HEADER_CANDIDATES) {
//            String ipFromHeader = request.getHeader(header);
//            if (Objects.nonNull(ipFromHeader) && ipFromHeader.length() != 0 && !"unknown".equalsIgnoreCase(ipFromHeader)) {
//                String ip = ipFromHeader.split(",")[0];
//                return ip;
//            }
//        }
        return request.getRemoteAddr();
    }
}
