# import numpy as np
# import cv2
#
#
# def anonymize_face_blur(image):
#     (h, w) = image.shape[:2]
#     width = int(w / 3)
#     height = int(h / 3)
#
#     if width % 2 == 0:
#         width -= 1
#
#     if height % 2 == 0:
#         height -= 1
#
#     return cv2.GaussianBlur(image, (width, height), 0)
#
#
# def anonymize_face_pixelate(image):
#     (h, w) = image.shape[:2]
#     xSteps = np.linspace(0, w, 10, dtype="int")
#     ySteps = np.linspace(0, h, 10, dtype="int")
#
#     for i in range(1, len(ySteps)):
#         for j in range(1, len(xSteps)):
#
#             startX = xSteps[j - 1]
#             startY = ySteps[i - 1]
#             endX = xSteps[j]
#             endY = ySteps[i]
#
#             roi = image[startY:endY, startX:endX]
#             (B, G, R) = [int(x) for x in cv2.mean(roi)[:3]]
#             cv2.rectangle(image, (startX, startY), (endX, endY),
#                           (B, G, R), -1)
#
#     return image
