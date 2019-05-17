package top.silenttt.allInOne.sso.dao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.silenttt.allInOne.sso.model.UserPrivateInfo;

public interface UserPrivateInfoRepository extends JpaRepository<UserPrivateInfo,Long> {
}
