package top.silenttt.allInOne.sso.util;

import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import top.silenttt.allInOne.sso.model.User;

import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    private static final String SIGN_KEY = "sign_key";
    private static final MacSigner signer = new MacSigner(SIGN_KEY);

    public static String encodeAccessToken(String username,int level){
        Map<String,String> data = new HashMap<>();
        data.put("username",username);
        data.put("auth",Integer.toString(level));

        String payload = JsonUtil.toJsonString(data);
        Jwt rs = JwtHelper.encode(payload,signer);

        return rs.getEncoded();
    }

    public static String encodeAccessToken(User user){
        user.setPassword("");

        String payload = JsonUtil.toJsonString(user);
        Jwt rs = JwtHelper.encode(payload,signer);

        return rs.getEncoded();
    }

    public static Jwt decodeAccessToken(String token){
        return JwtHelper.decode(token);
    }

    public static Jwt checkToken(String token){
        return JwtHelper.decodeAndVerify(token,signer);
    }

    public static User getUser(Jwt jwt){
        String payload = jwt.getClaims();
        User user = JsonUtil.decodeJson(payload,User.class);
        user.setPassword("PROTECT");
        return user;
    }

}
