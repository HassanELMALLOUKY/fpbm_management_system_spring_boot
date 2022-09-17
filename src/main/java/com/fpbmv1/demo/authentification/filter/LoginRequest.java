package com.fpbmv1.demo.authentification.filter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class LoginRequest {
    private String username;
    private String password;
}
