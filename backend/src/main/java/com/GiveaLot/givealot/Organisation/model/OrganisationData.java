package com.GiveaLot.givealot.Organisation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Builder
@Entity
@Table(name="organisation_data")
public class OrganisationData
{
    @Id
    @Column(name = "org_id", nullable = false, unique = true)
    public Long orgId;


    @Lob
    @Column(name="audit_doc")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] auditDoc;

    @Lob
    @Column(name="qr_code")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] qrCode;

    @Lob
    @Column(name="certificate")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] certificate;

    @Lob
    @Column(name="certificateImage")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] certificateImage;

    public OrganisationData() {

    }

    public OrganisationData(Long orgId, byte[] auditDoc, byte[] qrCode, byte[] certificate, byte[] certificateImage) {
        this.orgId = orgId;
        this.auditDoc = auditDoc;
        this.qrCode = qrCode;

        this.certificate = certificate;
        this.certificateImage = certificateImage;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public byte[] getAuditDoc() {
        return auditDoc;
    }

    public void setAuditDoc(byte[] auditDoc) {
        this.auditDoc = auditDoc;
    }

    public byte[] getQrCode() {
        return qrCode;
    }

    public void setQrCode(byte[] qrCode) {
        this.qrCode = qrCode;
    }

    public byte[] getCertificate() {
        return certificate;
    }

    public void setCertificate(byte[] certificate) {
        this.certificate = certificate;
    }

    public byte[] getCertificateImage() {
        return certificateImage;
    }

    public void setCertificateImage(byte[] certificateImage) {
        this.certificateImage = certificateImage;
    }
}
