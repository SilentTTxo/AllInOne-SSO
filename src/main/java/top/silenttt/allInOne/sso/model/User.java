package top.silenttt.allInOne.sso.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * @author tangtao
 * @date 2019-02-18
 **/
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username", nullable = false,length = 20)
    private String username;

    @JsonIgnore
    @Column(name = "password", nullable = false,length = 100)
    private String password;

    @Column(name = "auth", nullable = false,length = 20)
    private Integer auth;

    @CreatedDate
    @Column(name = "gmt_create_time")
    private Date gmtCreateTime;

    @LastModifiedDate
    @Column(name = "gmt_modify_time")
    private Date gmtModifyTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_private_info_id")
    private UserPrivateInfo userPrivateInfo;

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

    public Date getGmtCreateTime() {
        return gmtCreateTime;
    }

    public void setGmtCreateTime(Date gmtCreateTime) {
        this.gmtCreateTime = gmtCreateTime;
    }

    public Date getGmtModifyTime() {
        return gmtModifyTime;
    }

    public void setGmtModifyTime(Date gmtModifyTime) {
        this.gmtModifyTime = gmtModifyTime;
    }

    public UserPrivateInfo getUserPrivateInfo() {
        return userPrivateInfo;
    }

    public void setUserPrivateInfo(UserPrivateInfo userPrivateInfo) {
        this.userPrivateInfo = userPrivateInfo;
    }
}
