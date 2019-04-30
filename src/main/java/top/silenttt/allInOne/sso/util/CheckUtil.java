package top.silenttt.allInOne.sso.util;

import top.silenttt.allInOne.sso.constant.BizException;
import top.silenttt.allInOne.sso.constant.ErrorCode;

public class CheckUtil {
    public static void checkParam(Object param,String msg){
        if(param == null){
            throw new BizException(ErrorCode.CHECK_CODE.PARAM_ERROR,msg);
        }
    }

    public static void checkParam(Object param){
        checkParam(param,"check your param");
    }
}
