package com.GiveaLot.givealot.Organisation.response;

public class getOrgCertLevelResponse {
    private String code;
    private String message;
    private long level;

    public getOrgCertLevelResponse(String code, String message, long level) {
        this.code = code;
        this.message = message;
        this.level = level;
    }

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
