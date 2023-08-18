package com.spring.jwt.requestresponse;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtRequest {

    private String email;
    private String password;
}
