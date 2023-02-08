package com.hexing.dzk.domain;

import com.hexing.common.core.domain.BaseEntity;

/**
 * @author 80010641
 */
public class BookAttach extends BaseEntity {

    private int id;

    private String name;

    private long bookId;

    private String attachUrl;

    private String attachName;

    private String coverUrl;

    private String status;

    private int sorted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getAttachUrl() {
        return attachUrl;
    }

    public void setAttachUrl(String attachUrl) {
        this.attachUrl = attachUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSorted() {
        return sorted;
    }

    public void setSorted(int sorted) {
        this.sorted = sorted;
    }

    public String getAttachName() {
        return attachName;
    }

    public void setAttachName(String attachName) {
        this.attachName = attachName;
    }

    @Override
    public String toString() {
        return "BookAttach{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bookId=" + bookId +
                ", attachUrl='" + attachUrl + '\'' +
                ", attachName='" + attachName + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                ", status='" + status + '\'' +
                ", sorted=" + sorted +
                '}';
    }
}
