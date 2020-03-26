package com.matheuscruzdev.bethehero;

import java.util.HashMap;
import java.util.Map;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

/**
 * DatabaseDockerInitializer
 */
public class DatabaseDockerInitializer implements QuarkusTestResourceLifecycleManager {

    private static MySQLContainerTest DATABASE = new MySQLContainerTest();

    @Override
    public Map<String, String> start() {
        DATABASE.start();
        return configuration();
    }

    private Map<String, String> configuration() {
        Map<String, String> configuration = new HashMap<>();
        configuration.put("quarkus.datasource.url", DATABASE.getJdbcUrl());
        configuration.put("quarkus.datasource.username", DATABASE.getUsername());
        configuration.put("quarkus.datasource.password", DATABASE.getPassword());
        System.out.println(DATABASE.getUsername());
        return configuration;
    }

    @Override
    public void stop() {
        if (DATABASE != null) {
            DATABASE.close();
        }
    }
}