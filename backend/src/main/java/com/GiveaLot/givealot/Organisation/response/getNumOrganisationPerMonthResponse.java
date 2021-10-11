package com.GiveaLot.givealot.Organisation.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sept", "oct", "nov", "dec"})
public class getNumOrganisationPerMonthResponse {
    private long Jan;
    private long Feb;
    private long Mar;
    private long Apr;
    private long May;
    private long Jun;
    private long Jul;
    private long Aug;
    private long Sept;
    private long Oct;
    private long Nov;
    private long Dec;


    public getNumOrganisationPerMonthResponse(long jan, long feb, long mar, long apr, long may, long jun, long jul, long aug, long sept, long oct, long nov, long dec) {
        Jan = jan;
        Feb = feb;
        Mar = mar;
        Apr = apr;
        May = may;
        Jun = jun;
        Jul = jul;
        Aug = aug;
        Sept = sept;
        Oct = oct;
        Nov = nov;
        Dec = dec;
    }

    public long getJan() {
        return Jan;
    }

    public void setJan(long jan) {
        Jan = jan;
    }

    public long getFeb() {
        return Feb;
    }

    public void setFeb(long feb) {
        Feb = feb;
    }

    public long getMar() {
        return Mar;
    }

    public void setMar(long mar) {
        Mar = mar;
    }

    public long getApr() {
        return Apr;
    }

    public void setApr(long apr) {
        Apr = apr;
    }

    public long getMay() {
        return May;
    }

    public void setMay(long may) {
        May = may;
    }

    public long getJun() {
        return Jun;
    }

    public void setJun(long jun) {
        Jun = jun;
    }

    public long getJul() {
        return Jul;
    }

    public void setJul(long jul) {
        Jul = jul;
    }

    public long getAug() {
        return Aug;
    }

    public void setAug(long aug) {
        Aug = aug;
    }

    public long getSept() {
        return Sept;
    }

    public void setSept(long sept) {
        Sept = sept;
    }

    public long getOct() {
        return Oct;
    }

    public void setOct(long oct) {
        Oct = oct;
    }

    public long getNov() {
        return Nov;
    }

    public void setNov(long nov) {
        Nov = nov;
    }

    public long getDec() {
        return Dec;
    }

    public void setDec(long dec) {
        Dec = dec;
    }

}
