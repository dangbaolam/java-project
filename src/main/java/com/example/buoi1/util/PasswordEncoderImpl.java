package com.example.buoi1.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderImpl {
    public static void main(String[] args) {
      BCryptPasswordEncoder bCryptPasswordEncoder=  new BCryptPasswordEncoder();
      System.out.println(bCryptPasswordEncoder.encode("user"));
      System.out.println(bCryptPasswordEncoder.encode("admin"));
      System.out.println(bCryptPasswordEncoder.encode("password"));
      System.out.println(bCryptPasswordEncoder.encode("123456"));
    }
}
