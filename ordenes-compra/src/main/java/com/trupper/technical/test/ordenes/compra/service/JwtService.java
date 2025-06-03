package com.trupper.technical.test.ordenes.compra.service;

import com.trupper.technical.test.ordenes.compra.advise.TrackExecutionTime;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface JwtService {
    @TrackExecutionTime
    public String generateToken(UserDetails userDetails);
    @TrackExecutionTime
    public long getExpirationTime();
    @TrackExecutionTime
    public boolean isTokenValid(String token, UserDetails userDetails);
    @TrackExecutionTime
    public String extractUsername(String token);
}
