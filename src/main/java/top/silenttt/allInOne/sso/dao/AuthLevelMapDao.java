package top.silenttt.allInOne.sso.dao;

import top.silenttt.allInOne.sso.model.AuthLevel;

import java.util.List;

public interface AuthLevelMapDao {
    List<AuthLevel> getAll();
}
