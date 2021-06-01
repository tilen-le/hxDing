package com.hexing.dzk.service;

import com.hexing.common.utils.StringUtils;
import com.hexing.dzk.domain.SetConfigurationToken;
import com.hexing.dzk.utils.DingUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 创建人: zhuzl 80007635
 * @version 0.0
 * @Desctiption TODO:
 * @Company 杭州海兴电力
 * @Classname UtilsService
 * @date 时间：  2021/5/28 11:11
 */
@Slf4j
@Service
public class UtilsService {
    /**
     * 正式版还是测试版
     */
    @Value("${token.test}")
    private String vsesion_type;

    @Value("$token.appkey}")
    private String appkey;
    @Value("$token.appsecret}")
    private String appsecret;
    @Autowired
    ISetConfigurationTokenService tokenService;

    //获取通用token
    public String getAccessToken(String key, String type) {
        SetConfigurationToken settoken = new SetConfigurationToken();

        if (StringUtils.isEmpty(type) || "prod".equals(type)) {
            settoken.setOther("prod");
        } else if ("dev".equals(type)) {
            settoken.setOther("dev");
        }  else {
            settoken.setOther(vsesion_type);
        }
        settoken.setSetKey(key);
        List<SetConfigurationToken> setConfigurationTokens =
                tokenService.selectSetConfigurationTokenList(settoken);
        if (StringUtils.isEmpty(setConfigurationTokens)) {
            String tokenn = DingUtils.getToken(appkey, appsecret);
            setConfigurationTokens.get(0).setSetValue(tokenn);
            tokenService.updateSetConfigurationToken(setConfigurationTokens.get(0));
            return tokenn;
        }
        long nowTime = System.currentTimeMillis();
        long updateTime = 0;
        if (setConfigurationTokens.get(0).getUpdateTime() != null) {
            updateTime = setConfigurationTokens.get(0).getUpdateTime().getTime();
        } else {
            updateTime = setConfigurationTokens.get(0).getCreateTime().getTime();
        }
        if (nowTime - updateTime < 5400000) {
            return setConfigurationTokens.get(0).getSetValue();
        } else {
            String token = DingUtils.getToken(setConfigurationTokens.get(0).getAppKey(), setConfigurationTokens.get(0).getAppSecret());
            setConfigurationTokens.get(0).setSetValue(token);
            tokenService.updateSetConfigurationToken(setConfigurationTokens.get(0));
            return token;
        }
    }

}
