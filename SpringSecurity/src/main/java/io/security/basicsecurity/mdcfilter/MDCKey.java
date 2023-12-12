package io.security.basicsecurity.mdcfilter;


import lombok.Getter;

public enum MDCKey {
    TRACE_ID("traceId");

    @Getter
    private String key;

    MDCKey(String key) {
        this.key = key;
    }
}
