package com.GiveaLot.givealot.Browse.service;

public class OrganisationNode {
    int h;
    private String OrgId; /* order tree by */
    private OrganisationData data;

    OrganisationNode leftChild;
    OrganisationNode rightChild;

    public OrganisationNode(OrganisationData data) {
        this.setOrgId(data.getOrgId());
        this.setData(data);
        this.leftChild = null;
        this.rightChild = null;
        this.h = 0;
    }

    // default constructor to create null node
    public OrganisationNode() {
        leftChild = null;
        rightChild = null;
        OrgId = "";
        h = 0;
    }

    public OrganisationData getData() {
        return this.data;
    }

    public void setData(OrganisationData data2) {
        this.data = data2;
    }

    public void setOrgId(String orgId) {
        OrgId = orgId;
    }

    public String getOrgId() {
        return OrgId;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}