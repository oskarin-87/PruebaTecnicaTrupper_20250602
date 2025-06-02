package com.trupper.technical.test.ordenes.compra.dto;

import lombok.*;

/**
 * Contains the necessary information for a user to log in and obtain the token that will be used in requests.
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class LoginUserDto {
    private String email;

    private String password;
}
