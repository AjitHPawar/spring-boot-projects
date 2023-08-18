package com.spring.jwt.requestresponse;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtResponse {

    private String jwtToken;
    private String username;
}
