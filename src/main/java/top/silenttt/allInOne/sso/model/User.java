package top.silenttt.allInOne.sso.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;

/**
 * @author tangtao
 * @date 2019-02-18
 **/
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "username", nullable = false,length = 20)
    private String username;

    @Column(name = "password", nullable = false,length = 100)
    private String password;

    @Column(name = "auth", nullable = false,length = 20)
    private Integer auth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAuth() {
        return auth;
    }

    public void setAuth(Integer auth) {
        this.auth = auth;
    }
}
