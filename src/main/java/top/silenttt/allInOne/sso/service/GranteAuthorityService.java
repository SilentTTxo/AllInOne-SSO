package top.silenttt.allInOne.sso.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import top.silenttt.allInOne.sso.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tangtao
 * @date 2019-02-20
 **/
@Service
public class GranteAuthorityService {

    private final Map<String,String> AUTH_MAP = new HashMap<>();

    {
        AUTH_MAP.put("-1","ROLE_USER");
        AUTH_MAP.put("0","ROLE_ADMIN");
    }

    public List<GrantedAuthority> getAuthorityList(User user) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(AUTH_MAP.get(user.getAuth())));
        return  grantedAuthorities;
    }
}
