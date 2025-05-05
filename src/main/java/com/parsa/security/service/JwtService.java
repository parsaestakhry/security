package com.parsa.security.service;

import org.springframework.stereotype.Service;

@Service
public class JwtService {

    public String generateToken() {
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6InZlbm9tIiwicGFzc3dvcmQiOiJ2ZW5vbSIsImlkIjo1fQ.O3owVOG7NSAchPvJkhEF8ryKmJdZ3lTxUD7slL8NSBY";
    }

}
