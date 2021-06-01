package com.hexing.dzk.utils;

import com.hexing.dzk.domain.DzkInfoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 创建人: zhuzl 80007635
 * @version 0.0
 * @Desctiption TODO:
 * @Company 杭州海兴电力
 * @Classname DzkNumber
 * @date 时间：  2021/5/26 14:47
 */
public class DzkNumber {
    public static List<DzkInfoBean> getDzkInfoList(String baseUrl, String title) {
        if ("公司宣传册图片版".equals(title)) {
            return getDzk_GSXCSC(baseUrl);
        } else if ("海兴海外案例集图片版".equals(title)) {
            return getDzk_GSJ(baseUrl);
        } else if ("市场洞察月报（2019年3月）".equals(title)) {
            return getDzk_S3(baseUrl);
        } else if ("市场洞察月报（2019年5月）".equals(title)) {
            return getDzk_S5(baseUrl);
        } else if ("市场洞察月报（2019年7月）".equals(title)) {
            return getDzk_S7(baseUrl);
        } else if ("市场洞察月报（2019年8月）".equals(title)) {
            return getDzk_S8(baseUrl);
        } else if ("市场洞察月报（2019年12月）".equals(title)) {
            return getDzk_S12(baseUrl);
        }
        return null;
    }

    private static List<DzkInfoBean> getDzk_S8(String baseUrl) {
        List<DzkInfoBean> objects = new ArrayList<>();
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年8月）_00.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年8月）_01.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年8月）_02.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年8月）_03.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年8月）_04.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年8月）_05.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年8月）_06.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年8月）_07.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年8月）_08.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年8月）_09.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年8月）_10.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年8月）_11.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年8月）_12.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年8月）_13.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年8月）_14.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年8月）_15.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年8月）_16.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年8月）_17.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年8月）_18.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年8月）_19.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年8月）_20.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年8月）_21.jpg"));
        return objects;
    }

    private static List<DzkInfoBean> getDzk_S5(String baseUrl) {
        List<DzkInfoBean> objects = new ArrayList<>();
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年5月）压缩_00.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年5月）压缩_01.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年5月）压缩_02.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年5月）压缩_03.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年5月）压缩_04.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年5月）压缩_05.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年5月）压缩_06.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年5月）压缩_07.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年5月）压缩_08.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年5月）压缩_09.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年5月）压缩_10.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年5月）压缩_11.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年5月）压缩_12.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年5月）压缩_13.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年5月）压缩_14.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年5月）压缩_15.jpg"));
        return objects;
    }

    private static List<DzkInfoBean> getDzk_S3(String baseUrl) {
        List<DzkInfoBean> objects = new ArrayList<>();
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年3月）_00.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年3月）_01.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年3月）_02.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年3月）_03.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年3月）_04.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年3月）_05.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年3月）_06.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年3月）_07.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年3月）_08.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年3月）_09.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年3月）_10.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年3月）_11.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年3月）_12.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年3月）_13.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年3月）_14.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年3月）_15.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年3月）_16.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年3月）_17.jpg"));
        return objects;
    }

