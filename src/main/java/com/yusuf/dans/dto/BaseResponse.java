package com.yusuf.dans.dto;


import java.io.Serializable;
import java.util.Objects;

public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private int status = 200;
    private String info = "Success";
    private T content;

    public BaseResponse(T content) {
        this.content = content;
    }

    public BaseResponse(String info, T content) {
        this.info = info;
        this.content = content;
    }

    public BaseResponse(int status, String info, T content) {
        this.status = status;
        this.info = info;
        this.content = content;
    }

    public int getStatus() {
        return this.status;
    }

    public String getInfo() {
        return this.info;
    }

    public T getContent() {
        return this.content;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BaseResponse)) {
            return false;
        } else {
            BaseResponse<?> other = (BaseResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getStatus() != other.getStatus()) {
                return false;
            } else {
                Object this$info = this.getInfo();
                Object other$info = other.getInfo();
                if (this$info == null) {
                    if (other$info != null) {
                        return false;
                    }
                } else if (!this$info.equals(other$info)) {
                    return false;
                }

                Object this$content = this.getContent();
                Object other$content = other.getContent();
                if (this$content == null) {
                    if (other$content != null) {
                        return false;
                    }
                } else if (!this$content.equals(other$content)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof BaseResponse;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, info, content);
    }

    public String toString() {
        return "BaseResponse(status=" + this.getStatus() + ", info=" + this.getInfo() + ", content=" + this.getContent() + ")";
    }

}
