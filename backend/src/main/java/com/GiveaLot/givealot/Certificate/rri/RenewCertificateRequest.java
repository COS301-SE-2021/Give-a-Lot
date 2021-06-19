package com.GiveaLot.givealot.Certificate.rri;

public class RenewCertificateRequest {

    String renewalDate;
    String currentDate;

    boolean isRenewed;

    RenewCertificateRequest(String renewalDate,String currentDate,boolean isRenewed)
    {
        this.renewalDate = renewalDate;
        this.currentDate = currentDate;
        this.isRenewed = isRenewed;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public void setRenewalDate(String renewalDate) {
        this.renewalDate = renewalDate;
    }

    public void setRenewed(boolean renewed) {
        isRenewed = renewed;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public String getRenewalDate() {
        return renewalDate;
    }
    public boolean getIsRenewed()
    {
        return isRenewed;
    }

}
