package top.silenttt.allInOne.sso.service.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import top.silenttt.allInOne.sso.constant.BizException;
import top.silenttt.allInOne.sso.constant.ErrorCode;
import top.silenttt.allInOne.sso.dao.Repository.UserPrivateInfoRepository;
import top.silenttt.allInOne.sso.dao.Repository.UserRepository;
import top.silenttt.allInOne.sso.model.User;
import top.silenttt.allInOne.sso.model.UserPrivateInfo;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    public BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserPrivateInfoRepository userPrivateInfoRepository;

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

    public User save(User user){
        return userRepository.save(user);
    }

    public void singup(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // TODO: 魔法值
        user.setAuth(0);
        user.setGmtCreateTime(new Date());
        user.setGmtModifyTime(new Date());
        user.setUserPrivateInfo(new UserPrivateInfo());

        if(userRepository.findByUsername(user.getUsername()) != null){
            throw new BizException(ErrorCode.CHECK_CODE.REGIST_ERROR,"username already exist");
        }

        save(user);
    }

    public UserPrivateInfo updatePrivateInfo(UserPrivateInfo info){
        String username = (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new BizException(ErrorCode.BIZ_CODE.BIZ_ERROR,"can not find user");
        }
        info.setId(user.getUserPrivateInfo().getId());
        return userPrivateInfoRepository.save(info);
    }
}
