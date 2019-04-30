package top.silenttt.allInOne.sso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter;
import top.silenttt.allInOne.sso.filter.JwtAuthFilter;
import top.silenttt.allInOne.sso.service.AuthResultHandler;
import top.silenttt.allInOne.sso.service.ExceptionResolver;
import top.silenttt.allInOne.sso.service.JwtResultHandler;
import top.silenttt.allInOne.sso.service.UserDetailService;

/**
 * @author tangtao
 * @date 2019-02-18
 **/

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailService userDetailService;

    @Autowired
    AuthResultHandler authResultHandler;

    @Autowired
    JwtAuthFilter jwtAuthFilter;

    @Autowired
    JwtResultHandler jwtResultHandler;

    @Autowired
    ExceptionResolver exceptionResolver;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login", "/oauth/authorize", "/oauth/token_key").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin().failureHandler(authResultHandler).successHandler(authResultHandler).permitAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .httpBasic()
                .and().csrf().disable();

        http.addFilterBefore(jwtAuthFilter, LogoutFilter.class);
        http.exceptionHandling().authenticationEntryPoint(exceptionResolver).accessDeniedHandler(exceptionResolver);
    }

    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception{
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
    }

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("a132132"));
    }
}
