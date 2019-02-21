package top.silenttt.allInOne.sso.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import top.silenttt.allInOne.sso.model.User;

/**
 * @author tangtao
 * @date 2019-02-18
 **/

@Mapper
public interface UserDao {
    public User find(User user);
}
