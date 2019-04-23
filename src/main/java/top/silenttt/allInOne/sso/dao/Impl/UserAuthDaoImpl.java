package top.silenttt.allInOne.sso.dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.silenttt.allInOne.sso.dao.Repository.UserRepository;
import top.silenttt.allInOne.sso.dao.UserAuthDao;
import top.silenttt.allInOne.sso.model.User;

@Component
public class UserAuthDaoImpl implements UserAuthDao {
    @Autowired
    UserRepository userRepository;

    @Override
    public User find(String username) {
        return userRepository.findByUsername(username);
    }
}
