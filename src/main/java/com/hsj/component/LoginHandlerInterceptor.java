package com.hsj.component;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>登陆拦截器<p/>
 * Created by 黄仕杰 on 2019/4/15.
 */
@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {
    /**
     * <p>登陆前<p/>
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    //@Override
    //public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       // Object o = request.getSession().getAttribute("user");
       // if (o == null) {
        //    request.setAttribute("msg", "先登录");
         //   request.getRequestDispatcher("/user/loginPage").forward(request, response);
         //   return false;
       // }else {
        //    return true;
        //}
    //}

    //@Override
    //public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    //}

    //@Override
    //public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    //}
}
