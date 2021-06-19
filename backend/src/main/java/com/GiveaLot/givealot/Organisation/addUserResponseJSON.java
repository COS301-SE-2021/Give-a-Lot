package com.GiveaLot.givealot.Organisation;

public class addUserResponseJSON
{
    int code;
    String status;

    public addUserResponseJSON(int http_code, String status) {
        this.code = http_code;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
