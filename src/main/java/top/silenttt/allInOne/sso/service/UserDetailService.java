package top.silenttt.allInOne.sso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.silenttt.allInOne.sso.dao.UserDao;
import top.silenttt.allInOne.sso.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author tangtao
 * @date 2019-02-18
 **/
@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Autowired
    GranteAuthorityService granteAuthorityService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User query = new User();
        query.setUsername(s);
        User user = userDao.find(query);
        List<GrantedAuthority> authorities = granteAuthorityService.getAuthorityList(user);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
