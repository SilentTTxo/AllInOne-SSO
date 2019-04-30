package top.silenttt.allInOne.sso.model.vo;

/**
 * 登陆用VO
 */
public class LoginVo {
    private String token;

    public LoginVo() {
    }

    public LoginVo(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