    private static List<DzkInfoBean> getDzk_S12(String baseUrl) {
        List<DzkInfoBean> objects = new ArrayList<>();
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年12月）_00.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年12月）_01.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年12月）_02.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年12月）_03.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年12月）_04.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年12月）_05.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年12月）_06.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年12月）_07.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年12月）_08.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年12月）_09.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年12月）_10.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年12月）_11.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年12月）_12.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年12月）_13.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年12月）_14.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年12月）_15.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年12月）_16.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年12月）_17.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年12月）_18.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年12月）_19.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年12月）_20.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年12月）_21.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "市场洞察月报（2019年12月）_22.jpg"));
        return objects;
    }

    private static List<DzkInfoBean> getDzk_S7(String baseUrl) {
        List<DzkInfoBean> objects = new ArrayList<>();
        objects.add(new DzkInfoBean(baseUrl + "0704_1.png"));
        objects.add(new DzkInfoBean(baseUrl + "0704_2.png"));
        objects.add(new DzkInfoBean(baseUrl + "0704_3.png"));
        objects.add(new DzkInfoBean(baseUrl + "0704_4.png"));
        objects.add(new DzkInfoBean(baseUrl + "0704_5.png"));
        objects.add(new DzkInfoBean(baseUrl + "0704_6.png"));
        objects.add(new DzkInfoBean(baseUrl + "0704_7.png"));
        objects.add(new DzkInfoBean(baseUrl + "0704_8.png"));
        objects.add(new DzkInfoBean(baseUrl + "0704_9.png"));
        objects.add(new DzkInfoBean(baseUrl + "0704_10.png"));
        objects.add(new DzkInfoBean(baseUrl + "0704_11.png"));
        objects.add(new DzkInfoBean(baseUrl + "0704_12.png"));
        objects.add(new DzkInfoBean(baseUrl + "0704_13.png"));
        objects.add(new DzkInfoBean(baseUrl + "0704_14.png"));
        objects.add(new DzkInfoBean(baseUrl + "0704_15.png"));
        objects.add(new DzkInfoBean(baseUrl + "0704_16.png"));
        objects.add(new DzkInfoBean(baseUrl + "0704_17.png"));
        objects.add(new DzkInfoBean(baseUrl + "0704_18.png"));
        objects.add(new DzkInfoBean(baseUrl + "0704_19.png"));
        objects.add(new DzkInfoBean(baseUrl + "0704_20.png"));
        objects.add(new DzkInfoBean(baseUrl + "0704_21.png"));
        return objects;
    }

    private static List<DzkInfoBean> getDzk_GSJ(String baseUrl) {
        List<DzkInfoBean> objects = new ArrayList<>();
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_01.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_03.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_05.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_06.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_07.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_08.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_09.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_10.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_11.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_12.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_13.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_14.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_15.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_16.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_17.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_18.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_19.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_20.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_21.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_22.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_23.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_24.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_25.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_26.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_27.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_28.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_29.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_30.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_31.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_32.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_33.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_34.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_35.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_36.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_38.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "海兴客户故事集图片更新（海外版）_页面_40.jpg"));
        return objects;
    }

    private static List<DzkInfoBean> getDzk_GSXCSC(String baseUrl) {
        List<DzkInfoBean> objects = new ArrayList<>();
        objects.add(new DzkInfoBean(baseUrl + "2021公司宣传册5月28（电子版）_页面_01.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "2021公司宣传册5月28（电子版）_页面_02.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "2021公司宣传册5月28（电子版）_页面_03.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "2021公司宣传册5月28（电子版）_页面_04.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "2021公司宣传册5月28（电子版）_页面_05.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "2021公司宣传册5月28（电子版）_页面_06.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "2021公司宣传册5月28（电子版）_页面_07.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "2021公司宣传册5月28（电子版）_页面_08.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "2021公司宣传册5月28（电子版）_页面_09.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "2021公司宣传册5月28（电子版）_页面_10.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "2021公司宣传册5月28（电子版）_页面_11.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "2021公司宣传册5月28（电子版）_页面_12.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "2021公司宣传册5月28（电子版）_页面_13.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "2021公司宣传册5月28（电子版）_页面_14.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "2021公司宣传册5月28（电子版）_页面_15.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "2021公司宣传册5月28（电子版）_页面_16.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "2021公司宣传册5月28（电子版）_页面_17.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "2021公司宣传册5月28（电子版）_页面_18.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "2021公司宣传册5月28（电子版）_页面_19.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "2021公司宣传册5月28（电子版）_页面_20.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "2021公司宣传册5月28（电子版）_页面_21.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "2021公司宣传册5月28（电子版）_页面_22.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "2021公司宣传册5月28（电子版）_页面_23.jpg"));
        objects.add(new DzkInfoBean(baseUrl + "2021公司宣传册5月28（电子版）_页面_24.jpg"));
        return objects;
    }
}
