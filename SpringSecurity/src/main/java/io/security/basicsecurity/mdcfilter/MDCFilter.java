package io.security.basicsecurity.mdcfilter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@Component
public class MDCFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final String traceId = UUID.randomUUID().toString().substring(0,8);
        MDC.put(MDCKey.TRACE_ID.getKey(), traceId);
        filterChain.doFilter(servletRequest, servletResponse);

        MDC.remove(MDCKey.TRACE_ID.getKey());
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
