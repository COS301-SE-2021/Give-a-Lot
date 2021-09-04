package com.GiveaLot.givealot.User.response;

public class getNumUsersPerMonthResponse {
    private String message;
    private String code;
    private long janNum;
    private long febNum;
    private long marNum;
    private long aprNum;
    private long mayNum;
    private long junNum;
    private long julNum;
    private long augNum;
    private long septNum;
    private long octNum;
    private long novNum;
    private long decNum;

    public getNumUsersPerMonthResponse(String message, String code, long janNum, long febNum, long marNum, long aprNum, long mayNum, long junNum, long julNum, long augNum, long septNum, long octNum, long novNum, long decNum) {
        this.message = message;
        this.code = code;
        this.janNum = janNum;
        this.febNum = febNum;
        this.marNum = marNum;
        this.aprNum = aprNum;
        this.mayNum = mayNum;
        this.junNum = junNum;
        this.julNum = julNum;
        this.augNum = augNum;
        this.septNum = septNum;
        this.octNum = octNum;
        this.novNum = novNum;
        this.decNum = decNum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getJanNum() {
        return janNum;
    }

    public void setJanNum(long janNum) {
        this.janNum = janNum;
    }

    public long getFebNum() {
        return febNum;
    }

    public void setFebNum(long febNum) {
        this.febNum = febNum;
    }

    public long getMarNum() {
        return marNum;
    }

    public void setMarNum(long marNum) {
        this.marNum = marNum;
    }

    public long getAprNum() {
        return aprNum;
    }

    public void setAprNum(long aprNum) {
        this.aprNum = aprNum;
    }

    public long getMayNum() {
        return mayNum;
    }

    public void setMayNum(long mayNum) {
        this.mayNum = mayNum;
    }

    public long getJunNum() {
        return junNum;
    }

    public void setJunNum(long junNum) {
        this.junNum = junNum;
    }

    public long getJulNum() {
        return julNum;
    }

    public void setJulNum(long julNum) {
        this.julNum = julNum;
    }

    public long getAugNum() {
        return augNum;
    }

    public void setAugNum(long augNum) {
        this.augNum = augNum;
    }

    public long getSeptNum() {
        return septNum;
    }

    public void setSeptNum(long septNum) {
        this.septNum = septNum;
    }

    public long getOctNum() {
        return octNum;
    }

    public void setOctNum(long octNum) {
        this.octNum = octNum;
    }

    public long getNovNum() {
        return novNum;
    }

    public void setNovNum(long novNum) {
        this.novNum = novNum;
    }

    public long getDecNum() {
        return decNum;
    }

    public void setDecNum(long decNum) {
        this.decNum = decNum;
    }
}
