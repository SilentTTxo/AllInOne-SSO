package top.silenttt.allInOne.sso.model;

/**
 * @author tangtao
 * @date 2019-02-18
 **/
public class BaseResponse {
    private int code = 200;
    private Object value;
    private String msg;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BaseResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse() {
    }

    public BaseResponse(Object value) {
        this.value = value;
    }

    public static BaseResponse NORMAL_RETURN = new BaseResponse();
}
