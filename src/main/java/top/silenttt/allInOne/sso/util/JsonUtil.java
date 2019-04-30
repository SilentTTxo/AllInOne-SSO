package top.silenttt.allInOne.sso.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import top.silenttt.allInOne.sso.constant.BizException;
import top.silenttt.allInOne.sso.model.BaseResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class JsonUtil {
    static ObjectMapper mapper = new ObjectMapper();

    public static String toJsonString(Object obj){
        String rsStr = null;
        try {
            rsStr = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return rsStr;
    }

    public static void writeResponse(HttpServletResponse httpServletResponse, Object obj){
        try {
            Writer out = httpServletResponse.getWriter();
            out.append(JsonUtil.toJsonString(obj));
            httpServletResponse.setHeader("content-type","application/json;charset=utf-8");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static <T> T decodeJson(String json,Class<T> t){
        try {
            return mapper.readValue(json,t);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
