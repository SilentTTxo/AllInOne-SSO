package top.silenttt.allInOne.sso.dao;

import top.silenttt.allInOne.sso.model.User;

public interface UserAuthDao {
    User find(String username);
}
