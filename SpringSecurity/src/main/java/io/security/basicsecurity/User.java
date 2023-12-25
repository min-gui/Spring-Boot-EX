package io.security.basicsecurity;

import lombok.Data;

@Data
public class User {

    private String username;
    private String password;
    private String email;
    private String age;
    private String role;

    private String provider;
    private String providerId;
}
