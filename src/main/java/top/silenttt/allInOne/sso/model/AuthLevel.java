package top.silenttt.allInOne.sso.model;

import javax.persistence.*;

/**
 * 权限等级表（角色表）
 * 约定默认权限为：
 *      0 ：普通用户
 *      1 ：系统管理员
 * 可根据后续需要按序增添权限
 */
@Entity
@Table(name="auth_level_map")
public class AuthLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "role",length = 20)
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
