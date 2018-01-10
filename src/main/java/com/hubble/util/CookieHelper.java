package com.hubble.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieHelper {
    public void addCookie(HttpServletResponse response, String key, String value){
        Cookie cookie = new Cookie(key,value);
        cookie.setMaxAge(10 * 365 * 24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
