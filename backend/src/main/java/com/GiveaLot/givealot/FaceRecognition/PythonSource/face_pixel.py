import cv2
import numpy as np
from Anonamizer import anonymize_face_pixelate


def pixel(org_id):
    model = cv2.dnn.readNet("deploy.prototxt", "face_model.caffemodel")

    image = cv2.imread('tempImages/temp' + org_id + '.jpg')
    (h, w) = image.shape[:2]

    blob = cv2.dnn.blobFromImage(image, 1.0, (300, 300), (104.0, 177.0, 123.0))

    model.setInput(blob)
    faceCount = model.forward()

    for i in range(0, faceCount.shape[2]):
        confidence = faceCount[0, 0, i, 2]
        if confidence > 0.3:
            pixelBox = faceCount[0, 0, i, 3:7] * np.array([w, h, w, h])
            (startX, startY, endX, endY) = pixelBox.astype("int")

            face = image[startY:endY, startX:endX]
            face = anonymize_face_pixelate(face)

            image[startY:endY, startX:endX] = face

    cv2.imwrite('tempImages/pixel' + org_id + '.jpg', image)

if __name__ == '__main__':
    import sys
    org = sys.argv[1]
    pixel(org)
