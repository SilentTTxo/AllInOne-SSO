package top.silenttt.allInOne.sso.dao.Repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import top.silenttt.allInOne.sso.model.User;

/**
 * @author tangtao
 * @date 2019-02-18
 **/

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
