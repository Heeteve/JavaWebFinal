package com.javawebfinal.interceptor;

import com.javawebfinal.util.JwtUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        /*String url = req.getRequestURL().toString();
        log.info("请求url: {}", url);
        // 获取Cookie
        Cookie[] cookies = req.getCookies();
        String jwt = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("jwt".equals(cookie.getName())) {
                    jwt = cookie.getValue();
                    break;
                }
            }
        }

        // 判断jwt令牌是否存在
        if (!StringUtils.hasLength(jwt)) {
            log.warn("拦截请求：Cookie为空");
            String s = "未登录，2秒后跳转登录页";
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write(s);
            // 跳转登录页
            resp.setHeader("refresh", "2;url=/login.jsp");
            return false;
        }

        // 解析jwt，如果解析失败，返回错误结果（未登录）。
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {//jwt解析失败
            e.printStackTrace();
            log.error("拦截请求：解析令牌失败");
            String s = "令牌错误，请重新登录";
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write(s);
            // 跳转登录页
            resp.setHeader("refresh", "2;url=/login.jsp");
            return false;
        }
        log.info("放行请求");*/
        return true;
    }
}