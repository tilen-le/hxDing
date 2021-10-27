package com.hexing.dzk.domain;

import com.hexing.common.core.domain.BaseEntity;

/**
 * @author 创建人: zhuzl 80007635
 * @version 0.0
 * @Desctiption TODO:
 * @Company 杭州海兴电力
 * @Classname ImgBean
 * @date 时间：  2021/5/21 16:09
 */

public class DzkInfoBean extends BaseEntity {
    private String imgUrl;
    private String  dzkName;

    public String getDzkName() {
        return dzkName;
    }

    public void setDzkName(String dzkName) {
        this.dzkName = dzkName;
    }

    public DzkInfoBean(String imgUrl){
        this.imgUrl=imgUrl;
    }
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "DzkInfoBean{" +
                "imgUrl='" + imgUrl + '\'' +
                '}';
    }
}