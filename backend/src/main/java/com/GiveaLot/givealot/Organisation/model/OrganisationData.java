package com.GiveaLot.givealot.Organisation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Builder
@Entity
@Table(name="organisation_data")
public class OrganisationData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
