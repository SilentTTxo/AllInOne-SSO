package top.silenttt.allInOne.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.silenttt.allInOne.sso.model.BaseResponse;
import top.silenttt.allInOne.sso.model.User;
import top.silenttt.allInOne.sso.service.biz.UserService;
import top.silenttt.allInOne.sso.util.CheckUtil;

/**
 * 用户自己相关接口
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/info")
    public BaseResponse list(){
        User user = userService.getSelf();
        return new BaseResponse(user);
    }
}
