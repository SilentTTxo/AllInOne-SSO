package top.silenttt.allInOne.sso.dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.silenttt.allInOne.sso.dao.AuthLevelMapDao;
import top.silenttt.allInOne.sso.dao.Repository.AuthLevelMapRepository;
import top.silenttt.allInOne.sso.model.AuthLevel;

import java.util.List;

@Component
public class AuthLevelMapDaoImpl implements AuthLevelMapDao {
    @Autowired
    AuthLevelMapRepository authLevelMapRepository;

    @Override
    public List<AuthLevel> getAll() {
        return authLevelMapRepository.findAll();
    }
}
