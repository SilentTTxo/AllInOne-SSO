package top.silenttt.allInOne.sso.model.vo;


import org.springframework.beans.BeanUtils;
import top.silenttt.allInOne.sso.model.User;

/**
 * TODO: 这玩意儿暂时不用
 */
public class UserInfoVo {
    private Integer id;
    private String username;
    private String auth;

    UserInfoVo(){}
    UserInfoVo(User user){
        BeanUtils.copyProperties(user,this);
    }
}
