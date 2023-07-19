package com.yusuf.dans.common;

import com.yusuf.dans.dto.BaseResponse;

public class BuildResponseUtil {

    public BuildResponseUtil() {
    }

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(data);
    }

    public static <T> BaseResponse<T> error() {
        return (BaseResponse<T>) error((Integer)null, (Object)null);
    }

    public static <T> BaseResponse<T> error(T message) {
        return error((Integer)null, message);
    }

    public static <T> BaseResponse<T> error(Integer status, T message) {
        if (status == null) {
            status = -1;
        }

        if (message == null) {
            message = (T) "System error, please try again later.";
        }

        return new BaseResponse<>(status, "Failed", message);
    }
}
