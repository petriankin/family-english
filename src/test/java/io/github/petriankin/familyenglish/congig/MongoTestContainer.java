package io.github.petriankin.familyenglish.congig;

import org.testcontainers.containers.MongoDBContainer;

public class MongoTestContainer extends MongoDBContainer {

    private static final String IMAGE_VERSION = "mongo:4.0";
    private static MongoTestContainer container;

    private MongoTestContainer() {
        super(IMAGE_VERSION);
    }

    public static MongoTestContainer getInstance() {
        if (container == null) {
            container = new MongoTestContainer();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("DB_HOST", container.getContainerIpAddress());
        System.setProperty("DB_PORT", container.getMappedPort(27017).toString());
    }

    @Override
    public void stop() {
        //do nothing, JVM handles shut down
    }
}
