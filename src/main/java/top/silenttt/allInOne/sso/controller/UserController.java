package top.silenttt.allInOne.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.silenttt.allInOne.sso.dao.Repository.UserRepository;
import top.silenttt.allInOne.sso.dao.UserAuthDao;
import top.silenttt.allInOne.sso.model.BaseResponse;

/**
 * @author tangtao
 * @date 2019-02-18
 **/
@RestController
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "list")
    public BaseResponse list(){
        BaseResponse rs = new BaseResponse();
        rs.setValue(userRepository.findAll());
        return rs;
    }
}
