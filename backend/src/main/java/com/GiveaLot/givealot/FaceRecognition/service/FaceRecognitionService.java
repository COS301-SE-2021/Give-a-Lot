package com.GiveaLot.givealot.FaceRecognition.service;

import java.io.IOException;

public interface FaceRecognitionService {
    void FacePixel(long orgId) throws IOException, InterruptedException;
    void FaceBlur(long orgId) throws IOException, InterruptedException;
}
