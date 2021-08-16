package com.GiveaLot.givealot.Blockchain.dataclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name="blockchain"
)
public class Blockchain {
    @Id
    @Column(
            name = "org_id",
            nullable = false,
            columnDefinition = "INT"
    )
    long orgId;

    @Column(
            name = "index",
            nullable = false,
            columnDefinition = "INT"
    )
    long index;
    @Column(
            name = "level",
            nullable = false,
            columnDefinition = "INT"
    )
    long level;
    @Column(
            name = "transaction_hash",
            nullable = false,
            columnDefinition = "TEXT"
    )
    String transactionHash;
    @Column(
            name = "certificate_hash",
            nullable = false,
            columnDefinition = "TEXT"
    )
    String certificateHash;



    public Blockchain(long orgId, long index, long level, String transactionHash, String certificateHash) {
        this.orgId = orgId;
        this.index = index;
        this.level = level;
        this.transactionHash = transactionHash;
        this.certificateHash = certificateHash;
    }

    public Blockchain() {

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

    @Override
    public String toString() {
        return "blockchain{" +
                "id='" + orgId + '\'' +
                ",index ='" + index + '\'' +
                ", level='" + level + '\'' +
                ", transactionHash='" + transactionHash + '\'' +
                ", certificateHash='" + certificateHash + '\'' +
                '}';
    }
}
