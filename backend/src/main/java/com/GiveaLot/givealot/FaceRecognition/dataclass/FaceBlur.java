package com.GiveaLot.givealot.FaceRecognition.dataclass;

import org.hibernate.annotations.Type;

import javax.persistence.*;


@Entity
@Table(
        name = "blurred_images"
)
public class FaceBlur {

    @Id
    @Column(
            name = "org_id",
            updatable = false,
            nullable = false
    )
    long org_id;

    @Lob
    @Column(name="image_bytes")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] image_bytes;

    public FaceBlur() {

    }

    public long getOrg_id() {
        return org_id;
    }

    public void setOrg_id(long org_id) {
        this.org_id = org_id;
    }

    public byte[] getImage_bytes() {
        return image_bytes;
    }

    public void setImage_bytes(byte[] image_bytes) {
        this.image_bytes = image_bytes;
    }
}
