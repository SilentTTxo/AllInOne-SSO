package top.silenttt.allInOne.sso.constant;

/**
 * 错误码约定
 */
public interface ErrorCode {
    interface BASE_CODE {
        int OK = 200;
        int UNAUTH = 401;
    }
    interface CHECK_CODE {
        int UNKNOWN_ERROR = 10000;
        int LOGIN_ERROR = 10001;
        int LOGIN_BAD_TOKEN = 10002;
        int LOGIN_TOKEN_EXPIRE = 10003;
        int PARAM_ERROR = 10011;
    }
}
