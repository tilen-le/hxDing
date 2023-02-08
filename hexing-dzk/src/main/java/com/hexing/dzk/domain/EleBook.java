package com.hexing.dzk.domain;

import com.hexing.common.core.domain.BaseEntity;

/**
 * @author 80010641
 */
public class EleBook extends BaseEntity {

    private int id;

    private String bookName;

    private String coverUrl;

    private String status;

    private int sorted;

    public int getSorted() {
        return sorted;
    }

    public void setSorted(int sorted) {
        this.sorted = sorted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    @Override
    public String toString() {
        return "EleBook{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                ", status='" + status + '\'' +
                ", sorted=" + sorted +
                '}';
    }
}
