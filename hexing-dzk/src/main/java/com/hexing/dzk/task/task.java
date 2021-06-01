package com.hexing.dzk.task;

import com.hexing.common.utils.StringUtils;
import com.hexing.dzk.domain.SetConfigurationToken;
import com.hexing.dzk.service.ISetConfigurationTokenService;
import com.hexing.dzk.utils.DingUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 创建人: zhuzl 80007635
 * @version 0.0
 * @Desctiption TODO:定时任务
 * @Company 杭州海兴电力
 * @Classname task
 * @date 时间：  2021/5/28 10:39
 */
@Slf4j
@Component("dingTask")
public class task {
    /**
     * 正式版还是测试版
     */
    @Value("${token.test}")
    private String vsesion_type;
    private ISetConfigurationTokenService tokenService;
    /**
     * 同步立项申请至redmine
     */
    public void token() {
        SetConfigurationToken settoken = new SetConfigurationToken();
        settoken.setOther(vsesion_type);
        List<SetConfigurationToken> setConfigurationTokens =
                tokenService.selectSetConfigurationTokenList(settoken);
        if (StringUtils.isNotEmpty(setConfigurationTokens)) {
            for (SetConfigurationToken setToken : setConfigurationTokens) {
                String accessToken = DingUtils.getToken(setToken.getAppKey(), setToken.getAppSecret());
                setToken.setSetValue(accessToken);
                int i = tokenService.updateSetConfigurationToken(setToken);
                log.debug(setToken.getName() + "更新" + (i > 0 ? "成功" : "失败"));
            }
        }
    }
}
