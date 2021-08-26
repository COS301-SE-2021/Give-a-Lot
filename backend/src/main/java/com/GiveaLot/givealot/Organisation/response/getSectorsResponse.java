package com.GiveaLot.givealot.Organisation.response;

import java.util.List;

public class getSectorsResponse {
    String code;
    String message;
    List<String> sectors;

    public getSectorsResponse(String code, String message, List<String> sectors) {
        this.code = code;
        this.message = message;
        this.sectors = sectors;
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

    public List<String> getSectors() {
        return sectors;
    }

    public void setSectors(List<String> sectors) {
        this.sectors = sectors;
    }
}
