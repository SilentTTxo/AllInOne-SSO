package top.silenttt.allInOne.sso.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import top.silenttt.allInOne.sso.dao.AuthLevelMapDao;
import top.silenttt.allInOne.sso.model.AuthLevel;
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
public class GrantedAuthorityService {
    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AuthLevelMapDao authLevelMapDao;

    private Map<Integer,String> authMap;

    public List<GrantedAuthority> getAuthorityList(User user) {
        if(authMap == null){
            reloadAuthMap();
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(authMap.get(user.getAuth())));
        return  grantedAuthorities;
    }

    public void reloadAuthMap(){
        LOG.info("start reload auth map");
        List<AuthLevel> authLevelList = authLevelMapDao.getAll();
        Map<Integer,String> newAuthMap = new HashMap<>(authLevelList.size());

        for(AuthLevel authLevel : authLevelList){
            newAuthMap.put(authLevel.getId(),authLevel.getRole());
        }
        authMap = newAuthMap;
        LOG.info("end reload auth map ,auth size: {}",authLevelList.size());
    }
}
