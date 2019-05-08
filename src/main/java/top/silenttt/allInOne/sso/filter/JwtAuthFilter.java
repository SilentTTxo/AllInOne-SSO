package top.silenttt.allInOne.sso.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import top.silenttt.allInOne.sso.model.User;
import top.silenttt.allInOne.sso.service.JwtResultHandler;
import top.silenttt.allInOne.sso.service.UserDetailService;
import top.silenttt.allInOne.sso.util.JwtUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * jwtToken验证过滤器
 */
@Component
public class JwtAuthFilter extends AbstractAuthenticationProcessingFilter {
    Logger ILOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserDetailService userDetailService;

    @Override
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    @Autowired
    public void setAuthenticationSuccessHandler(JwtResultHandler successHandler) {
        super.setAuthenticationSuccessHandler(successHandler);
    }

    @Autowired
    public void setAuthenticationFailureHandler(JwtResultHandler failureHandler) {
        super.setAuthenticationFailureHandler(failureHandler);
    }

    public static final String TOKEN_HEADER = "Authorization";
    private static RequestMatcher requestMatcher = new RequestHeaderRequestMatcher(TOKEN_HEADER);

    protected JwtAuthFilter() {
        super(requestMatcher);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        Jwt jwt;
        try {
            String token = request.getHeader(TOKEN_HEADER);
            jwt = JwtUtil.checkToken(token);
        }catch (IllegalArgumentException e){
            ILOG.error("bad token :{}");
            throw new BadCredentialsException("bad token");
        }

        User user = JwtUtil.getUser(jwt);
        UserDetails userDetails = userDetailService.loadUserByUser(user);

        return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
    }
}
