package com.wonderrobot.ankenmatchingu.common;
// MultiResponse.vm
import java.util.Collection;

/**
 * MultiResponse
 */
public class MultiResponse<T> extends Response {

    /**
     * Result Count
     */
    private Long total;

    /**
     * Data
     */
    private Collection<T> data;

    public MultiResponse() {
    }

    public static <T> MultiResponse<T> of(Collection<T> data, long total) {
        MultiResponse<T> multiResponse = new MultiResponse<T>();
        multiResponse.setSuccess(true);
        multiResponse.setData(data);
        multiResponse.setTotal(total);
        return multiResponse;
    }

    public static <T> MultiResponse<T> ofWithoutTotal(Collection<T> data) {
        return of(data, 0L);
    }

    public Long getTotal() {
        return this.total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Collection<T> getData() {
        return this.data;
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }

    public static MultiResponse buildFailure(String errCode, String errMessage) {
        MultiResponse response = new MultiResponse();
        response.setSuccess(false);
        response.setErrCode(errCode);
        response.setErrMessage(errMessage);
        return response;
    }

    public static MultiResponse buildSuccess() {
        MultiResponse response = new MultiResponse();
        response.setSuccess(true);
        return response;
    }
}
