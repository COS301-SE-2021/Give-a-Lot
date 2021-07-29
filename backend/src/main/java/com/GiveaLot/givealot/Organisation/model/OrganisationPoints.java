package com.GiveaLot.givealot.Organisation.model;

import java.io.File;
import java.util.Date;

public class OrganisationPoints {

    private String orgId;
    private String website;
    private String address;
    private File audit;
    private String reference;
    private String auditor;
    private String committee;
    private String info;
    private String type;
    private Date ngoDate;
    private Date estDate;

    public OrganisationPoints(String orgId, String website, File audit, String reference, String auditor, String committee, String info, String type, Date ngoDate, Date estDate) {
        this.orgId = orgId;
        this.website = website;
        this.audit = audit;
        this.reference = reference;
        this.auditor = auditor;
        this.committee = committee;
        this.info = info;
        this.type = type;
        this.ngoDate = ngoDate;
        this.estDate = estDate;
    }
    public OrganisationPoints() {
        this.orgId = null;
        this.website = null;
        this.audit = null;
        this.reference = null;
        this.auditor = null;
        this.committee = null;
        this.info = null;
        this.type = null;
        this.ngoDate = null;
        this.estDate = null;
    }



    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public File getAudit() {
        return audit;
    }

    public void setAudit(File audit) {
        this.audit = audit;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getCommittee() {
        return committee;
    }

    public void setCommittee(String committee) {
        this.committee = committee;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getNgoDate() {
        return ngoDate;
    }

    public void setNgoDate(Date ngoDate) {
        this.ngoDate = ngoDate;
    }

    public Date getEstDate() {
        return estDate;
    }

    public void setEstDate(Date estDate) {
        this.estDate = estDate;
    }
}
