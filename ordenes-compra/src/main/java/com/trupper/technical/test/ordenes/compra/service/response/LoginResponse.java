package com.trupper.technical.test.ordenes.compra.service.response;

import lombok.*;

/**
 * Contains the token and the expiration time.
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class LoginResponse {
    private String token;

    private long expiresIn;
}
