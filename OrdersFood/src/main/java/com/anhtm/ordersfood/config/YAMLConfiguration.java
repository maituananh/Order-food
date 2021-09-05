package com.anhtm.ordersfood.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * The type Yaml config.
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLConfiguration {

    /**
     * The Server port.
     */
    @Value("${server.port}")
    private String serverPort;


    /**
     * Gets server port.
     *
     * @return the server port
     */
    public String getServerPort() {
        return serverPort;
    }

    /**
     * Sets server port.
     *
     * @param serverPort the server port
     */
    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }
}
