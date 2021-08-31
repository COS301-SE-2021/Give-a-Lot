package com.GiveaLot.givealot.Organisation.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ImagePackage {
    List<MultipartFile> images;

    public List<MultipartFile> getImages() {
        return images;
    }

    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }
}
