package com.hexing.dzk.tool;

import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiUserGetuserinfoRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Slf4j
public class GetUserMsg {
    //userid
    public static HashMap<String,String> getUserid(String key, String secret, String code) {
        try {
            DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
            OapiGettokenRequest request = new OapiGettokenRequest();
            request.setAppkey(key);
            request.setAppsecret(secret);
            request.setHttpMethod("GET");
            OapiGettokenResponse response = client.execute(request);
            String accessToken = response.getAccessToken();

            DingTalkClient client1 = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/getuserinfo");
            OapiUserGetuserinfoRequest request1 = new OapiUserGetuserinfoRequest();
            request1.setCode(code);
            request1.setHttpMethod("GET");
            OapiUserGetuserinfoResponse response1 = client1.execute(request1, accessToken);
            log.info("=====GetUserMsg:getUserid:response1=" + response1.toString());

            String userid = response1.getUserid();
            log.info("userid" + userid);
            if (userid.startsWith("S")) {
                userid = userid.substring(1);
            }
            String body = response1.getBody();
            JSONObject jsonObject = JSONObject.parseObject(body);
            String name = jsonObject.getString("name");
            HashMap<String, String> map = new HashMap<>();
            map.put("userId",userid);
            map.put("name",name);
//            if ("070003405826144516".equals(userid)) {
//                return "80007635";
//            }

            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<>();
        }
//return "80007635";
    }

}
