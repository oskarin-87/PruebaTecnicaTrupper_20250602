package com.trupper.technical.test.ordenes.compra.service;

import com.trupper.technical.test.ordenes.compra.dto.LoginUserDto;
import com.trupper.technical.test.ordenes.compra.dto.RegisterUserDto;
import com.trupper.technical.test.ordenes.compra.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    public User signup(RegisterUserDto input);
    public User authenticate(LoginUserDto input);
}
