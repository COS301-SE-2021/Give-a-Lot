package com.GiveaLot.givealot.FaceRecognition.service;

import java.io.File;
import java.io.IOException;

public interface FaceRecognitionService {
    File FacePixel(long orgId) throws IOException, InterruptedException;
    File FaceBlur(long orgId) throws IOException, InterruptedException;
}
