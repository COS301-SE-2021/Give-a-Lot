package com.GiveaLot.givealot.Organisation.model;


import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "organisation_gallery")
public class OrganisationGallery
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", nullable = false, unique = true)
    public Long imageId;

    @Column(name="org_id")
    public Long orgId;

    @Lob
    @Column(name="image")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] image;

    public OrganisationGallery() {

    }

    public OrganisationGallery(Long orgId, byte[] image) {
        this.orgId = orgId;
        this.image = image;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
