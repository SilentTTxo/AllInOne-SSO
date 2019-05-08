package top.silenttt.allInOne.sso.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import top.silenttt.allInOne.sso.model.BaseResponse;
import top.silenttt.allInOne.sso.util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static top.silenttt.allInOne.sso.constant.ErrorCode.CHECK_CODE.*;

/**
 * jwt验证后续处理handler
 */
@Service
public class JwtResultHandler implements AuthenticationSuccessHandler, AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        BaseResponse rs = new BaseResponse(LOGIN_BAD_TOKEN,"token error");
        JsonUtil.writeResponse(response,rs);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        request.getRequestDispatcher(request.getRequestURI()).forward(request,response);
    }
}
