package top.silenttt.allInOne.sso.dao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.silenttt.allInOne.sso.model.AuthLevel;

@Repository
public interface AuthLevelMapRepository extends JpaRepository<AuthLevel,Long> {
}
