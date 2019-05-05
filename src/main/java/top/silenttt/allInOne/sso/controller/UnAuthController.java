package top.silenttt.allInOne.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.silenttt.allInOne.sso.model.BaseResponse;
import top.silenttt.allInOne.sso.model.User;
import top.silenttt.allInOne.sso.service.biz.UserService;
import top.silenttt.allInOne.sso.util.CheckUtil;

@RestController
public class UnAuthController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/signUp")
    public BaseResponse signup(User user){
        CheckUtil.checkParam(user.getUsername());
        CheckUtil.checkParam(user.getPassword());

        userService.singup(user);

        return new BaseResponse();
    }
}
