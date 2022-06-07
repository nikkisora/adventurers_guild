package com.guild.backend.service;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}