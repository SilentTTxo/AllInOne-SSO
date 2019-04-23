package top.silenttt.allInOne.sso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.silenttt.allInOne.sso.dao.UserAuthDao;
import top.silenttt.allInOne.sso.model.User;

import java.util.List;

/**
 * @author tangtao
 * @date 2019-02-18
 **/
@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    UserAuthDao userAuthDao;

    @Autowired
    GrantedAuthorityService granteAuthorityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userAuthDao.find(username);
        List<GrantedAuthority> authorities = granteAuthorityService.getAuthorityList(user);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
