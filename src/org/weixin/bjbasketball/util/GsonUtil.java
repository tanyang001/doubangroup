package org.weixin.bjbasketball.util;

import org.weixin.bjbasketball.service.HttpService;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class GsonUtil {

    public static Object parseObject(String url, Class obj) {
        Object object = null;
        try {
            String strJson = HttpService.httpRequest(url);
            object = new Gson().fromJson(strJson, obj);
        } catch (JsonSyntaxException e) {
        }
        if (object != null) {
            return object;
        } else {
            return null;
        }
    }
}
