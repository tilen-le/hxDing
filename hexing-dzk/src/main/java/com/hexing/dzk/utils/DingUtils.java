package com.hexing.dzk.utils;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiUserGetuserinfoRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import com.hexing.common.utils.StringUtils;

/**
 * @author 创建人: zhuzl 80007635
 * @version 0.0
 * @Desctiption TODO:
 * @Company 杭州海兴电力
 * @Classname DingUtils
 * @date 时间：  2021/5/28 10:32
 */
public class DingUtils {
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

    //获取userid
    public static String getUserid(String accessToken, String code) {
        try {

            DingTalkClient client1 = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/getuserinfo");
            OapiUserGetuserinfoRequest request1 = new OapiUserGetuserinfoRequest();
            request1.setCode(code);
            request1.setHttpMethod("GET");
            OapiUserGetuserinfoResponse response1 = client1.execute(request1, accessToken);
            if (response1!=null && response1.getErrcode()==0 && StringUtils.isNotEmpty(response1.getUserid())){
                String userid = response1.getUserid();
                if (userid.startsWith("S")) {
                    userid = userid.substring(1);
                }
                return userid;
            }else {
                return "111";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "000";
        }
    }
    //获取name
    public static String getName(String accessToken, String code) {
        try {

            DingTalkClient client1 = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/getuserinfo");
            OapiUserGetuserinfoRequest request1 = new OapiUserGetuserinfoRequest();
            request1.setCode(code);
            request1.setHttpMethod("GET");
            OapiUserGetuserinfoResponse response1 = client1.execute(request1, accessToken);
            String userid = response1.getUserid();
            return userid;
        } catch (Exception e) {
            e.printStackTrace();
            return "000";
        }
    }


    //获取token
    public static String getToken(String key, String secret) {
        try {
            DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
            OapiGettokenRequest request = new OapiGettokenRequest();
            request.setAppkey(key);
            request.setAppsecret(secret);
            request.setHttpMethod("GET");
            OapiGettokenResponse response = client.execute(request);
            String accessToken = response.getAccessToken();
            return accessToken;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
