package com.trupper.technical.test.ordenes.compra.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface JwtService {
    public String generateToken(UserDetails userDetails);
    public long getExpirationTime();
    public boolean isTokenValid(String token, UserDetails userDetails);
    public String extractUsername(String token);
}
