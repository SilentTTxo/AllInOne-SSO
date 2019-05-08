package top.silenttt.allInOne.sso.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.silenttt.allInOne.sso.dao.Repository.UserRepository;
import top.silenttt.allInOne.sso.dao.UserAuthDao;
import top.silenttt.allInOne.sso.model.BaseResponse;
import top.silenttt.allInOne.sso.service.biz.UserService;
import top.silenttt.allInOne.sso.util.CheckUtil;

/**
 * admin管理页面user接口
 * @author tangtao
 * @date 2019-02-18
 **/
@RestController
@RequestMapping(value = "/admin/user")
public class UserAdminController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/list")
    public BaseResponse list(Integer page){
        CheckUtil.checkParam(page);
        BaseResponse rs = new BaseResponse();
        rs.setValue(userService.getUserListByPage(page));
        return rs;
    }

}
