package top.silenttt.allInOne.sso.service.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import top.silenttt.allInOne.sso.dao.Repository.UserRepository;
import top.silenttt.allInOne.sso.model.User;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getUserListByPage(Integer page,int count){
        return userRepository.findAll();
    }

    public List<User> getUserListByPage(int page){
        return getUserListByPage(page,20);
    }

    public User getUserById(long id){
        return userRepository.findById(id).get();
    }

    public User getSelf(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = (String)authentication.getPrincipal();
        return userRepository.findByUsername(username);
    }
}
