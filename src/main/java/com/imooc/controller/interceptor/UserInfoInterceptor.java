package com.imooc.controller.interceptor;

import com.imooc.exception.GraceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserInfoInterceptor implements HandlerInterceptor {

    /**
     * 拦截请求，访问 Controller 之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        String userId = request.getHeader("userId");
        String userToken = request.getHeader("userToken");
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(userToken)) {
//            log.error("用户校验不通过，信息不完整！");
            GraceException.display("用户校验不通过，信息不完整！");
            return false;
        }
        // 假设用户真实id=330,token=abc
        if (!userId.equalsIgnoreCase("330") || !userToken.equalsIgnoreCase("abc")) {
//            log.error("用户权限不通过，信息不完整！");
            GraceException.display("用户权限不通过，信息不完整！");
            return false;
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    /**
     * 请求访问到 Controller 之后，渲染视图之前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 请求访问到 Controller 之后，渲染视图之后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
