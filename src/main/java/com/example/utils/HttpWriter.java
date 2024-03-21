package com.example.utils;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ZAXIE
 * @date 2024/3/11 17:45
 * write
 */
public class HttpWriter {
    public static String write(HttpServletResponse response, String alertContent, String page) {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        out.print("<script>alert('" + alertContent + "');</script>");
        return page;
    }
}
