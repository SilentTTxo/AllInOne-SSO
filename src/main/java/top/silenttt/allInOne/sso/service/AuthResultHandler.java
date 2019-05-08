package top.silenttt.allInOne.sso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import top.silenttt.allInOne.sso.dao.Repository.UserRepository;
import top.silenttt.allInOne.sso.model.BaseResponse;
import top.silenttt.allInOne.sso.model.User;
import top.silenttt.allInOne.sso.util.JsonUtil;
import top.silenttt.allInOne.sso.util.JwtUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static top.silenttt.allInOne.sso.constant.ErrorCode.CHECK_CODE.LOGIN_ERROR;

/**
 * 认证结果后续处理handler
 */
@Service
public class AuthResultHandler implements AuthenticationSuccessHandler, AuthenticationFailureHandler {

    @Autowired
    UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        BaseResponse rs = new BaseResponse();

        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user =  userRepository.findByUsername(userDetails.getUsername());
        String token = JwtUtil.encodeAccessToken(user.getUsername(),user.getAuth());

        rs.setValue(token);
        JsonUtil.writeResponse(response,rs);
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        BaseResponse rs = new BaseResponse(LOGIN_ERROR,"login failed");
        JsonUtil.writeResponse(response,rs);
    }
}
