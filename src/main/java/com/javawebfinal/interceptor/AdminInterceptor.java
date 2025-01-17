package com.javawebfinal.interceptor;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
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
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("未登录，2秒后跳转登录页");
            // 跳转登录页
            resp.setHeader("refresh", "2;url=/login.html");
            return false;
        }

        // 解析jwt，如果解析失败，返回错误结果（未登录）。
        try {
            JwtUtils.parseJWT(jwt);
            // base64解码
            String[] split = jwt.split("\\.");
            String payload = new String(java.util.Base64.getDecoder().decode(split[1]));
            // JSON解析，判断是否为管理员
            JSONObject jsonObject = JSON.parseObject(payload);
            String role = jsonObject.getString("role");
            if (!"1".equals(role)) {
                log.warn("拦截请求：非管理员用户");
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("非管理员用户，禁止访问");
                return false;
            }
            
        } catch (Exception e) {//jwt解析失败
            log.warn("拦截请求：jwt解析失败", e);
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("令牌错误，请重新登录");
            // 跳转登录页
            resp.setHeader("refresh", "2;url=/login.html");
            return false;
        }
        //log.info("放行请求");
        return true;
    }
}