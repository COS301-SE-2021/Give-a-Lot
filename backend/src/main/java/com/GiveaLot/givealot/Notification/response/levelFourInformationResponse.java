package com.GiveaLot.givealot.Notification.response;

public class levelFourInformationResponse {
    private Long level;
    private String commiteeMembers;
    private String socialMedia1;
    private String socialMedia2;

    public levelFourInformationResponse(Long level, String commiteeMembers, String socialMedia1, String socialMedia2) {
        this.level = level;
        this.commiteeMembers = commiteeMembers;
        this.socialMedia1 = socialMedia1;
        this.socialMedia2 = socialMedia2;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public String getCommiteeMembers() {
        return commiteeMembers;
    }

    public void setCommiteeMembers(String commiteeMembers) {
        this.commiteeMembers = commiteeMembers;
    }

    public String getSocialMedia1() {
        return socialMedia1;
    }

    public void setSocialMedia1(String socialMedia1) {
        this.socialMedia1 = socialMedia1;
    }

    public String getSocialMedia2() {
        return socialMedia2;
    }

    public void setSocialMedia2(String socialMedia2) {
        this.socialMedia2 = socialMedia2;
    }
}
