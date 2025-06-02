package com.trupper.technical.test.ordenes.compra.dto;

import lombok.*;

/**
 * Contains the necessary information to register a user in the database.
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RegisterUserDto {
    private String email;

    private String password;

    private String fullName;
}