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
    @Column(name="image1")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] image1;

    @Lob
    @Column(name="image2")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] image2;

    @Lob
    @Column(name="image3")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] image3;

    @Lob
    @Column(name="image4")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] image4;

    @Lob
    @Column(name="image5")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] image5;

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

    public OrganisationData(Long orgId, byte[] auditDoc, byte[] qrCode, byte[] image1, byte[] image2, byte[] image3, byte[] image4, byte[] image5, byte[] certificate, byte[] certificateImage) {
        this.orgId = orgId;
        this.auditDoc = auditDoc;
        this.qrCode = qrCode;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.image5 = image5;
        this.certificate = certificate;
        this.certificateImage = certificateImage;
    }
}
