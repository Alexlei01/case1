package com.wonderrobot.ankenmatchingu.common;
// Response.vm

/**
 * Response
 */
public class Response {

    private Boolean success;
    private String errCode;
    private String errMessage;
    private String extend;

    public Response() {
    }

    public String toString() {
        return "Response [success=" + this.success + ", errCode=" + this.errCode + ", errMessage=" + this.errMessage + ", extend=" + this.extend + "]";
    }

    public static Response buildFailure(String errCode, String errMessage) {
        Response response = new Response();
        response.setSuccess(false);
        response.setErrCode(errCode);
        response.setErrMessage(errMessage);
        return response;
    }

    public static Response buildSuccess() {
        Response response = new Response();
        response.setSuccess(true);
        return response;
    }

    public String getExtend() {
        return this.extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMessage() {
        return this.errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
