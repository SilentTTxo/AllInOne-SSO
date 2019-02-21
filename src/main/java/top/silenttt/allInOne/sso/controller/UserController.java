package top.silenttt.allInOne.sso.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.silenttt.allInOne.sso.model.BaseResponse;

/**
 * @author tangtao
 * @date 2019-02-18
 **/
@RestController
@RequestMapping(value = "/user/")
public class UserController {

    @RequestMapping(value = "list")
    public BaseResponse list(){
        return new BaseResponse();
    }
}
