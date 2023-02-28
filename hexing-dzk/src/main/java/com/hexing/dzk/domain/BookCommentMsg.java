package com.hexing.dzk.domain;

import lombok.Data;

@Data
public class BookCommentMsg {
    private String name;

    private String isAsc;

    private String Status;

    private Integer pageSize;

    private Integer pageNum;
}
