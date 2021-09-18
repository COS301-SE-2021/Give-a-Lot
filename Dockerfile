FROM openjdk:11
COPY backend/target/classes/com/GiveaLot/givealot/Notification /tmp
WORKDIR /tmp
CMD backend/src/main/java/com/GiveaLot/givealot/Notification
