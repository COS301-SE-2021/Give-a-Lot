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

}
