package com.hexing.dzk.domain;

import com.hexing.common.core.domain.BaseEntity;

/**
 * @author 80010641
 */
public class BookAttach extends BaseEntity {

    private int id;

    private String name;

    private String author;

    private long bookId;

    private String attachUrl;

    private String attachName;

    private String coverUrl;

    private String coverName;

    private String status;

    private int sorted;

    private String enableComment;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCoverName() {
        return coverName;
    }

    public void setCoverName(String coverName) {
        this.coverName = coverName;
    }

    public String getEnableComment() {
        return enableComment;
    }

    public void setEnableComment(String enableComment) {
        this.enableComment = enableComment;
    }

    @Override
    public String toString() {
        return "BookAttach{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", bookId=" + bookId +
                ", attachUrl='" + attachUrl + '\'' +
                ", attachName='" + attachName + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                ", coverName='" + coverName + '\'' +
                ", status='" + status + '\'' +
                ", sorted=" + sorted + '\'' +
                ", enableComment=" + enableComment +
                '}';
    }
}
