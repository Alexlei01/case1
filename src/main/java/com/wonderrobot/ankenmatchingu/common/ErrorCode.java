package com.wonderrobot.ankenmatchingu.common;
// ErrorCode.vm

/**
 * Error Code
 */
public enum ErrorCode {

    SUCCESS("0000","処理成功"),                     //処理成功
    SE00000("SE00000","処理失敗"),                     //処理失敗
    ;

    /**
     * ErrorCode
     * @param code
     * @param message
     */
    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Code
     */
    private String code;

    /**
     * Message
     */
    private String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
