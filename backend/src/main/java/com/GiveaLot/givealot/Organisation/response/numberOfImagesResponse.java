package com.GiveaLot.givealot.Organisation.response;

public class numberOfImagesResponse {
    private String code;
    private String message;
    private Integer number_of_images;

    public numberOfImagesResponse(String code, String message, Integer number_of_images) {
        this.code = code;
        this.message = message;
        this.number_of_images = number_of_images;
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

    public Integer getNumber_of_images() {
        return number_of_images;
    }

    public void setNumber_of_images(Integer number_of_images) {
        this.number_of_images = number_of_images;
    }
}
