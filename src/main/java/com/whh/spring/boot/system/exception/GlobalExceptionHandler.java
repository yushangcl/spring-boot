package com.whh.spring.boot.system.exception;

import com.whh.spring.boot.utils.AbsResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常处理
 * <p>
 *
 * @author huahui.wu.
 *         Created on 2018/1/10.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    /**
     * 创建全局异常处理类：通过使用 @ControllerAdvice定义统一的异常处理类，而不是在每个Controller中逐个定义。@ExceptionHandler
     * 用来定义函数针对的异常类型，最后将Exception对象和请求URL映射到error.html中
     * @param req 请求信息
     * @param e 异常信息
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    /**
     * 自定义异常处理
     * @param req HttpServletRequest
     * @param e ServiceException
     * @return AbsResponse
     * @throws Exception
     */
    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public AbsResponse customErrorHandler(HttpServletRequest req, ServiceException e) throws Exception{
        AbsResponse abs = new AbsResponse();
        abs.setCode(e.getCode());
        abs.setData("");
        abs.setMsg(e.getMessage());
        return abs;
    }
}
