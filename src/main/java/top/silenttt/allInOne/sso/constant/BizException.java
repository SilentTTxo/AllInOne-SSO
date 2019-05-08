package top.silenttt.allInOne.sso.constant;

/**
 * 业务Exception
 */
public class BizException extends RuntimeException {
    private int code = 200;
    private String msg ;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BizException() {
    }

    public BizException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
