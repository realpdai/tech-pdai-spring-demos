package tech.pdai.springboot.smartdoc.entity;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import tech.pdai.springboot.smartdoc.constant.ResponseStatus;

@Data
@Builder
public class ResponseResult<T> {

    /**
     * response timestamp.
     *
     * @since 1.0
     */
    private long timestamp;

    /**
     * response code, 200 -> OK.
     *
     * @since 1.0
     */
    private String status;

    /**
     * response message.
     *
     * @since 1.0
     */
    private String message;

    /**
     * response data.
     *
     * @since 1.0
     */
    private T data;

    /**
     * response success result wrapper.
     *
     * @param <T> type of data class
     * @return response result
     */
    public static <T> ResponseResult<T> success() {
        return success(null);
    }

    /**
     * response success result wrapper.
     *
     * @param data response data
     * @param <T>  type of data class
     * @return response result
     */
    public static <T> ResponseResult<T> success(T data) {
        return ResponseResult.<T>builder().data(data)
                .message(ResponseStatus.SUCCESS.getDescription())
                .status(ResponseStatus.SUCCESS.getResponseCode())
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * response error result wrapper.
     *
     * @param message error message
     * @param <T>     type of data class
     * @return response result
     */
    public static <T extends Serializable> ResponseResult<T> fail(String message) {
        return fail(null, message);
    }

    /**
     * response error result wrapper.
     *
     * @param data    response data
     * @param message error message
     * @param <T>     type of data class
     * @return response result
     */
    public static <T> ResponseResult<T> fail(T data, String message) {
        return ResponseResult.<T>builder().data(data)
                .message(message)
                .status(ResponseStatus.FAIL.getResponseCode())
                .timestamp(System.currentTimeMillis())
                .build();
    }


}
