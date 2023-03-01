package com.hexing.dzk.domain;

import com.hexing.common.core.domain.BaseEntity;
import lombok.Data;

@Data
public class EleBookMsg extends BaseEntity {

    private int id;

    private String name;

    private String coverUrl;

    private String author;

    private String coverName;

    private String attachName;

    private String attachUrl;

    private String status;

    private Integer praiseNum;

    private Integer commentNum;

    private int sorted;

    private String enableComment;

}
