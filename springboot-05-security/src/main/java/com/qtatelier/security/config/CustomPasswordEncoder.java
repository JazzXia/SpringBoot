package com.qtatelier.security.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author JazzXia
 * @create 2019-10-23-16:25
 * @email jazzxiaw@qq.com
 * @since 2019
 */
public class CustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
