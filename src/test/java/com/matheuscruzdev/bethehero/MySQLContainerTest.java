package com.matheuscruzdev.bethehero;

import static com.github.dockerjava.api.model.Ports.Binding.bindPort;

import org.testcontainers.containers.MySQLContainer;

import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.PortBinding;

/**
 * MySQLContainerTest
 */
public class MySQLContainerTest extends MySQLContainer<MySQLContainerTest> {

    public MySQLContainerTest() {
        withUsername("bethehero");
        withPassword("bethehero");
        withDatabaseName("bethehero");
        withCreateContainerCmdModifier(consumer -> {

            consumer.withName("mysql-5.7.22-test");
            consumer.withPortBindings(new PortBinding(bindPort(MYSQL_PORT), new ExposedPort(MYSQL_PORT)));
        });
    }
}