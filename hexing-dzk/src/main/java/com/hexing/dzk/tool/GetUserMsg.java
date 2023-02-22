package com.hexing.dzk.tool;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiUserGetuserinfoRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import org.springframework.stereotype.Service;

@Service
public class GetUserMsg {
    //userid
    public static String getUserid(String key, String secret, String code) {
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
            String userid = response1.getUserid();
            if (userid.startsWith("S")) {
                userid = userid.substring(1);
            }
//            if ("070003405826144516".equals(userid)) {
//                return "80007635";
//            }
            return userid;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
//return "80007635";
    }

}
