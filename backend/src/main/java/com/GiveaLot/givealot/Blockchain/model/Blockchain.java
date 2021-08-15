package com.GiveaLot.givealot.Blockchain.model;

public class Blockchain {
    long orgId;
    long index;
    long level;
    String transactionHash;
    String certificateHash;

    public Blockchain(long orgId, long index, long level, String transactionHash, String certificateHash) {
        this.orgId = orgId;
        this.index = index;
        this.level = level;
        this.transactionHash = transactionHash;
        this.certificateHash = certificateHash;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public String getTransactionHash() {
        return transactionHash;
    }

    public void setTransactionHash(String transactionHash) {
        this.transactionHash = transactionHash;
    }

    public String getCertificateHash() {
        return certificateHash;
    }

    public void setCertificateHash(String certificateHash) {
        this.certificateHash = certificateHash;
    }
}
