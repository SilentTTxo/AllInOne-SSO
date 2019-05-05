package top.silenttt.allInOne.sso.model;

import javax.persistence.*;

@Entity
@Table(name = "user_private_info")
public class UserPrivateInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "sex",length = 20)
    private Integer sex;

    @Column(name = "age",length = 20)
    private Integer age;

    @Column(name = "email",length = 20)
    private String email;

    @Column(name = "tel",length = 20)
    private String tel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
