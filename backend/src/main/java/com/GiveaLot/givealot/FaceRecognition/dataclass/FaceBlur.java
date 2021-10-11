package com.GiveaLot.givealot.FaceRecognition.dataclass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Builder
@AllArgsConstructor
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

    public FaceBlur(Long org_id, byte[] image_bytes) {
        this.org_id = org_id;
        this.image_bytes = image_bytes;
    }

    public FaceBlur(Long org_id) {
    this.org_id = org_id;
    }

    public FaceBlur() {

    }


}
