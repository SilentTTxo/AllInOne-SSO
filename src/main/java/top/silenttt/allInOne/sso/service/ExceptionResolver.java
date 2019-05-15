package top.silenttt.allInOne.sso.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import top.silenttt.allInOne.sso.constant.BizException;
import top.silenttt.allInOne.sso.model.BaseResponse;
import top.silenttt.allInOne.sso.util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

import static top.silenttt.allInOne.sso.constant.ErrorCode.*;

/**
 * 统一异常拦截器
 */
@Service
public class ExceptionResolver implements HandlerExceptionResolver, AccessDeniedHandler, AuthenticationEntryPoint {
    private Logger ILOG = LoggerFactory.getLogger(this.getClass());

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView rs = new ModelAndView();
        try {
            BaseResponse bs;
            if(e instanceof BizException){
                bs = new BaseResponse(((BizException) e).getCode(),((BizException) e).getMsg());
            }
            else{
                bs = new BaseResponse(CHECK_CODE.UNKNOWN_ERROR,"unknown error");
            }
            JsonUtil.writeResponse(httpServletResponse,bs);
        }catch (Exception err){
            ILOG.error("exceptin handle err: ",err);
        }
        return rs;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        BaseResponse bs = new BaseResponse(BASE_CODE.UNAUTH,"Unauthorized");
        JsonUtil.writeResponse(response,bs);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        BaseResponse bs = new BaseResponse(BASE_CODE.UNAUTH,"permission denied");
        JsonUtil.writeResponse(response,bs);
    }
}
